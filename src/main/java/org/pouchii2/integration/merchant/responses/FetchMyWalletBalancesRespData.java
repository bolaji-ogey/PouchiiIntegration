/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.merchant.responses;

import java.math.BigDecimal;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class FetchMyWalletBalancesRespData {
    
    private  BigDecimal    totalAvailableBalance  =  new BigDecimal(0.00);
    private  BigDecimal    totalBookedBalance  =  new BigDecimal(0.00);
    
    private  Currency      currency  =  new Currency();
    private  WalletInfo[]   walletInfos  =  null;   // new WalletInfo[2];
    private   BonusWallet   bonusWallet =  null;   // new  BonusWallet();
    
    private  boolean   hasTransactionPin   = true;
    
   
    public  BigDecimal  getTotalAvailableBalance(){
        return  totalAvailableBalance;
    }
    
    public  BigDecimal  getTotalBookedBalance(){
        return  totalBookedBalance;
    }
    
    public  Currency  getCurrency(){
        return  currency;
    }
    
    public  WalletInfo[]  getWalletInfos(){
        return  walletInfos;
    }
    
    public  BonusWallet  getBonusWallet(){
        return  bonusWallet;
    }
    
    public  boolean  getHasTransactionPin(){
        return  hasTransactionPin;
    }
    
    
    
    
    
    public  void  setTotalAvailableBalance(BigDecimal  inTotalAvailableBalance){
           totalAvailableBalance = inTotalAvailableBalance;
    }
    
    public  void  setTotalBookedBalance(BigDecimal  inTotalBookedBalance){
           totalBookedBalance = inTotalBookedBalance;
    }
    
    public  void  setCurrency(Currency  inCurrency){
           currency = inCurrency;
    }
    
    public  void  setWalletInfos(WalletInfo[]  inWalletInfos){
           walletInfos = inWalletInfos;
    }
    
    public  void  setBonusWallet(BonusWallet  inBonusWallet){
           bonusWallet = inBonusWallet;
    }
    
    public  void  setHasTransactionPin(boolean  inHasTransactionPin){
           hasTransactionPin = inHasTransactionPin;
    }
    
    
    
    
}
