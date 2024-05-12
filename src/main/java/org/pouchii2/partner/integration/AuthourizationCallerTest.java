/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.partner.integration;

 
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import org.json.JSONObject;
import  org.pouchii2.partner.test.correct.data.AuthourizationTestData;
import  i.ogeyingbo.testgroup.AuthourizationWrongTestData;
import org.pouchii2.integration.open.api.AuthourizationCaller;
import  org.pouchii2.partner.base.GenericCaller;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class AuthourizationCallerTest   extends   GenericCaller  {
     
    AuthourizationCaller   authCaller  = new   AuthourizationCaller();
    
    
    public  static void main(String[] args){
         AuthourizationCallerTest  authCallerTest  = new  AuthourizationCallerTest(); 
        System.out.println(String.valueOf(
             authCallerTest.testAuthenticateCall(AuthourizationWrongTestData.getLoginTestData()))
         );  
       // System.out.println(String.valueOf("-->"+authCallerTest.testSendOTPCall("+2348095510360")));
    }
    
        
    
   
    
   
     
    public  JSONObject   testSendOTPCall(final String  mobileNumber){  
        return   authCaller.callSendOTP(mobileNumber); 
   }
    
    /**  
   public  JSONObject   testForgotPINCall(){
         return  authCaller.callForgotPIN(false, AuthourizationTestData.getForgotPinTestData());                      
   }
     
      
    public  JSONObject   testForgotPasswordCall(){
        return  authCaller.callForgotPassword(false, AuthourizationTestData.getForgotPwdTestData());
   }
    **/  
      
      
      
      
      
      
}
