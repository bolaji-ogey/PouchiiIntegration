/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.my.common.loan.services.requests;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper; 
import java.sql.Connection;
import java.util.ArrayList;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class LoanStatusNotification  extends  RequestBase  {
     
    private  String  requestReference  = "";
    private  String  lenderCode     = "";
    private  String  loanStatus  = "";
    private  String  reason  = "";
     
    
    
    ArrayList<RepaymentPlan>    repaymantPlans  =  new  ArrayList<>();
    
     
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
     
     
     public   final  LoanStatusNotification  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        LoanStatusNotification   loanStatusNotification  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              loanStatusNotification = objectMapper.readValue(inObjectJSON, LoanStatusNotification.class);
               this.log(con, inObjectJSON, true);
            }catch(Exception ex){
              this.log(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  loanStatusNotification;
    }
     
     
     
    public  static  LoanStatusNotification  readFromJSON(String  inObjectJSON){ 
        LoanStatusNotification  loanStatusNotification  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              loanStatusNotification = objectMapper.readValue(inObjectJSON, LoanStatusNotification.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  loanStatusNotification;
    }
      
    
    
    public  String   getRequestReference(){
        return  requestReference;
    }
    
    public  String   getLenderCode(){
        return  lenderCode;
    }
    
    public  String   getLoanStatus(){
        return  loanStatus;
    }
    
    public  String   getReason(){
        return  reason;
    }
    
     
    
    
}
