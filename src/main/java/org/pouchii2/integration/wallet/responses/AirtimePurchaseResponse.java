/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.responses;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
@JsonPropertyOrder({"data"}) 
public class AirtimePurchaseResponse extends  PouchiiResponseBase  {
    
    @JsonProperty("data")
    private  AirtimePurchRespData   data  =  new  AirtimePurchRespData();
    
     public  AirtimePurchRespData   getData(){
       return  data;
   }
   
   public  void  setData(AirtimePurchRespData   inData){
       data = inData;
   }
    
    
   
   
   
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
     
     
     public   final  AirtimePurchaseResponse  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        AirtimePurchaseResponse   airtimePurchaseResponse  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              airtimePurchaseResponse = objectMapper.readValue(inObjectJSON, AirtimePurchaseResponse.class);
               this.logResponse(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logResponse(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  airtimePurchaseResponse;
    }
     
     
     
    public  static  AirtimePurchaseResponse  readFromJSON(String  inObjectJSON){ 
        AirtimePurchaseResponse   airtimePurchaseResponse  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              airtimePurchaseResponse = objectMapper.readValue(inObjectJSON, AirtimePurchaseResponse.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  airtimePurchaseResponse;
    }
      
    
    
    
}
