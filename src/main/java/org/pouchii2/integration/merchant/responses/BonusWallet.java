/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.merchant.responses;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class BonusWallet {
     
    private  Currency      currency  =  new Currency();
    
    private  String   walletNumber = ""; 
    private  String   dateCreated = "";
    private  String   bookedBalance = "0.00";
    private  String   availableBalance = "0.00"; 
       
    
    public  Currency  getCurrency(){
        return  currency;
    } 
    
    public  String  getWalletNumber(){
        return  walletNumber;
    }
    
    public  String  getDateCreated(){
        return  dateCreated;
    }
    
    public  String  getBookedBalance(){
        return  bookedBalance;
    }
    
    public  String  getAvailableBalance(){
        return  availableBalance;
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
    
    public  void  setBookedBalance(String  inBookedBalance){
           bookedBalance = inBookedBalance;
    }
    
    public  void  setAvailableBalance(String  inAvailableBalance){
           availableBalance = inAvailableBalance;
    }
    
    
}
