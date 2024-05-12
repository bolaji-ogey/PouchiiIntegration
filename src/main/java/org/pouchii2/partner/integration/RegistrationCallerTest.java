/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.partner.integration;

 
import i.java.pouchiiintegration.open.api.RegistrationCaller;
import i.ogeyingbo.testgroup.GenericCaller;
import i.ogeyingbo.testgroup.RegistrationTestData; 
import i.ogeyingbo.testgroup.AuthourizationWrongTestData;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class RegistrationCallerTest  extends    GenericCaller {
    
    
    RegistrationCaller   regCaller  = new  RegistrationCaller();
    
    
    
    public  static void main(String[] args){
        RegistrationCallerTest   regCallerTest  = new  RegistrationCallerTest();
       //   regCaller.authenticate();
       // regCaller.sendOTP();
    } 
    
    
    
    
    
     
   public  JSONObject   testRegUserCall(){
       return  regCaller.callRegUser(RegistrationTestData.getRegisterTestData());
   }
    
   
   
   
   
     public  JSONObject    testCreatePINCall(){
        return  regCaller.callCreatePIN(RegistrationTestData.getPINTestData());
   }     
     
     
      
    public  JSONObject   testLastPageCall(){
        return  regCaller.callLastPage(RegistrationTestData.getLastPageTestData());
   }      
       
       
        
    public  JSONObject   testRegStageCall(){
      return  regCaller.callRegStage();
   }   
    
    
    
}
