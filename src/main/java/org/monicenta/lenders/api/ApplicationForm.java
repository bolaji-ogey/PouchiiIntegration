/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.monicenta.lenders.api;

 

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class ApplicationForm {
   
   private String  formName =  "Loan Application Additional Details";
   private long  formIndex  =  0L;
 
   private  FormData  formDate  =  new FormData(); 
   
   
  public  void  setFormName(String  inFormName){
       formName =  inFormName;
   }
    
    
     public  void  setFormIndex(long  inFormIndex){
       formIndex =  inFormIndex;
   }
     
     
    public  void  setFormData(FormData  inFormData){
       formDate =  inFormData;
   }
      
    
    
    
    public  String  getFormName(){
       return  formName;
   }
    
    
     public  long  getFormIndex(){
       return  formIndex;
   }
     
     
    public  FormData  getFormData(){
       return  formDate;
   }
      
}
