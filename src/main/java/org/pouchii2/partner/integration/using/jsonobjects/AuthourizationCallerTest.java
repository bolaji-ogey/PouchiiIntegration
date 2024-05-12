/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.partner.integration.using.jsonobjects;

  
import org.json.JSONObject;
import  org.pouchii2.integration.merchant.requests.*;
import org.pouchii2.integration.open.api.AuthourizationCaller;
import  org.pouchii2.partner.base.GenericCaller;
import org.json.JSONArray;
import  org.pouchii2.integration.wallet.responses.*; 

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class AuthourizationCallerTest   extends   GenericCaller  {
     
    AuthourizationCaller   authCaller  = new   AuthourizationCaller();
    
    static String inputBankName  =  "assets";
  //  static String inputBankName  = "eNaira";
    
    
    public  static void main(String[] args){
         AuthourizationCallerTest  authCallerTest  = new  AuthourizationCallerTest();
         MerchantIntAuthRequest   merchantIntAuthRequest =  new  MerchantIntAuthRequest();
        System.out.println(String.valueOf(
             authCallerTest.testAuthenticateCall(merchantIntAuthRequest.convertToJSON()))
         );  
      
       // System.out.println(String.valueOf("-->"+authCallerTest.testSendOTPCall("+2348095510360")));
       
        BankListResp   bankListResp   =  null;
        
        try{
            //  bankListResp   =  BankListResp.readFromJSON(authCallerTest.testBankGet().toString());
            String   resp  =    authCallerTest.testBankGet().toString();
            System.out.println("resp: "+resp);
            JSONObject reqRespJson =  new JSONObject(resp);
        //  JSONObject data   = reqRespJson.getJSONObject("data");
           JSONArray contents   = reqRespJson.getJSONArray("contents");
            
          JSONArray innerContents   =    contents.getJSONArray(0);
         // System.out.println("innerContents  = "+innerContents.toString());
         // System.out.println("innerContents Object at index 0 = "+innerContents.getJSONObject(0).toString());
           String[]  bankNameTokens =  inputBankName.split(" ");
           int  tokenSize = bankNameTokens.length;
           int  matchCount  =  0;
           int u  = 0;
           
           System.out.println("innerContents.length() >>>> "+innerContents.length());
           
            for(u = 0; u < innerContents.length(); u++){
                // Bankz   bankz   =     Bankz.readFromJSON(new JSONObject(innerContents.getJSONObject(u)).toString());
               JSONObject bankz = innerContents.getJSONObject(u);
                 String  serchBankName = bankz.getString("name");
                serchBankName = serchBankName.toUpperCase();
                 System.out.println("serchBankName:  "+serchBankName);
                 
                 for(int r = 0; r < tokenSize; r++){
                     if(serchBankName.contains(bankNameTokens[r].trim().toUpperCase())){
                         matchCount  = matchCount + 1;
                     }
                 }
               if(matchCount  == tokenSize){
                   System.out.println("Match found");
                   break;
               }
               
            }
            
            System.out.println("Total iteration done >>>> "+u);
            
        }catch(Exception  ex){
            ex.printStackTrace();
                  
        }
    }
    
        
    
    
    
    
    
    public  static  boolean   findBankMatch(String  inputBankName){
         AuthourizationCallerTest  authCallerTest  = new  AuthourizationCallerTest();
         MerchantIntAuthRequest   merchantIntAuthRequest =  new  MerchantIntAuthRequest();
 
         boolean matchFound = false;
          authCallerTest.testAuthenticateCall(merchantIntAuthRequest.convertToJSON());
        
      
       // System.out.println(String.valueOf("-->"+authCallerTest.testSendOTPCall("+2348095510360")));
       
        BankListResp   bankListResp   =  null;
        
        try{
            //  bankListResp   =  BankListResp.readFromJSON(authCallerTest.testBankGet().toString());
            String   resp  =    authCallerTest.testBankGet().toString();
            System.out.println("resp: "+resp);
            JSONObject reqRespJson =  new JSONObject(resp);
        //  JSONObject data   = reqRespJson.getJSONObject("data");
           JSONArray contents   = reqRespJson.getJSONArray("contents");
            
          JSONArray innerContents   =    contents.getJSONArray(0);
         // System.out.println("innerContents  = "+innerContents.toString());
        //  System.out.println("innerContents Object at index 0 = "+innerContents.getJSONObject(0).toString());
           String[]  bankNameTokens =  inputBankName.split(" ");
           int  tokenSize = bankNameTokens.length;
           int  matchCount  =  0;
           int u  = 0;
           
           System.out.println("innerContents.length() >>>> "+innerContents.length());
           
            for(u = 0; u < innerContents.length(); u++){
                // Bankz   bankz   =     Bankz.readFromJSON(new JSONObject(innerContents.getJSONObject(u)).toString());
               JSONObject bankz = innerContents.getJSONObject(u);
                 String  serchBankName = bankz.getString("name");
                 serchBankName = serchBankName.toUpperCase();
                 System.out.println("serchBankName:  "+serchBankName);
                 
                 for(int r = 0; r < tokenSize; r++){
                     if(serchBankName.contains(bankNameTokens[r].trim().toUpperCase())){
                         matchCount  = matchCount + 1;
                     }
                 }
               if(matchCount  == tokenSize){
                   matchFound = true;
                   System.out.println("Match found");
                   break;
               }
               
            }
            
            System.out.println("Total iteration done >>>> "+u);
            
        }catch(Exception  ex){
            ex.printStackTrace();
                  
        }
        return  matchFound;
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
