/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.merchant.responses;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class WalletInfo {
    
    private  String   walletType = "Merchant";
    private  long   walletId = 0; 
    
    private  Currency      currency  =  new Currency();
    
    private  String   walletNumber = "";
    private  String   walletName = "";
    private  String   schemeId = "";
    private  String   walletKycLevel = "Level2";
    private  String   accountNumber = "";
    private  String   accountName = "";
    private  String   dateCreated = "";
    private  String   bookedBalance = "0.00";
    private  String   availableBalance = "0.00"; 
      
    private  WBank      bank  =  new WBank();
    
    
    
    public  String   getWalletType(){
        return   walletType;
    }
    
    public  long   getWalletId(){
        return   walletId;
    }
    
    public  Currency   getCurrency(){
        return   currency;
    }
    
    public  String   getWalletNumber(){
        return   walletNumber;
    }
    
    public  String   getWalletName(){
        return   walletName;
    }
    
    public  String   getSchemeId(){
        return   schemeId;
    }
    
    public  String   getWalletKycLevel(){
        return   walletKycLevel;
    }
    
    public  String   getAccountNumber(){
        return   accountNumber;
    }
    
    public  String   getAccountName(){
        return   accountName;
    }
      
    
    public  String   getDateCreated(){
        return   dateCreated;
    }
    
    public  String   getBookedBalance(){
        return   bookedBalance;
    }
    
    public  String   getAvailableBalance(){
        return   availableBalance;
    }
    
    
    public  WBank   getBank(){
        return   bank;
    }
    
    
    
    
    
    
    
    public  void   setWalletType(String   inWalletType){
            walletType = inWalletType;
    }
    
    public  void   setWalletId(long   inWalletId){
            walletId = inWalletId;
    }
    
    public  void   setCurrency(Currency   inCurrency){
            currency = inCurrency;
    }
    
    public  void   setWalletNumber(String   inWalletNumber){
            walletNumber = inWalletNumber;
    }
    
    public  void   setWalletName(String   inWalletName){
            walletName = inWalletName;
    }
    
    public  void   setSchemeId(String   inSchemeId){
            schemeId = inSchemeId;
    }
    
    public  void   setWalletKycLevel(String   inWalletKycLevel){
            walletKycLevel = inWalletKycLevel;
    }
    
    public  void   setAccountNumber(String   inAccountNumber){
            accountNumber = inAccountNumber;
    }
    
    public  void   getAccountName(String   inAccountName){
            accountName = inAccountName;
    }
      
    
    public  void   getDateCreated(String   inDateCreated){
            dateCreated = inDateCreated;
    }
    
    public  void   getBookedBalance(String   inBookedBalance){
            bookedBalance = inBookedBalance;
    }
    
    public  void   getAvailableBalance(String   inAvailableBalance){
            availableBalance = inAvailableBalance;
    }
    
    
    public  void   getBank(WBank   inBank){
            bank = inBank;
    }
    
    
    
}
