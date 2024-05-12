/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.single.node.wallet.merchant.requests;
  
 
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;  
import java.sql.Connection;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class MerchantIntAuthRequest   extends  MerchantRequestBase  {
     
    private  String  username = "PUB_STSL_162ECSFGWTK4H3R";
    private  String  password = "g8djJvTEX73ZgGsde/G0KbWf8UadW9qVR4wmD6ustJ0=";
    private  boolean  rememberMe = true;
     
     
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
     
     
    
     public   final  MerchantIntAuthRequest  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        MerchantIntAuthRequest   merchantIntAuthRequest  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              merchantIntAuthRequest = objectMapper.readValue(inObjectJSON, MerchantIntAuthRequest.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  merchantIntAuthRequest;
    }
     
     
    
    public  static  MerchantIntAuthRequest  readFromJSON(String  inObjectJSON){ 
        MerchantIntAuthRequest  merchantIntAuthRequest  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              merchantIntAuthRequest = objectMapper.readValue(inObjectJSON, MerchantIntAuthRequest.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  merchantIntAuthRequest;
    }
  
    
    
   
    public  void  setUsername(String  inUsername){
           username = inUsername;
    }
    
    
    public  void  setPassword(String  inPassword){
           password = inPassword;
    }
    
    
    public  void setRememberMe(boolean  inRememberMe){
           rememberMe = inRememberMe;
    }
    
    
    
    
    
    public  String  getUsername(){
        return  username;
    }
    
    
    public  String  getPassword(){
        return  password;
    }
    
    
    public  boolean  getRememberMe(){
        return  rememberMe;
    }
    
    
    
    
    
    
}
