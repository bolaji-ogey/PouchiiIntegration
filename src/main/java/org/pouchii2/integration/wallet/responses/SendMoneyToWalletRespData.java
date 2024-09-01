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
@JsonPropertyOrder({"transactionId", "transactionReference", "processorResponseCode",   "processorResponseReference",
                        "transactionStatus", "transactionAmount", "transactionValueAmount", "transactionFeeAmount",
                             "bonusPotCreditAmount", "bonusPotDebitAmount", "beneficiaryAccountName", "beneficiaryAccountNumber", 
                            "beneficiaryBankName", "beneficiaryBankCode", "senderAccountName", "senderAccountNumber", "serviceCustomerId",
                        "narration", "transactionStartDate", "transactionEndDate", "transactionFees", "transactionEvent", "transactionType", 
                             "transactionMode", "senderName", "receiverName", "receivingBank", "serviceProvider", 
                                  "productProviderCustomerName",  "productProviderCustomerAddress"})
 
public class SendMoneyToWalletRespData {
    
    @JsonProperty("transactionId")
     private  long   transactionId  = -1;
    
    @JsonProperty("transactionReference")
    private  String  transactionReference = "";
    
    @JsonProperty("processorResponseCode")
    private  String  processorResponseCode = "";
    
    @JsonProperty("processorResponseReference")
    private  String  processorResponseReference = "";
    
    @JsonProperty("transactionStatus")
    private  String  transactionStatus = "";
    
    @JsonProperty("transactionAmount")
    private  String  transactionAmount = "";
    
    @JsonProperty("transactionValueAmount")
    private  String  transactionValueAmount = "";
    
    @JsonProperty("transactionFeeAmount")
    private  String  transactionFeeAmount = "";
    
    @JsonProperty("bonusPotCreditAmount")
    private  String  bonusPotCreditAmount = "";
    
    @JsonProperty("bonusPotDebitAmount")
    private  String  bonusPotDebitAmount = "";
    
    @JsonProperty("beneficiaryAccountName")
    private  String  beneficiaryAccountName = "";
    
    @JsonProperty("beneficiaryAccountNumber")
    private  String  beneficiaryAccountNumber = "";
    
    @JsonProperty("beneficiaryBankName")
    private  String  beneficiaryBankName = "";
    
    @JsonProperty("beneficiaryBankCode")
    private  String  beneficiaryBankCode = "";
    
    @JsonProperty("senderAccountName")
    private  String  senderAccountName = "";
    
    @JsonProperty("senderAccountNumber")
    private  String  senderAccountNumber = "";
    
    @JsonProperty("serviceCustomerId")
    private  String  serviceCustomerId = "";
    
    @JsonProperty("narration")
    private  String  narration = "Send Money";
    
    @JsonProperty("transactionStartDate")
    private  String  transactionStartDate = "";
    
    @JsonProperty("transactionEndDate")
    private  String  transactionEndDate = "";
    
    @JsonProperty("transactionFees")
    private  String  transactionFees = "";
    
    @JsonProperty("transactionEvent")
    private  String  transactionEvent = "";
    
    @JsonProperty("transactionType")
    private  String  transactionType = "";
    
    @JsonProperty("transactionMode")
    private  String  transactionMode = "";
    
    @JsonProperty("senderName")
    private  String  senderName = "";
    
    @JsonProperty("receiverName")
    private  String  receiverName = "";
    
    @JsonProperty("receivingBank")
    private  String  receivingBank = "";
    
    @JsonProperty("serviceProvider")
    private  String  serviceProvider = "";
    
    @JsonProperty("productProviderCustomerName")
    private  String  productProviderCustomerName = "";
    
    @JsonProperty("productProviderCustomerAddress")
    private  String  productProviderCustomerAddress = "";
    
   
    public  long  getTransactionId(){
        return  transactionId;
    }
    
    public  String  getTransactionReference(){
        return  transactionReference;
    }
    
    public  String  getProcessorResponseCode(){
        return  processorResponseCode;
    }
    
    public  String  getProcessorResponseReference(){
        return  processorResponseReference;
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
    
    public  String  getBonusPotCreditAmount(){
        return  bonusPotCreditAmount;
    }
    
    public  String  getBonusPotDebitAmount(){
        return  bonusPotDebitAmount;
    }
    
    public  String  getBeneficiaryAccountName(){
        return  beneficiaryAccountName;
    }
    public  String  getBeneficiaryAccountNumber(){
        return  beneficiaryAccountNumber;
    }
    
    public  String  getBeneficiaryBankName(){
        return  beneficiaryBankName;
    }
    public  String  getBeneficiaryBankCode(){
        return  beneficiaryBankCode;
    }
          
    public  String  getSenderAccountName(){
        return  senderAccountName;
    }
    public  String  getSenderAccountNumber(){
        return  senderAccountNumber;
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
    
    public  String  getTransactionFees(){
        return  transactionFees;
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
    
    public  void  setProcessorResponseCode(String  inProcessorResponseCode){
           processorResponseCode = inProcessorResponseCode;
    }
    
    public  void  setProcessorResponseReference(String  inProcessorResponseReference){
           processorResponseReference = inProcessorResponseReference;
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
    
    public  void  setBonusPotCreditAmount(String  inBonusPotCreditAmount){
           bonusPotCreditAmount = inBonusPotCreditAmount;
    }
    
    public  void  setBonusPotDebitAmount(String  inBonusPotDebitAmount){
           bonusPotDebitAmount = inBonusPotDebitAmount;
    }
    
    public  void  setBeneficiaryAccountName(String  inBeneficiaryAccountName){
           beneficiaryAccountName = inBeneficiaryAccountName;
    }
    
    public  void  setBeneficiaryAccountNumber(String  inBeneficiaryAccountNumber){
           beneficiaryAccountNumber = inBeneficiaryAccountNumber;
    }
    
    public  void  setBeneficiaryBankName(String  inBeneficiaryBankName){
           beneficiaryBankName = inBeneficiaryBankName;
    }
    public  void  setBeneficiaryBankCode(String  inBeneficiaryBankCode){
           beneficiaryBankCode = inBeneficiaryBankCode;
    }
          
    public  void  setSenderAccountName(String  inSenderAccountName){
           senderAccountName = inSenderAccountName;
    }
    public  void  setSenderAccountNumber(String  inSenderAccountNumber){
           senderAccountNumber = inSenderAccountNumber;
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
    
    public  void  setTransactionFees(String  inTransactionFees){
           transactionFees = inTransactionFees;
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
