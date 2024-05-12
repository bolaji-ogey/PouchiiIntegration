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
public class CreatePartnerOperateWalletResp extends  PouchiiAdminResponseBase  {
    
    FetchMerchCredentialRespData    data  = new  FetchMerchCredentialRespData();
    
    public  FetchMerchCredentialRespData  getData(){
        return  data;
    }
    
    public  void  setData(FetchMerchCredentialRespData  inData){
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
     
    
    
     public   final  CreatePartnerOperateWalletResp  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        CreatePartnerOperateWalletResp   createPartnerOperateWalletResp  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              createPartnerOperateWalletResp = objectMapper.readValue(inObjectJSON, CreatePartnerOperateWalletResp.class);
               this.logResponse(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logResponse(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  createPartnerOperateWalletResp;
    }
     
    
    public  static  CreatePartnerOperateWalletResp  readFromJSON(String  inObjectJSON){ 
        CreatePartnerOperateWalletResp  createPartnerOperateWalletResp  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              createPartnerOperateWalletResp = objectMapper.readValue(inObjectJSON, CreatePartnerOperateWalletResp.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  createPartnerOperateWalletResp;
    }
    
    
}
