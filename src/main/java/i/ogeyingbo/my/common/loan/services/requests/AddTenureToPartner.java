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
public class AddTenureToPartner  extends  RequestBase {
    
    private  String  name  = ""; 
    private  String  lenderCode  = ""; 
    private  BigDecimal  minimumAmount  = new  BigDecimal(0.00); 
    private  BigDecimal  maximumAmount  = new  BigDecimal(0.00);  
    private  int  minimumDuration  = 1; 
    private  int  maximumDuration  = 6; 
   
    private  String  tenureType  = "";
    private  String  loanType  = "";
    private  int  loanTypeId  = 2;
 
    private  String  serviceType  = "Loans";
    private  BigDecimal  rate  = new  BigDecimal(22.00); 
    private  boolean  status  = true;
     
     
    
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
     
     
     public   final  AddTenureToPartner  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        AddTenureToPartner   addTenureToPartner  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              addTenureToPartner = objectMapper.readValue(inObjectJSON, AddTenureToPartner.class);
               this.log(con, inObjectJSON, true);
            }catch(Exception ex){
              this.log(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  addTenureToPartner;
    }
     
     
    public  static  AddTenureToPartner  readFromJSON(String  inObjectJSON){ 
        AddTenureToPartner  addTenureToPartner  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              addTenureToPartner = objectMapper.readValue(inObjectJSON, AddTenureToPartner.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  addTenureToPartner;
    }
      
      
    
    
    
    public String   getName(){
        return  name;
    }
    
    public String   getLenderCode(){
        return  lenderCode;
    }
    
    public BigDecimal   getMinimumAmount(){
        return  minimumAmount;
    }
    
    public BigDecimal   getMaximumAmount(){
        return  maximumAmount;
    }
    
    public int   getMinimumDuration(){
        return  minimumDuration;
    }
    
    public int   getMaximumDuration(){
        return  maximumDuration;
    } 
     
    
    public String   getTenureType(){
        return  tenureType;
    }
    
    public String   getLoanType(){
        return  loanType;
    }
    
    public int   getLoanTypeId(){
        return  loanTypeId;
    }
    
    public String   getServiceType(){
        return  serviceType;
    }
    
    
    public BigDecimal   getRate(){
        return  rate;
    }
    
    public boolean   getStatus(){
        return  status;
    }
    
    
    
    
    
    
    
}
