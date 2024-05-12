/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.requests;
 
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper; 
import java.sql.Connection;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class CreateMerchCustomerWallet    extends  PouchiiRequestBase  {
      
    private  String  firstName = "-"; 
    private  String  middleName = "-"; 
    private  String  lastName = "-"; 
    private  String  gender = "Male"; 
    private  String  currency = "NGN"; 
    
    private  String  bvn = ""; 
    private  String  emailAddress = "-"; 
    private  String  mobileNumber = "-"; 
    private  String  address = "-"; 
    private  String  walletType = "CUSTOMER"; 
    private  String  walletName = "-"; 
    private  boolean  createNubanAccount = true; 
    private  String  dateOfBirth = "2001-01-13"; 
     
       
    
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
     
     
    
     public   final  CreateMerchCustomerWallet  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        CreateMerchCustomerWallet   createMerchCustomerWallet  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              createMerchCustomerWallet = objectMapper.readValue(inObjectJSON, CreateMerchCustomerWallet.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  createMerchCustomerWallet;
    }
     
     
     
    
    public  static  CreateMerchCustomerWallet  readFromJSON(String  inObjectJSON){ 
        CreateMerchCustomerWallet  createMerchCustomerWallet  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              createMerchCustomerWallet = objectMapper.readValue(inObjectJSON, CreateMerchCustomerWallet.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  createMerchCustomerWallet;
    }
      
     
    
    
     
    public  String  getFirstName(){
        return  firstName;
    }
    
    public  String  getMiddleName(){
       return  middleName; 
    }
    
    public  String  getLastName(){
        return  lastName;
    }
    
    public  String  getGender(){
        return  gender;
    }
    
    public  String  getCurrency(){
        return  currency;
    }
    
    public  String  getBvn(){
        return  bvn;
    }
    
    public  String  getEmailAddress(){
        return  emailAddress;
    }
    
    public  String  getMobileNumber(){
        return  mobileNumber;
    }
    
    public  String  getAddress(){
        return  address;
    } 
    
    public  String  getWalletType(){
        return  walletType;
    }
    
    public  String  getWalletName(){
        return  walletName;
    }
    
    public  boolean  getCreateNubanAccount(){
        return  createNubanAccount;
    }
    
    public  String  getDateOfBirth(){
        return  dateOfBirth;
    } 
    
    
    
    
    
    
    
    
    
    public  void  setFirstName(String  inFirstName){
           firstName = inFirstName;
    }
    
    public  void  setMiddleName(String  inMiddleName){
          middleName = inMiddleName; 
    }
    
    public  void  setLastName(String  inLastName){
           lastName = inLastName;
    }
    
    public  void  setGender(String  inGender){
           gender = inGender;
    }
    
    public  void  setCurrency(String  inCurrency){
           currency = inCurrency;
    }
    
    public  void  setBvn(String  inBvn){
           bvn = inBvn;
    }
    
    public  void  setEmailAddress(String  inEmailAddress){
           emailAddress = inEmailAddress;
    }
    
    public  void  setMobileNumber(String  inMobileNumber){
           mobileNumber = inMobileNumber;
    }
    
    public  void  setAddress(String  inAddress){
           address = inAddress;
    } 
    
    public  void  setWalletType(String  inWalletType){
           walletType = inWalletType;
    }
    
    public  void  setWalletName(String  inWalletName){
           walletName = inWalletName;
    }
    
    public  void  setCreateNubanAccount(boolean  inCreateNubanAccount){
           createNubanAccount = inCreateNubanAccount;
    }
    
    public  void  setDateOfBirth(String  inDateOfBirth){
           dateOfBirth = inDateOfBirth;
    }
    
    
    
    
}
