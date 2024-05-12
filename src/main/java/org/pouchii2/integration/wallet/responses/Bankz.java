/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.responses;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */  
 

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class Bankz {
    
    private  long  id = 1;
    private  String  code  =  "";
    private  String  name  =  "";
    private  String  avatar  =  "";
    
    
    public  long  getId(){
        return  id;
    }
    
    public  String  getCode(){
        return  code;
    }
    
    public  String  getName(){
        return  name;
    }
    
    public  String  getAvatar(){
        return  avatar;
    }
    
    
    
         
     
    public  static  Bankz  readFromJSON(String  inObjectJSON){ 
        Bankz    bankz  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              bankz = objectMapper.readValue(inObjectJSON, Bankz.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  bankz;
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
    
    public  void  setAvatar(String  inAvatar){
           avatar = inAvatar;
    }
    
    
}
