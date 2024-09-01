/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
@JsonPropertyOrder({"totalAvailableBalance", "totalBookedBalance", "currency",
                      "walletInfos",  "bonusWallet"}) 
public class GetWalletRespData {
    
    @JsonProperty("totalAvailableBalance")
    private  BigDecimal   totalAvailableBalance   =  new  BigDecimal(0.00);
    
    @JsonProperty("totalBookedBalance")
    private  BigDecimal   totalBookedBalance   =  new  BigDecimal(0.00);
    
    @JsonProperty("currency")
    private   Currency   currency;
    
    @JsonProperty("walletInfos")
    private   ArrayList<WalletInfo>  walletInfos  =  new  ArrayList<>();
    
    @JsonProperty("bonusWallet")
    private  BonusWallet   bonusWallet   =  new  BonusWallet();
    
    
    public  void  setTotalAvailableBalance(BigDecimal   inTotalAvailableBalance){
         totalAvailableBalance  =    inTotalAvailableBalance;        
    }
    
    public  void  setTotalBookedBalance(BigDecimal  inTotalBookedBalance){
        totalBookedBalance   =  inTotalBookedBalance;
    }
    
    
    public  void  setCurrency(Currency  inCurrency){
        currency  =  inCurrency;
    }
    
    
    public  void  setWalletInfos(ArrayList<WalletInfo>    inWalletInfos){
        walletInfos  = inWalletInfos;
    }
    
    
    public  void  setBonusWallet(BonusWallet   inBonusWallet){
        bonusWallet  = inBonusWallet;
    }
    
    
    
   
    
    public  BigDecimal  getTotalAvailableBalance(){
        return    totalAvailableBalance;        
    }
    
    public  BigDecimal  getTotalBookedBalance(){
        return     totalBookedBalance;
    }
    
    
    public  Currency  getCurrency(){
        return    currency;
    }
    
    
    public  ArrayList<WalletInfo>  getWalletInfos(){
        return    walletInfos;
    }
    
    
    public  BonusWallet  getBonusWallet(){
        return    bonusWallet;
    }
    
    
    
    
    
}
