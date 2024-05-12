/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.my.common.loan.mgmt.network;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper; 
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class PartnerLoanTenure {
    
   private  long  id = -1;
   private  String  companyId =  "";
   private  String  partnerCode =  "";
   private  String  applicationCode =  "";
   private  String  loanName =  "";
   private  String  lenderCode =  "";
   private  BigDecimal  minimumAmount =  new BigDecimal(0.00);
   private  BigDecimal  maximumAmount =  new BigDecimal(0.00);
   private  int  minimumDuration = -1;
   private  int  maximumDuration = -1;
   private  String  tenureType =  "";
   private  String  loanType =  "";
   private  int  loanTypeId = -1;
   private  String  serviceType =  "";
   private  BigDecimal  rate =  new BigDecimal(0.00);
   private  boolean  isActive = false;
   
 
   public  PartnerLoanTenure(long inId,  String inCompanyId,  String inPartnerCode,  String inAppCode,
                                String  inLoanName, String inLenderCode,  BigDecimal  inMinimumAmount,
                                BigDecimal  inMaximumAmount, int inMinimumDuration,  int inMaximumDuration,
                                String  inTenureType, String inLoanType,  int inLoanTypeId, String inServiceType,
                                 BigDecimal  inRate,  boolean  inIsActive){
       id = inId;
       companyId = inCompanyId;
       partnerCode = inPartnerCode;
       applicationCode = inAppCode;
       loanName = inLoanName;
       lenderCode =  inLenderCode;
       minimumAmount = inMinimumAmount;
       maximumAmount = inMaximumAmount;
       minimumDuration = inMinimumDuration;
       maximumDuration = inMaximumDuration;
       tenureType  =  inTenureType;
       loanType  =  inLoanType;
       loanTypeId  =  inLoanTypeId;
       serviceType = inServiceType;
       rate  =  inRate;
       isActive =  inIsActive;      
       
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
     
     
    
    public  static  PartnerLoanTenure  readFromJSON(String  inObjectJSON){ 
        PartnerLoanTenure  partnerLoanTenure  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              partnerLoanTenure = objectMapper.readValue(inObjectJSON, PartnerLoanTenure.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
                objectMapper = null;
            }
        return  partnerLoanTenure;
    }
    
    
     
    public    boolean   createPartnerLoanTenure(Connection    con) {
         
         PreparedStatement ps  =    null; 
         int  countOfRecordsInserted  =  0;
         boolean  isRecordInserted  = false; 
                              
            StringBuilder  INSERT_PARTNER_LOAN_TENURE_SQL =  new StringBuilder(200);
            INSERT_PARTNER_LOAN_TENURE_SQL.append("INSERT  INTO  partner_loan_tenures  (company_id, partner_code, ");
            INSERT_PARTNER_LOAN_TENURE_SQL.append(" application_code, loan_name, lender_code,  minimum_amount,  ");
            INSERT_PARTNER_LOAN_TENURE_SQL.append("  maximum_amount,  minimum_duration,  maximum_duration, tenure_type, ");
            INSERT_PARTNER_LOAN_TENURE_SQL.append("   loan_type,  loan_type_id,  service_type, rate,  is_active) "); 
            INSERT_PARTNER_LOAN_TENURE_SQL.append("   VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
                   
            try { 
                   
                        ps = con.prepareStatement(String.format(INSERT_PARTNER_LOAN_TENURE_SQL.toString()));
                        
                        ps.setString(1, companyId);
                        ps.setString(2, partnerCode);  
                        ps.setString(3, applicationCode);
                        ps.setString(4, loanName);
                        ps.setString(5, lenderCode);
                        ps.setBigDecimal(6, minimumAmount);
                        ps.setBigDecimal(7, maximumAmount);
                        ps.setInt(8, minimumDuration);
                        ps.setInt(9, maximumDuration);
                        ps.setString(10, tenureType);
                        ps.setString(11, loanType);
                        ps.setInt(12, loanTypeId);
                        ps.setString(13, serviceType);
                        ps.setBigDecimal(14, rate);
                        ps.setBoolean(15, isActive);

                        isRecordInserted  =  (ps.executeUpdate() == 1);                      
                  
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                INSERT_PARTNER_LOAN_TENURE_SQL  = null;
                try{
                    ps = null;
                }catch(Exception er){
                    er.printStackTrace();
                }
            }
        return  isRecordInserted;
    }

   
   
	  
}
