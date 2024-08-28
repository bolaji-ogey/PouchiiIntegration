/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.requests;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.sql.Connection;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class LockFundRequest   extends  PouchiiRequestBase  {
    
    @NotBlank(message = "Lock transaction request cannot be null or empty")
    private  String  lockTransactionRequest  = "";
    
    @NotBlank(message = "Lock transaction amount cannot be null or empty")
    private  BigDecimal  lockTransactionAmount  =  new BigDecimal(0.00); 
    
    
    private  String  narration;
    
    @NotBlank(message = "Currency cannot be null or empty")
    private  String  currency  = "NGN";
    
    @NotBlank(message = "Source account cannot be null or empty")
    private  String  sourceAccount;
    
    @NotBlank(message = "Source account type cannot be null or empty")
    private  String  sourceAccountType;
    
    @NotBlank(message = "Transaction PIN cannot be null or empty") @Pattern(regexp="[0-9]")
    @Size(min=4,  max=4, message="Transaction PIN must be four (4) digits")
    private  String  transactionPin;
    
     
    
    
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
    
    
    
    public   final  LockFundRequest  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        LockFundRequest  lockFundRequest  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              lockFundRequest = objectMapper.readValue(inObjectJSON, LockFundRequest.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  lockFundRequest;
    }
     
     
    
    public  static  LockFundRequest  readFromJSON(String  inObjectJSON){ 
        LockFundRequest  lockFundRequest  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              lockFundRequest = objectMapper.readValue(inObjectJSON, LockFundRequest.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  lockFundRequest;
    }
      
    
    
    public  void  setLockTransactionRequest(String  inLockTransactionRequest){
        lockTransactionRequest  =  inLockTransactionRequest;
    }
    
    
    public  void  setLockTransactionAmount(BigDecimal  inLockTransactionAmount){
        lockTransactionAmount  =  inLockTransactionAmount;
    }
    
     
    public  void  setNarration(String  inNarration){
        narration  =  inNarration;
    }
   
    
    public  void  setCurrency(String  inCurrency){
        currency  =  inCurrency;
    }
     
    
    public  void  setSourceAccount(String  inSourceAccount){
        sourceAccount  =  inSourceAccount;
    }
    
     
    public  void  setSourceAccountType(String  inSourceAccountType){
        sourceAccountType  =  inSourceAccountType;
    }
    
    public  void  setTransactionPin(String  inTransactionPin){
        transactionPin  =  inTransactionPin;
    }
    
      
    
    
    
    
    
    
    public  String  getLockTransactionRequest(){
        return  lockTransactionRequest;
    }
    
    
    public  BigDecimal  getLockTransactionAmount(){
        return  lockTransactionAmount;
    }
    
     
    public  String  getNarration(){
        return  narration;
    }
   
    
    public  String  getCurrency(){
        return  currency;
    }
     
    
    public  String  getSourceAccount(){
        return  sourceAccount;
    }
    
     
    public  String  getSourceAccountType(){
        return  sourceAccountType;
    }
    
    public  String  getTransactionPin(){
        return  transactionPin;
    }
    
    
    
}
