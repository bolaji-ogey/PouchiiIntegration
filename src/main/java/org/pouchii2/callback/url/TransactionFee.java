/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.callback.url;


import org.json.JSONObject;
/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class TransactionFee {
     
    private  String  feeName = "Commission";
    private  String  feeOperator = "";
    private  String  feeType = "Percentage";
    private  String  feeAmount = "";
    
   /*** 
    public  TransactionFee(){}
    
    public  TransactionFee(String inFeeName,  String inFeeOperator,  
                               String inFeeType,  String  inFeeAmount){
        feeName  =  inFeeName;
        feeOperator =  inFeeOperator;
        feeType =  inFeeType;
        feeAmount  =  inFeeAmount;
    }
    ***/
    
     public  TransactionFee(JSONObject   inResultFee){
         try{
            feeName  =  inResultFee.getString("feeName");
            feeOperator =  inResultFee.getString("feeOperator");
            feeType =  inResultFee.getString("feeType");
            feeAmount  =  inResultFee.getString("feeAmount");
         }catch(Exception ex){
             ex.printStackTrace();
         }
    }
    
    
    public  String  getFeeName(){
       return   feeName;
    }
    
    public  String  getFeeOperator(){
       return   feeOperator;
    }
    
    public  String  getFeeType(){
       return  feeType; 
    }
    
    
    public  String  getFeeAmount(){
      return    feeAmount;
    }
    
    
    public  void  logOut(){
        System.out.println("feeName  --> "+feeName);
        System.out.println("feeOperator  --> "+feeOperator);
        System.out.println("feeType  --> "+feeType);
        System.out.println("feeAmount  --> "+feeAmount);
    }
    
}
