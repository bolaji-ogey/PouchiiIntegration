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
public class ChangeMerchSecurityQuest  extends  PouchiiMerchRequestBase {
      
    private  String  securityQuestion = "-";
    private  boolean  hasCustomSecurityQuestion = true;
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
     
     
     public   final  ChangeMerchSecurityQuest  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        ChangeMerchSecurityQuest   changeMerchSecurityQuest  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              changeMerchSecurityQuest = objectMapper.readValue(inObjectJSON, ChangeMerchSecurityQuest.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  changeMerchSecurityQuest;
    }
     
     
     
    public  static  ChangeMerchSecurityQuest  readFromJSON(String  inObjectJSON){ 
        ChangeMerchSecurityQuest  changeMerchSecurityQuest  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              changeMerchSecurityQuest = objectMapper.readValue(inObjectJSON, ChangeMerchSecurityQuest.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  changeMerchSecurityQuest;
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
    
    
    
    
    public  void  setSecurityQuestion(String  inSecurityQuestion){
           securityQuestion = inSecurityQuestion;
    }
    
    public  void  setHasCustomSecurityQuestion(boolean  inHasCustomSecurityQuestion){
           hasCustomSecurityQuestion = inHasCustomSecurityQuestion;
    }
    
    public  void  setSecurityQuestionAnswer(String  inSecurityQuestionAnswer){
           securityQuestionAnswer = inSecurityQuestionAnswer;
    }
    
    
    
}
