/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.math.BigDecimal;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */

@JsonPropertyOrder({"walletType", "walletId", "currency", "walletNumber", "walletName", "schemeId", "walletKycLevel", 
                         "kycWalletInfo", "accountNumber", "accountName", "dateCreated", "bookedBalance", "availableBalance",
                       "creditLienAmount", "debitLienAmount", "bank", "isPrimaryWallet", "walletStatus"})
public class WalletInfo {
    
    @JsonProperty("walletType")
    private  String  walletType;
    
    @JsonProperty("walletId")
    private  long  walletId  =  -1L;
    
    @JsonProperty("currency")
    private  Currency  currency;
    
    @JsonProperty("walletNumber")
    private  String  walletNumber;
    
    @JsonProperty("walletName")
    private  String  walletName;
    
    @JsonProperty("schemeId")
    private  String  schemeId;
    
    @JsonProperty("walletKycLevel")
    private  String  walletKycLevel;
    
    @JsonProperty("kycWalletInfo")
    private  KycWalletInfo    kycWalletInfo;
    
    @JsonProperty("accountNumber")
    private  String  accountNumber;
    
    @JsonProperty("accountName")
    private  String  accountName;
    
    @JsonProperty("dateCreated")
    private  String  dateCreated;
    
    @JsonProperty("bookedBalance")
    private  BigDecimal   bookedBalance   =  new  BigDecimal(0.00);
    
    @JsonProperty("availableBalance")
    private  BigDecimal   availableBalance   =  new  BigDecimal(0.00);
    
    @JsonProperty("creditLienAmount")
    private  BigDecimal   creditLienAmount   =  new  BigDecimal(0.00);
    
    @JsonProperty("debitLienAmount")
    private  BigDecimal   debitLienAmount   =  new  BigDecimal(0.00);
    
    @JsonProperty("bank")
    private  Bank  bank;
    
    @JsonProperty("isPrimaryWallet")
    private  boolean  isPrimaryWallet  = false;
    
    @JsonProperty("walletStatus")
    private  boolean  walletStatus  = false;
    
    
    
    
    
    
    
}
