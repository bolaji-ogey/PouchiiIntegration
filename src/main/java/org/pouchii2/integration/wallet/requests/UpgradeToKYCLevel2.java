/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.requests;

 
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
 
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class UpgradeToKYCLevel2  extends  PouchiiRequestBase {
    
     @NotBlank(message = "BVN cannot be null or empty") @Pattern(regexp="[0-9]")
    @Size(min=11,  max=11, message="bvn must be eleven (11) digits")
    private  String  bvn = "_";
     
     @NotBlank(message = "ID type cannot be null or empty")
    private  String  idType = "NIN";
     
    @NotBlank(message = "Document number cannot be null or empty") @Pattern(regexp="[0-9]")
    private  String  documentNumber = "09087654";
    
    @NotBlank(message = "Document file cannot be null or empty")
    private  String  documentFile = "https://localhost:8080/nin/leke.png";
    
    
   @NotBlank(message = "Document content type cannot be null or empty")
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
