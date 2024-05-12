/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.single.node.wallet.merchant.requests.backup;

   
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;  
import java.sql.Connection;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class ChangeMerchSecQuestAnswer  extends  MerchantRequestBase  {
         
    private  String  previousSecurityQuestionAnswer = "_";
    private  String  securityQuestionAnswer = "_";
     
    
    
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
     
     
     public   final  ChangeMerchSecQuestAnswer  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        ChangeMerchSecQuestAnswer   changeMerchSecQuestAnswer  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              changeMerchSecQuestAnswer = objectMapper.readValue(inObjectJSON, ChangeMerchSecQuestAnswer.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  changeMerchSecQuestAnswer;
    }
     
     
    public  static  ChangeMerchSecQuestAnswer  readFromJSON(String  inObjectJSON){ 
        ChangeMerchSecQuestAnswer  changeMerchSecQuestAnswer  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              changeMerchSecQuestAnswer = objectMapper.readValue(inObjectJSON, ChangeMerchSecQuestAnswer.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  changeMerchSecQuestAnswer;
    }
      
    
     
    public  String  getPreviousSecurityQuestionAnswer(){
        return  previousSecurityQuestionAnswer;
    }
    
    public  String  getSecurityQuestionAnswer(){
        return  securityQuestionAnswer;
    }
     
    
    
    
    public  void  setPreviousSecurityQuestionAnswer(String  inPreviousSecurityQuestionAnswer){
           previousSecurityQuestionAnswer = inPreviousSecurityQuestionAnswer;
    }
    
    public  void  setSecurityQuestionAnswer(String  inSecurityQuestionAnswer){
           securityQuestionAnswer = inSecurityQuestionAnswer;
    }
    
    
}
