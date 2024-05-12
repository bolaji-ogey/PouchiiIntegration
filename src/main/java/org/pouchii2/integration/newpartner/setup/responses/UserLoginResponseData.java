/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.newpartner.setup.responses;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class UserLoginResponseData {
    
                                                                                                                                                                                                                                       
    
    private String  applicationCode =  "POUCHII";
    private String  partnerCode =  "SPECS";
    private  int   applicationId = 1;
    private  int   partnerId = 50;
    private  boolean  isFirstLogin  = true;
    private String  userId =  "11941e4a-936f-496a-86b9-23c9caf83121";
    private String  firstName =  "Bolaji";
    private String  lastName =  "Ogeyingbo";
    private String  middleName =  "Lawrence";
    private String  mobileNumber =  "+2348083064718";
    private String  alternateMobileNumber =  "";
     
    private String  emailAddress =  "bogeyingbo@gmail.com";
    private String  alternateEmailAddress =  ""; 
    
    private  Authorization   authorization = new Authorization();
    
    private String  avatar =  "";
    private String[]  userAuthorities =  {"User"};
    private  UserTypeInfo  userTypeInfo =  new UserTypeInfo();
    
    private  boolean  pinCreated  = false;
    private  boolean  profileCreationCompleted  = false;
    private  String[]  menus  = null; 
    private  boolean  pushNotificationEnabled  = false;
    private  boolean  smsNotificationEnabled  = false;
    
    AppFeature[]  appFeatures  = null;   
    
   
    
    
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
    
    public boolean  getIsFirstLogin(){
        return  isFirstLogin;
    }
    
    public String  getUserId(){
        return  userId;
    }
    
    public String  getFirstName(){
        return  firstName;
    }
    
    public String  getLastName(){
        return  lastName;
    }
    
    public String  getMiddleName(){
        return  middleName;
    }
    
    public String  getMobileNumber(){
        return  mobileNumber;
    }
    
    public String  getAlternateMobileNumber(){
        return  alternateMobileNumber;
    }
 
    public String  getEmailAddress(){
        return  emailAddress;
    }
    
    public String  getAlternateEmailAddress(){
        return  alternateEmailAddress;
    }
    
    public Authorization  getAuthorization(){
        return  authorization;
    }
    
    public String  getAvatar(){
        return  avatar;
    }
    
    public String[]  getUserAuthorities(){
        return  userAuthorities;
    }
    
    public UserTypeInfo  getUserTypeInfo(){
        return  userTypeInfo;
    }
    
    public boolean  getPinCreated(){
        return  pinCreated;
    }
    
    public boolean  getProfileCreationCompleted(){
        return  profileCreationCompleted;
    }
    
    public String[]  getMenus(){
        return  menus;
    }
    
     
    
    public boolean  getPushNotificationEnabled(){
        return  pushNotificationEnabled;
    }
    
    public boolean  getSmsNotificationEnabled(){
        return  smsNotificationEnabled;
    }
    
    public AppFeature[]  getAppFeatures(){
        return  appFeatures;
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
    
    public void  setIsFirstLogin(boolean  inIsFirstLogin){
           isFirstLogin = inIsFirstLogin;
    }
    
    public void  setUserId(String  inUserId){
          userId = inUserId;
    }
    
    public  void  setFirstName(String  inFirstName){
          firstName = inFirstName;
    }
    
    public  void  setLastName(String  inLastName){
          lastName = inLastName;
    }
    
    public void  setMiddleName(String  inMiddleName){
           middleName = inMiddleName;
    }
    
    public void  setMobileNumber(String  inMobileNumber){
           mobileNumber = inMobileNumber;
    }
    
    public void  setAlternateMobileNumber(String  inAlternateMobileNumber){
           alternateMobileNumber = inAlternateMobileNumber;
    }
 
    public  void  setEmailAddress(String  inEmailAddress){
         emailAddress = inEmailAddress;
    }
    
    public void  setAlternateEmailAddress(String   inAlternateEmailAddress){
           alternateEmailAddress = inAlternateEmailAddress;
    }
    
    public void  setAuthorization(Authorization   inAuthorization){
           authorization = inAuthorization;
    }
    
    public void  setAvatar(String  inAvatar){
           avatar =  inAvatar;
    }
    
    public void  setUserAuthorities(String[]  inUserAuthorities){
           userAuthorities = inUserAuthorities;
    }
    
    public void  setUserTypeInfo(UserTypeInfo  inUserTypeInfo){
          userTypeInfo = inUserTypeInfo;
    }
    
    
    
     public void  setPinCreated(boolean  inPinCreated){
           pinCreated = inPinCreated;
    }
    
    public void  setProfileCreationCompleted(boolean  inProfileCreationCompleted){
           profileCreationCompleted = inProfileCreationCompleted;
    }
    
    public void  setMenus(String[]  inMenus){
           menus = inMenus;
    }
    
    
    
    public void  setPushNotificationEnabled(boolean  inPushNotificationEnabled){
          pushNotificationEnabled = inPushNotificationEnabled;
    }
    
    public void  setSmsNotificationEnabled(boolean  inSmsNotificationEnabled){
           smsNotificationEnabled = inSmsNotificationEnabled;
    }
    
    public void  setAppFeatures(AppFeature[]  inAppFeatures){
           appFeatures = inAppFeatures;
    }
    
    
    
    
}
