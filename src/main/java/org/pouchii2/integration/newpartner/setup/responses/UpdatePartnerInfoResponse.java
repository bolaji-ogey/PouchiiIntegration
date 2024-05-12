/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.newpartner.setup.responses;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class UpdatePartnerInfoResponse extends  PouchiiAdminResponseBase  {
    
   private    UpdatePartnerInfoResponseData  data  =  new UpdatePartnerInfoResponseData();
    
    
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
     
    
    
     public   final  UpdatePartnerInfoResponse  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        UpdatePartnerInfoResponse   updatePartnerInfoResponse  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              updatePartnerInfoResponse = objectMapper.readValue(inObjectJSON, UpdatePartnerInfoResponse.class);
               this.logResponse(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logResponse(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  updatePartnerInfoResponse;
    }
     
    
    public  static  UpdatePartnerInfoResponse  readFromJSON(String  inObjectJSON){ 
        UpdatePartnerInfoResponse  updatePartnerInfoResponse  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              updatePartnerInfoResponse = objectMapper.readValue(inObjectJSON, UpdatePartnerInfoResponse.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  updatePartnerInfoResponse;
    }
    
    
    public  UpdatePartnerInfoResponseData  getData(){
        return  data;
    }
    
    public  void  setData(UpdatePartnerInfoResponseData  inUpdatePartnerInfoResponseData){
          data = inUpdatePartnerInfoResponseData;
    }
    
    
    
}
