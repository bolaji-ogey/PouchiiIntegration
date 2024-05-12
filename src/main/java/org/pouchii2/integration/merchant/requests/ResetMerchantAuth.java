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
public class ResetMerchantAuth  extends  PouchiiMerchRequestBase {
     
    private  String  verificationReference = "-"; 
    private  String  verificationCode = "-"; 
    private  String  verificationEvent = "-"; 
    private  String  newPin = "-"; 
    private  String  confirmPin = "-"; 
     
    
    
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
     
     
     public   final  ResetMerchantAuth  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        ResetMerchantAuth   resetMerchantAuth  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              resetMerchantAuth = objectMapper.readValue(inObjectJSON, ResetMerchantAuth.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  resetMerchantAuth;
    }
     
     
    public  static  ResetMerchantAuth  readFromJSON(String  inObjectJSON){ 
        ResetMerchantAuth  resetMerchantAuth  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              resetMerchantAuth = objectMapper.readValue(inObjectJSON, ResetMerchantAuth.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  resetMerchantAuth;
    }
      
 
      
    public  String  getVerificationReference(){
        return  verificationReference;
    }
    
    public  String  getVerificationCode(){
        return  verificationCode;
    }
    
    public  String  getVerificationEvent(){
        return  verificationEvent;
    }
    
    public  String  getNewPin(){
        return  newPin;
    }
    
    public  String  getConfirmPin(){
        return  confirmPin;
    }
    
    
    
    
    public  void  setVerificationReference(String  inVerificationReference){
           verificationReference = inVerificationReference;
    }
    
    public  void  setVerificationCode(String  inVerificationCode){
           verificationCode = inVerificationCode;
    }
    
    public  void  setVerificationEvent(String  inVerificationEvent){
           verificationEvent = inVerificationEvent;
    }
    
    public  void  setNewPin(String  inNewPin){
           newPin = inNewPin;
    }
    
    public  void  setConfirmPin(String  inConfirmPin){
           confirmPin = inConfirmPin;
    }
    
    
    
}
