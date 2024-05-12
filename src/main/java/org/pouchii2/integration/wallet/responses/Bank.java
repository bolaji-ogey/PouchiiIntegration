/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.responses;
 

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class Bank {
    
    private  long  id = 1;
    private  String  code  =  "";
    private  String  name  =  "";
    private  String  shortName  =  "";
    
    
    public  long  getId(){
        return  id;
    }
    
    public  String  getCode(){
        return  code;
    }
    
    public  String  getName(){
        return  name;
    }
    
    public  String  getShortName(){
        return  shortName;
    }
    
    
    
    
    public  void  setId(long  inId){
           id = inId;
    }
    
    public  void  setCode(String  inCode){
           code = inCode;
    }
    
    public  void  setName(String  inName){
           name = inName;
    }
    
    public  void  setShortName(String  inShortName){
           shortName = inShortName;
    }
    
    
}
