/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.newpartner.setup.responses;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class CreatePartnerOperateWalletRespData {
    
    private  long  id =  476;
    private  boolean  walletStatus  =  true;
    private  String  walletName  =  "";
    private  String  walletNumber  =  "";
    private  String  walletKycLevel  =  "Level2";
    private  String  walletBankAccountName  =  "";
    
    private  Bank    bank = new Bank();
    
    private  String  availableBalance  =  "0.00";
    private  String  bookedBalance  =  "0.00";
    private  String  creditLienBalance  =  "0.00";
    private  String  debitLienBalance  =  "0.00";
  
    private  Currency    currency = new Currency();
    
    private  String  dateCreated  =  "";
    
    private  SettlementAccount  settlementAccount   =  new  SettlementAccount();

    private  String  walletType  =  "Operational";
   
    
    
     
    public  long  getId(){
        return  id;
    }
    
    public  boolean  getWalletStatus(){
        return  walletStatus;
    }
    
    public  String  getWalletName(){
        return  walletName;
    }
    
    public  String  getWalletNumber(){
        return  walletNumber;
    }
    
    public  String  getWalletKycLevel(){
        return  walletKycLevel;
    }
    
    public  String  getWalletBankAccountName(){
        return  walletBankAccountName;
    }
    
    public  Bank  getBank(){
        return  bank;
    }
    
    public  String  getAvailableBalance(){
        return  availableBalance;
    }
    
    public  String  getBookedBalance(){
        return  bookedBalance;
    }
      
    public  String  getCreditLienBalance(){
        return  creditLienBalance;
    }
    
    public  String  getDebitLienBalance(){
        return  debitLienBalance;
    }
    
     
    
    public  Currency  getCurrency(){
        return  currency;
    }
    
    public  String  getDateCreated(){
        return  dateCreated;
    }
      
    public  SettlementAccount  getSettlementAccount(){
        return  settlementAccount;
    }
    
    public  String  getWalletType(){
        return  walletType;
    }
    
     
    
    
    
    
    
    
    public  void  setId(long  inId){
           id = inId;
    }
    
    public  void  setWalletStatus(boolean  inWalletStatus){
           walletStatus = inWalletStatus;
    }
    
    public  void  setWalletName(String  inWalletName){
           walletName = inWalletName;
    }
    
    public  void  setWalletNumber(String  inWalletNumber){
           walletNumber = inWalletNumber;
    }
    
    public  void  setWalletKycLevel(String  inWalletKycLevel){
           walletKycLevel = inWalletKycLevel;
    }
    
    public  void  setWalletBankAccountName(String  inWalletBankAccountName){
           walletBankAccountName = inWalletBankAccountName;
    }
    
    public  void  setBank(Bank  inBank){
           bank = inBank;
    }
    
    public  void  setAvailableBalance(String  inAvailableBalance){
           availableBalance = inAvailableBalance;
    }
    
    public  void  setBookedBalance(String  inBookedBalance){
           bookedBalance = inBookedBalance;
    }
      
    public  void  setCreditLienBalance(String  inCreditLienBalance){
           creditLienBalance = inCreditLienBalance;
    }
    
    public  void  setDebitLienBalance(String  inDebitLienBalance){
           debitLienBalance = inDebitLienBalance;
    }
     
    public  void  setCurrency(Currency  inCurrency){
           currency = inCurrency;
    }
    
    public  void  setDateCreated(String  inDateCreated){
           dateCreated = inDateCreated;
    }
      
    public  void  setSettlementAccount(SettlementAccount  inSettlementAccount){
           settlementAccount  =  inSettlementAccount;
    }
    
    public  void   setWalletType(String  inWalletType){
           walletType = inWalletType;
    }
    
    
    
}
