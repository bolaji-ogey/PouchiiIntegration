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
public class DynamicKYCLevel3Upgrade    extends  PouchiiRequestBase   {
          
    private  String  bvn = "_";
    private  String  idType = "NIN";
    private  String  kyc3DocumentType = "Electricity_Bill"; 
    private  String  kyc3DocumentNumber = "09087654";
    private  String  kyc3DocumentFile = "https://localhost:8080/nin/leke.png";
    private  String  kyc3DocumentContentType = "image/jpg";     
    private  String  kyc3DocumentIssuedDate = "2021-03-14"; 
     
     
     
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
     
     
     public   final  DynamicKYCLevel3Upgrade  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        DynamicKYCLevel3Upgrade   dynamicKYCLevel3Upgrade  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              dynamicKYCLevel3Upgrade = objectMapper.readValue(inObjectJSON, DynamicKYCLevel3Upgrade.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  dynamicKYCLevel3Upgrade;
    }
     
     
     
    public  static  DynamicKYCLevel3Upgrade  readFromJSON(String  inObjectJSON){ 
        DynamicKYCLevel3Upgrade  dynamicKYCLevel3Upgrade  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              dynamicKYCLevel3Upgrade = objectMapper.readValue(inObjectJSON, DynamicKYCLevel3Upgrade.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  dynamicKYCLevel3Upgrade;
    }
      
     
     
     
    
    public  String  getBvn(){
        return  bvn;
    }
    
    public  String  getIdType(){
       return  idType; 
    }
      
    
    public  String  getKyc3DocumentType(){
        return  kyc3DocumentType;
    }
    
    
    public  String  getKyc3DocumentNumber(){
        return  kyc3DocumentNumber;
    }
    
    public  String  getKyc3DocumentFile(){
        return  kyc3DocumentFile;
    }
    
    public  String  getKyc3DocumentContentType(){
        return  kyc3DocumentContentType;
    }
    
    public  String  getKyc3DocumentIssuedDate(){
       return  kyc3DocumentIssuedDate; 
    }
    
    
    
    
    
    
    
    
    public  void  setBvn(String  inBvn){
           bvn = inBvn;
    }
    
    public  void  setIdType(String  inIdType){
          idType = inIdType; 
    }
      
    
    public  void  setKyc3DocumentType(String  inKyc3DocumentType){
           kyc3DocumentType = inKyc3DocumentType;
    }
    
    
    public  void  setKyc3DocumentNumber(String  inKyc3DocumentNumber){
           kyc3DocumentNumber = inKyc3DocumentNumber;
    }
    
    public  void  setKyc3DocumentFile(String  inKyc3DocumentFile){
           kyc3DocumentFile = inKyc3DocumentFile;
    }
    
    public  void  setKyc3DocumentContentType(String  inKyc3DocumentContentType){
           kyc3DocumentContentType = inKyc3DocumentContentType;
    }
    
    public  void  setKyc3DocumentIssuedDate(String  inKyc3DocumentIssuedDate){
          kyc3DocumentIssuedDate = inKyc3DocumentIssuedDate; 
    }
    
    
    
    
    
}
