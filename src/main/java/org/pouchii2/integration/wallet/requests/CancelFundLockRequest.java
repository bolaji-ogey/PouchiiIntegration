/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.requests;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.sql.Connection;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class CancelFundLockRequest  extends  PouchiiRequestBase  {
    
    @NotBlank(message = "Lock transaction request cannot be null or empty")
    private  String  lockTransactionRequest  = "";
    
    @NotBlank(message = "Request reference cannot be null or empty")
    private  String  requestReference  = "";
    
    @NotBlank(message = "Lock transaction amount cannot be null or empty")
    private  BigDecimal  lockTransactionAmount  =  new BigDecimal(0.00); 
    
    @NotBlank(message = "Lock transaction fee amount cannot be null or empty")
    private  BigDecimal  lockTransactionFeeAmount  =  new BigDecimal(0.00);
    
    private  String  narration;
    
    @NotBlank(message = "Currency cannot be null or empty")
    private  String  currency  = "NGN";
    
    @NotBlank(message = "Source account cannot be null or empty")
    private  String  sourceAccount;
    
    @NotBlank(message = "Source account type cannot be null or empty")
    private  String  sourceAccountType;
     
    
     
    
    
    
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
    
    
    
    public   final  CancelFundLockRequest  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        CancelFundLockRequest  cancelFundLockRequest  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              cancelFundLockRequest = objectMapper.readValue(inObjectJSON, CancelFundLockRequest.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  cancelFundLockRequest;
    }
     
     
    
    public  static  CancelFundLockRequest  readFromJSON(String  inObjectJSON){ 
        CancelFundLockRequest  cancelFundLockRequest  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              cancelFundLockRequest = objectMapper.readValue(inObjectJSON, CancelFundLockRequest.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  cancelFundLockRequest;
    }
      
    
    
    
        
    public  void  setLockTransactionRequest(String  inLockTransactionRequest){
        lockTransactionRequest  =  inLockTransactionRequest;
    }
    
    
    public  void  setRequestReference(String  inRequestReference){
        requestReference  =  inRequestReference;
    }
    
    public  void  setLockTransactionAmount(BigDecimal  inLockTransactionAmount){
        lockTransactionAmount  =  inLockTransactionAmount;
    }
    
     
    public  void  setLockTransactionFeeAmount(BigDecimal  inLockTransactionFeeAmount){
        lockTransactionFeeAmount  =  inLockTransactionFeeAmount;
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
    
    
    
      
    
    
    
    
    
    
    public  String  getLockTransactionRequest(){
        return  lockTransactionRequest;
    }
    
    
     public  String  getRequestReference(){
        return  requestReference;
    }
    
    
    public  BigDecimal  getLockTransactionAmount(){
        return  lockTransactionAmount;
    }
    
     
    public  BigDecimal  getLockTransactionFeeAmount(){
        return  lockTransactionFeeAmount;
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
    
    
    
}
