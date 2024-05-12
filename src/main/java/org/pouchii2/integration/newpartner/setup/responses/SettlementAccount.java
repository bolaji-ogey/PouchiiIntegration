/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.newpartner.setup.responses;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class SettlementAccount {
    
    private  String  accountName  =  "";
    private  String  accountNumber  =  "";
    
    private  Bank   bank   =  new Bank();
    
    
    
    public  String  getAccountName(){
        return  accountName;
    }
    
    
    public  String  getAccountNumber(){
        return  accountNumber;
    }
    
 
    public  Bank  getBank(){
        return  bank;
    }
    
    
    
    
    
    public  void  setAccountName(String  inAccountName){
           accountName = inAccountName;
    }
    
    
    public  void  setAccountNumber(String  inAccountNumber){
           accountNumber = inAccountNumber;
    }
    
 
    public  void  setBank(Bank  inBank){
           bank = inBank;
    }
    
    
    
    
}
