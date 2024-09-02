/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.responses;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import java.util.ArrayList;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class CustWalletBeneficiaryListResponse   extends  PouchiiResponseBase  {
    
    
     @JsonProperty("data")
   private CustWalletBeneficiaryListRespData   data =  null;  // new  CustWalletBeneficiaryListRespData();
    
   public  CustWalletBeneficiaryListRespData  getData(){
       return  data;
   }
    
   public  void  setData(CustWalletBeneficiaryListRespData  inData){
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
     
     
     public   final  CustWalletBeneficiaryListResponse  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        CustWalletBeneficiaryListResponse   custWalletBeneficiaryListResponse  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              custWalletBeneficiaryListResponse = objectMapper.readValue(inObjectJSON, CustWalletBeneficiaryListResponse.class);
               this.logResponse(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logResponse(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  custWalletBeneficiaryListResponse;
    }
     
     
     
    public  static  CustWalletBeneficiaryListResponse  readFromJSON(String  inObjectJSON){ 
        CustWalletBeneficiaryListResponse  custWalletBeneficiaryListResponse  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              custWalletBeneficiaryListResponse = objectMapper.readValue(inObjectJSON, CustWalletBeneficiaryListResponse.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  custWalletBeneficiaryListResponse;
    }
      
   
    
    
    
}
