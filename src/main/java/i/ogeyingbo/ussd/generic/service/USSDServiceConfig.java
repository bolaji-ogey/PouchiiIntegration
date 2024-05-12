/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.ussd.generic.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.pouchii2.callback.url.CustomPool; 
/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class USSDServiceConfig extends  ConcurrentHashMap<String,USSDService> {   
    
 private  static    USSDServiceConfig   ussdDServiceConfigx =  null;
 private  static  final  String  postGreMiniWalletConnString  
         =   "jdbc:postgresql://localhost:5432/miniwalletdb?user=postgres&password=admin&autoReconnect=true";
      
 public static   TimeSeriesCounter   timeSeriesCounter  =  null;
 
    public  long  getSessionId(){
           return   this.timeSeriesCounter.getCurrentSessionId();
       }
    
    public  long  getTimeSeriesCount(){
        return  this.timeSeriesCounter.getTimeSeriesCount();
    }
    
  private  USSDServiceConfig(){
     initAllUssdServices();
  }
    
  
  public static USSDServiceConfig getInstance()
    {
        if (ussdDServiceConfigx == null)
        {
            synchronized (CustomPool.class)
            {
                ussdDServiceConfigx = new USSDServiceConfig();
            } 
        }
         timeSeriesCounter  =  new TimeSeriesCounter(getConnection(), ussdDServiceConfigx);
         timeSeriesCounter.run();
        return   ussdDServiceConfigx;
    }
  
  
  
  
  
   private   void    initAllUssdServices(){
              
           StringBuilder   sbQuery = new StringBuilder(150);
           Statement    stmntx =    null;
           ResultSet rsx = null;  
           Connection  cron  =  getConnection();  
           int loadRecordsResetted =  this.resetUSSDConfigLoad(cron);
           System.out.println(String.format("%d USSD Service Configuration has been reset for Load into memory .. ", loadRecordsResetted));
           USSDService     ussdService   =  null;
           try {                  
               // sbQuery.append("  SELECT  ussd_service_code, action_url  FROM  ussd_services  "); 
               sbQuery.append("  SELECT  id, ussd_service_code, current_user_count, service_description,  "); 
               sbQuery.append("  action_url, require_authorization, highest_user_count, is_loaded_in_memory,   "); 
               sbQuery.append("  config_approved_level_1, config_approved_level_2,  last_access_date,   "); 
               sbQuery.append("  registration_date,  registration_time  FROM  ussd_services  "); 
               sbQuery.append("    WHERE    (is_loaded_in_memory = false) AND  (config_approved_level_1 = true)   ");
               sbQuery.append("     AND  (config_approved_level_2 = true)   ");
         
                stmntx =    cron.createStatement();
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
               
                 ussdService.initUSSDMenus(cron,   ussdService.getUSSDServiceCode());
                
                  this.put(ussdService.getUSSDServiceCode(),  ussdService);
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
                    cron.close();
                    cron = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }  
       } 
   
   
   
   
     private  static  Connection    getConnection() {
        Connection con = null;  
        try {
               Properties properties = new Properties();
               properties.put("connectTimeout", 3600000);
               // postGreWalletConnString
                // postGreMiniWalletConnString
                 Class.forName("org.postgresql.Driver");
                 con = DriverManager.getConnection(postGreMiniWalletConnString, properties);
               //  con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/NeoWalletDB", "postgres", "admin");
 
            System.out.println("Connection with local database established.");
        } catch (Exception ex) { 
            ex.printStackTrace();
            //java.util.logging.Logger.getLogger(DbAccess.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return con;
    }
     
     
     
      
     private  final  int   resetUSSDConfigLoad(Connection    con) {
         
         PreparedStatement ps  =    null; 
         int   resettedRecords = 0;
         
         String   RESET_SERVICE_LOADER_SQL = " UPDATE  ussd_services  SET  is_loaded_in_memory = false ";
                   
            try {                 
                     ps = con.prepareStatement(RESET_SERVICE_LOADER_SQL);
                    resettedRecords =  ps.executeUpdate(); 
                    
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                RESET_SERVICE_LOADER_SQL = null; 
                try{
                    ps.close();
                    ps = null;
                }catch(Exception erx){
                    erx.printStackTrace();
                }
            } 
        return  resettedRecords;
    }
    
     
    
     
   
        
        
    
}
