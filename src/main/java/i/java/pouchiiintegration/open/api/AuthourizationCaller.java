/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.java.pouchiiintegration.open.api;
 

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import org.json.JSONObject;
import  i.ogeyingbo.testgroup.AuthourizationTestData;
import  i.ogeyingbo.testgroup.GenericCaller;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class AuthourizationCaller   extends   GenericCaller  {
     
    
    
    
    public  static void main(String[] args){
        AuthourizationCaller  authCaller  = new  AuthourizationCaller();
        System.out.println(String.valueOf(
             authCaller.callAuthenticate(AuthourizationTestData.getLoginTestData()))
                    
        );
       // authCaller.callSendOTP("+2348095510360");
    }
    
       
    
    
  
   
     
    public  JSONObject   callSendOTP(final String profileId){
        String  sendOtpStr  =  AuthourizationTestData.SEND_OTP;
        sendOtpStr = sendOtpStr.replace("{phoneNumber}", profileId);
        return   getRequest(sendOtpStr); 
   }
    
     
    
     public   JSONObject    callVerifyOTP(final  JSONObject    testData){
        return postRequest(AuthourizationTestData.VERIFY_OTP,   testData); 
   }
      
     
     
     
    
    public  JSONObject   callVerifyOTP_II(final String  profileId,  final String otp){
        String  verifyOtpStrII  =  AuthourizationTestData.SEND_OTP;
        verifyOtpStrII =  verifyOtpStrII.replace("{phoneNumber}", profileId);
          verifyOtpStrII =  verifyOtpStrII.replace("{OTP}", otp);
         return getRequest(verifyOtpStrII);
   }
     
    
     public  JSONObject   callForgotPIN(final  JSONObject    testData){
         return postRequest(AuthourizationTestData.FORGET_PIN,   testData);                      
   }
     
      
    public  JSONObject   callForgotPassword(final  JSONObject    testData){
        return  postRequest(AuthourizationTestData.FORGET_PASSWORD,  testData);
   }
      
      
      
      
      
      
}
