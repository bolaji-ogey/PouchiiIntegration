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
public class LoanDisbursementNotification  extends  RequestBase  {
    
    private String  requestReference = "";
    private String  lenderCode = "";
    private String  loanStatus = "";
    private String  reason = ""; 
    
    ArrayList<Fee>   fees  =  new ArrayList<>();
     
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
     
     
     public   final  LoanDisbursementNotification  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        LoanDisbursementNotification   loanDisbursementNotification  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              loanDisbursementNotification = objectMapper.readValue(inObjectJSON, LoanDisbursementNotification.class);
               this.log(con, inObjectJSON, true);
            }catch(Exception ex){
              this.log(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  loanDisbursementNotification;
    }
     
     
    public  static  LoanDisbursementNotification  readFromJSON(String  inObjectJSON){ 
        LoanDisbursementNotification  loanDisbursementNotification  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              loanDisbursementNotification = objectMapper.readValue(inObjectJSON, LoanDisbursementNotification.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  loanDisbursementNotification;
    }
      
    
     
    
    public  String  getRequestReference(){
        return  requestReference;
    }
    
    public  String  getLenderCode(){
        return  lenderCode;
    }
    
    
    public  String  getLoanStatus(){
        return  loanStatus;
    }
    
    
    public  String  getReason(){
        return  reason;
    }
    
    
    public  ArrayList<Fee>  getFees(){
        return  fees;
    }
    
    
}
