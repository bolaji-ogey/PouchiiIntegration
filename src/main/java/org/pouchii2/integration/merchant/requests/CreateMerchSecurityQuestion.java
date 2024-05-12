/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.merchant.requests;

 
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper; 
import java.sql.Connection;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class CreateMerchSecurityQuestion  extends  PouchiiMerchRequestBase {
     
    private  int     securityQuestionId =  -1;
    private  String  securityQuestion = "-";  
    private  boolean  hasCustomSecurityQuestion = false;  
    private  String  securityQuestionAnswer = "-";  
     
    
    
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
     
     
     public   final  CreateMerchSecurityQuestion  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        CreateMerchSecurityQuestion   createMerchSecurityQuestion  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              createMerchSecurityQuestion = objectMapper.readValue(inObjectJSON, CreateMerchSecurityQuestion.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  createMerchSecurityQuestion;
    }
     
     
     
    public  static  CreateMerchSecurityQuestion  readFromJSON(String  inObjectJSON){ 
        CreateMerchSecurityQuestion  createMerchSecurityQuestion  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              createMerchSecurityQuestion = objectMapper.readValue(inObjectJSON, CreateMerchSecurityQuestion.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  createMerchSecurityQuestion;
    }
      
 
     
    public  void  setSecurityQuestionId(int  inSecurityQuestionId){
      securityQuestionId   =  inSecurityQuestionId;
    }
    
    
    public  void  setSecurityQuestion(String  inSecurityQuestion){
       securityQuestion =  inSecurityQuestion;
    }
    
    
    public  void  setHasCustomSecurityQuestion(boolean  inHasCustomSecurityQuestion){
        hasCustomSecurityQuestion = inHasCustomSecurityQuestion;
    }
    
    
    public  void  setSecurityQuestionAnswer(String  inSecurityQuestionAnswer){
       securityQuestionAnswer  =  inSecurityQuestionAnswer;
    }
    
    
    
    
    public  int  getSecurityQuestionId(){
        return  securityQuestionId;
    }
    
    
    public  String  getSecurityQuestion(){
        return  securityQuestion;
    }
    
    
    public  boolean  getHasCustomSecurityQuestion(){
         return  hasCustomSecurityQuestion;
    }
    
    
    public  String  getSecurityQuestionAnswer(){
        return  securityQuestionAnswer;
    }
    
    
}
