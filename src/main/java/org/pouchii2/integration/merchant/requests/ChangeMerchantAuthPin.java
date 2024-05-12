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
public class ChangeMerchantAuthPin  extends  PouchiiMerchRequestBase {
     
    private  String  currentPin = "-";
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
     
    
    
     public   final  CreateMerchantAuthPin  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        CreateMerchantAuthPin   createMerchantAuthPin  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              createMerchantAuthPin = objectMapper.readValue(inObjectJSON, CreateMerchantAuthPin.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  createMerchantAuthPin;
    }
     
    
    public  static  CreateMerchantAuthPin  readFromJSON(String  inObjectJSON){ 
        CreateMerchantAuthPin  createMerchantAuthPin  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              createMerchantAuthPin = objectMapper.readValue(inObjectJSON, CreateMerchantAuthPin.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  createMerchantAuthPin;
    }
      
  
    
    public String  getCurrentPin(){
        return   currentPin;
    }
    
    public String  getNewPin(){
        return   newPin;
    }
    
    
    public String  getConfirmPin(){
        return   confirmPin;
    }
    
    
    
    
    
    public void  setCurrentPin(String  inCurrentPin){
           currentPin = inCurrentPin;
    }
    
    public void  setNewPin(String  inNewPin){
           newPin = inNewPin;
    }
    
    
    public void  setConfirmPin(String  inConfirmPin){
           confirmPin = inConfirmPin;
    }
    
    
    
}
