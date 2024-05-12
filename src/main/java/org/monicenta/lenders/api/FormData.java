/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.monicenta.lenders.api;

 

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class FormData {
    
   private String  firstName =  "";
   private String  lastName =  "";
   private String  phoneNumber =  "";
   
   private String  bvn =  "";
   private String  nextOfKin =  "";
   private String  relationship =  "";
   
   private String  address =  "";
   private String  accountNumber =  "";
   private String  bankCode =  "";
   
   private String  accountName =  "";
   private String  nubanBankCode =  "";
   private String  nubanAccountNumber =  "";
   
   private String  tin =  "";
   
   
    
   public  void  setFirstName(String  inFirstName){
       firstName =  inFirstName;
   }
   
    public  void  setLastName(String  inLastName){
       lastName =  inLastName;
   }
    
    public  void  setPhoneNumber(String  inPhoneNumber){
       phoneNumber =  inPhoneNumber;
   }
    
    
    public  void  setBvn(String  inBvn){
       bvn =  inBvn;
   }
   
    public  void  setNextOfKin(String  inNextOfKin){
       nextOfKin =  inNextOfKin;
   }
    
    public  void  setRelationship(String  inRelationship){
       relationship =  inRelationship;
   }
    
    
    
    public  void  setAddress(String  inAddress){
       address =  inAddress;
   }
   
    public  void  setAccountNumber(String  inAccountNumber){
       accountNumber =  inAccountNumber;
   }
    
    public  void  setBankCode(String  inBankCode){
       bankCode =  inBankCode;
   }
    
    
    
    public  void  setAccountName(String  inAccountName){
       accountName =  inAccountName;
   }
   
    public  void  setNubanBankCode(String  inNubanBankCode){
       nubanBankCode =  inNubanBankCode;
   }
    
    public  void  setNubanAccountNumber(String  inNubanAccountNumber){
       nubanAccountNumber =  inNubanAccountNumber;
   }
    
    
   public  void  setTin(String  inTin){
       tin =  inTin;
   }
    
    
    
    public  String  getFirstName(){
       return  firstName;
   }
   
    public  String  getLastName(){
       return  lastName;
   }
    
    public  String  getPhoneNumber(){
       return  phoneNumber;
   }
    
    
    
      
    public  String  getBvn(){
       return   bvn;
   }
   
    public  String  getNextOfKin(){
       return   nextOfKin;
   }
    
    public  String  getRelationship(){
       return   relationship;
   }
    
    
    
    public  String  getAddress(){
       return   address;
   }
   
    public  String  getAccountNumber(){
       return   accountNumber;
   }
    
    public  String  getBankCode(){
       return   bankCode;
   }
    
    
    
    public  String  getAccountName(){
       return   accountName;
   }
   
    public  String  getNubanBankCode(){
       return   nubanBankCode;
   }
    
    public  String  getNubanAccountNumber(){
       return   nubanAccountNumber;
   }
    
    
  public  String  getTin(){
      return  tin;
   }  
    
}
