/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.partner.test.correct.data;


   
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
public class AuthourizationLiveData   extends     AuthourizationInterface {
     
    
  public static  final String   LOGIN       = "/rest/api/integration/authentication/credential";      // POST
  public static  final String   LOG_OUT  =   "/rest/api/authentication/logout";    // POST
  public static  final String   UPDATE_PASSWORD_REQUEST  =   "/rest/api/authentication/update/password";   // POST
  public static  final String   CHANGE_PASSWORD_REQUEST  =   "/rest/api/authentication/change/password";   // POST
  public static  final String   PASSWORD_RESET  =   "/rest/api/authentication/reset/password";   // POST
  
  public static  final String   CREATE_AUTHOURIZATION_PIN    = "/rest/api/authentication/create/transaction/pin";     // POST
  public static  final String   CHANGE_AUTHOURIZATION_PIN  = "/rest/api/authentication/change/transaction/pin";     // POST
  public static  final String   VERIFY_MY_PASSWORD  = "/rest/api/authentication/verify/my/password";     // POST
  public static  final String   FORGOT_TRANSACTION_PIN  = "/rest/api/authentication/reset/transaction/pin";     // POST
  public static  final String   SEND_RESET_PIN_REQUEST  = "/rest/api/generate/authentication/request";     // POST
  
  
  
   
  
  

  
    public  static JSONObject  getMerchantLoginTestData(){
        return  new JSONObject()
            .put("requestChannelId", REQUEST_CHANNEL_ID)
            .put("requestChannel", REQUEST_CHANNEL)
            .put("requestChannelType", REQUEST_CHANNEL_TYPE)
            .put("requestApplicationCode", REQUEST_APPLICATION_CODE)
            .put("requestPartnerCode", REQUEST_PARTNER_CODE)
            .put("username", "")
            .put("password", "MoneyBag123#") 
            .put("rememberMe", true);
    }
    
    
    
    public  static JSONObject  getUpdatePasswordRqstTestData(){
        return  new JSONObject()
            .put("requestChannelId", REQUEST_CHANNEL_ID)
            .put("requestChannel", REQUEST_CHANNEL)
            .put("requestChannelType", REQUEST_CHANNEL_TYPE)
            .put("requestApplicationCode", REQUEST_APPLICATION_CODE)
            .put("requestPartnerCode", REQUEST_PARTNER_CODE) 
            .put("password", "MoneyBag123#") 
            .put("confirmPassword", true)
            .put("requestAuthourization", new JSONObject()
                                                   .put("verificationEvent", "")
                                                   .put("verificationReference", "")
                                                   .put("verificationCode", "")
                                                   .put("authorizationType", ""));
    }
    
    
    
     public  static JSONObject  getChangePasswordRqstTestData(){
        return  new JSONObject()
            .put("requestChannelId", REQUEST_CHANNEL_ID)
            .put("requestChannel", REQUEST_CHANNEL)
            .put("requestChannelType", REQUEST_CHANNEL_TYPE)
            .put("requestApplicationCode", REQUEST_APPLICATION_CODE)
            .put("requestPartnerCode", REQUEST_PARTNER_CODE)
            .put("oldPassword", "")
            .put("password", "MoneyBag123#") 
            .put("confirmPassword", true);
    }
     
     
     
     public  static JSONObject  getPasswordResetTestData(){
        return  new JSONObject()
            .put("requestChannelId", REQUEST_CHANNEL_ID)
            .put("requestChannel", REQUEST_CHANNEL)
            .put("requestChannelType", REQUEST_CHANNEL_TYPE)
            .put("requestApplicationCode", REQUEST_APPLICATION_CODE)
            .put("requestPartnerCode", REQUEST_PARTNER_CODE)
            .put("username", "") 
            .put("generateAndSendPassword", true);
    }
    
     
     
     public  static JSONObject  getCreateAuthourizationPinTestData(){
        return  new JSONObject()
            .put("requestChannelId", REQUEST_CHANNEL_ID)
            .put("requestChannel", REQUEST_CHANNEL)
            .put("requestChannelType", REQUEST_CHANNEL_TYPE)
            .put("requestApplicationCode", REQUEST_APPLICATION_CODE)
            .put("requestPartnerCode", REQUEST_PARTNER_CODE)
            .put("pin", "") 
            .put("confirmPin", "") ;
    }
     
     
     
     public  static JSONObject  getChangeAuthourizationPinTestData(){
        return  new JSONObject()
            .put("requestChannelId", REQUEST_CHANNEL_ID)
            .put("requestChannel", REQUEST_CHANNEL)
            .put("requestChannelType", REQUEST_CHANNEL_TYPE)
            .put("requestApplicationCode", REQUEST_APPLICATION_CODE)
            .put("requestPartnerCode", REQUEST_PARTNER_CODE)
            .put("currentPin", "") 
            .put("newPin", "") 
            .put("confirmPin", "") ;
    }
     
     
     
     public  static JSONObject  getVerifyMyPasswordTestData(){
        return  new JSONObject()
            .put("requestChannelId", REQUEST_CHANNEL_ID)
            .put("requestChannel", REQUEST_CHANNEL)
            .put("requestChannelType", REQUEST_CHANNEL_TYPE)
            .put("requestApplicationCode", REQUEST_APPLICATION_CODE)
            .put("requestPartnerCode", REQUEST_PARTNER_CODE)
            .put("password", "");
    }
     
     
     
     
     public  static JSONObject  getForgotTransactionPinTestData(){
        return  new JSONObject()
            .put("requestChannelId", REQUEST_CHANNEL_ID)
            .put("requestChannel", REQUEST_CHANNEL)
            .put("requestChannelType", REQUEST_CHANNEL_TYPE)
            .put("requestApplicationCode", REQUEST_APPLICATION_CODE)
            .put("requestPartnerCode", REQUEST_PARTNER_CODE)
            .put("securityAnswer", "") 
            .put("pin", "");
    }
     
     
     
     public  static JSONObject  getSendRequestPinResetTestData(){
        return  new JSONObject()
            .put("requestChannelId", REQUEST_CHANNEL_ID)
            .put("requestChannel", REQUEST_CHANNEL)
            .put("requestChannelType", REQUEST_CHANNEL_TYPE)
            .put("requestApplicationCode", REQUEST_APPLICATION_CODE)
            .put("requestPartnerCode", REQUEST_PARTNER_CODE)
            .put("verificationEvent", "PinReset");
    }
     
     
     
     
     
     
     
     
     
     
     
         
             
}
