/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.requests;

 
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class Logger {
    
    /****
    public  final int  log(Connection  con, final String  inRequestJson, final boolean isParsedToJsonOk) {
           
         int recordsInserted = 0;
         PreparedStatement ps  =    null;
         
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
                ps.setString(5,  "FetchMyTrxnHistory"); 
                ps.setLong(6,  inRequestJson.hashCode());
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
    
        ***/
}
