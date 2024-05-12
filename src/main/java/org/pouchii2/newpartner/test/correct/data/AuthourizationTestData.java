/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.newpartner.test.correct.data;


    
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import org.json.JSONObject;
import org.pouchii2.partner.base.AuthourizationInterface;
/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class AuthourizationTestData     extends     AuthourizationInterface {
     
  public static  final String   LOGIN       = "/identityservice/rest/api/authenticate/login";     // POST
  public static  final String   REFRESH_TOKEN       =  "/identityservice/rest/api/authenticate/refresh/token";  // GET
  public static  final String   FETCH_MY_WALLET_BALANCE  =   "/walletservice/rest/api/my/wallet/balance";  // GET 
  public static  final String   SEND_OTP    = "/send-otp/{phoneNumber}";     // GET
  public static  final String   VERIFY_OTP  = "/verify-otp";                  // POST
  public static  final String   VERIFY_OTP_II = "/verify-otp/{OTP}/{phoneNumber}";  // GET
  public static  final String   FORGET_PIN    =  "/account/forgot-pin";  // POST
  public static  final String   FORGET_PASSWORD  = "/forgot/password";  // POST
  public static  final String   FORGET_PASSWORD_II  = "/changelostpassword";  // POST
    
  
 
  
  
  
    public  static JSONObject  getLoginTestData(){
        return  new JSONObject()
            .put("requestChannelId", "PAYMASTA")
            .put("requestChannel", "Api")
            .put("requestChannelType", "Integrator")
            .put("requestApplicationCode", "POUCHII")
            .put("requestPartnerCode", "PAYMASTA")
            .put("username", "PUB_STSL_5FEGHD6OXKMV0CL")
            .put("password", "d7qBQ2EV5q6+XlQ2lTF8uuQVN8mA3b5qMaQfLvGgxWA=")
            .put("rememberMe", true);
    }
    
    
        
    public  static JSONObject  getVerifyOtpTestData(){
        return  new JSONObject()
            .put("otp", "534941");
    }
     
     
   
    public  static JSONObject  getForgotPinTestData(){
        return  new JSONObject()
            .put("phoneNumber", "+2349122187911")
            .put("newPin", "1111")
            .put("password", "Breeze123#")
            .put("question", "What primary school did you attend")
            .put("answer", "Ebire");
    }
      
      
    
    
    public  static JSONObject  getForgotPwdTestData(){
        return  new JSONObject()
            .put("phoneNumber", "+2347747834566")
            .put("newPassword", "Techno123#")
            .put("pin", "1234");
    }
      
    
    
    public  static JSONObject  getForgotPwdIITestData(){
        return  new JSONObject()
            .put("phoneNumber", "+2347747834566")
            .put("newPassword", "Techno123#");
    }
    
    
    
    
    
   
   
   
             
}
