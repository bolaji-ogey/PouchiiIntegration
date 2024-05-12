/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.testgroup;

import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class ProfileTestData {
    
  public static  final String   UPDATE_EXTERNAL_PROFILE  = "/profile/update-external-user-profile";    //  POST 
  
  public static  final String   CHANGE_PASSWORD       = "/changelostpassword";    // POST
  public static  final String   CHANGE_DEVICE_STATUS  = "/my-devices/status";     // POST
  public static  final String   GET_LOGIN_DEVICES     = "/my-devices/self";            // GET
  public static  final String   UPDATE_PIN            = "/account/update-pin";    //  POST
  public static  final String   UPDATE_EMAIL          = "/account/update/email/{OTP}/{newEmail}";    //  POST
  public static  final String   UPDATE_SECRET_QUESTION  = "/account/update/secret-question";    //  POST
  public static  final String   UPGRADE_KYC            = "/upgrade-kyc";    //  POST
  public static  final String   UPGRADE_KYC3           = "/upgrade-kyc3";    //  POST
  
  public static  final String   GET_IMAGE           = "/images/{imgFileName}";    //  GET
  public static  final String   GET_PROFILES        = "/profiles/{phoneNumber}";    //  GET
    
   
  
  
    public  static JSONObject  getChangePwdTestData(){
        return  new JSONObject()
            .put("phoneNumber", "+2348095510360")
            .put("pin", "1111")
            .put("newPassword", "MoneyWise123#");
    }
    
    
   
    
    public  static JSONObject  getDeviceStatusTestData(){
        return  new JSONObject()
            .put("question", "a")
            .put("answer", "b")
            .put("pin", "4321")
            .put("status", "ACTIVE")
            .put("deviceId", "64784844-hhhd748849-g737838")
            .put("phoneNumber", "+2348061111165");
    }
    
    
    
    public  static JSONObject  getUpdatePINTestData(){
        return  new JSONObject()
            .put("phoneNumber", "+2348095510360")
            .put("newPin", "1111");
    }
     
     
      
    public  static JSONObject  getUpdateEmailTestData(){
        return  new JSONObject()
            .put("phoneNumber", "+2349122187911")
            .put("question", "What primary school did you attend")
            .put("pin", "4321")
            .put("answer", "Ebire")
            .put("email", "bogeyingbo@gmail.com");
    }
     
       
    
    public  static JSONObject  getUpdateSecretQstTestData(){
          return  new JSONObject()
            .put("question", "Which primary school did you attend")
            .put("answer", "Ebire")
            .put("otp", "432122")
            .put("trigger", true); 
    }
    
    
    
     public  static JSONObject  getUpgradeKYCTestData(){
          return  new JSONObject()
            .put("bvn", "22150115241")
            .put("verificationId", "68455469787")
            .put("docType", "NEPA Bill")
            .put("docFormat", "JPG")
            .put("docFile", true); 
    }
     
     
    
   public  static JSONObject  getUpgradeKYC3TestData(){
          return  new JSONObject() 
            .put("docType", "NEPA Bill")
            .put("docFormat", "JPG")
            .put("docFile", true); 
    }
      
      
    
   
    public  static JSONObject  getUpdateExtUserProfileTestData(){
          return  new JSONObject() 
            .put("pin", "1111")
            .put("password", "MoneyWise123#")
            .put("phoneNumber", "+2348061111165")
            .put("image", "/9j/4AAQSkZJRgABAQAAAQABAAD/"); 
    }
    



}
