/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.my.common.lenders.api.requests;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper; 
import java.sql.Connection;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class LoanApplStatusEnquiryReq  extends  RequestBase {
    
    private  String         loanRequestReference = "";
    
    
    
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
     
     
     public   final  LoanApplStatusEnquiryReq  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        LoanApplStatusEnquiryReq   loanApplStatusEnquiryReq  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              loanApplStatusEnquiryReq = objectMapper.readValue(inObjectJSON, LoanApplStatusEnquiryReq.class);
               this.log(con, inObjectJSON, true);
            }catch(Exception ex){
              this.log(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  loanApplStatusEnquiryReq;
    }
     
     
     
    public  static  LoanApplStatusEnquiryReq  readFromJSON(String  inObjectJSON){ 
        LoanApplStatusEnquiryReq  loanApplStatusEnquiryReq  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              loanApplStatusEnquiryReq = objectMapper.readValue(inObjectJSON, LoanApplStatusEnquiryReq.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  loanApplStatusEnquiryReq;
    }
      
    
     public  String  getLoanRequestReference(){
        return  loanRequestReference;
    }
     
     
}
