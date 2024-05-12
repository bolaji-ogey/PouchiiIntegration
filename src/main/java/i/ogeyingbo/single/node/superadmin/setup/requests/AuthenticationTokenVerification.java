/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.single.node.superadmin.setup.requests;

 
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import org.json.JSONObject; 

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class AuthenticationTokenVerification extends  AdminRequestBase  {
    
    private  String  verificationEvent = "";
    private  String  verificationReference = "";
    private  String  verificationCode = "";
     
       
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
     
    
    
     public   final  AuthenticationTokenVerification  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        AuthenticationTokenVerification   authTokenVerification  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              authTokenVerification = objectMapper.readValue(inObjectJSON, AuthenticationTokenVerification.class);
               this.log(con, inObjectJSON, true);
            }catch(Exception ex){
              this.log(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  authTokenVerification;
    }
     
    
    public  static  AuthenticationTokenVerification  readFromJSON(String  inObjectJSON){ 
        AuthenticationTokenVerification  authTokenVerification  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              authTokenVerification = objectMapper.readValue(inObjectJSON, AuthenticationTokenVerification.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  authTokenVerification;
    }
      
  
    
    public String  getVerificationEvent(){
        return  verificationEvent;
    }
    
    public String  getVerificationReference(){
        return  verificationReference;
    }
    
    public String  getVerificationCode(){
        return  verificationCode;
    }
    
    
    public  void  setVerificationEvent(String inVerificationEvent){
        verificationEvent  = inVerificationEvent;
    }
    
    
    public  void  setVerificationReference(String inVerificationReference){
        verificationReference  = inVerificationReference;
    }
    
    
    public  void  setVerificationCode(String inVerificationCode){
        verificationCode  = inVerificationCode;
    }
    
}
