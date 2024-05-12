/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.partner.integration;

 
 
import i.ogeyingbo.testgroup.ProfileTestData;
import i.java.pouchiiintegration.open.api.ProfileCaller;
import i.ogeyingbo.testgroup.AuthourizationWrongTestData;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class ProfileCallerTest    {
    
     ProfileCaller    profileCaller  = new  ProfileCaller();
       
       
    public  static void main(String[] args){
        ProfileCallerTest    profileCallerTest  = new  ProfileCallerTest();
     }
    
    
    
  
    
    public  JSONObject   testUpdateExternalProfileCall(){
        return  profileCaller.callUpdateExternalProfile(ProfileTestData.getUpdateExtUserProfileTestData());                    
   }
     
      
     
    public  JSONObject   testChangeLostPasswordCall(){
       return  profileCaller.callChangeLostPassword(ProfileTestData.getChangePwdTestData());                        
   }
       
        
    public  JSONObject   testChangeDeviceStatusCall(final  JSONObject    testData){
        return  profileCaller.callChangeDeviceStatus(ProfileTestData.getDeviceStatusTestData());  
    }
       
     /***  
    public  JSONObject   getLoginDevices(){
        return   profileCaller.getLoginDevices(ProfileTestData); 
   }
    **/
    
    
    public  JSONObject   testUpdatePINCall(){
      return   profileCaller.callUpdatePIN(ProfileTestData.getUpdatePINTestData());  
    }
    
    
     
    public  JSONObject   testUpdateEmailCall(){ 
        return  profileCaller.callUpdateEmail("","");  
    }
    
     
    public   JSONObject   testUpdateSecretQuestionCall(){
        return  profileCaller.callUpdateSecretQuestion(ProfileTestData.getUpdateSecretQstTestData());  
    }
    
     
    public  JSONObject    testUpgradeKYCCall(){  
        return  profileCaller.callUpgradeKYC(ProfileTestData.getUpgradeKYCTestData());  
    }
    
     
    public  JSONObject   testUpgradeKYC3Call(){  
        return  profileCaller.callUpgradeKYC3(ProfileTestData.getUpgradeKYC3TestData());  
    }
    
     
    
    
}
