/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.callback.url;


import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class CallBackResultData {
    
    private  long  transactionId =  0L;
    private  String  transactionReference =  "";
    private  String  processorResponseCode =  ""; 
    private  String  processorResponseReference =  ""; 
    private  String  transactionStatus =  ""; 
    private  String  transactionAmount =  ""; 
    private  String  transactionValueAmount =  ""; 
    private  String  transactionFeeAmount =  ""; 
    private  String  bonusPotCreditAmount =  ""; 
    private  String  bonusPotDebitAmount =  ""; 
    private  String  beneficiaryAccountName =  ""; 
    
    private  String  beneficiaryAccountNumber =  ""; 
    private  String  beneficiaryBankName =  ""; 
    private  String  beneficiaryBankCode =  ""; 
    private  String  sourceAccountName =  ""; 
    private  String  sourceAccountNumber =  ""; 
    private  String  narration =  ""; 
    private  String  transactionStartDate =  ""; 
    private  String  transactionEndDate =  ""; 
    
    private  String  transactionMode =  ""; 
    
    ArrayList<TransactionFee>     transactionFees    =  new  ArrayList<>();
     
            
    
    public  CallBackResultData(JSONObject  inResultData){
        
        transactionId = inResultData.getLong("transactionId");
        transactionReference = inResultData.getString("transactionReference");
        processorResponseCode = inResultData.getString("processorResponseCode");
        processorResponseReference = inResultData.getString("processorResponseReference");
        transactionStatus = inResultData.getString("transactionStatus");
        transactionAmount = inResultData.getString("transactionAmount");
        transactionValueAmount = inResultData.getString("transactionValueAmount");
        transactionFeeAmount = inResultData.getString("transactionFeeAmount");
        bonusPotCreditAmount = inResultData.getString("bonusPotCreditAmount");
        bonusPotDebitAmount =  inResultData.getString("bonusPotDebitAmount");
        beneficiaryAccountName =  inResultData.getString("beneficiaryAccountName");
        beneficiaryAccountNumber  =  inResultData.getString("beneficiaryAccountNumber");
        beneficiaryBankName  = inResultData.getString("beneficiaryBankName");
        beneficiaryBankCode  = inResultData.getString("beneficiaryBankCode");
        sourceAccountName  = inResultData.getString("sourceAccountName");
        sourceAccountNumber  = inResultData.getString("sourceAccountNumber");
        
        narration  = inResultData.getString("narration");
        transactionStartDate = inResultData.getString("transactionStartDate");
        transactionEndDate =  inResultData.getString("transactionEndDate");
        transactionMode = inResultData.getString("transactionMode");
        
        
        JSONArray  inTrxnFees  =   inResultData.getJSONArray("transactionFees");
        for(int v = 0; v < inTrxnFees.length();  v++){
            TransactionFee   transactionFee =  new TransactionFee((JSONObject)inTrxnFees.get(v));
            transactionFee.logOut();
            transactionFees.add(transactionFee);
        }
    }
    
   
    
    public  void  logOut(){
        System.out.println("transactionId  --> "+transactionId);
        System.out.println("transactionReference  --> "+transactionReference);
        System.out.println("processorResponseCode  --> "+processorResponseCode);
        System.out.println("processorResponseReference  --> "+processorResponseReference);
        System.out.println("transactionStatus  --> "+transactionStatus);
        System.out.println("transactionAmount  --> "+transactionAmount);
        System.out.println("transactionValueAmount  --> "+transactionValueAmount);
        System.out.println("transactionFeeAmount  --> "+transactionFeeAmount);
        System.out.println("bonusPotCreditAmount  --> "+bonusPotCreditAmount);
        System.out.println("bonusPotDebitAmount  --> "+bonusPotDebitAmount);
        System.out.println("beneficiaryAccountName  --> "+beneficiaryAccountName);
        System.out.println("beneficiaryAccountNumber  --> "+beneficiaryAccountNumber);
        System.out.println("beneficiaryBankName  --> "+beneficiaryBankName);
        System.out.println("beneficiaryBankCode  --> "+beneficiaryBankCode);
        System.out.println("sourceAccountName  --> "+sourceAccountName);
        System.out.println("sourceAccountNumber  --> "+sourceAccountNumber);
        System.out.println("narration  --> "+narration);
        System.out.println("transactionStartDate  --> "+transactionStartDate);
        System.out.println("transactionEndDate  --> "+transactionEndDate);
        System.out.println("transactionMode  --> "+transactionMode); 
    
        
    }
    
    
}
