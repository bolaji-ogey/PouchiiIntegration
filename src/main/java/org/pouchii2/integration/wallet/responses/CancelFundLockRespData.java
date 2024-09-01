/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
@JsonPropertyOrder({"customerReference", "lockTransactionAmount", "lockTransactionFeeAmount", "lockNarration",
                       "cancelLockNarration", "currency", "sourceAccount", "sourceAccountType", "lockTransactionRequest",
                          "cancelLockTransactionRequest",  "date_created",  "dateCancelled"})
public class CancelFundLockRespData {
      
         
    @JsonProperty("customerReference")
    private  String  customerReference;
    
    @JsonProperty("lockTransactionAmount")
    private  String  lockTransactionAmount;
    
    @JsonProperty("lockTransactionFeeAmount")
    private  String  lockTransactionFeeAmount;
    
    @JsonProperty("lockNarration")
    private  String  lockNarration;
    
    @JsonProperty("cancelLockNarration")
    private  String  cancelLockNarration;
    
    @JsonProperty("currency")
    private  String  currency;
    
    @JsonProperty("sourceAccount")
    private  String  sourceAccount;
    
    @JsonProperty("sourceAccountType")
    private  String  sourceAccountType;
    
    @JsonProperty("lockTransactionRequest")
    private  String  lockTransactionRequest;
    
     @JsonProperty("cancelLockTransactionRequest")
    private  String  cancelLockTransactionRequest;
    
    @JsonProperty("date_created")
    private  String  date_created;
    
     @JsonProperty("dateCancelled")
    private  String  dateCancelled;
    
    
     public  void  setCustomerReference(String  inCustomerReference){
         customerReference  =  inCustomerReference;
     }
             
     public  void  setLockTransactionAmount(String  inLockTransactionAmount){
         lockTransactionAmount  =  inLockTransactionAmount;
     }
     
     public  void  setLockTransactionFeeAmount(String  inLockTransactionFeeAmount){
         lockTransactionFeeAmount  =  inLockTransactionFeeAmount;
     }
     
    public  void  setLockNarration(String  inLockNarration){
         lockNarration  =  inLockNarration;
    }
    
    
    public  void  setCancelLockNarration(String  inCancelLockNarration){
         cancelLockNarration  =  inCancelLockNarration;
    }
    
    
    public  void  setCurrency(String  inCurrency){
         currency  =  inCurrency;
    } 
                           
    
    public  void  setSourceAccount(String  inSourceAccount){
        sourceAccount =  inSourceAccount;
    }
    
    public  void  setSourceAccountType(String  inSourceAccountType){
        sourceAccountType =  inSourceAccountType;
    }
    
    public  void  setLockTransactionRequest(String  inLockTransactionRequest){
        lockTransactionRequest =  inLockTransactionRequest;
    }
    

    public  void  setCancelLockTransactionRequest(String  inCancelLockTransactionRequest){
        cancelLockTransactionRequest =  inCancelLockTransactionRequest;
    }


    public  void  setDate_created(String  inDate_created){
        date_created =  inDate_created;
    }
    
    public  void  setDateCancelled(String  inDateCancelled){
        dateCancelled =  inDateCancelled;
    }
    
    
    
    
    
    
    
    public  String  getCustomerReference(){
       return  customerReference;
    }
     
    public  String  getLockTransactionAmount(){
       return    lockTransactionAmount;
    }
    
    public  String  getLockTransactionFeeAmount(){
       return   lockTransactionFeeAmount;
    }
    
    public  String  getLockNarration(){
       return   lockNarration;
    }
    
    public  String  getCancelLockNarration(){
        return    cancelLockNarration;
    }
    
    public  String  getCurrency(){
       return   currency;
    }
    
    public  String  getSourceAccount(){
        return   sourceAccount;
    }
    
    public  String  getSourceAccountType(){
        return   sourceAccountType;
    }
    
    public  String  getLockTransactionRequest(){
        return   lockTransactionRequest;
    }
    
    public  String  getDate_created(){
        return   date_created;
    }
    
    
    public  String  getDateCancelled(){
        return  dateCancelled;
    }
    
    
             
}
