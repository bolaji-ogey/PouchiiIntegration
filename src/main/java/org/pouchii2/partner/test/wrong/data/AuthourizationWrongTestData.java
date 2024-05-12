/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.partner.test.wrong.data;


    
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import org.json.JSONObject;
/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class AuthourizationWrongTestData    {
     
  public static  final String   LOGIN       = "/authenticate";              // POST
  public static  final String   SEND_OTP    = "/send-otp/{phoneNumber}";     // GET
  public static  final String   VERIFY_OTP  = "/verify-otp";                  // POST
  public static  final String   VERIFY_OTP_II = "/verify-otp/{OTP}/{phoneNumber}";  // GET
  public static  final String   FORGET_PIN    =  "/account/forgot-pin";  // POST
  public static  final String   FORGET_PASSWORD  = "/forgot/password";  // POST
  public static  final String   FORGET_PASSWORD_II  = "/changelostpassword";  // POST
    
  

  
    public  static JSONObject  getLoginTestData(){
        return  new JSONObject()
            .put("username", "+2348095510360")
            .put("password", "MoneyBag123#")
            .put("scheme", "53797374656d73706563732077616c6c6574")
            .put("deviceId", "64784844-hhhd748849-g737838")
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
