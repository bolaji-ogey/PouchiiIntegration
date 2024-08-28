/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.requests;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.NotBlank;
import java.sql.Connection;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class FetchWalletByIDAndCustRef  extends  PouchiiRequestBase  {
    
    @NotBlank(message = "Wallet number cannot be null or empty")
    private  String   walletNumber;
    
    
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
    
    
    
    public   final  ReleaseFundLockRequest  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        ReleaseFundLockRequest  releaseFundLockRequest  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              releaseFundLockRequest = objectMapper.readValue(inObjectJSON, ReleaseFundLockRequest.class);
              // this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              //this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  releaseFundLockRequest;
    }
     
     
    
    public  static  ReleaseFundLockRequest  readFromJSON(String  inObjectJSON){ 
        ReleaseFundLockRequest  releaseFundLockRequest  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              releaseFundLockRequest = objectMapper.readValue(inObjectJSON, ReleaseFundLockRequest.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  releaseFundLockRequest;
    }
      
  
    public  void  setWalletNumber(String  inWalletNumber){
        walletNumber  =  inWalletNumber;
    }
    
    
    public  String  getWalletNumber(){
        return  walletNumber;
    }
    
    
    
}
