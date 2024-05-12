/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.single.node.wallet.merchant.requests.base;
  
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class MerchantRequestBase {
    
    private  String  requestType = "-"; 
    
    private  String  requestId = "-";
    private  String  requestChannelId = "-";
    private  String  requestChannel = "API";
    private  String  requestChannelType = "Integrator";
    private  String  requestApplicationCode = "-";
    private  String  requestApplicationModule = "INTEGRATOR";
    private  String  requestPartnerCode = "-"; 
    
    private  long   requestHash =  -1;
    
    public  long  getRequestHash(){
        return  requestHash;
    }
    
    
    public  final int  logRequest(Connection  con, final String  inRequestJson, final boolean isParsedToJsonOk) {
           
         int recordsInserted = 0;
         PreparedStatement ps  =    null;
         requestHash  = inRequestJson.trim().hashCode();
         
        StringBuilder  REQUEST_LOG_FIELDS = new StringBuilder(100);
        REQUEST_LOG_FIELDS.append(" request_id, request_company_id, request_partner_code,  ");
        REQUEST_LOG_FIELDS.append(" request_application_code,  request_type, request_hash,   ");
        REQUEST_LOG_FIELDS.append("  request_json,  is_request_parsed_ok, request_time, request_date "); 
         
            try {
 
                String rwInsertString =   "INSERT  INTO  request_log (%s) VALUES (?,?,?,?,?,?,?,?,CURRENT_TIME, CURRENT_DATE)";
                String  insertString = String.format(rwInsertString, REQUEST_LOG_FIELDS.toString());

                 ps = con.prepareStatement(insertString);
 
                // Parameters start with 1
                ps.setString(1, requestId);
                ps.setString(2, "-");  
                ps.setString(3, requestPartnerCode);
                ps.setString(4, requestApplicationCode);                   
                ps.setString(5,  requestType); 
                ps.setLong(6,  requestHash);
                ps.setString(7,  inRequestJson);   
                ps.setBoolean(8,  isParsedToJsonOk);   

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
    
    
    public  String  getRequestType(){
       return  requestType; 
    }
    
    
    public  String  getRequestId(){
       return  requestId; 
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
    
    
    
    public  void   setRequestType(String  inRequestType){
       requestType =  inRequestType;
    }
    
    
    public  void   setRequestId(String  inRequestId){
       requestId =  inRequestId;
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
