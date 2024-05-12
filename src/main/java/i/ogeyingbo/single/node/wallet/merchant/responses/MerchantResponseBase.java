/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.single.node.wallet.merchant.responses;
 

import i.ogeyingbo.single.node.wallet.merchant.responses.base.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import org.json.JSONObject; 

import  i.ogeyingbo.single.node.wallet.merchant.requests.MerchantRequestBase;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class MerchantResponseBase  extends  MerchantRequestBase {
    
    private  int  responseCode = 401;
    private String  responseMessage  =  "";
    private  boolean  requiredLogout  =  false;
    private  boolean  requireLogin  =  false;
    private  boolean  requireRefreshToken  =  false;
    private  boolean  requiredPasswordChange  =  false;
    private  boolean  requiredVerification  =  false;
    private  boolean  requiredPinCreation  =  false;
    private  String  responseTime  =  ""; 
    
    
    
    public  final int  logResponse(Connection  con, final String  inRequestJson, final boolean isParsedToJsonOk) {
           
         int recordsInserted = 0;
         PreparedStatement ps  =    null; 
         
        StringBuilder  REQUEST_LOG_FIELDS = new StringBuilder(100);
        REQUEST_LOG_FIELDS.append("   request_channel_id, request_partner_code, request_channel_type, ");
        REQUEST_LOG_FIELDS.append(" request_application_code,   request_json,  is_request_parsed_ok, request_time, request_date "); 
         
            try {
 
                String rwInsertString =   "INSERT  INTO  pouchii_response_log (%s) VALUES (?,?,?,?,?,?,CURRENT_TIME, CURRENT_DATE)";
                String  insertString = String.format(rwInsertString, REQUEST_LOG_FIELDS.toString());

                 ps = con.prepareStatement(insertString);
 
                // Parameters start with 1 
                ps.setString(1, getRequestChannelId());  
                ps.setString(2, getRequestPartnerCode());
                ps.setString(3, getRequestChannelType());
                ps.setString(4, getRequestApplicationCode());  
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
    
    
    
    
    public  int  getResponseCode(){
        return  responseCode;
    }
    
    public  String  getResponseMessage(){
       return  responseMessage; 
    }
    
    public  boolean  getRequiredLogout(){
        return  requiredLogout;
    }
    
    public  boolean  getRequireLogin(){
        return  requireLogin;
    }
    
    public  boolean  getRequireRefreshToken(){
        return  requireRefreshToken;
    }
    
    public  boolean  getRequiredPasswordChange(){
        return  requiredPasswordChange;
    }
    
    public  boolean  getRequiredVerification(){
        return  requiredVerification;
    }
    
    public  boolean  getRequiredPinCreation(){
        return  requiredPinCreation;
    }
    
    public  String  getResponseTime(){
        return  responseTime;
    }
     
    
    
    
    
    
    
    public  void  setResponseCode(int inResponseCode){
          responseCode = inResponseCode;
    }
    
    public  void  setResponseMessage(String inResponseMessage){
         responseMessage  =  inResponseMessage; 
    }
    
    public  void  setRequiredLogout(boolean  inRequiredLogout){
         requiredLogout = inRequiredLogout;
    }
    
    public  void   setRequireLogin(boolean inRequireLogin){
        requireLogin = inRequireLogin;
    }
    
    public  void  setRequireRefreshToken(boolean inRequireRefreshToken){
          requireRefreshToken = inRequireRefreshToken;
    }
    
    public  void  setRequiredPasswordChange(boolean inRequiredPasswordChange){
          requiredPasswordChange = inRequiredPasswordChange;
    }
    
    public  void  setRequiredVerification(boolean inRequiredVerification){
         requiredVerification = inRequiredVerification;
    }
    
    public  void  setRequiredPinCreation(boolean inRequiredPinCreation){
         requiredPinCreation = inRequiredPinCreation;
    }
    
    public  void  setResponseTime(String inResponseTime){
         responseTime = inResponseTime;
    }
    
    
      
}
