/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.responses;
 
import java.math.BigDecimal;


/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class BonusWallet {
     
    private  Currency      currency  =  new Currency();
    
    private  String   walletNumber = ""; 
    private  String   dateCreated = "";
    
    private  BigDecimal   bookedBalance =  new  BigDecimal(0.00);
    private  BigDecimal   availableBalance =  new  BigDecimal(0.00);
    
    private   boolean  walletStatus  =  false;
       
    
    public  Currency  getCurrency(){
        return  currency;
    } 
    
    public  String  getWalletNumber(){
        return  walletNumber;
    }
    
    public  String  getDateCreated(){
        return  dateCreated;
    }
    
    public  BigDecimal  getBookedBalance(){
        return  bookedBalance;
    }
    
    public  BigDecimal  getAvailableBalance(){
        return  availableBalance;
    }
    
    
    public  boolean  getWalletStatus(){
        return  walletStatus;
    }
    
    
    
    
    public  void  setCurrency(Currency   inCurrency){
           currency = inCurrency;
    } 
    
    public  void  setWalletNumber(String  inWalletNumber){
           walletNumber = inWalletNumber;
    }
    
    public  void  setDateCreated(String  inDateCreated){
           dateCreated = inDateCreated;
    }
    
    public  void  setBookedBalance(BigDecimal  inBookedBalance){
           bookedBalance = inBookedBalance;
    }
    
    public  void  setAvailableBalance(BigDecimal  inAvailableBalance){
           availableBalance = inAvailableBalance;
    }
    
    
    public  void  setWalletStatus(boolean  inWalletStatus){
        walletStatus   =   inWalletStatus;
    }
    
    
    
}
