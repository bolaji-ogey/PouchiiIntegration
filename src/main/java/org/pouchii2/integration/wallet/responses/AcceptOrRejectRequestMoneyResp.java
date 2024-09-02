/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.responses;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class AcceptOrRejectRequestMoneyResp   extends  PouchiiResponseBase  {
     
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
     
     
     public   final  AcceptOrRejectRequestMoneyResp  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        AcceptOrRejectRequestMoneyResp   acceptOrRejectRequestMoneyResp  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              acceptOrRejectRequestMoneyResp = objectMapper.readValue(inObjectJSON, AcceptOrRejectRequestMoneyResp.class);
               this.logResponse(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logResponse(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  acceptOrRejectRequestMoneyResp;
    }
     
     
     
    public  static  AcceptOrRejectRequestMoneyResp  readFromJSON(String  inObjectJSON){ 
        AcceptOrRejectRequestMoneyResp  acceptOrRejectRequestMoneyResp  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              acceptOrRejectRequestMoneyResp = objectMapper.readValue(inObjectJSON, AcceptOrRejectRequestMoneyResp.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  acceptOrRejectRequestMoneyResp;
    }
      
   
    
    
    
    
    
}
