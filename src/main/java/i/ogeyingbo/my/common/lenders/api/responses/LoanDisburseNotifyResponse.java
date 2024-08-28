/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.my.common.lenders.api.responses;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
@JsonPropertyOrder({"responseCode", "responseMessage"})
public class LoanDisburseNotifyResponse {
    
    private  int responseCode  = 400;
    private  String responseMessage = ""; 
    
    
    
    public int  getResponseCode(){
        return  responseCode;
    }
    
    public String  getResponseMessage(){
        return  responseMessage;
    }
    
    
    
    
    
    public void  setResponseCode(int  inResponseCode){
       responseCode = inResponseCode;
    }
    
    public void  setResponseMessage(String  inResponseMessage){
          responseMessage = inResponseMessage;
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
     
    
    
     public   final  LoanDisburseNotifyResponse  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        LoanDisburseNotifyResponse   loanDisburseNotifyResponse  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              loanDisburseNotifyResponse = objectMapper.readValue(inObjectJSON, LoanDisburseNotifyResponse.class);
             //  this.log(con, inObjectJSON, true);
            }catch(Exception ex){
            //  this.log(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  loanDisburseNotifyResponse;
    }
     
    
    public  static  LoanDisburseNotifyResponse  readFromJSON(String  inObjectJSON){ 
        LoanDisburseNotifyResponse  loanDisburseNotifyResponse  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              loanDisburseNotifyResponse = objectMapper.readValue(inObjectJSON, LoanDisburseNotifyResponse.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  loanDisburseNotifyResponse;
    }
      
    
}
