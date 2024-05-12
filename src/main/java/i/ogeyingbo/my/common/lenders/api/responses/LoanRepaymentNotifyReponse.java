/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.my.common.lenders.api.responses;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class LoanRepaymentNotifyReponse {
    
    private  int responseCode  = 400;
    private  String responseMessage = "";
    
    private  String responseReference = "";
    
    public int  getResponseCode(){
        return  responseCode;
    }
    
    public String  getResponseMessage(){
        return  responseMessage;
    }
    
    public String  getResponseReference(){
        return  responseReference;
    }  
    
    
    public void  setResponseCode(int  inResponseCode){
       responseCode = inResponseCode;
    }
    
    public void  setResponseMessage(String  inResponseMessage){
          responseMessage = inResponseMessage;
    }
    
    public void  setResponseReference(String  inResponseReference){
          responseReference = inResponseReference;
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
     
    
    
     public   static  LoanRepaymentNotifyReponse  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        LoanRepaymentNotifyReponse   loanRepaymentNotifyReponse  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              loanRepaymentNotifyReponse = objectMapper.readValue(inObjectJSON, LoanRepaymentNotifyReponse.class);
             //  this.log(con, inObjectJSON, true);
            }catch(Exception ex){
            //  this.log(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  loanRepaymentNotifyReponse;
    }
     
    
    public  static  LoanRepaymentNotifyReponse  readFromJSON(String  inObjectJSON){ 
        LoanRepaymentNotifyReponse  loanRepaymentNotifyReponse  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              loanRepaymentNotifyReponse = objectMapper.readValue(inObjectJSON, LoanRepaymentNotifyReponse.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  loanRepaymentNotifyReponse;
    }
      
    
    
}
