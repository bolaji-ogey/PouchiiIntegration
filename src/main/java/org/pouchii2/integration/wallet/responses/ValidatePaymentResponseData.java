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
     
     
     
}
