/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.my.common.loan.services.requests;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper; 
import java.sql.Connection;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class SearchCustomerLoanApplications   extends  RequestBase {
    
    private  String  lenderCode =  "";
    private  String  status =  "Pending";
    private  String  requestDate =  "2023-08-23";
  
    
     
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
     
     
     public   final  SearchCustomerLoanApplications  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        SearchCustomerLoanApplications   searchCustomerLoanApplications  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              searchCustomerLoanApplications = objectMapper.readValue(inObjectJSON, SearchCustomerLoanApplications.class);
               this.log(con, inObjectJSON, true);
            }catch(Exception ex){
              this.log(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  searchCustomerLoanApplications;
    }
     
     
    public  static  SearchCustomerLoanApplications  readFromJSON(String  inObjectJSON){ 
        SearchCustomerLoanApplications  searchCustomerLoanApplications  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              searchCustomerLoanApplications = objectMapper.readValue(inObjectJSON, SearchCustomerLoanApplications.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  searchCustomerLoanApplications;
    }
      
     
    
    public  String  getLenderCode(){
        return   lenderCode;
    }
    
    public  String  getStatus(){
        return   status;
    }
    
    
    public  String  getRequestDate(){
        return   requestDate;
    }
    
}
