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
@JsonPropertyOrder({"accountName", "accountNumber", "accountType", "bankCode"})
public class AccountNameEnquiryRespData {
    
    @JsonProperty("accountName")
    private  String   accountName;
    
    @JsonProperty("accountNumber")
    private  String   accountNumber;
    
    @JsonProperty("accountType")
    private  String   accountType;
    
    @JsonProperty("bankCode")
    private  String   bankCode;
    
    
    public   void  setAccountName(String  inAccountName){
        accountName  =  inAccountName;
    }
    
    public   void  setAccountNumber(String  inAccountNumber){
        accountNumber  =  inAccountNumber;
    }
    
    
    public   void  setAccountType(String  inAccountType){
        accountType  =  inAccountType;
    }
    
    
    public   void  setBankCode(String  inBankCode){
        bankCode  =  inBankCode;
    }
    
    
    
    
    public   String  getAccountName(){
        return   accountName;
    }
    
    public   String  getAccountNumber(){
        return   accountNumber;
    }
    
    
    public   String  getAccountType(){
        return   accountType;
    }
    
    
    public   String  getBankCode(){
        return   bankCode;
    }
    
    
    
    
    
    
}
