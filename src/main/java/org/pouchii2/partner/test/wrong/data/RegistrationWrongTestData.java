/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.partner.test.wrong.data;
  
 
import org.json.JSONObject;
import org.pouchii2.partner.base.AuthourizationInterface;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class RegistrationWrongTestData extends     AuthourizationInterface {
    
  public static  final String   REGISTER       = "/register";    // POST
  public static  final String   PIN            = "/pin";     // POST
  public static  final String   LAST_PAGE      = "/lastpage";   // POST
  public static  final String   REG_STAGE      = "/regStage";  //  GET
    
  

  
  
    public  static JSONObject  getRegisterTestData(){
        return  new JSONObject()
            .put("phoneNumber", "+2348095510360")
            .put("firstName", "Wynk-Person-23")
            .put("lastName", "Pay-Wynk-2")
            .put("MoneyWise123#", "MoneyWise123#");
    }
    
    
        
    public  static JSONObject  getPINTestData(){
        return  new JSONObject()
            .put("pin", "5349");
    }
     
     
     
   
    public  static JSONObject  getLastPageTestData(){
        return  new JSONObject()
            .put("dateOfBirth", "1976-02-11")
            .put("gender", "MALE")
            .put("state", "Ogun")
            .put("localGovt", "Atan-1")
            .put("latitude", "6.605874")
        
            .put("longitude", "3.349149")
            .put("address", "Lade Hospital")
            .put("secretQuestion", "What primary school did you attend?")
            .put("secretAnswer", "Ebire")
            .put("bvn", "6.605874")
        
            .put("scheme", "57796e6b")
            .put("email", "bogeyingbo@gmail.com")
            .put("photo", "/9j/4AAQSkZJRgABAQAAAQABAAD/");
    }
      
      
     
}
