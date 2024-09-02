/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.responses;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.pouchii2.callback.url.*;
import org.json.JSONObject;
/**
 *
 * @author BOLAJI-OGEYINGBO
 */

@JsonPropertyOrder({"transactionDate", "bookedBalanceAfterTransaction", "bookedBalanceBeforeTransaction",   
                          "availableBalanceAfterTransaction", "availableBalanceBeforeTransaction",  
                      "transactionAmount", "transactionEvent" }) 
public class TransactionFee {
     
    @JsonProperty("feeName")
    private  String  feeName = "Commission";
    
    @JsonProperty("feeOperator")
    private  String  feeOperator = "";
    
    @JsonProperty("feeType")
    private  String  feeType = "Percentage";
    
    @JsonProperty("feeAmount")
    private  String  feeAmount = "";
    
    
    
    
    public  String  getFeeName(){
       return   feeName;
    }
    
    public  String  getFeeOperator(){
       return   feeOperator;
    }
    
    public  String  getFeeType(){
       return  feeType; 
    }
    
    
    public  String  getFeeAmount(){
      return    feeAmount;
    }
    
    
    
    
    
    
    public  void  setFeeName(String  inFeeName){
         feeName  =  inFeeName;
    }
    
    public  void  setFeeOperator(String  inFeeOperator){
        feeOperator = inFeeOperator;
    }
    
    public  void  setFeeType(String   inFeeType){
         feeType = inFeeType; 
    }
    
    
    public  void  setFeeAmount(String  inFeeAmount){
        feeAmount = inFeeAmount;
    }
    
    
    
    
}
