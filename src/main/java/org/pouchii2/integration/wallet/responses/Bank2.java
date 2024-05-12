/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.responses;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class Bank2 {
    
    Bank[]  bank  = new Bank[0];
    
    public  void  setBank(Bank[]  inBank){
         bank  =  inBank;
     }
    
    
    public  Bank[]  getBank(){
       return  bank;
     }
    
}
