/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.merchant.responses;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import org.json.JSONObject; 

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class FetchMyWalletBalancesResponse  extends  PouchiiMerchResponseBase  {
     
   private    FetchMyWalletBalancesRespData  data  = new  FetchMyWalletBalancesRespData();
    
   public  FetchMyWalletBalancesRespData  getData(){
       return   data;
   }
   
   
   public  void  setData(FetchMyWalletBalancesRespData   inData){
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
     
     
     public   final  FetchMyWalletBalancesResponse  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        FetchMyWalletBalancesResponse   fetchMyWalletBalancesResponse  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              fetchMyWalletBalancesResponse = objectMapper.readValue(inObjectJSON, FetchMyWalletBalancesResponse.class);
               this.logResponse(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logResponse(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  fetchMyWalletBalancesResponse;
    }
     
     
     
    public  static  FetchMyWalletBalancesResponse  readFromJSON(String  inObjectJSON){ 
        FetchMyWalletBalancesResponse  fetchMyWalletBalancesResponse  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              fetchMyWalletBalancesResponse = objectMapper.readValue(inObjectJSON, FetchMyWalletBalancesResponse.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  fetchMyWalletBalancesResponse;
    }
      
 
}
