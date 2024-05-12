/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.requests;

 
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper; 
import java.sql.Connection;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class TrxnAuthourization  extends  PouchiiRequestBase {
          
    private  String  verificationEvent = "RequestMoney";
    private  String  verificationReference = "ZCTKJGXA4IHB892";
    private  String  verificationCode = "831769";
     
      
    
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
    
    
    
    
     public   final  TrxnAuthourization  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        TrxnAuthourization   trxnAuthourization  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              trxnAuthourization = objectMapper.readValue(inObjectJSON, TrxnAuthourization.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  trxnAuthourization;
    }
     
     
    
    public  static  TrxnAuthourization  readFromJSON(String  inObjectJSON){ 
        TrxnAuthourization  trxnAuthourization  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              trxnAuthourization = objectMapper.readValue(inObjectJSON, TrxnAuthourization.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  trxnAuthourization;
    }
      
     
     
    
    public  String  getVerificationEvent(){
        return  verificationEvent;
    }
    
    public  String  getVerificationReference(){
        return  verificationReference;
    }
    
    public  String  getVerificationCode(){
        return  verificationCode;
    }
    
    
    
    
    public  void  setVerificationEvent(String  inVerificationEvent){
           verificationEvent = inVerificationEvent;
    }
    
    public  void  setVerificationReference(String  inVerificationReference){
           verificationReference = inVerificationReference;
    }
    
    public  void  setVerificationCode(String  inVerificationCode){
           verificationCode = inVerificationCode;
    }
    
    
    
    
}
