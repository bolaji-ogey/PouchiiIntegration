/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.newpartner.integration.setup.open.api;
 
  
import  org.pouchii2.newpartner.test.correct.data.RegistrationTestData;
import  org.pouchii2.newpartner.base.integration.setup.open.api.GenericCaller; 
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
import org.json.JSONString;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class RegistrationCaller  extends   GenericCaller {
    
    
    
    
    
    
    public  static void main(String[] args){
        RegistrationCaller   regCaller  = new  RegistrationCaller();
       //   regCaller.authenticate();
       // regCaller.sendOTP();
    } 
    
    
    
    
    
     
   public  JSONObject   callRegUser(final  JSONObject    testData){
      return  postRequest(false,  RegistrationTestData.REGISTER,  testData);  
   }
    
   
    
     public  JSONObject   callCreatePIN(final  JSONObject    testData){
         return  postRequest(false,  RegistrationTestData.PIN,  testData);  
   }
     
     
     
     
     
   public  JSONObject   callLastPage(final  JSONObject    testData){
         return  postRequest(false, RegistrationTestData.LAST_PAGE, testData);  
   }
       
       
        
   
  public  JSONObject   callRegStage(){
     return  getRequest(false, RegistrationTestData.REG_STAGE); 
   }
    
    
    
}
