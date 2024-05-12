/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.newpartner.integration.setup.open.api;


  
import  org.pouchii2.newpartner.test.correct.data.ProfileTestData;
import  org.pouchii2.newpartner.base.integration.setup.open.api.GenericCaller;  
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
public class ProfileCaller extends   GenericCaller  {
    
    
  
  /**  
    public  JSONObject   callUpdateExternalProfile(final  JSONObject    testData){
        return  putRequest(false, ProfileTestData.UPDATE_EXTERNAL_PROFILE,  testData);                    
   }
   **/  
      
     
    public  JSONObject   callChangeLostPassword(final  JSONObject    testData){
       return  postRequest(false, ProfileTestData.CHANGE_PASSWORD, testData);                        
   }
       
        
    public  JSONObject   callChangeDeviceStatus(final  JSONObject    testData){
        return  postRequest(false, ProfileTestData.CHANGE_DEVICE_STATUS, testData);  
    }
      
       
    public  JSONObject   getLoginDevices(){
        return   getRequest(false, ProfileTestData.GET_LOGIN_DEVICES); 
   }
     
    
    public  JSONObject   callUpdatePIN(final  JSONObject    testData){
    return   postRequest(false, ProfileTestData.UPDATE_PIN, testData);  
    }
    
    
     
    public  JSONObject   callUpdateEmail(final  String  otp,  final String newAddEmail){ 
        String  emailUpdtStr  =  ProfileTestData.UPDATE_EMAIL;
       emailUpdtStr  = emailUpdtStr.replace("{OTP}", otp);
       emailUpdtStr =  emailUpdtStr.replace("{newEmail}", newAddEmail);
        return  getRequest(false, emailUpdtStr);  
    }
    
     
    public   JSONObject   callUpdateSecretQuestion(final  JSONObject    testData){
        return  postRequest(false, ProfileTestData.UPDATE_SECRET_QUESTION, testData);  
    }
    
     
    public  JSONObject   callUpgradeKYC(final  JSONObject    testData){  
        return  postRequest(false, ProfileTestData.UPGRADE_KYC, testData);  
    }
    
     
    public  JSONObject   callUpgradeKYC3(final  JSONObject    testData){  
        return  postRequest(false, ProfileTestData.UPGRADE_KYC3, testData);  
    }
    
     
    
    public  JSONObject   getImage(final String  imageFileName){
        String  imageStr  =  ProfileTestData.GET_IMAGE;
        imageStr  =  imageStr.replace("{imgFileName}", imageFileName);
     return  getRequest(false, imageStr);  
    }
     
    
    
    public  JSONObject   getProfiles(final String  profileId){
        String  profileStr  =  ProfileTestData.GET_PROFILES;
        profileStr  =  profileStr.replace("{phoneNumber}", profileId);
        return   getRequest(false, profileStr);
    }
    
    
    
    
}
