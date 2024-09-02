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
@JsonPropertyOrder({"transactionDate", "bookedBalanceAfterTransaction", "bookedBalanceBeforeTransaction",   
                          "availableBalanceAfterTransaction", "availableBalanceBeforeTransaction",  
                      "transactionAmount", "transactionEvent" }) 
public class TrxnJournalItem {
    
    @JsonProperty("transactionDate")
    private  String   transactionDate;
    
    @JsonProperty("bookedBalanceAfterTransaction")
    private  String   bookedBalanceAfterTransaction;
    
    @JsonProperty("bookedBalanceBeforeTransaction")
    private  String   bookedBalanceBeforeTransaction;
    
    @JsonProperty("availableBalanceAfterTransaction")
    private  String   availableBalanceAfterTransaction;
    
    @JsonProperty("availableBalanceBeforeTransaction")
    private  String   availableBalanceBeforeTransaction;
    
    @JsonProperty("transactionAmount")
    private  String   transactionAmount;
    
    @JsonProperty("transactionEvent")
    private  String   transactionEvent;
    
    
    
}
