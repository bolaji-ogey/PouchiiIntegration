/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.monicenta.lenders.api;
 
 

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class LoanDocument {
    
   private String  docFormat =  "";
   private String  docType =  "";
   private String  docFile =  "";
   
   public  void  setDocFormat(String  inDocFormat){
       docFormat = inDocFormat;
   }
   
   public  void  setDocType(String  inDocType){
       docType = inDocType;
   }
   
   public  void  setDocFile(String  inDocFile){
       docFile = inDocFile;
   }
   
   
   
   
   public  String  getDocFormat(){
       return  docFormat;
   }
   
   public  String  getDocType(){
       return  docType;
   }
   
   public  String  getDocFile(){
       return  docFile;
   }
   
   
    
}
