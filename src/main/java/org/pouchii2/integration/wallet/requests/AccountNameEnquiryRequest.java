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
public class AccountNameEnquiryRequest   extends  PouchiiRequestBase  {
     
    private  String   url  =  "/walletservice/rest/api/wallet/account/lookup/{account_number}/{wallet}";
    private  String  accountNumber = "9014777477";
    private  String  bankCode = "Wallet";  // 052 / Wallet
    
    
    public  String  getUrl(){
        return url;
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
     
     
    
     public   final  AccountNameEnquiryRequest  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        AccountNameEnquiryRequest   accountNameEnquiryRequest  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              accountNameEnquiryRequest = objectMapper.readValue(inObjectJSON, AccountNameEnquiryRequest.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  accountNameEnquiryRequest;
    }
     
     
    
    public  static  AccountNameEnquiryRequest  readFromJSON(String  inObjectJSON){ 
        AccountNameEnquiryRequest  accountNameEnquiryRequest  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              accountNameEnquiryRequest = objectMapper.readValue(inObjectJSON, AccountNameEnquiryRequest.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  accountNameEnquiryRequest;
    }
      
    
    
    
    
    public  String  getAccountNumber(){
        return  accountNumber;
    }
    
    public  String  getBankCode(){
        return  bankCode;
    }
    
    
    
    public  void  setAccountNumber(String  inAccountNumber){
           accountNumber = inAccountNumber;
    }
    
    public  void  setBankCode(String  inBankCode){
           bankCode = inBankCode;
    }
    
    
}
