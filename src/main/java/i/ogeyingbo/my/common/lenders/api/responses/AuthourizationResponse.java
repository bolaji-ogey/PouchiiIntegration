/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.my.common.lenders.api.responses;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import i.ogeyingbo.single.node.superadmin.setup.requests.StandardUserRegistration;
import java.sql.Connection;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class AuthourizationResponse {
    
    private  int responseCode  = 400;
    private  String responseMessage = "";
    private  ResponseData  data = null;
    
    public int  getResponseCode(){
        return  responseCode;
    }
    
    public String  getResponseMessage(){
        return  responseMessage;
    }
    
    public ResponseData  getData(){
        return  data;
    }
    
    
    
    public void  setResponseCode(int  inResponseCode){
       responseCode = inResponseCode;
    }
    
    public void  setResponseMessage(String  inResponseMessage){
          responseMessage = inResponseMessage;
    }
    
    public void  setData(ResponseData  inData){
          data = inData;
    }
    
    
    
    private  final  String  convertToJSONString(){
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
     
    
    
     public   final  AuthourizationResponse  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        AuthourizationResponse   authourizationResponse  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              authourizationResponse = objectMapper.readValue(inObjectJSON, AuthourizationResponse.class);
             //  this.log(con, inObjectJSON, true);
            }catch(Exception ex){
            //  this.log(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  authourizationResponse;
    }
     
    
    public  static  AuthourizationResponse  readFromJSON(String  inObjectJSON){ 
        AuthourizationResponse  authourizationResponse  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              authourizationResponse = objectMapper.readValue(inObjectJSON, AuthourizationResponse.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  authourizationResponse;
    }
      
    
    
}
