/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.my.common.loan.services.requests;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper; 
import java.math.BigDecimal;
import java.sql.Connection;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class LoanRepaymentNotification  extends  RequestBase  {
    
    private  String  loanReference  = "";
    private  String  lenderCode  = "";
    private  String  repaymentReference  = "";
    private  BigDecimal  repaymentAmount  = new BigDecimal(0.00);
    private  String  repaymentDueDate  = "";
    private  String  paymentDate  = "";
    
     
    
     
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
     
     
     public   final  LoanRepaymentNotification  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        LoanRepaymentNotification   loanRepaymentNotification  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              loanRepaymentNotification = objectMapper.readValue(inObjectJSON, LoanRepaymentNotification.class);
               this.log(con, inObjectJSON, true);
            }catch(Exception ex){
              this.log(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  loanRepaymentNotification;
    }
     
     
    public  static  LoanRepaymentNotification  readFromJSON(String  inObjectJSON){ 
        LoanRepaymentNotification  loanRepaymentNotification  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              loanRepaymentNotification = objectMapper.readValue(inObjectJSON, LoanRepaymentNotification.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  loanRepaymentNotification;
    }
      
    
    public  String   getLoanReference(){
        return  loanReference;
    }
     
    public  String   getLenderCode(){
        return  lenderCode;
    }
    
    public  String   getRepaymentReference(){
        return  repaymentReference;
    }
    
    public  BigDecimal   getRepaymentAmount(){
        return  repaymentAmount;
    }
    
    public  String   getRepaymentDueDate(){
        return  repaymentDueDate;
    }
    
    
    public  String   getPaymentDate(){
        return  paymentDate;
    }
    
     
    
    
    
}
