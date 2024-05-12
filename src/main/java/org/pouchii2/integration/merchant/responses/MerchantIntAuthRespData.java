/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.merchant.responses;

import org.pouchii2.integration.newpartner.setup.responses.AppFeature;
import org.pouchii2.integration.newpartner.setup.responses.Authorization;
import org.pouchii2.integration.newpartner.setup.responses.UserTypeInfo;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class MerchantIntAuthRespData {
          
    private String  applicationCode =  "POUCHII";
    private String  partnerCode =  "SPECS";
    private  int   applicationId = 1;
    private  int   partnerId = 1; 
    
    private  Authorization   authorization = new Authorization();
     
    private  boolean  pushNotificationEnabled  = false;
    private  boolean  smsNotificationEnabled  = false;
    
    
     public String  getApplicationCode(){
        return  applicationCode;
    }
    
    public String  getPartnerCode(){
        return  partnerCode;
    }
    
    public int  getApplicationId(){
        return  applicationId;
    }
    
    public int  getPartnerId(){
        return  partnerId;
    }
   
    public Authorization  getAuthorization(){
        return  authorization;
    }
     
    public boolean  getPushNotificationEnabled(){
        return  pushNotificationEnabled;
    }
    
    public boolean  getSmsNotificationEnabled(){
        return  smsNotificationEnabled;
    }
    
    
    
    
    
    
    public void  setApplicationCode(String  inApplicationCode){
           applicationCode = inApplicationCode;
    }
    
    public void  setPartnerCode(String  inPartnerCode){
           partnerCode = inPartnerCode;
    }
    
    public void  setApplicationId(int  inApplicationId){
           applicationId = inApplicationId;
    }
    
    public void  setPartnerId(int  inPartnerId){
           partnerId = inPartnerId;
    }
     
    public void  setAuthorization(Authorization   inAuthorization){
           authorization = inAuthorization;
    }
    
     
    public void  setPushNotificationEnabled(boolean  inPushNotificationEnabled){
          pushNotificationEnabled = inPushNotificationEnabled;
    }
    
    public void  setSmsNotificationEnabled(boolean  inSmsNotificationEnabled){
           smsNotificationEnabled = inSmsNotificationEnabled;
    }
    
     
    
    
     
}
