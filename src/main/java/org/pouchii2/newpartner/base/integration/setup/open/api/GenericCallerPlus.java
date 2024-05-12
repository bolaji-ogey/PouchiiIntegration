
package  org.pouchii2.newpartner.base.integration.setup.open.api;
 
 

import org.pouchii2.newpartner.test.correct.data.AuthourizationTestData; 
import org.pouchii2.newpartner.test.correct.data.PartnerMerchantCreateData;
import  org.pouchii2.integration.merchant.responses.*; 
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject; 
import org.pouchii2.integration.newpartner.setup.requests.FetchMerchantCredentials;
import org.pouchii2.integration.newpartner.setup.responses.FetchMerchantCredentialResponse;
import org.pouchii2.integration.newpartner.setup.responses.PouchiiAdminResponseBase;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public  class  GenericCallerPlus   extends     AuthourizationInterface {
    
    private  static  String    errorMessage = "";
    
    private  static  int       partnerId  =  -1;
    private  static  int       merchantId  =  -1;
    private  static  String    partnerCode = "";
    private  static  String    partnerName = "";
    
    
    public   void  setPartnerId(int  inPartnerId){
        partnerId =  inPartnerId;
        merchantId =  inPartnerId;
    }
    
    
    
    public  void  setPartnerCode(String  inPartnerCode){
        partnerCode =  inPartnerCode;
        partnerName   = inPartnerCode;
    }
    
     
    private  static  GenericCallerPlus   genericCallerPluss; 
    
    private  GenericCallerPlus(){}
    
    
    
    public static GenericCallerPlus getInstance()
    {
        if (genericCallerPluss == null)
        {
            synchronized (GenericCallerPlus.class)
            {
                genericCallerPluss = new GenericCallerPlus();
            } 
        }
        return   genericCallerPluss;
    }
    
    
    
    public  void  resetErrorMessage(){
         errorMessage = "";
    }
     
    
    public  String  getErrorMessage(){
        return  errorMessage;
    }
   
    public  int  getPartnerId(){
        return  partnerId;
    }
    
    public  int  getMerchantId(){
        return  merchantId;
    }
    
    public  String  getPartnerCode(){
        return  partnerCode;
    }
    
    public  String  getPartnerName(){
        return  partnerName;
    }
    
   public   int   testAuthenticateCall(final  JSONObject    testData){
        return    callAuthenticate(false, AuthourizationTestData.LOGIN, testData);
   } 
   
   public   int   testCreatePartner(final  JSONObject    testData){
        return    createPartner(false, PartnerMerchantCreateData.PARTNER_CREATION, testData);
   } 
   
   
   public   int   testUpdatePartnerInfo(final  JSONObject    testData){
        return    postRequest(false, PartnerMerchantCreateData.UPDATE_PARTNER_INFO, testData);
   }
   
   public   int   testCreateMerchant(final  JSONObject    testData){
        return    createMerchant(false, PartnerMerchantCreateData.MERCHANT_CREATION, testData);
   } 
   
   
   public   int   testFetchMerchantCredential(){
        return    getMerchantCredential(false, PartnerMerchantCreateData.FETCH_MERCHANT_CREDNTIALS);
   } 
   
    
   
   public   int   testInitializePartnerWallet(final  JSONObject    testData){
        return    postRequest(false, PartnerMerchantCreateData.INITIALIZE_PARTNER_WALLET, testData);
   }
    
    
   public   int   testCreatePartnerOpWallet(final  JSONObject    testData){
        return    postRequest(false, PartnerMerchantCreateData.CREATE_PARTNER_OPERATIONAL_WALLET, testData);
   }
   
   
      
   public   int   callAuthenticate(final boolean IS_LIVE,  final String  inURL, final  JSONObject    testData){
        JSONObject   respJson =  new JSONObject();
        HttpClient client = null;
        HttpRequest request = null;
        HttpResponse response = null; 
        String  url  =  String.format("%s%s",  getBaseURL(IS_LIVE),  inURL);
        String   token =  ""; 
        int   responseCode  = 500;
        System.out.println("Calling authenticate().... . . . .  .  ."+url); 
            try{
               client = HttpClient.newHttpClient(); 
                URI uri = new URI(url); 
                 request = HttpRequest.newBuilder(uri)
                            .POST(HttpRequest.BodyPublishers.ofString(testData.toString())) 
                            .header("Content-type", "application/json")
                            .header("User-Agent", "ZY")
                            .build();
                 response = client.send(request, HttpResponse.BodyHandlers.ofString());                 
                 System.out.println("callAuthenticate: HTTP Response code := "+response.statusCode());
                 System.out.println("callAuthenticate: Response BODY:   "+response.body().toString());
                 errorMessage =   response.body().toString();
                 if ((response.statusCode() == 200) &&  (response.body() != null)) {
                     String  reqResp = response.body().toString();
                     if(!StringUtils.isEmpty(reqResp) && reqResp.startsWith("{") && reqResp.endsWith("}")){
                              
                        JSONObject reqRespJson =  new JSONObject(reqResp); 
                             responseCode  =  reqRespJson.getInt("responseCode");
                             String   responseMessage  =  errorMessage =  reqRespJson.getString("responseMessage");
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
                    System.out.print("Error encountered when authenticating....  ");
                    e.printStackTrace();
                }
        return     responseCode;    
   }
    
    
   
   
    public  int   getRefreshedToken(final boolean IS_LIVE,  final  String  getURL){
        JSONObject   respJson  =  new JSONObject();
        HttpClient client = null;
        HttpRequest request = null;
        HttpResponse response = null; 
        String    token =  "";
        String    refreshToken =  "";
        int   responseCode  =   500;
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
                            .header("User-Agent", "ZY")
                            .build();
                 response = client.send(request, HttpResponse.BodyHandlers.ofString());                 
                 System.out.println("getRefreshedToken: HTTP Response code := "+response.statusCode());
                 System.out.println("getRefreshedToken: Response BODY:   "+response.body().toString());//System.out.println(response.body().toString());
                 errorMessage =   response.body().toString();
                 if ((response.statusCode() == 200) &&  (response.body() != null)) {
                     String  reqResp = response.body().toString();
                     if(!StringUtils.isEmpty(reqResp) && reqResp.startsWith("{") && reqResp.endsWith("}")){
                              
                              JSONObject reqRespJson =  new JSONObject(reqResp); 
                             responseCode  =  reqRespJson.getInt("responseCode");
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
        return     responseCode;      
   }
    
    
    
    
    
  public  int   postRequest(final boolean IS_LIVE,  final String  postURL,  final  JSONObject    testData){
        JSONObject   respJson  =  null;
        HttpClient client = null;
        HttpRequest request = null;
        HttpResponse response = null;
        int   responseCode    = 500;
        String   responseMessage  =  "No respsonse yet";
        
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
                            .header("User-Agent", "ZY")
                            .build();
                 response = client.send(request, HttpResponse.BodyHandlers.ofString());                 
                 System.out.println("postRequest: HTTP Response code := "+response.statusCode());
                 System.out.println("postRequest: Response BODY:   "+response.body().toString());
                 errorMessage =   response.body().toString();
                 if ((response.statusCode() == 200) &&  (response.body() != null)) {
                     String  reqResp = response.body().toString();
                     
                     if(!StringUtils.isEmpty(reqResp) && reqResp.startsWith("{") && reqResp.endsWith("}")){
                              
                        JSONObject reqRespJson =  new JSONObject(reqResp); 
                             responseCode  =  reqRespJson.getInt("responseCode");
                             responseMessage  = errorMessage =  reqRespJson.getString("responseMessage");
                              System.out.println("Login:   -->  "+responseCode);
                              System.out.println("Login:   -->  "+responseMessage);
                        if(responseCode == 200){
                            if(reqRespJson.getJSONObject("data") != null){
                                 data =   reqRespJson.getJSONObject("data"); 
                            }
                        } 
                                                    
                     }  
                 }
                }catch(Exception e){
                    e.printStackTrace();
                }
        return     responseCode;    
   }
             
  
  
  
   public  int   getRequest(final boolean IS_LIVE,  final  String  getURL){
        JSONObject   respJson  =  new JSONObject();
        HttpClient client = null;
        HttpRequest request = null;
        HttpResponse response = null; 
        JSONObject    data =  new JSONObject();
        int   responseCode   = 500;
        String   responseMessage  =  "No respsonse yet";
        String  url  =  String.format("%s%s",  getBaseURL(IS_LIVE),  getURL); 
        System.out.println("BEARER_TOKEN:  "+BEARER_TOKEN); 
            try{
               client = HttpClient.newHttpClient(); 
                URI uri = new URI(url); 
                 request = HttpRequest.newBuilder(uri)
                            .GET() 
                            .header("Content-type", "application/json")
                            .header("Authorization",  "Bearer "+BEARER_TOKEN)
                            .header("User-Agent", "ZY")
                            .build();
                 response = client.send(request, HttpResponse.BodyHandlers.ofString());                 
                 System.out.println("getRequest: HTTP Response code := "+response.statusCode());
                 System.out.println("getRequest: Response BODY:   "+response.body().toString());
                 errorMessage =   response.body().toString();
                 if ((response.statusCode() == 200) &&  (response.body() != null)) {
                     String  reqResp = response.body().toString();
                     if(!StringUtils.isEmpty(reqResp) && reqResp.startsWith("{") && reqResp.endsWith("}")){
                              
                          JSONObject reqRespJson =  new JSONObject(reqResp); 
                           responseCode  =  reqRespJson.getInt("responseCode");
                             responseMessage  = errorMessage =  reqRespJson.getString("responseMessage");
                              System.out.println("Login:   -->  "+responseCode);
                              System.out.println("Login:   -->  "+responseMessage);
                            if(responseCode == 200){
                                if(reqRespJson.getJSONObject("data") != null){
                                    data =    reqRespJson.getJSONObject("data");
                                }
                                if(reqRespJson.getJSONObject("partnerId") != null){
                                     setPartnerId(reqRespJson.getInt("partnerId"));
                                }
                            }                                     
                     }  
                 }
                }catch(Exception e){
                    e.printStackTrace();
                }
        return     responseCode;      
   }
             
   
    
   
   
   
       
  public  int   createPartner(final boolean IS_LIVE,  final String  postURL,  final  JSONObject    testData){
        JSONObject   respJson  =  null;
        HttpClient client = null;
        HttpRequest request = null;
        HttpResponse response = null;
        int   responseCode   = 500;
        String   responseMessage  =  "No respsonse yet";
        
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
                            .header("User-Agent", "ZY")
                            .build();
                 response = client.send(request, HttpResponse.BodyHandlers.ofString());     
                 System.out.println("createPartner: Request Sent := "+testData.toString());
                 System.out.println("createPartner: HTTP Response code := "+response.statusCode());
                 System.out.println("createPartner: Response BODY:   "+response.body().toString());
                  errorMessage =   response.body().toString();
                 if ((response.statusCode() == 200) &&  (response.body() != null)) {
                     String  reqResp = response.body().toString();
                     
                     if(!StringUtils.isEmpty(reqResp) && reqResp.startsWith("{") && reqResp.endsWith("}")){
                              
                        JSONObject reqRespJson =  new JSONObject(reqResp); 
                             responseCode  =  reqRespJson.getInt("responseCode");
                             responseMessage  = errorMessage =  reqRespJson.getString("responseMessage");
                              System.out.println("createPartner:   -->  "+responseCode);
                              System.out.println("createPartner:   -->  "+responseMessage);
                        if(responseCode == 200){
                           if(reqRespJson.getJSONObject("data") != null){
                                 data =    reqRespJson.getJSONObject("data");
                              }
                           partnerId =  data.getInt("partnerId");
                        } 
                                                    
                     }  
                 }
                }catch(Exception e){
                    System.out.print("Error encountered when creating new Partner  ");
                    e.printStackTrace();
                }
        return     responseCode;    
   }
    
  
  
  
    public   int   createMerchant(final boolean IS_LIVE,  final String  inURL, final  JSONObject    testData){
        JSONObject   respJson =  new JSONObject();
        HttpClient client = null;
        HttpRequest request = null;
        HttpResponse response = null; 
        String  url  =  String.format("%s%s",  getBaseURL(IS_LIVE),  inURL);
        String   token =  ""; 
        int   responseCode    = 500;
        System.out.println("Calling authenticate().... . . . .  .  ."+url); 
            try{
               client = HttpClient.newHttpClient(); 
                URI uri = new URI(url); 
                 request = HttpRequest.newBuilder(uri)
                            .POST(HttpRequest.BodyPublishers.ofString(testData.toString())) 
                            .header("Content-type", "application/json")
                            .header("Authorization",  "Bearer "+BEARER_TOKEN)
                            .header("User-Agent", "ZY")
                            .build();
                 response = client.send(request, HttpResponse.BodyHandlers.ofString());                 
                 System.out.println("createMerchant: HTTP Response code := "+response.statusCode());
                 System.out.println("createMerchant: Response BODY:   "+response.body().toString());
                 errorMessage =   response.body().toString();
                 if ((response.statusCode() == 200) &&  (response.body() != null)) {
                     String  reqResp = response.body().toString();
                     if(!StringUtils.isEmpty(reqResp) && reqResp.startsWith("{") && reqResp.endsWith("}")){
                              
                        JSONObject reqRespJson =  new JSONObject(reqResp); 
                             responseCode  =  reqRespJson.getInt("responseCode");
                             String   responseMessage  = errorMessage =  reqRespJson.getString("responseMessage");
                              System.out.println("createMerchant:   -->  "+responseCode);
                              System.out.println("createMerchant:   -->  "+responseMessage);
                             // MerchantIntAuthResponse  merchantIntAuthResponse  =  MerchantIntAuthResponse.readFromJSON(reqResp);
                             if(responseCode == 200){
                               JSONObject  data =    reqRespJson.getJSONObject("data");
                               JSONObject  authourization =    data.getJSONObject("authorization");
                               token  =  MERCHANT_BEARER_TOKEN =  authourization.getString("token");
                                MERCHANT_REFRESH_TOKEN =  authourization.getString("refreshToken");                                 
                              //  System.out.println(merchantIntAuthResponse.getData().getAuthorization().getToken());
                                
                             } else{
                                 System.out.println(responseMessage);
                              // MerchantIntAuthResponse  merchantIntAuthResponse  =  MerchantIntAuthResponse.readFromJSON(reqResp);
                              // System.out.println(merchantIntAuthResponse.getResponseMessage());
                             } 
                     }  
                 } 
                }catch(Exception e){
                    System.out.print("Error encountered when creating new Merchant  ");
                    e.printStackTrace();
                }
        return     responseCode;    
   }
    
    
    
    
    
     
   public  int   getMerchantCredential(final boolean IS_LIVE,  final  String  getURL){
        JSONObject   respJson  =  new JSONObject();
        HttpClient client = null;
        HttpRequest request = null;
        HttpResponse response = null; 
        JSONObject    data =  new JSONObject();
        int   responseCode    = 500;
        String   responseMessage  =  "No respsonse yet";
        String  url  =  String.format("%s%s",  getBaseURL(IS_LIVE),  getURL); 
        System.out.println("MERCHANT_BEARER_TOKEN:  "+MERCHANT_BEARER_TOKEN); 
            try{
               client = HttpClient.newHttpClient(); 
                URI uri = new URI(url); 
                 request = HttpRequest.newBuilder(uri)
                            .GET() 
                            .header("Content-type", "application/json")
                            .header("Authorization",  "Bearer "+MERCHANT_BEARER_TOKEN)
                            .header("User-Agent", "ZY")
                            .build();
                 response = client.send(request, HttpResponse.BodyHandlers.ofString());                 
                 System.out.println("getMerchantCredential: HTTP Response code := "+response.statusCode());
                 System.out.println("getMerchantCredential: Response BODY:   "+response.body().toString());//System.out.println(response.body().toString());
                 errorMessage =   response.body().toString();
                 if ((response.statusCode() == 200) &&  (response.body() != null)) {
                     String  reqResp = response.body().toString();
                     if(!StringUtils.isEmpty(reqResp) && reqResp.startsWith("{") && reqResp.endsWith("}")){
                              
                          JSONObject reqRespJson =  new JSONObject(reqResp); 
                           responseCode  =  reqRespJson.getInt("responseCode");
                             responseMessage  = errorMessage =  reqRespJson.getString("responseMessage");
                              System.out.println("Login:   -->  "+responseCode);
                              System.out.println("Login:   -->  "+responseMessage);
                            if(responseCode == 200){
                               data =    reqRespJson.getJSONObject("data"); 
                                FetchMerchantCredentialResponse  fetchMerchantCredentialResponse  =  FetchMerchantCredentialResponse.readFromJSON(reqResp);
                               System.out.println("Merchant Username: "+fetchMerchantCredentialResponse.getData().getPublicKey()); 
                               System.out.println("Merchant Password:  "+fetchMerchantCredentialResponse.getData().getSecretKey()); 
                            } else{
                             //  PouchiiAdminResponseBase  pouchiiAdminResponseBase   =  PouchiiAdminResponseBase.readFromJSON(reqResp);
                               System.out.println(responseMessage);
                             }                                      
                     }  
                 }
                }catch(Exception e){
                    System.out.print("Error encountered when fetching Merchant Credentials  ");
                    e.printStackTrace();
                }
        return     responseCode;      
   }
   
   
   
}
