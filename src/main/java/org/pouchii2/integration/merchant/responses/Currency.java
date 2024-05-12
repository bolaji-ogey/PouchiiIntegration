/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.merchant.responses;
 

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class Currency {
    
    private  String  name  =  "";
    private  String  code  =  "";
    private  String  symbol  =  ""; 
    
    
    
    public  String  getName(){
        return  name;
    }
    
    public  String  getCode(){
        return  code;
    }
    
    public  String  getSymbol(){
        return  symbol;
    }
    
     
    
    
    public  void  setName(String  inName){
           name = inName;
    }
    
    public  void  setCode(String  inCode){
           code = inCode;
    }
    
    public  void  setSymbol(String  inSymbol){
           symbol = inSymbol;
    }
    
    
    
    
    
}
