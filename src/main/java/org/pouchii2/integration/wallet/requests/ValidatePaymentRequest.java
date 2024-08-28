/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.requests;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.sql.Connection;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class ValidatePaymentRequest extends  PouchiiRequestBase  {
    
    @NotBlank(message = "Wallet number cannot be null or empty")
    private String  walletNumber;
     
    @NotBlank(message = "Currency cannot be null or empty")
    @Size(min=3,  max=3, message="Currency must be three (3) letter code")
    private  String  currency  = "";
    
    
    @NotBlank(message = "Transaction event cannot be null or empty")
    private  String  transactionEvent  = "";
    
    @NotBlank(message = "Transaction mode cannot be null or empty")
    private  String  transactionMode  = "";
     
       
    @NotBlank(message = "Transaction amount cannot be null or empty")
    private  BigDecimal  transactionAmount  =  new BigDecimal(0.00); 
    
    
    
    public  void  setWalletNumber(String  inWalletNumber){
        walletNumber  = inWalletNumber;
    }
       
    public  void  setCurrency(String  inCurrency){
        currency  = inCurrency;
    }
    
    public  void  setTransactionEvent(String  inTransactionEvent){
        transactionEvent  = inTransactionEvent;
    }
    
    public  void  setTransactionMode(String  inTransactionMode){
        transactionMode  = inTransactionMode;
    }
    
     
    public  void  setTransactionAmount(BigDecimal  inTransactionAmount){
        transactionAmount  = inTransactionAmount;
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
    
    
    
    public   final  ValidatePaymentRequest  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        ValidatePaymentRequest  validatePaymentRequest  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              validatePaymentRequest = objectMapper.readValue(inObjectJSON, ValidatePaymentRequest.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  validatePaymentRequest;
    }
     
     
    
    public  static  ValidatePaymentRequest  readFromJSON(String  inObjectJSON){ 
        ValidatePaymentRequest  validatePaymentRequest  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              validatePaymentRequest = objectMapper.readValue(inObjectJSON, ValidatePaymentRequest.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  validatePaymentRequest;
    }
      
    
    
    
    public  String  getWalletNumber(){
       return   walletNumber;
    }
       
    public  String  getCurrency(){
       return    currency;
    }
    
    public  String  getTransactionEvent(){
        return   transactionEvent;
    }
    
    public  String  getTransactionMode(){
        return   transactionMode;
    }
    
     
    public  BigDecimal  getTransactionAmount(){
        return   transactionAmount;
    }
    
    
    
    
    
}
