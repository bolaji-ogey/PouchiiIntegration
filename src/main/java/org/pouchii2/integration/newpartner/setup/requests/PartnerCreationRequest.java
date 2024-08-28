/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.newpartner.setup.requests;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import org.json.JSONObject; 

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class PartnerCreationRequest  extends   PouchiiAdminRequestBase {
    
    private  String  partnerName = "HACK-IN";
    private  String  partnerCode = "HACK-5";
    private  String  avatar = "Male";
    private  String  partnerIntegrationType = "Api";
    private  boolean  requireWalletCreation = true;
    private  boolean  requireBonusWalletCreation = false;
    private  boolean  hasCustomLogin = true;
    private  String  customLogin = "https://localhost:8080/pouchii/Remita/login";
    private  boolean  sendLoginInfo = true;
    private  boolean  assignedNubanToSubAgent = false;
    
    private  boolean  enableUserNotificationOptions = true;
    private  boolean  enabledNotification = true;
    private  boolean  allowCustomerTransaction = false;
    private  boolean  allowSystemTransaction = false;
    private  boolean  partnerStatus = false;
    private  String  noReplyEmailSender = " <noreply@pouchii.net>";
    
    private  String  supportEmailSender = " Support<noreply@pouchii.net>";
    private  String  supportMobileNumber = "0163489113";
    private  String  technicalSupportEmail = " Technical Support<noreply@pouchii.net>";
    private  String  financeSupportEmail = " Finance Support<noreply@pouchii.net>";
     
    private  String  smsSender = "POUCHII";
    private  boolean  sendVerificationEmail = true;
    private  boolean  sendVerificationSMS = true;
    private  boolean  sendTransactionEmailNotification = true;
    private  boolean  sendTransactionSMSNotification = true;
    private  String  kycLevel = "Level2";
    private  String  merchantSendMoneyKYCLevel = "Level2";
    private  boolean  createNubanAccountForIndividual = true;
    
    private  boolean  createNubanAccountForTeller = false;
    private  boolean  createNubanAccountForSuperAgent = true;
    private  boolean  createNubanAccountForAgent = true;
    private  boolean  createNubanAccountForMerchant = true;
    private  boolean  allowBonusWalletCreation = true;
    private  boolean  applyBonusOnTransaction = false;
    private  boolean  sendPushNotification = true;
    private  boolean  makePhoneNumberUnique = true;
    private  boolean  sendLoginNotification = true;
    private  boolean  aggregateWalletNotification = true;
    private  boolean  canFundWalletOutSideScheme = false; 
    
    private  STSLApplication[]   applications  =  new STSLApplication[1];
    
    
    
    public PartnerCreationRequest(){
       applications[0] = new STSLApplication(); 
    }
        
    
    
    public  final  JSONObject  convertToJSON(){
        JSONObject  returnedJson =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
             objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
           returnedJson =  new JSONObject(objectMapper.writeValueAsString(this));
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            objectMapper = null;
        }
      return  returnedJson;
    }
    
    
    public  final  String  convertToJSONString(){
        String  returnedJsonString =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            returnedJsonString  =   objectMapper.writeValueAsString(this);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            objectMapper = null;
        }
      return  returnedJsonString;
    }
     
    
    
     public   final  PartnerCreationRequest  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        PartnerCreationRequest   partnerCreationRequest  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              partnerCreationRequest = objectMapper.readValue(inObjectJSON, PartnerCreationRequest.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  partnerCreationRequest;
    }
     
    
    public  static  PartnerCreationRequest  readFromJSON(String  inObjectJSON){ 
        PartnerCreationRequest  partnerCreationRequest  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              partnerCreationRequest = objectMapper.readValue(inObjectJSON, PartnerCreationRequest.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  partnerCreationRequest;
    }
      
    
    public  String  getPartnerName(){
        return  partnerName;
    }
    
    
    public  String  getPartnerCode(){
        return partnerCode;
    }
    
    public  String  getAvatar(){
        return  avatar;
    }
    
    public  String  getPartnerIntegrationType(){
        return partnerIntegrationType;
    }
    
    public  boolean  getRequireWalletCreation(){
        return requireWalletCreation;
    }
    
    public  boolean  getRequireBonusWalletCreation(){
        return requireBonusWalletCreation;
    }
    
    public  boolean  getHasCustomLogin(){
        return hasCustomLogin;
    }
    
    public  String  getCustomLogin(){
        return customLogin;
    }
    
    public  boolean  getSendLoginInfo(){
        return sendLoginInfo;
    }
    
    public  boolean  getAssignedNubanToSubAgent(){
        return assignedNubanToSubAgent;
    }
     
    public  boolean  getEnableUserNotificationOptions(){
        return enableUserNotificationOptions;
    }
    
    public  boolean  getEnabledNotification(){
        return enabledNotification;
    }
    
    public  boolean  getAllowCustomerTransaction(){
        return allowCustomerTransaction;
    }
    
    public  boolean  getAllowSystemTransaction(){
        return allowSystemTransaction;
    }
    
    public  boolean  getPartnerStatus(){
        return partnerStatus;
    }
    
    public  String  getNoReplyEmailSender(){
        return noReplyEmailSender;
    }
    
    public  String  getSupportEmailSender(){
        return supportEmailSender;
    }
    
    public  String  getSupportMobileNumber(){
        return supportMobileNumber;
    }
    
    public  String  getTechnicalSupportEmail(){
        return technicalSupportEmail;
    }
    
    public  String  getFinanceSupportEmail(){
        return financeSupportEmail;
    }
    
    public  String  getSmsSender(){
        return smsSender;
    }
    
    public  boolean  getSendVerificationEmail(){
        return sendVerificationEmail;
    }
    
    public  boolean  getSendVerificationSMS(){
        return sendVerificationSMS;
    }
     
    public  boolean  getSendTransactionEmailNotification(){
        return sendTransactionEmailNotification;
    }
    
    public  boolean  getSendTransactionSMSNotification(){
        return sendTransactionSMSNotification;
    }
    
    public  String  getKycLevel(){
        return kycLevel;
    }
    
    public  String  getMerchantSendMoneyKYCLevel(){
        return merchantSendMoneyKYCLevel;
    }
    
    public  boolean  getCreateNubanAccountForIndividual(){
        return createNubanAccountForIndividual;
    }
      
    
    public  boolean  getCreateNubanAccountForTeller(){
        return createNubanAccountForTeller;
    }
    
    public  boolean  getCreateNubanAccountForSuperAgent(){
        return createNubanAccountForSuperAgent;
    }
    
    public  boolean  getCreateNubanAccountForAgent(){
        return createNubanAccountForAgent;
    }
    
    public  boolean  getCreateNubanAccountForMerchant(){
        return createNubanAccountForMerchant;
    }
    
    public  boolean  getAllowBonusWalletCreation(){
        return allowBonusWalletCreation;
    }
    
    public  boolean  getApplyBonusOnTransaction(){
        return applyBonusOnTransaction;
    }
    
    public  boolean  getSendPushNotification(){
        return sendPushNotification;
    }
    
    public  boolean  getMakePhoneNumberUnique(){
        return makePhoneNumberUnique;
    }
    
    
    public  boolean  getSendLoginNotification(){
        return sendLoginNotification;
    }
    
    public  boolean  getAggregateWalletNotification(){
        return aggregateWalletNotification;
    }
    
    public  boolean  getCanFundWalletOutSideScheme(){
        return canFundWalletOutSideScheme;
    }
        
    
    public  STSLApplication[]  getApplications(){
        return applications;
    }
     
    
    
    
    
    
    
    
    public  void  setPartnerName(String   inPartnerName){
          partnerName = inPartnerName;
          partnerCode =  inPartnerName;
    }
    
    
    public  void  setPartnerCode(String   inPartnerCode){
        partnerCode = inPartnerCode;
        partnerName =  inPartnerCode;
    }
    
    public  void  setAvatar(String   inAvatar){
         avatar = inAvatar;
    }
    
    public  void  setPartnerIntegrationType(String   inPartnerIntegrationType){
         partnerIntegrationType = inPartnerIntegrationType;
    }
    
    public  void  setRequireWalletCreation(boolean  inRequireWalletCreation){
          requireWalletCreation = inRequireWalletCreation;
    }
    
    public  void  setRequireBonusWalletCreation(boolean   inRequireWalletCreation){
         requireBonusWalletCreation = inRequireWalletCreation;
    }
    
    public  void  setHasCustomLogin(boolean   inHasCustomLogin){
         hasCustomLogin = inHasCustomLogin;
    }
    
    public  void  setCustomLogin(String   inCustomLogin){
         customLogin = inCustomLogin;
    }
    
    public  void  setSendLoginInfo(boolean  inSendLoginInfo){
         sendLoginInfo = inSendLoginInfo;
    }
    
    public  void  setAssignedNubanToSubAgent(boolean  inAssignedNubanToSubAgent){
          assignedNubanToSubAgent = inAssignedNubanToSubAgent;
    }
     
    public  void  setEnableUserNotificationOptions(boolean  inEnableUserNotificationOptions){
         enableUserNotificationOptions = inEnableUserNotificationOptions;
    }
    
    public  void   setEnabledNotification(boolean  inEnabledNotification){
          enabledNotification = inEnabledNotification;
    }
    
    public  void  setAllowCustomerTransaction(boolean  inAllowCustomerTransaction){
         allowCustomerTransaction = inAllowCustomerTransaction;
    }
    
    public  void  setAllowSystemTransaction(boolean  inAllowSystemTransaction){
          allowSystemTransaction = inAllowSystemTransaction;
    }
    
    public  void  setPartnerStatus(boolean  inPartnerStatus){
         partnerStatus = inPartnerStatus;
    }
    
    public  void  setNoReplyEmailSender(String   inNoReplyEmailSender){
          noReplyEmailSender = inNoReplyEmailSender;
    }
    
    public  void  setSupportEmailSender(String   inSupportEmailSender){
          supportEmailSender = inSupportEmailSender;
          technicalSupportEmail = inSupportEmailSender;
          financeSupportEmail = inSupportEmailSender;
    }
    
    public  void  setSupportMobileNumber(String   inSupportMobileNumber){
          supportMobileNumber = inSupportMobileNumber;
    }
    
    public  void  setTechnicalSupportEmail(String   inTechnicalSupportEmail){
          technicalSupportEmail = inTechnicalSupportEmail;
    }
    
    public  void  setFinanceSupportEmail(String   inFinanceSupportEmail){
          financeSupportEmail = inFinanceSupportEmail;
    }
    
    public  void  setSmsSender(String   inSmsSender){
          smsSender = inSmsSender;
    }
    
    public  void  setSendVerificationEmail(boolean  inSendVerificationEmail){
        sendVerificationEmail = inSendVerificationEmail;
    }
    
    public  void  setSendVerificationSMS(boolean  inSendVerificationSMS){
        sendVerificationSMS = inSendVerificationSMS;
    }
     
    public  void  setSendTransactionEmailNotification(boolean  inSendTransactionEmailNotification){
         sendTransactionEmailNotification = inSendTransactionEmailNotification;
    }
    
    public  void  setSendTransactionSMSNotification(boolean  inSendTransactionSMSNotification){
         sendTransactionSMSNotification = inSendTransactionSMSNotification;
    }
    
    public  void  setKycLevel(String  inKycLevel){
          kycLevel = inKycLevel;
    }
    
    public  void  setMerchantSendMoneyKYCLevel(String  inMerchantSendMoneyKYCLevel){
         merchantSendMoneyKYCLevel = inMerchantSendMoneyKYCLevel;
    }
    
    public  void  setCreateNubanAccountForIndividual(boolean  inCreateNubanAccountForIndividual){
        createNubanAccountForIndividual = inCreateNubanAccountForIndividual;
    }
      
    
    public  void  setCreateNubanAccountForTeller(boolean  inCreateNubanAccountForTeller){
         createNubanAccountForTeller = inCreateNubanAccountForTeller;
    }
    
    public  void  setCreateNubanAccountForSuperAgent(boolean   inCreateNubanAccountForSuperAgent){
         createNubanAccountForSuperAgent = inCreateNubanAccountForSuperAgent;
    }
    
    public  void  setCreateNubanAccountForAgent(boolean   inCreateNubanAccountForAgent){
         createNubanAccountForAgent = inCreateNubanAccountForAgent;
    }
    
    public  void  setCreateNubanAccountForMerchant(boolean  inCreateNubanAccountForMerchant){
        createNubanAccountForMerchant = inCreateNubanAccountForMerchant;
    }
    
    public  void  setAllowBonusWalletCreation(boolean   inAllowBonusWalletCreation){
         allowBonusWalletCreation = inAllowBonusWalletCreation;
    }
    
    public  void  setApplyBonusOnTransaction(boolean  inApplyBonusOnTransaction){
       applyBonusOnTransaction = inApplyBonusOnTransaction;
    }
    
    public  void  setSendPushNotification(boolean  inSendPushNotification){
       sendPushNotification = inSendPushNotification;
    }
    
    public  void  setMakePhoneNumberUnique(boolean  inMakePhoneNumberUnique){
         makePhoneNumberUnique = inMakePhoneNumberUnique;
    }
    
    
    public  void  setSendLoginNotification(boolean  inSendLoginNotification){
         sendLoginNotification = inSendLoginNotification;
    }
    
    public  void  setAggregateWalletNotification(boolean  inAggregateWalletNotification){
        aggregateWalletNotification = inAggregateWalletNotification;
    }
    
    public  void  setCanFundWalletOutSideScheme(boolean  inCanFundWalletOutSideScheme){
         canFundWalletOutSideScheme = inCanFundWalletOutSideScheme;
    }
        
    
    public  void  setApplications(STSLApplication[]  inApplications){
        applications = inApplications;
    }
    
    
}
