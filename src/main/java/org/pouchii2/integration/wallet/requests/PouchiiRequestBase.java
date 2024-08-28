/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.requests;

 
import jakarta.validation.constraints.NotBlank;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.validation.constraints.Pattern;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class PouchiiRequestBase {
     
    @NotBlank(message = "Request channel ID cannot be null or empty") 
    private  String  requestChannelId = "-";
    
    @NotBlank(message = "Request channel cannot be null or empty") 
    private  String  requestChannel = "API";
    
    @NotBlank(message = "Request channel type cannot be null or empty") 
    private  String  requestChannelType = "Integrator";
    
    @NotBlank(message = "Request application code cannot be null or empty") 
    private  String  requestApplicationCode = "-";
    
    @NotBlank(message = "Request application module cannot be null or empty") 
    private  String  requestApplicationModule = "INTEGRATOR";
    
    @NotBlank(message = "Request partner code cannot be null or empty")
    private  String  requestPartnerCode = "-"; 
     
    private  String  customerReference = ""; 
    
    
    public  final int  logRequest(Connection  con, final String  inRequestJson, final boolean isParsedToJsonOk) {
           
         int recordsInserted = 0;
         PreparedStatement ps  =    null; 
         
        StringBuilder  REQUEST_LOG_FIELDS = new StringBuilder(100);
        REQUEST_LOG_FIELDS.append("   request_channel_id, request_partner_code, request_channel_type, ");
        REQUEST_LOG_FIELDS.append(" request_application_code,   request_json,  is_request_parsed_ok, request_time, request_date "); 
         
            try {
 
                String rwInsertString =   "INSERT  INTO  pouchii_request_log (%s) VALUES (?,?,?,?,?,?,CURRENT_TIME, CURRENT_DATE)";
                String  insertString = String.format(rwInsertString, REQUEST_LOG_FIELDS.toString());

                 ps = con.prepareStatement(insertString);
 
                // Parameters start with 1 
                ps.setString(1, requestChannelId);  
                ps.setString(2, requestPartnerCode);
                ps.setString(3, requestChannelType);
                ps.setString(4, requestApplicationCode);  
                ps.setString(5,  inRequestJson);   
                ps.setBoolean(6,  isParsedToJsonOk);   

                recordsInserted = ps.executeUpdate();
                
               
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                try{
                    ps.close();
                    ps = null;
                }catch(Exception er){
                    er.printStackTrace();
                }
            }
          return  recordsInserted;
         }
    
    
    
    
    
    public  String  getRequestChannelId(){
        return  requestChannelId;
    }
    
    public  String  getRequestChannel(){
       return  requestChannel; 
    }
    
    public  String  getRequestChannelType(){
        return  requestChannelType;
    }
    
    public  String  getRequestApplicationCode(){
        return  requestApplicationCode;
    }
    
    public  String  getRequestApplicationModule(){
        return  requestApplicationModule;
    }
    
    public  String  getRequestPartnerCode(){
        return  requestPartnerCode;
    }
    
    public  String  getCustomerReference(){
        return  customerReference;
    }
     
     
    public  void   setRequestChannelId(String  inRequestChannelId){
       requestChannelId =  inRequestChannelId;
    }
    
    public  void   setRequestChannel(String  inRequestChannel){
       requestChannel =  inRequestChannel;
    }
    
    public  void   setRequestChannelType(String  inRequestChannelType){
       requestChannelType =  inRequestChannelType;
    }
    
    public  void   setRequestApplicationCode(String  inRequestApplicationCode){
       requestApplicationCode =  inRequestApplicationCode;
    }
    
    
    public  void   setRequestApplicationModule(String  inRequestApplicationModule){
       requestApplicationModule =  inRequestApplicationModule;
    }
    
    public  void   setRequestPartnerCode(String  inRequestPartnerCode){
       requestPartnerCode =  inRequestPartnerCode;
    }
    
    public  void   setCustomerReference(String  inCustomerReference){
       customerReference =  inCustomerReference;
    }
    
    
}
