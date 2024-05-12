/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.java.client.example;


  
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpResponse;
import java.util.Base64;
import org.json.JSONObject;
/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class HttpClientExample {
    
 
    JSONObject   jsonObjt = null;
     String  bearerToken =  
     "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIrMjM0ODA5NTUxMDM2MCIsImF1dGgiOiJST0xFX0FETUlOLFJPTEVfU1VQRVJfQURNSU4sUk9MRV9VU0VSIiwiZXhwIjoxNjc3MTM3MjYxfQ.koNqhFWFZvJwFcc-F3D02iWqlUmxrKsnrjSW6f_jotUro0m6_86ipGOdfuDi2XgOrwSNIO7y3umFUxHnWlmeoQ";
    
    
    public  HttpClientExample(){
           jsonObjt = new JSONObject();
           jsonObjt.put("username", "+2348095510360");
            jsonObjt.put("password", "MoneyBag123#");
            jsonObjt.put("scheme", "53797374656d73706563732077616c6c6574");
            jsonObjt.put("deviceId", "64784844-hhhd748849-g737838");
            jsonObjt.put("rememberMe", true);
    }
    
    
    
    
    public  static void main(String[] args){
        HttpClientExample   htttpClientExample  = new  HttpClientExample();
         htttpClientExample.authenticate();
       // htttpClientExample.sendOTP();
    }
    
       
    
    
    
   public  void   authenticate(){
 
        HttpClient client = null;
        HttpRequest request = null;
        HttpResponse response = null;
            try{
               client = HttpClient.newHttpClient(); 
                URI uri = new URI("https://walletdemo.remita.net/api/authenticate"); 
                 request = HttpRequest.newBuilder(uri)
                            .POST(BodyPublishers.ofString(jsonObjt.toString())) 
                            .header("Content-type", "application/json")
                            .build();
                 response = client.send(request, BodyHandlers.ofString());
            }catch(Exception ex){
                ex.printStackTrace();
            }
          System.out.println(response.body().toString());
          response.body();
             
   }
    
   
   
   
   
    public  void   sendOTP(){
 
        HttpClient client = null;
        HttpRequest request = null;
        HttpResponse response = null;
            try{
               client = HttpClient.newHttpClient(); 
                URI uri = new URI("https://walletdemo.remita.net/api/send-otp/2348095510360"); 
                 request = HttpRequest.newBuilder(uri)
                            .GET()  
                         .header("Authorization", bearerToken)
                           // .header("Content-type", "application/json")
                            .build();
                 response = client.send(request, BodyHandlers.ofString());
                  
                System.out.println("res.toString(): "+response.body().toString());
            
                if (response.statusCode() == 200) {
                         try{ 
                                System.out.println(new String(Base64.getDecoder().decode(response.body().toString())));
                                String respStr   =    new String(Base64.getDecoder().decode(response.body().toString()));
                                JSONObject   respJson =  new JSONObject(respStr);
                                if(respJson != null){
                                    String  respCode = respJson.getString("responseCode");
                                    if(respCode.equals("00")){
                                        // OK It is successfull.
                                        // DO other meaningful things.
                                         System.out.println(respJson.getString("msg"));
                                      }
                                }
                                //     System.out.println(res.bodyAsJsonObject().toString());
                                // sendOTP();
                            }catch(Exception ex){
                                ex.printStackTrace();
                            }

                } 
            }catch(Exception ex){
                ex.printStackTrace();
            }
          System.out.println(response.body().toString());
          
             
   }
    
    
    
    
    
    
}
