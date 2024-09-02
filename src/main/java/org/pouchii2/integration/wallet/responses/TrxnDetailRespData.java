/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
@JsonPropertyOrder({"transactionId", "transactionReference", "processorReference",   "transactionEvent",  "transactionType",
                          "transactionMode", "transactionModeDescription", "currency",  "transactionStartDate", "transactionEndDate",
                      "transactionAmount", "transactionValueAmount", "transactionFeeAmount",  "bonusCreditAmount", "bonusDebitAmount",
                            "sourceAccount",  "beneficiaryAccount", "purchaseToken", "availableBalanceBeforeTransaction", "bookedBalanceBeforeTransaction", 
                                 "bookedBalanceAfterTransaction", "transactionStatus", "senderName",   "receiverName",  "receivingBank", "serviceProvider",
                                     "serviceCustomerId", "narration", "productProviderCustomerName",  "productProviderCustomerAddress" }) 
public class TrxnDetailRespData {
    
      
    @JsonProperty("transactionId") 
    private  long   transactionId  = -1;
    
    @JsonProperty("transactionReference")
    private  String  transactionReference = ""; 
    
    @JsonProperty("processorReference")
    private  String  processorReference = "";
    
    @JsonProperty("transactionEvent")
    private  String  transactionEvent = "";
    
    @JsonProperty("transactionType")
    private  String  transactionType = "";
    
    @JsonProperty("transactionMode")
    private  String  transactionMode = "";
    
    @JsonProperty("transactionModeDescription")
    private  String  transactionModeDescription = "";
    
    @JsonProperty("currency")
    private  Currency  currency  =  new Currency();
    
    @JsonProperty("transactionStartDate")
    private  String  transactionStartDate = "";
    
    @JsonProperty("transactionEndDate")
    private  String  transactionEndDate = "";
    
    @JsonProperty("transactionAmount")
    private  String  transactionAmount = "";
    
    @JsonProperty("transactionValueAmount")
    private  String  transactionValueAmount = "";
    
    @JsonProperty("transactionFeeAmount")
    private  String  transactionFeeAmount = "";  
    
   
    
    
    @JsonProperty("bonusCreditAmount")
    private  String  bonusCreditAmount = "";
    
    @JsonProperty("bonusDebitAmount")
    private  String  bonusDebitAmount = "";
                
    @JsonProperty("sourceAccount")
    private  String  sourceAccount = "";
    
    
    
    @JsonProperty("beneficiaryAccount")
    private  String  beneficiaryAccount = "";
    
    @JsonProperty("purchaseToken")
    private  String  purchaseToken = "";
    
    @JsonProperty("availableBalanceBeforeTransaction")
    private  String  availableBalanceBeforeTransaction = "0.00";
    
    @JsonProperty("availableBalanceAfterTransaction")
    private  String  availableBalanceAfterTransaction = "0.00";
    
    @JsonProperty("bookedBalanceBeforeTransaction")
    private  String  bookedBalanceBeforeTransaction = "0.00";
    
    @JsonProperty("bookedBalanceAfterTransaction")
    private  String  bookedBalanceAfterTransaction = "0.00";
    
    
         
    
    @JsonProperty("transactionStatus")
    private  String  transactionStatus = ""; 
    
    @JsonProperty("senderName")
    private  String  senderName = "";
    
    @JsonProperty("receiverName")
    private  String  receiverName = "";
    
    @JsonProperty("receivingBank")
    private  String  receivingBank = "";
    
    @JsonProperty("serviceProvider")
    private  String  serviceProvider = "";
    
    @JsonProperty("serviceCustomerId")
    private  String  serviceCustomerId = "";
    
    @JsonProperty("narration")
    private  String  narration = "Send Money";
     
    @JsonProperty("productProviderCustomerName")
    private  String  productProviderCustomerName = "";
    
    @JsonProperty("productProviderCustomerAddress")
    private  String  productProviderCustomerAddress = "";
    
    @JsonProperty("transactionStatusHistory")
    private  ArrayList<TraxnHistoryItem>  transactionStatusHistory   =  new  ArrayList<>();
                
                 
   @JsonProperty("transaction_journal_history")
    private  ArrayList<TrxnJournalItem>  transaction_journal_history   =  new  ArrayList<>();          
                 
                
             
    
     
    
   
    public  long  getTransactionId(){
        return  transactionId;
    }
    
    public  String  getTransactionReference(){
        return  transactionReference;
    }
     
    public  String  getProcessorReference(){
        return  processorReference;
    }
    
    public  String  getTransactionModeDescription(){
        return  transactionModeDescription;
    }
    
    public  Currency  getCurrency(){
        return  currency;
    }
    
    public  String  getTransactionStatus(){
        return  transactionStatus;
    }
    
    public  String  getTransactionAmount(){
        return  transactionAmount;
    }
    
    public  String  getTransactionValueAmount(){
        return  transactionValueAmount;
    }
    
    
    public  String  getTransactionFeeAmount(){
        return  transactionFeeAmount;
    }
    
    public  String  getBonusCreditAmount(){
        return  bonusCreditAmount;
    }
    
    public  String  getBonusDebitAmount(){
        return  bonusDebitAmount;
    }
    
    
    
    public  String  getAvailableBalanceBeforeTransaction(){
        return  availableBalanceBeforeTransaction;
    }
    public  String  getAvailableBalanceAfterTransaction(){
        return  availableBalanceAfterTransaction;
    }
          
    public  String  getBookedBalanceBeforeTransaction(){
        return  bookedBalanceBeforeTransaction;
    }
    public  String  getBookedBalanceAfterTransaction(){
        return  bookedBalanceAfterTransaction;
    }
    
    
    
    public  String  getSourceAccount(){
        return  sourceAccount;
    }
    public  String  getBeneficiaryAccount(){
        return  beneficiaryAccount;
    }
    
    public  String  getPurchaseToken(){
        return  purchaseToken;
    }
    
   
    
     
    public  String  getServiceCustomerId(){
        return  serviceCustomerId;
    }
    public  String  getNarration(){
        return  narration;
    }
    
    public  String  getTransactionStartDate(){
        return  transactionStartDate;
    }
    
    public  String  getTransactionEndDate(){
        return  transactionEndDate;
    }
    
    
    public  String  getTransactionEvent(){
        return  transactionEvent;
    }
    
    public  String  getTransactionType(){
        return  transactionType;
    }
    
    public  String  getTransactionMode(){
        return  transactionMode;
    }
      
     
    public  String  getSenderName(){
        return  senderName;
    }
    
    public  String  getReceiverName(){
        return  receiverName;
    }
    
    public  String  getReceivingBank(){
        return  receivingBank;
    }
    
    public  String  getServiceProvider(){
        return  serviceProvider;
    }
    
     
     
    public  String  getProductProviderCustomerName(){
        return  productProviderCustomerName;
    }
    
    public  String  getProductProviderCustomerAddress(){
        return  productProviderCustomerAddress;
    }
    
    
    
    
    
    
    
    
    
     
    public  void  setTransactionId(long  inTransactionId){
           transactionId = inTransactionId;
    }
    
    public  void  setTransactionReference(String  inTransactionReference){
           transactionReference = inTransactionReference;
    }
     
    
    public  void  setProcessorReference(String  inProcessorReference){
           processorReference = inProcessorReference;
    }
    
    
    public  void  setTransactionModeDescription(String  inTransactionModeDescription){
           transactionStatus = inTransactionModeDescription;
    }
    
    
    public  void  setCurrency(Currency    inCurrency){
           currency = inCurrency;
    }
    
    
    public  void  setTransactionStatus(String  inTransactionStatus){
           transactionStatus = inTransactionStatus;
    }
    
    public  void  setTransactionAmount(String  inTransactionAmount){
           transactionAmount = inTransactionAmount;
    }
    
    public  void  setTransactionValueAmount(String  inTransactionValueAmount){
           transactionValueAmount = inTransactionValueAmount;
    }
    
    
    public  void  setTransactionFeeAmount(String  inTransactionFeeAmount){
           transactionFeeAmount = inTransactionFeeAmount;
    }
    
    public  void  setBonusCreditAmount(String  inBonusCreditAmount){
           bonusCreditAmount = inBonusCreditAmount;
    }
    
    public  void  setBonusDebitAmount(String  inBonusDebitAmount){
           bonusDebitAmount = inBonusDebitAmount;
    }
     
    
    
    public  void  setAvailableBalanceBeforeTransaction(String  inAvailableBalanceBeforeTransaction){
           availableBalanceBeforeTransaction = inAvailableBalanceBeforeTransaction;
    }
          
    public  void  setAvailableBalanceAfterTransaction(String  inAvailableBalanceAfterTransaction){
           availableBalanceAfterTransaction = inAvailableBalanceAfterTransaction;
    }
    public  void  setBookedBalanceBeforeTransaction(String  inBookedBalanceBeforeTransaction){
           bookedBalanceBeforeTransaction = inBookedBalanceBeforeTransaction;
    }
    
    public  void  setBookedBalanceAfterTransaction(String  inBookedBalanceAfterTransaction){
           bookedBalanceAfterTransaction = inBookedBalanceAfterTransaction;
    }
    
    
    public  void  setSourceAccount(String  inSourceAccount){
           sourceAccount = inSourceAccount;
    }
    
    public  void  setBeneficiaryAccount(String  inBeneficiaryAccount){
           beneficiaryAccount = inBeneficiaryAccount;
    }
    
    public  void  setPurchaseToken(String  inPurchaseToken){
           purchaseToken = inPurchaseToken;
    }
    
    
     
    public  void  setServiceCustomerId(String  inServiceCustomerId){
           serviceCustomerId = inServiceCustomerId;
    }
    public  void  setNarration(String  inNarration){
           narration = inNarration;
    }
    
    public  void  setTransactionStartDate(String  inTransactionStartDate){
           transactionStartDate = inTransactionStartDate;
    }
    
    public  void  setTransactionEndDate(String  inTransactionEndDate){
           transactionEndDate = inTransactionEndDate;
    }
    
   
    public  void  setTransactionEvent(String  inTransactionEvent){
           transactionEvent = inTransactionEvent;
    }
    
    public  void  setTransactionType(String  inTransactionType){
           transactionType = inTransactionType;
    }
    
    public  void  setTransactionMode(String  inTransactionMode){
           transactionMode = inTransactionMode;
    }
      
     
    public  void  setSenderName(String  inSenderName){
           senderName = inSenderName;
    }
    
    public  void  setReceiverName(String  inReceiverName){
           receiverName = inReceiverName;
    }
    
    public  void  setReceivingBank(String  inReceivingBank){
           receivingBank = inReceivingBank;
    }
    
    public  void  setServiceProvider(String  inServiceProvider){
           serviceProvider = inServiceProvider;
    }
    
      
    public  void  setProductProviderCustomerName(String  inProductProviderCustomerName){
           productProviderCustomerName = inProductProviderCustomerName;
    }
    
    public  void  setProductProviderCustomerAddress(String  inProductProviderCustomerAddress){
           productProviderCustomerAddress = inProductProviderCustomerAddress;
    }
    
    
    
}
