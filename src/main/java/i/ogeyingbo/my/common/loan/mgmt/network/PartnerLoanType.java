/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.my.common.loan.mgmt.network;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class PartnerLoanType {
    
   private  long  id = -1;
   private  String  companyId =  "";
   private  String  partnerCode =  "";
   private  String  applicationCode =  "";
   private  String  loanName =  "";
   private  String  loanDescription =  "";
   private  String  loanType =  "";
   private  String  shortName =  "";
   private  boolean  isActive = false;
    
   
    public   PartnerLoanType(long  inId, String inCompanyId, String inPartnerCode,  String inAppCode,
                              String inLoanName, String  inLoanDescription,  String inLoanType,
                                 String  inShortName,   boolean inIsActive){
         id = inId;
         companyId =  inCompanyId;
         partnerCode  =  inPartnerCode;
         applicationCode = inAppCode;
         loanName = inLoanName;
         loanDescription  =  inLoanDescription;
         loanType  =  inLoanType;
         shortName  =  inShortName;
         isActive = inIsActive;
        
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
     
     
    
    public  static  PartnerLoanType  readFromJSON(String  inObjectJSON){ 
        PartnerLoanType  partnerLoanType  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              partnerLoanType = objectMapper.readValue(inObjectJSON, PartnerLoanType.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
                objectMapper = null;
            }
        return  partnerLoanType;
    }
    
    
    
     
    public    boolean   createPartnerLoanType(Connection    con) {
         
         PreparedStatement ps  =    null; 
         int  countOfRecordsInserted  =  0;
         boolean  isRecordInserted  = false; 
           
         StringBuilder  INSERT_PARTNER_LOAN_TYPE_SQL =  new StringBuilder(200);
            INSERT_PARTNER_LOAN_TYPE_SQL.append("INSERT  INTO  partner_loan_types  (company_id, partner_code, ");
            INSERT_PARTNER_LOAN_TYPE_SQL.append(" application_code,  loan_name, loan_description, loan_type, ");
            INSERT_PARTNER_LOAN_TYPE_SQL.append("  short_name, is_active)   VALUES (?,?,?,?,?,?,?,?)  ");  
                   
            try { 
                   
                        ps = con.prepareStatement(String.format(INSERT_PARTNER_LOAN_TYPE_SQL.toString()));
                        
                        ps.setString(1, companyId);
                        ps.setString(2, partnerCode);
                        ps.setString(3, applicationCode);
                        ps.setString(4, loanName);
                        ps.setString(5, loanDescription); 
                        ps.setString(6, loanType); 
                        ps.setString(7, shortName); 
                        ps.setBoolean(8, isActive);                         

                        isRecordInserted  =  (ps.executeUpdate() == 1);                      
                  
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                INSERT_PARTNER_LOAN_TYPE_SQL  = null;
                try{
                    ps = null;
                }catch(Exception er){
                    er.printStackTrace();
                }
            }
        return  isRecordInserted;
    }

    
    
}
