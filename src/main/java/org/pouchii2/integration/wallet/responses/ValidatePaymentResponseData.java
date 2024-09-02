/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.math.BigDecimal;
import java.util.ArrayList;
//import org.pouchii2.callback.url.TransactionFee;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
@JsonPropertyOrder({"transactionAmount", "transactionFeeAmount", "totalTransactionAmount",
                           "appliedBonusAmount", "transactionFees"})
public class ValidatePaymentResponseData {
    
     @JsonProperty("transactionAmount")
     private  BigDecimal  transactionAmount  =  new  BigDecimal(0.00);
     
     @JsonProperty("transactionFeeAmount")
     private  BigDecimal  transactionFeeAmount  =  new  BigDecimal(0.00);
     
     @JsonProperty("totalTransactionAmount")
     private  BigDecimal  totalTransactionAmount  =  new  BigDecimal(0.00);
     
     @JsonProperty("appliedBonusAmount")
     private  BigDecimal  appliedBonusAmount  =  new  BigDecimal(0.00);
     
     @JsonProperty("transactionFees")
     private  ArrayList<TransactionFee>   transactionFees   =  new  ArrayList<>();
     
     
     
     public  void  setTransactionAmount(BigDecimal    inTransactionAmount){
          transactionAmount  =  inTransactionAmount;
     }
     
     
     public  void  setTransactionFeeAmount(BigDecimal    inTransactionFeeAmount){
          transactionFeeAmount  =  inTransactionFeeAmount;
     }
     
     
     public  void  setTotalTransactionAmount(BigDecimal    inTotalTransactionAmount){
          totalTransactionAmount  =  inTotalTransactionAmount;
     }
     
     
     public  void  setAppliedBonusAmount(BigDecimal    inAppliedBonusAmount){
          appliedBonusAmount  =  inAppliedBonusAmount;
     }
     
     public  void  setTransactionFees(ArrayList<TransactionFee>    inTransactionFees){
          transactionFees  =  inTransactionFees;
     }
     
     
     
     
     
     
     
     
     
    public  BigDecimal  getTransactionAmount(){
          return   transactionAmount;
     }
     
     
     public  BigDecimal  getTransactionFeeAmount(){
          return   transactionFeeAmount;
     }
     
     
     public  BigDecimal  getTotalTransactionAmount(){
          return   totalTransactionAmount;
     }
     
     
     public  BigDecimal  getAppliedBonusAmount(){
          return   appliedBonusAmount;
     }
     
     public  ArrayList<TransactionFee>  getTransactionFees(){
          return   transactionFees;
     }
     
     
     
     
}
