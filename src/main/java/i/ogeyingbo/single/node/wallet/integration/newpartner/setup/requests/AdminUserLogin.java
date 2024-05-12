/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.single.node.wallet.integration.newpartner.setup.requests;

 
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import org.json.JSONObject; 

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class AdminUserLogin   extends   AdminRequestBase {
     
    private  final  String  username  = "08083064718";
    private  final  String  password  = "antiBrewery123#";
    private  final boolean  rememberMe = true;
    
    
    public  AdminUserLogin(){
        setRequestChannelId("123456770");
        setRequestChannel("Mobile");
        setRequestChannelType("Android");
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
     
    
    
     public   final  AdminUserLogin  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        AdminUserLogin   adminUserLogin  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              adminUserLogin = objectMapper.readValue(inObjectJSON, AdminUserLogin.class);
               this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
              this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  adminUserLogin;
    }
     
    
    public  static  AdminUserLogin  readFromJSON(String  inObjectJSON){ 
        AdminUserLogin  adminUserLogin  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              adminUserLogin = objectMapper.readValue(inObjectJSON, AdminUserLogin.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  adminUserLogin;
    }
      
  
    
    public String  getUsername(){
        return  username;
    }
    
    public String  getPassword(){
        return  password;
    }
    
    public boolean  getRememberMe(){
        return  rememberMe;
    }
    
    
     
    
    
}
