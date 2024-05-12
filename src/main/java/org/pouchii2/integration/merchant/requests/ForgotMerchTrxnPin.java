/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.merchant.requests;
 
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper; 
import java.sql.Connection;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class ForgotMerchTrxnPin  extends  PouchiiMerchRequestBase { 
     
    private  String  securityAnswer = "_";
    private  String  pin = "_";
     
    
    
    public  final  JSONObject  convertToJSON(){
        JSONObject  returnedJson =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
             objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
           returnedJson =  new JSONObject(objectMapper.writeValueAsString(this));
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            objectMapper = null;
        }
      return  returnedJson;
    }
    
    
    public  final  String  convertToJSONString(){
        String  returnedJsonString =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            returnedJsonString  =   objectMapper.writeValueAsString(this);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            objectMapper = null;
        }
      return  returnedJsonString;
    }
     
     
     public   final  ForgotMerchTrxnPin  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        ForgotMerchTrxnPin   forgotMerchTrxnPin  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              forgotMerchTrxnPin = objectMapper.readValue(inObjectJSON, ForgotMerchTrxnPin.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  forgotMerchTrxnPin;
    }
     
     
     
    public  static  ForgotMerchTrxnPin  readFromJSON(String  inObjectJSON){ 
         ForgotMerchTrxnPin  forgotMerchTrxnPin  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              forgotMerchTrxnPin = objectMapper.readValue(inObjectJSON, ForgotMerchTrxnPin.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  forgotMerchTrxnPin;
    }
      
 
    
    public  String  getSecurityAnswer(){
        return  securityAnswer;
    }
    
    public  String  getPin(){
        return  pin;
    }
    
    
    public  void  setSecurityAnswer(String  inSecurityAnswer){
           securityAnswer = inSecurityAnswer;
    }
    
    public  void  setPin(String  inPin){
           pin = inPin;
    }
    
    
    
}
