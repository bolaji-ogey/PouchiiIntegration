/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.java.pouchiiintegration.open.api;
 
import i.ogeyingbo.testgroup.GenericCaller;
import i.ogeyingbo.testgroup.RegistrationTestData;  
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
      return  postRequest(RegistrationTestData.REGISTER,  testData);  
   }
    
   
    
     public  JSONObject   callCreatePIN(final  JSONObject    testData){
         return  postRequest(RegistrationTestData.PIN,  testData);  
   }
     
     
     
     
     
   public  JSONObject   callLastPage(final  JSONObject    testData){
         return  postRequest(RegistrationTestData.LAST_PAGE, testData);  
   }
       
       
        
   
  public  JSONObject   callRegStage(){
     return  getRequest(RegistrationTestData.REG_STAGE); 
   }
    
    
    
}
