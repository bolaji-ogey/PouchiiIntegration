/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.callback.url;

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
public class LoanApplicationNotifyReq {
    
    private String  loanRequestReference =  "";
    private BigDecimal  requestAmount =  new BigDecimal(0.00);
    private String  currency =  "";
    private String  requestDate =  "";
    private String  loanProductDesc =  "";
    private String  loanProductTypeCode =  "";
    private int  loanProductTypeId =  1;
    
    private String  businessType =  "";
    private String  businessTypeCode =  "";
    private String  customerCompanyName =  "";
    
    private String  location =  "";
    private String  industry =  "";
    private BigDecimal  monthlyRevenue =  new BigDecimal(0.00);
    
    private int  tenureDuration =  6;
    private  String tenureType =  "Months";
    private double  tenureRate =  2.5;
    
    private  boolean  receivedMySalaryViaRemita =  false;
    
    private String  employmentStatus =  "Employed";
    private String  employmentStatusDesc =  "Employed";
    private String  employmentType =  "Private_Organization";
    private String  employerTypeDesc =  "Private_Organization";
    
   
     
    
    RepaymentInfo   rePaymentInfo  =  new  RepaymentInfo();  
    ApplicationForm[]   applicationForms  =  new  ApplicationForm[1];
    LoanDocument[]   loanDocuments   =  new LoanDocument[2];
    
    private String  loanStatus =  "PENDING";
  
   
    
     public  void  setLoanRequestReference(String inLoanRequestReference){
        loanRequestReference  =  inLoanRequestReference;
    }
      
    public  void  setRequestAmount(BigDecimal   inRequestAmount){
        requestAmount  =  inRequestAmount;
    }
    
     public  void  setCurrency(String inCurrency){
        currency  =  inCurrency;
    }
      
    public  void  setRequestDate(String inRequestDate){
        requestDate  =  inRequestDate;
    }
    
     public  void  setLoanProductDesc(String inLoanProductDesc){
        loanProductDesc  =  inLoanProductDesc;
    }
      
    public  void  setLoanProductTypeCode(String inLoanProductTypeCode){
        loanProductTypeCode  =  inLoanProductTypeCode;
    }
    
    public  void  setLoanProductTypeId(int inLoanProductTypeId){
        loanProductTypeId  =  inLoanProductTypeId;
    }
    
    
     
    public  void  setBusinessType(String inBusinessType){
        businessType  =  inBusinessType;
    }
      
    public  void  setBusinessTypeCode(String inBusinessTypeCode){
        businessTypeCode  =  inBusinessTypeCode;
    }
     
    public  void  setCustomerCompanyName(String inCustomerCompanyName){
        customerCompanyName  =  inCustomerCompanyName;
    }
    
   
    public  void  setLocation(String inLocation){
        location  =  inLocation;
    }
     
    public  void  setIndustry(String inIndustry){
        industry  =  inIndustry;
    }
     
    
     public  void  setMonthlyRevenue(BigDecimal inMonthlyRevenue){
        monthlyRevenue  =  inMonthlyRevenue;
    }
    
    public  void  setTenureDuration(int inTenureDuration){
        tenureDuration  =  inTenureDuration;
    }
    
    public  void  setTenureType(String inTenureType){
        tenureType  =  inTenureType;
    }
    
    public  void  setTenureRate(double inTenureRate){
        tenureRate  =  inTenureRate;
    }
    
    public  void  setReceivedMySalaryViaRemita(boolean inReceivedMySalaryViaRemita){
        receivedMySalaryViaRemita  =  inReceivedMySalaryViaRemita;
    }
    
    
    
    
    
    
    public  void  setEmploymentStatus(String inEmploymentStatus){
        employmentStatus  =  inEmploymentStatus;
    }
    
    public  void  setEmploymentStatusDesc(String inEmploymentStatusDesc){
        employmentStatusDesc  =  inEmploymentStatusDesc;
    }
    
    public  void  setEmploymentType(String inEmploymentType){
        employmentType  =  inEmploymentType;
    }
    
    public  void  setEmployerTypeDesc(String inEmployerTypeDesc){
        employerTypeDesc  =  inEmployerTypeDesc;
    }
    
    
    
    
   public  void  setRePaymentInfo(RepaymentInfo  inRepaymentInfo){
       rePaymentInfo  =    inRepaymentInfo;
   }
   
   
   public  void  setApplicationForms(ApplicationForm[]  inApplicationForms){
       applicationForms  =    inApplicationForms;
   }
    
   public  void  setLoanDocuments(LoanDocument[]  inLoanDocuments){
       loanDocuments  =    inLoanDocuments;
   }
     
   
   public  void  setLoanStatus(String inLoanStatus){
        loanStatus  =  inLoanStatus;
    }
   
   
            
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
     
     
    public   final  LoanApplicationNotifyReq  readFromJSONAndLog(Connection con, final String  inObjectJSON){ 
        LoanApplicationNotifyReq   loanApplicationNotifyReq  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              loanApplicationNotifyReq = objectMapper.readValue(inObjectJSON, LoanApplicationNotifyReq.class);
             //  this.logRequest(con, inObjectJSON, true);
            }catch(Exception ex){
             // this.logRequest(con, inObjectJSON, false);
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  loanApplicationNotifyReq;
    }
     
     
     
     
    public  static final LoanApplicationNotifyReq  readFromJSON(String  inObjectJSON){ 
        LoanApplicationNotifyReq  loanApplicationNotifyReq  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              loanApplicationNotifyReq = objectMapper.readValue(inObjectJSON, LoanApplicationNotifyReq.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
               objectMapper = null;
            }
        return  loanApplicationNotifyReq;
    }
    
    
    
    
    
    
    
   public  String  getLoanRequestReference(){
        return  loanRequestReference;
    }
      
    public  BigDecimal  getRequestAmount(){
        return   requestAmount;
    }
    
     public  String  getCurrency(){
        return   currency;
    }
      
    public  String  getRequestDate(){
        return   requestDate;
    }
    
     public  String  getLoanProductDesc(){
        return   loanProductDesc;
    }
      
    public  String  getLoanProductTypeCode(){
         return  loanProductTypeCode;
    }
    
    public  int  getLoanProductTypeId(){
         return  loanProductTypeId;
    }
    
    
    
    
    public  String  getBusinessType(){
       return    businessType;
    }
      
    public  String  getBusinessTypeCode(){
       return    businessTypeCode;
    }
     
    public  String  getCustomerCompanyName(){
       return    customerCompanyName;
    }
    
   
    public  String  getLocation(){
       return    location;
    }
     
    public  String  getIndustry(){
       return    industry;
    }
     
    
     public  BigDecimal  getMonthlyRevenue(){
        return   monthlyRevenue;
    }
    
    public  int  getTenureDuration(){
        return   tenureDuration;
    }
    
    public   String getTenureType(){
        return  tenureType;
    }
    
    public  double  getTenureRate(){
        return   tenureRate;
    }
    
    public  boolean  getReceivedMySalaryViaRemita(){
        return   receivedMySalaryViaRemita;
    }
    
    
    
    public  String  getEmploymentStatus(){
       return employmentStatus;
    }
    
    public  String  getEmploymentStatusDesc(){
      return  employmentStatusDesc;
    }
    
    public  String  getEmploymentType(){
       return   employmentType;
    }
    
    public  String  getEmployerTypeDesc(){
       return   employerTypeDesc;
    }
    
    
    
    
   public  RepaymentInfo  getRePaymentInfo(){
       return   rePaymentInfo;
   }
   
   
   public  ApplicationForm[]  getApplicationForms(){
      return    applicationForms;
   }
    
   public  LoanDocument[]  getLoanDocuments(){
      return    loanDocuments;
   }
   
   
   public  String  getLoanStatus(){
       return loanStatus;
    }
   
   
}
