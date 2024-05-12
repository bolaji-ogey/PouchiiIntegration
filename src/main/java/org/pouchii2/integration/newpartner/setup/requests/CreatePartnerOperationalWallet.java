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
public class CreatePartnerOperationalWallet  extends   PouchiiAdminRequestBase {
    
    private    String  schemeId =  "d2423272-dc1b-4c7b-b774-6fac86e8085d";
    private         long  partnerId =  -1;
    private         long  merchantId =  -1;
    private  final  long  applicationId =  1;
    private  final  String  currency =  "NGN";
    private     String  walletName =  "Operational Wallet";
    private  final  boolean  status =  true;
    private  final  String  walletOperationType =  "Any";
    private   String  bankAccountName =  "Operational Wallet";
   private    String  bankAccountNumber =  "1234500081";                                                                                                                                                                                      
    
    private    final     long  bankId =  1;
    
    
       
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
     
    
    
     public   final  CreatePartnerOperationalWallet  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        CreatePartnerOperationalWallet   createPartnerOperationalWallet  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              createPartnerOperationalWallet = objectMapper.readValue(inObjectJSON, CreatePartnerOperationalWallet.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  createPartnerOperationalWallet;
    }
     
    
    public  static  CreatePartnerOperationalWallet  readFromJSON(String  inObjectJSON){ 
        CreatePartnerOperationalWallet  createPartnerOperationalWallet  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              createPartnerOperationalWallet = objectMapper.readValue(inObjectJSON, CreatePartnerOperationalWallet.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  createPartnerOperationalWallet;
    }
      
    
    public String  getSchemeId(){
        return  schemeId;
    }
    
    public long  getPartnerId(){
        return  partnerId;
    }
    
    public long  getMerchantId(){
        return  merchantId;
    }
    
    public  long  getApplicationId(){
        return  applicationId;
    }
    
    
    public String  getCurrency(){
        return  currency;
    }
    
    public String  getWalletName(){
        return  walletName;
    }
    
    public boolean  getStatus(){
        return  status;
    }
    
    public String  getWalletOperationType(){
        return  walletOperationType;
    }
    
    public String  getBankAccountName(){
        return  bankAccountName;
    }
    
    public String  getBankAccountNumber(){
        return  bankAccountNumber;
    }
    
    
    
    
   
     public void  setPartnerId(long  inPartnerId){
         partnerId = inPartnerId;
    }
    
    public void  setMerchantId(long  inMerchantId){
         merchantId = inMerchantId;
    }
    
     public void  setWalletName(String inWalletName){
        walletName = inWalletName;
    }
    
    
    public void  setBankAccountName(String  inBankAccountName){
          bankAccountName = inBankAccountName;
    }
    
    public void  setBankAccountNumber(String  inBankAccountNumber){
         bankAccountNumber = inBankAccountNumber;
    }
    
    
    
 
}
