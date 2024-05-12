/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.newpartner.setup.responses;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class PartnerCreationResponseData extends  AdminPouchiiResponseData  {
    
    private  int   partnerId = 50;
     private String  partnerName =  "TEST-MERCHX";
    private String  partnerCode =  "TEST-MERCHX";
    private String  integrationType =  "Api";
    private  boolean  partnerStatus  = true;
    private String  avatar =  "";
    
    private String  partnerKycLevel =  "";
    private String  dateCreated =  "";
    
    
    public  int  getPartnerId(){
        return  partnerId;
    }
    
    public  String  getPartnerName(){
        return  partnerName;
    }
    
    public  String  getPartnerCode(){
        return  partnerCode;
    }
    
    public  String  getIntegrationType(){
        return  integrationType;
    }
    
    public  boolean  getPartnerStatus(){
        return  partnerStatus;
    }
    
    public  String  getAvatar(){
        return  avatar;
    }
    
    public  String  getPartnerKycLevel(){
        return  partnerKycLevel;
    }
    
    public  String  getDateCreated(){
        return  dateCreated;
    }
    
    
    
    
    
    
    
    public  void  setPartnerId(int  inPartnerId){
           partnerId = inPartnerId;
    }
    
    public  void  setPartnerName(String  inPartnerName){
           partnerName = inPartnerName;
    }
    
    public  void  setPartnerCode(String  inPartnerCode){
           partnerCode = inPartnerCode;
    }
    
    public  void  setIntegrationType(String  inIntegrationType){
           integrationType = inIntegrationType;
    }
    
    public  void  setPartnerStatus(boolean  inPartnerStatus){
           partnerStatus = inPartnerStatus;
    }
    
    public  void  setAvatar(String  inAvatar){
           avatar = inAvatar;
    }
    
    public  void  setPartnerKycLevel(String  inPartnerKycLevel){
           partnerKycLevel = inPartnerKycLevel;
    }
    
    public  void  setDateCreated(String  inDateCreated){
           dateCreated = inDateCreated;
    }
    
    
    
}
