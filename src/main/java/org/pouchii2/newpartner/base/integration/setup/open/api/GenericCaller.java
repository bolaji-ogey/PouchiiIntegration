
package  org.pouchii2.newpartner.base.integration.setup.open.api;
 
 
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import org.pouchii2.newpartner.test.correct.data.AuthourizationTestData; 
import  org.pouchii2.integration.merchant.responses.*; 
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject; 

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public  class  GenericCaller   extends     AuthourizationInterface {
    
   
   public   String   testAuthenticateCall(final  JSONObject    testData){
        return    callAuthenticate(false, AuthourizationTestData.LOGIN, testData);
   } 
      
   public   String   callAuthenticate(final boolean IS_LIVE,  final String  inURL, final  JSONObject    testData){
        JSONObject   respJson =  new JSONObject();
        HttpClient client = null;
        HttpRequest request = null;
        HttpResponse response = null; 
        String  url  =  String.format("%s%s",  getBaseURL(IS_LIVE),  inURL);
        String   token =  ""; 
        System.out.println("Calling authenticate().... . . . .  .  ."+url); 
            try{
               client = HttpClient.newHttpClient(); 
                URI uri = new URI(url); 
                 request = HttpRequest.newBuilder(uri)
                            .POST(HttpRequest.BodyPublishers.ofString(testData.toString())) 
                            .header("Content-type", "application/json")
                            .build();
                 response = client.send(request, HttpResponse.BodyHandlers.ofString());                 
                 System.out.println("HTTP Response code := "+response.statusCode());
               //  System.out.println("Response BODY:   "+response.body().toString());
                 if ((response.statusCode() == 200) &&  (response.body() != null)) {
                     String  reqResp = response.body().toString();
                     if(!StringUtils.isEmpty(reqResp) && reqResp.startsWith("{") && reqResp.endsWith("}")){
                              
                        JSONObject reqRespJson =  new JSONObject(reqResp); 
                             int   responseCode  =  reqRespJson.getInt("responseCode");
                             String   responseMessage  =  reqRespJson.getString("responseMessage");
                              System.out.println("Login:   -->  "+responseCode);
                              System.out.println("Login:   -->  "+responseMessage);
                             if(responseCode == 200){
                               JSONObject  data =    reqRespJson.getJSONObject("data");
                               JSONObject  authourization =    data.getJSONObject("authorization");
                               token  =  BEARER_TOKEN =  authourization.getString("token");
                                REFRESH_TOKEN =  authourization.getString("refreshToken");
                             } else{
                               MerchantIntAuthResponse  merchantIntAuthResponse  =  MerchantIntAuthResponse.readFromJSON(reqResp);
                               System.out.println(merchantIntAuthResponse.getData().getAuthorization().getToken());
                             } 
                     }  
                 } 
                }catch(Exception e){
                    e.printStackTrace();
                }
        return     token;    
   }
    
    
   
   
    public  String   getRefreshedToken(final boolean IS_LIVE,  final  String  getURL){
        JSONObject   respJson  =  new JSONObject();
        HttpClient client = null;
        HttpRequest request = null;
        HttpResponse response = null; 
        String    token =  "";
        String    refreshToken =  "";
        String  url  =  String.format("%s%s",  getBaseURL(IS_LIVE),  getURL); 
        System.out.println("BEARER_TOKEN:  "+BEARER_TOKEN); 
        System.out.println("REFRESH_TOKEN:  "+REFRESH_TOKEN); 
            try{
               client = HttpClient.newHttpClient(); 
                URI uri = new URI(url); 
                 request = HttpRequest.newBuilder(uri)
                            .GET() 
                            .header("Content-type", "application/json")
                            .header("Refresh-Authorization-Token", BEARER_TOKEN)
                            .header("Authorization",  "Bearer "+BEARER_TOKEN)
                            .build();
                 response = client.send(request, HttpResponse.BodyHandlers.ofString());                 
                 System.out.println("HTTP Response code := "+response.statusCode());
                 System.out.println("Response BODY:   "+response.body().toString());//System.out.println(response.body().toString());
                 if ((response.statusCode() == 200) &&  (response.body() != null)) {
                     String  reqResp = response.body().toString();
                     if(!StringUtils.isEmpty(reqResp) && reqResp.startsWith("{") && reqResp.endsWith("}")){
                              
                              JSONObject reqRespJson =  new JSONObject(reqResp); 
                             int   responseCode  =  reqRespJson.getInt("responseCode");
                             if(responseCode == 200){
                               JSONObject  data =    reqRespJson.getJSONObject("data");
                               token =   BEARER_TOKEN  =  data.getString("token"); 
                               refreshToken  =  REFRESH_TOKEN =  data.getString("refreshToken");
                             }                                
                     }  
                 }
                }catch(Exception e){
                    e.printStackTrace();
                }
        return     token;      
   }
    
    
    
    
    
  public  JSONObject   postRequest(final boolean IS_LIVE,  final String  postURL,  final  JSONObject    testData){
        JSONObject   respJson  =  null;
        HttpClient client = null;
        HttpRequest request = null;
        HttpResponse response = null;
         String  url  =  String.format("%s%s",  getBaseURL(IS_LIVE),  postURL);
        JSONObject   data =  new JSONObject();
        System.out.println("BEARER_TOKEN:  "+BEARER_TOKEN); 
            try{
               client = HttpClient.newHttpClient(); 
                URI uri = new URI(url); 
                 request = HttpRequest.newBuilder(uri)
                            .POST(HttpRequest.BodyPublishers.ofString(testData.toString())) 
                            .header("Content-type", "application/json")
                            .header("Authorization",  "Bearer "+BEARER_TOKEN)
                            .build();
                 response = client.send(request, HttpResponse.BodyHandlers.ofString());                 
                 System.out.println("HTTP Response code := "+response.statusCode());
                 System.out.println("Response BODY:   "+response.body().toString());
                 if ((response.statusCode() == 200) &&  (response.body() != null)) {
                     String  reqResp = response.body().toString();
                     if(!StringUtils.isEmpty(reqResp) && reqResp.startsWith("{") && reqResp.endsWith("}")){
                              
                        JSONObject reqRespJson =  new JSONObject(reqResp); 
                        int   responseCode  =  reqRespJson.getInt("responseCode");
                        if(responseCode == 200){
                           data =   reqRespJson.getJSONObject("data"); 
                        } 
                                                    
                     }  
                 }
                }catch(Exception e){
                    e.printStackTrace();
                }
        return     data;    
   }
             
  
  
  
   public  JSONObject   getRequest(final boolean IS_LIVE,  final  String  getURL){
        JSONObject   respJson  =  new JSONObject();
        HttpClient client = null;
        HttpRequest request = null;
        HttpResponse response = null; 
        JSONObject    data =  new JSONObject();
        String  url  =  String.format("%s%s",  getBaseURL(IS_LIVE),  getURL); 
        System.out.println("BEARER_TOKEN:  "+BEARER_TOKEN); 
            try{
               client = HttpClient.newHttpClient(); 
                URI uri = new URI(url); 
                 request = HttpRequest.newBuilder(uri)
                            .GET() 
                            .header("Content-type", "application/json")
                            .header("Authorization",  "Bearer "+BEARER_TOKEN)
                            .build();
                 response = client.send(request, HttpResponse.BodyHandlers.ofString());                 
                 System.out.println("HTTP Response code := "+response.statusCode());
                 System.out.println("Response BODY:   "+response.body().toString());//System.out.println(response.body().toString());
                 if ((response.statusCode() == 200) &&  (response.body() != null)) {
                     String  reqResp = response.body().toString();
                     if(!StringUtils.isEmpty(reqResp) && reqResp.startsWith("{") && reqResp.endsWith("}")){
                              
                             JSONObject reqRespJson =  new JSONObject(reqResp); 
                            int   responseCode  =  reqRespJson.getInt("responseCode");
                            if(responseCode == 200){
                               data =    reqRespJson.getJSONObject("data"); 
                            }                                     
                     }  
                 }
                }catch(Exception e){
                    e.printStackTrace();
                }
        return     data;      
   }
             
   
    
   
    public   String   createMerchant(final boolean IS_LIVE,  final String  inURL, final  JSONObject    testData){
        JSONObject   respJson =  new JSONObject();
        HttpClient client = null;
        HttpRequest request = null;
        HttpResponse response = null; 
        String  url  =  String.format("%s%s",  getBaseURL(IS_LIVE),  inURL);
        String   token =  ""; 
        System.out.println("Calling authenticate().... . . . .  .  ."+url); 
            try{
               client = HttpClient.newHttpClient(); 
                URI uri = new URI(url); 
                 request = HttpRequest.newBuilder(uri)
                            .POST(HttpRequest.BodyPublishers.ofString(testData.toString())) 
                            .header("Content-type", "application/json")
                            .build();
                 response = client.send(request, HttpResponse.BodyHandlers.ofString());                 
                 System.out.println("HTTP Response code := "+response.statusCode());
               //  System.out.println("Response BODY:   "+response.body().toString());
                 if ((response.statusCode() == 200) &&  (response.body() != null)) {
                     String  reqResp = response.body().toString();
                     if(!StringUtils.isEmpty(reqResp) && reqResp.startsWith("{") && reqResp.endsWith("}")){
                              
                        JSONObject reqRespJson =  new JSONObject(reqResp); 
                             int   responseCode  =  reqRespJson.getInt("responseCode");
                             String   responseMessage  =  reqRespJson.getString("responseMessage");
                              System.out.println("Login:   -->  "+responseCode);
                              System.out.println("Login:   -->  "+responseMessage);
                             if(responseCode == 200){
                               JSONObject  data =    reqRespJson.getJSONObject("data");
                               JSONObject  authourization =    data.getJSONObject("authorization");
                               token  =  BEARER_TOKEN =  authourization.getString("token");
                                REFRESH_TOKEN =  authourization.getString("refreshToken");
                             } else{
                               MerchantIntAuthResponse  merchantIntAuthResponse  =  MerchantIntAuthResponse.readFromJSON(reqResp);
                               System.out.println(merchantIntAuthResponse.getData().getAuthorization().getToken());
                             } 
                     }  
                 } 
                }catch(Exception e){
                    e.printStackTrace();
                }
        return     token;    
   }
    
    
    
    
}
