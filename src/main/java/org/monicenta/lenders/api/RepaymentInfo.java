/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.monicenta.lenders.api;

 

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class RepaymentInfo {
    
   private String  repaymentMode =  "Remita_Inflight";
   private String  repaymentModeDesc =  "";
   private String  bankName =  "";
   private String  bankCode =  "";
   private String  accountNumber =  "";
   private String  accountName =  "";
   
   
      
   public  void  setRepaymentMode(String  inRepaymentMode){
       repaymentMode =  inRepaymentMode;
   }
   
    public  void  setRepaymentModeDesc(String  inRepaymentModeDesc){
       repaymentModeDesc =  inRepaymentModeDesc;
   }
    
    public  void  setBankName(String  inBankName){
       bankName =  inBankName;
   }
    
    
   public  void  setBankCode(String  inBankCode){
       bankCode =  inBankCode;
   }
   
    public  void  setAccountNumber(String  inAccountNumber){
       accountNumber =  inAccountNumber;
   }
    
    public  void  setAccountName(String  inAccountName){
       accountName =  inAccountName;
   }
    
    
     
   
 
    
    
   public  String  getRepaymentMode(String  inRepaymentMode){
      return   repaymentMode =  inRepaymentMode;
   }
   
    public  String  getRepaymentModeDesc(){
       return   repaymentModeDesc;
   }
    
    public  String  getBankName(){
       return   bankName;
   }
    
    
   public  String  getBankCode(){
       return   bankCode;
   }
   
    public  String  getAccountNumber(){
       return   accountNumber;
   }
    
    public  String  getAccountName(){
       return   accountName;
   }
    
    
    
    
    
}
