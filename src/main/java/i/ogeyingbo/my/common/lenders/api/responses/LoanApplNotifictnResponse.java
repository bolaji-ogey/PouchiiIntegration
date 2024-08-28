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
@JsonPropertyOrder({"responseCode", "responseMessage", "loanReference", "loanStatus", "loanStatusReason"})
public class LoanApplNotifictnResponse {
    
    private int   responseCode   = 200;
    private String   responseMessage   = "";
    
    private String   loanReference   = "";
    private String   loanStatus   = "";
    private String   loanStatusReason   = "";
    
    
    public int  getResponseCode(){
        return  responseCode;
    }
    
    public String  getResponseMessage(){
        return  responseMessage;
    }
    
    public String  getLoanReference(){
        return  loanReference;
    }
    
    public String  getLoanStatus(){
        return  loanStatus;
    }
    
    public String  getLoanStatusReason(){
        return  loanStatusReason;
    }
    
    
    
    public void  setResponseCode(int  inResponseCode){
       responseCode = inResponseCode;
    }
    
    public void  setResponseMessage(String  inResponseMessage){
          responseMessage = inResponseMessage;
    }
    
    public void  setLoanReference(String  inLoanReference){
          loanReference = inLoanReference;
    }
    
    public void  setLoanStatus(String  inLoanStatus){
          loanStatus = inLoanStatus;
    }
    
    public void  setLoanStatusReason(String  inLoanStatusReason){
          loanStatusReason = inLoanStatusReason;
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
     
    
    
     public   final  LoanApplNotifictnResponse  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        LoanApplNotifictnResponse   loanApplNotifictnResponse  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              loanApplNotifictnResponse = objectMapper.readValue(inObjectJSON, LoanApplNotifictnResponse.class);
             //  this.log(con, inObjectJSON, true);
            }catch(Exception ex){
            //  this.log(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  loanApplNotifictnResponse;
    }
     
    
    public  static  LoanApplNotifictnResponse  readFromJSON(String  inObjectJSON){ 
        LoanApplNotifictnResponse  loanApplNotifictnResponse  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              loanApplNotifictnResponse = objectMapper.readValue(inObjectJSON, LoanApplNotifictnResponse.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  loanApplNotifictnResponse;
    }
      
    
    
     
}
