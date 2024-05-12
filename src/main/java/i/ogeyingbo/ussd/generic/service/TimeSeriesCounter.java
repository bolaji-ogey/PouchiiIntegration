/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.ussd.generic.service;

import i.ogeyingbo.single.node.wallet.core.ServiceUptimeWatch;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class TimeSeriesCounter implements Runnable{  // extends Thread {
    
    private  long  currentSessionId =  0L;
    private  long  timeSeriesCount =  0L;
    private  Connection  con  =  null;
    private  int  numberOfUserSessionsResetted =  0;
    private  USSDServiceConfig  ussdServiceConfig = null;
    private  ServiceUptimeWatch   serviceUptimeWatch  =  null;
    
    public  long  getCurrentSessionId(){
        return  this.currentSessionId;
    }
    
    public  long  getTimeSeriesCount(){
        return  this.timeSeriesCount;
    }
    
    
    public  TimeSeriesCounter(Connection  cron, USSDServiceConfig  inUssdServiceConfig){
        con = cron;
        ussdServiceConfig = inUssdServiceConfig;
    }
    
    
     public  TimeSeriesCounter(Connection  cron, ServiceUptimeWatch  inServiceUptimeWatch){
        con = cron;
        serviceUptimeWatch = inServiceUptimeWatch;
    }
    
     
    @Override
    public void run()  {
        
        while(2 < 3){
            
            this.currentSessionId = currentSessionId + 1;
            this.timeSeriesCount = timeSeriesCount + 1;
           
            if(serviceUptimeWatch.get("current_uptime") == null){
                serviceUptimeWatch.createNewUptimeRecord(1, "NODE_1", currentSessionId);
                serviceUptimeWatch.loadJustCreatedSession();
            }else{
                serviceUptimeWatch.updateExistingUptimeRecord(currentSessionId);
            }
            this.loadNewUSSDServiceConfigs();
            
            System.out.println(String.format("timeSeriesCount  >>>>> %d ", timeSeriesCount));
            numberOfUserSessionsResetted =  this.resetUserUSSDSessions();
            System.out.println(String.format("Count of User Sessions been reset  = %d ", numberOfUserSessionsResetted));
            try{ 
                 Thread.sleep(1000);  // Count every second
             }catch(Exception ex){
                 ex.printStackTrace();
             } 
 
        }
    }
    
    
    
       
   private   int   resetUserUSSDSessions() {
         
         PreparedStatement ps  =    null; 
         int  countOfRecordsInserted  =  0; 
         
         StringBuilder  UPDATE_USER_USSD_SESSION_SQL =  new StringBuilder(200);
               UPDATE_USER_USSD_SESSION_SQL.append(" UPDATE  user_ussd_sessions  SET  is_active_session = false  ");
               UPDATE_USER_USSD_SESSION_SQL.append("   WHERE    %d  >=  (start_session_id + 120) ");
                   
            try { 
                
                     ps = con.prepareStatement(String.format(UPDATE_USER_USSD_SESSION_SQL.toString(),  currentSessionId));

                    countOfRecordsInserted = ps.executeUpdate();
   
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                UPDATE_USER_USSD_SESSION_SQL = null; 
                try{
                    ps.close();
                    ps = null;
                }catch(Exception erx){
                    erx.printStackTrace();
                }
            }
        return  countOfRecordsInserted;
    }
    
    
   
  private   void    loadNewUSSDServiceConfigs(){
              
           StringBuilder   sbQuery = new StringBuilder(150);
           Statement    stmntx =    null;
           ResultSet rsx = null;    
           USSDService     ussdService   =  null;
           try {                  
               
               sbQuery.append("  SELECT  id, ussd_service_code, current_user_count, service_description,  "); 
               sbQuery.append("  action_url, require_authorization, highest_user_count, is_loaded_in_memory,   "); 
               sbQuery.append("  config_approved_level_1, config_approved_level_2,  last_access_date,   "); 
               sbQuery.append("  registration_date,  registration_time  FROM  ussd_services  "); 
               sbQuery.append("    WHERE    (is_loaded_in_memory = false) AND  (config_approved_level_1 = true)   ");
               sbQuery.append("     AND  (config_approved_level_2 = true)   ");
         
                stmntx =    con.createStatement();
                rsx = stmntx.executeQuery(sbQuery.toString());
                
                // Parameters start with 1
                while (rsx.next()) {   
                   
                 ussdService =   new USSDService(rsx.getLong("id"), rsx.getString("ussd_service_code"),  
                            rsx.getLong("current_user_count"), rsx.getString("service_description"),
                            rsx.getString("action_url"),  rsx.getBoolean("require_authorization"),
                            rsx.getLong("highest_user_count"), rsx.getBoolean("is_loaded_in_memory"),
                          rsx.getBoolean("config_approved_level_1"), 
                rsx.getBoolean("config_approved_level_2"), rsx.getString("last_access_date"),
                            rsx.getString("registration_date"),rsx.getString("registration_time"));
               
                 ussdService.initUSSDMenus(con,   ussdService.getUSSDServiceCode());
                
                  ussdServiceConfig.put(ussdService.getUSSDServiceCode(),  ussdService);
                } 
            } catch (Exception e) {
                e.printStackTrace();
            }  finally{ 
               sbQuery = null;
                 try{ 
                     stmntx.close();
                    stmntx = null;
                    rsx.close();
                    rsx = null; 
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }  
       } 
    
    
    
    
}
