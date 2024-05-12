/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.merchant.requests;

  
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class PouchiiMerchRequestBase {
     
    private  String  requestChannelId = "TEST-MERCH";
    private  String  requestChannel = "Api";
    private  String  requestChannelType = "Integrator";
    private  String  requestApplicationCode = "POUCHII";
    private  String  requestApplicationModule = "INTEGRATOR";
    private  String  requestPartnerCode = "TEST-MERCH"; 
    
     
    
    
    public  final int  logRequest(Connection  con, final String  inRequestJson, final boolean isParsedToJsonOk) {
           
         int recordsInserted = 0;
         PreparedStatement ps  =    null; 
         
        StringBuilder  REQUEST_LOG_FIELDS = new StringBuilder(100);
        REQUEST_LOG_FIELDS.append("   request_channel_id, request_partner_code, request_channel_type, ");
        REQUEST_LOG_FIELDS.append(" request_application_code,   request_json,  is_request_parsed_ok, request_time, request_date "); 
         
            try {
 
                String rwInsertString =   "INSERT  INTO  [pouchii_request_log (%s) VALUES (?,?,?,?,?,?,CURRENT_TIME, CURRENT_DATE)";
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
    
    
    
    
    
}
