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
    
    
    public  void  setTransactionDate(String    inTransactionDate){
        transactionDate   =   inTransactionDate;
    }
    
    public  void  setBookedBalanceAfterTransaction(String    inBookedBalanceAfterTransaction){
        bookedBalanceAfterTransaction   =   inBookedBalanceAfterTransaction;
    }
    
    public  void  setBookedBalanceBeforeTransaction(String    inBookedBalanceBeforeTransaction){
        bookedBalanceBeforeTransaction   =   inBookedBalanceBeforeTransaction;
    }
    
    public  void  setAvailableBalanceAfterTransaction(String    inAvailableBalanceAfterTransaction){
        availableBalanceAfterTransaction   =   inAvailableBalanceAfterTransaction;
    }
    
    public  void  setAvailableBalanceBeforeTransactionTransactionDate(String    inAvailableBalanceBeforeTransaction){
        availableBalanceBeforeTransaction   =   inAvailableBalanceBeforeTransaction;
    }
    
    public  void  setTransactionAmount(String    inTransactionAmount){
        transactionAmount   =   inTransactionAmount;
    }
    
    public  void  setTransactionEvent(String    inTransactionEvent){
        transactionEvent   =   inTransactionEvent;
    }
    
    
    
    
    
    
    
    public  String  getTransactionDate(){
        return    transactionDate;
    }
    
    public  String  getBookedBalanceAfterTransaction(){
        return    bookedBalanceAfterTransaction;
    }
    
    public  String  getBookedBalanceBeforeTransaction(){
        return    bookedBalanceBeforeTransaction;
    }
    
    public  String  getAvailableBalanceAfterTransaction(){
        return    availableBalanceAfterTransaction;
    }
    
    public  String  getAvailableBalanceBeforeTransactionTransactionDate(){
        return    availableBalanceBeforeTransaction;
    }
    
    public  String  getTransactionAmount(){
        return    transactionAmount;
    }
    
    public  String  getTransactionEvent(){
        return    transactionEvent;
    }
    
    
    
}
