/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.newpartner.integration.setup.open.api;
 
 
 
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import org.json.JSONObject;
import  org.pouchii2.newpartner.test.correct.data.AuthourizationTestData;
import  org.pouchii2.newpartner.base.integration.setup.open.api.GenericCaller;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class AuthourizationCaller   extends   GenericCaller  {
     
    
    
    
    public  static void main(String[] args){
        AuthourizationCaller  authCaller  = new  AuthourizationCaller();
        System.out.println(String.valueOf(
             authCaller.callAuthenticate(false, AuthourizationTestData.LOGIN,  AuthourizationTestData.getLoginTestData())));
         System.out.println();
       //  System.out.println(String.valueOf(authCaller.callRefreshedToken()));
         System.out.println();
     // System.out.println(String.valueOf(authCaller.callFetchMyWalletBal()));
              
       // authCaller.callSendOTP("+2348095510360");
    }
    
       
   
    
     public  String   callRefreshedToken(){ 
        return   getRefreshedToken(false, AuthourizationTestData.REFRESH_TOKEN); 
   }
     
     
     public  JSONObject   callFetchMyWalletBal(){ 
        return   getRequest(false, AuthourizationTestData.FETCH_MY_WALLET_BALANCE); 
   }
  
   
     
    public  JSONObject   callSendOTP(final String profileId){
        String  sendOtpStr  =  AuthourizationTestData.SEND_OTP;
        sendOtpStr = sendOtpStr.replace("{phoneNumber}", profileId);
        return   getRequest(false, sendOtpStr); 
   }
    
    /** 
    
     public   JSONObject    callVerifyOTP(final  JSONObject    testData){
        return postRequest(false, AuthourizationTestData.VERIFY_OTP,   testData); 
   }
      
     
     
     
    
    public  JSONObject   callVerifyOTP_II(final String  profileId,  final String otp){
        String  verifyOtpStrII  =  AuthourizationTestData.SEND_OTP;
        verifyOtpStrII =  verifyOtpStrII.replace("{phoneNumber}", profileId);
          verifyOtpStrII =  verifyOtpStrII.replace("{OTP}", otp);
         return getRequest(false, verifyOtpStrII);
   }
     
    
     public  JSONObject   callForgotPIN(final  JSONObject    testData){
         return postRequest(false, AuthourizationTestData.FORGET_PIN,   testData);                      
   }
     
      
    public  JSONObject   callForgotPassword(final  JSONObject    testData){
        return  postRequest(false, AuthourizationTestData.FORGET_PASSWORD,  testData);
   }
      **/
      
      
      
      
      
}
