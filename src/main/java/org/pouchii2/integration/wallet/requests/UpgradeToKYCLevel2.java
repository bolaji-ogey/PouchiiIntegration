/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.requests;

 
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
 
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class UpgradeToKYCLevel2  extends  PouchiiRequestBase {
    
     
    private  String  bvn = "_";
    private  String  idType = "NIN";
    private  String  documentNumber = "09087654";
    private  String  documentFile = "https://localhost:8080/nin/leke.png";
    private  String  documentContentType = "image/jpg"; 
    
     
    
    
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
     
     
    
    public  static  UpgradeToKYCLevel2  readFromJSON(String  inObjectJSON){ 
        UpgradeToKYCLevel2  upgradeToKYCLevel2  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              upgradeToKYCLevel2 = objectMapper.readValue(inObjectJSON, UpgradeToKYCLevel2.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  upgradeToKYCLevel2;
    }
      
    
     
    
    
    
    
    public  String  getBvn(){
        return  bvn;
    }
    
    public  String  getIdType(){
       return  idType; 
    }
    
    public  String  getDocumentNumber(){
        return  documentNumber;
    }
    
    public  String  getDocumentFile(){
        return  documentFile;
    }
    
    public  String  getDocumentContentType(){
        return  documentContentType;
    }
    
    
    
    
    
    
    public  void  setBvn(String  inBvn){
           bvn = inBvn;
    }
    
    public  void  setIdType(String  inIdType){
          idType = inIdType; 
    }
    
    public  void  setDocumentNumber(String  inDocumentNumber){
           documentNumber = inDocumentNumber;
    }
    
    public  void  setDocumentFile(String  inDocumentFile){
           documentFile = inDocumentFile;
    }
    
    public  void  setDocumentContentType(String  inDocumentContentType){
           documentContentType = inDocumentContentType;
    }
    




}
