/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.my.common.lenders.api.requests;

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
public class LoanApplicationModificationReq extends  RequestBase {
    
    private  String         modificationRequestDate = "";
    private  String         modificationRequestReason = "";
    
    private  String         loanRequestReference = "";
    private  BigDecimal     requestAmount  = new  BigDecimal(0.00);
    private  String         currency = "NGN";
    private  String         requestDate = "";
    private  String         loanProductDesc = "";
    private  String         loanProductTypeCode = "";
    private  int           loanProductTypeId = 1;
    
    private  String         businessType = "";
    private  String         businessTypeCode = "";
    private  String         customerCompanyName = "";
    private  String         location = "";
    private  String         industry = "";
    private  BigDecimal     monthlyRevenue = new  BigDecimal(0.00);
    private  int           tenureDuration = 1;
    private  String        tenureType = "Months";
    private  BigDecimal     tenureRate = new  BigDecimal(0.00);
     
    private  boolean       receivedMySalaryViaRemita  = false;
    private  String         employmentStatus = "";
    private  String         employmentStatusDesc = "";
    private  String         employmentType = "";
    private  String         employerTypeDesc = "";
    private  final String  loanStatus = "Request";
    
    RePaymentInfo      rePaymentInfo  =  new  RePaymentInfo();
    
    ApplicationForm[]   applicationForms =  new ApplicationForm[2];
    
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
     
     
     public   final  LoanApplicationModificationReq  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        LoanApplicationModificationReq   loanApplicationModificationReq  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              loanApplicationModificationReq = objectMapper.readValue(inObjectJSON, LoanApplicationModificationReq.class);
               this.log(con, inObjectJSON, true);
            }catch(Exception ex){
              this.log(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  loanApplicationModificationReq;
    }
     
     
     
    public  static  LoanApplicationModificationReq  readFromJSON(String  inObjectJSON){ 
        LoanApplicationModificationReq  loanApplicationModificationReq  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              loanApplicationModificationReq = objectMapper.readValue(inObjectJSON, LoanApplicationModificationReq.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  loanApplicationModificationReq;
    }
      
    
    public  String  getModificationRequestDate(){
        return   modificationRequestDate;
    }
    
    public  String  getModificationRequestReason(){
        return  modificationRequestReason;
    }
    
    public  String  getLoanRequestReference(){
        return  loanRequestReference;
    }
    
    public  BigDecimal  getRequestAmount(){
        return  requestAmount;
    }
    
    public  String  getCurrency(){
        return  currency;
    }
    
    public  String  getRequestDate(){
        return  requestDate;
    }
    
    public  String  getLoanProductDesc(){
        return  loanProductDesc;
    }
    
    public  String  getLoanProductTypeCode(){
        return  loanProductTypeCode;
    }
    
    public  int  getLoanProductTypeId(){
        return  loanProductTypeId;
    }
    
    public  String  getBusinessType(){
        return  businessType;
    }
    
    public  String  getBusinessTypeCode(){
        return  businessTypeCode;
    }
    
    public  String  getCustomerCompanyName(){
        return  customerCompanyName;
    }
    
      
    public  String  getLocation(){
        return  location;
    }
    
    public  String  getIndustry(){
        return  industry;
    }
     
    public  BigDecimal  getMonthlyRevenue(){
        return  monthlyRevenue;
    }
     
    public  int  getTenureDuration(){
        return  tenureDuration;
    }
    
    public  String  getTenureType(){
        return  tenureType;
    }
    
    public  BigDecimal  getTenureRate(){
        return  tenureRate;
    }
     
    public  boolean  getReceivedMySalaryViaRemitaeRate(){
        return  receivedMySalaryViaRemita;
    }
    
    public  String  getEmploymentStatus(){
        return  employmentStatus;
    }
     
    public  String  getEmploymentStatusDesc(){
        return  employmentStatusDesc;
    }
    
    public  String  getEmploymentType(){
        return  employmentType;
    }
    
    public  String  getEmployerTypeDesc(){
        return  employerTypeDesc;
    }
    
    public  String  getLoanStatus(){
        return  loanStatus;
    }
     
    public  RePaymentInfo  getRePaymentInfo(){
        return  rePaymentInfo;
    }
    
    public  ApplicationForm[]  getApplicationForms(){
        return  applicationForms;
    }
    
    
    
    
}
