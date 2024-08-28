/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.my.common.lenders.api.responses;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.sql.Connection;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
@JsonPropertyOrder({"responseCode", "responseMessage", "loanRequestReference",   "loanRequestAmount",
                          "loanType", "loanStatus", "loanStatusReason"})
public class LoanApplStatusEnquiryResponse {
    
    private  int responseCode  = 400;
    private  String responseMessage = "";
    
    private  String  loanRequestReference = "";
    private  BigDecimal  loanRequestAmount = new BigDecimal(0.00);
    private  String  loanType = "";
    private  String  loanStatus = "";
    private  String  loanStatusReason = ""; 
    
    
    
    public int  getResponseCode(){
        return  responseCode;
    }
    
    public String  getResponseMessage(){
        return  responseMessage;
    }
    
    
    public String  getLoanRequestReference(){
        return  loanRequestReference;
    }
    
    public BigDecimal  getLoanRequestAmount(){
        return  loanRequestAmount;
    }
    
    public String  getLoanType(){
        return  loanType;
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
    
    
    public void  setLoanRequestReference(String  inLoanRequestReference){
          loanRequestReference = inLoanRequestReference;
    }
    
    public void  setLoanRequestAmount(BigDecimal  inLoanRequestAmount){
          loanRequestAmount = inLoanRequestAmount;
    }
    
    public void  setLoanType(String  inLoanType){
          loanType = inLoanType;
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
     
    
    
     public   final  LoanApplStatusEnquiryResponse  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        LoanApplStatusEnquiryResponse   loanApplStatusEnquiryResponse  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              loanApplStatusEnquiryResponse = objectMapper.readValue(inObjectJSON, LoanApplStatusEnquiryResponse.class);
             //  this.log(con, inObjectJSON, true);
            }catch(Exception ex){
            //  this.log(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  loanApplStatusEnquiryResponse;
    }
     
    
    public  static  LoanApplStatusEnquiryResponse  readFromJSON(String  inObjectJSON){ 
        LoanApplStatusEnquiryResponse  loanApplStatusEnquiryResponse  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              loanApplStatusEnquiryResponse = objectMapper.readValue(inObjectJSON, LoanApplStatusEnquiryResponse.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  loanApplStatusEnquiryResponse;
    }
      
    
}
