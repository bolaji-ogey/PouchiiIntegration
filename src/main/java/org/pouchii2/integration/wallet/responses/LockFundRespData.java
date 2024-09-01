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
@JsonPropertyOrder({"customerReference", "lockTransactionAmount", "lockTransactionFeeAmount"})
public class LockFundRespData {
    
    @JsonProperty("customerReference")
    private  String  customerReference;
    
    @JsonProperty("lockTransactionAmount")
    private  String  lockTransactionAmount;
    
    @JsonProperty("lockTransactionFeeAmount")
    private  String  lockTransactionFeeAmount;
    
    @JsonProperty("lockNarration")
    private  String  lockNarration;
    
    @JsonProperty("currency")
    private  String  currency;
    
    @JsonProperty("sourceAccount")
    private  String  sourceAccount;
    
    @JsonProperty("sourceAccountType")
    private  String  sourceAccountType;
    
    @JsonProperty("lockTransactionRequest")
    private  String  lockTransactionRequest;
    
    @JsonProperty("date_created")
    private  String  date_created;
       
    
    public  void  setCustomerReference(String  inCustomerReference){
        customerReference =  inCustomerReference;
    }
     
    public  void  setLockTransactionAmount(String  inLockTransactionAmount){
        lockTransactionAmount =  inLockTransactionAmount;
    }
    
    public  void  setLockTransactionFeeAmount(String  inLockTransactionFeeAmount){
        lockTransactionFeeAmount =  inLockTransactionFeeAmount;
    }
    
    public  void  setLockNarration(String  inLockNarration){
        lockNarration =  inLockNarration;
    }
    
    public  void  setCurrency(String  inCurrency){
        currency =  inCurrency;
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
    
    public  void  setDate_created(String  inDate_created){
        date_created =  inDate_created;
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
    
    
    
    
}
