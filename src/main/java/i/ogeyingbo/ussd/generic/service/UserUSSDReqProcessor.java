/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.ussd.generic.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.hsqldb.lib.StringUtil;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class UserUSSDReqProcessor {
    
    private  long  id =  -1;
    private  String   userMobileNumber = null;
    private  String   reqText = null;
    
    private  String   ussdServiceCode = null;
    private  String   previousDirectory = null;
    private  String   currentDirectory = null;    
    private  int   previousLevel = -1;
    private  int   currentLevel = -1;
    
    private boolean  actionExpected  = false;
    private  String   actionName     = null;
    private  int   previousSelectOption = -1;
    private  int   currentSelectOption = -1;
    private  String   previousDataEntered     = null;
    private  String   currentDataEntered     = null;
    
    private  String   actionUrl     = null;
    private boolean  requireAuth  = false;
    private boolean  isFinal  = false;
    private boolean  isActiveSession  = false;
    private  String   sessionInitDate     = null;
    private  String   lastSessionDate     = null;
    private  String   lastSessionTime     = null;
    
 
    
     public  UserUSSDReqProcessor(String  inMobileNumber,  String  inText){
         this.userMobileNumber =  inMobileNumber.trim();
         this.reqText   =  inText.trim();        
     }
    
    
    
     public  String  doProcess(Connection  con, USSDServiceConfig   ussdServieConfig, 
                                  String  inMobileNumber, String  inReqText){
           String response  = "";
           userMobileNumber =  inMobileNumber.trim();
           if(!StringUtil.isEmpty(inReqText)){
                 reqText =  inReqText.trim();
           }else{   
               response  =  "Cannot process empty data input for this service.";
               System.out.println(response);
               return   response;             
           }
           System.out.println(String.format("%s: Input Text >>> %s", userMobileNumber, reqText));
            if(reqText.contains("*")  &&  reqText.contains("#")){
              //  begin to init session for client
                if(this.startNewUserUSSDSession(con) == true){
                    System.out.println();
                    USSDService  ussdService  =  ussdServieConfig.get(reqText);
                    if(ussdService != null){
                         USSDMenuItem    ussdMenuItem =  ussdService.ussdMenus.get(1).ussdMenuItems.get("1");
                         if(ussdMenuItem != null){
                                System.out.println(String.format("%s: Returned menu >>> %s", userMobileNumber, ussdMenuItem.getMenu()));
                                response  =  ussdMenuItem.getMenu();
                                System.out.println(String.format(" <<<< %s ",response));
                         }else{  
                             response  = String.format("Invalid menu: %s selected\n\nSelected menu is not in list of options.", reqText);
                             System.out.println(response);   
                         }
                    }else{   
                        System.out.println(String.format("No USSD Service configured for the code: %s on this platform", reqText));
                    }
                }else{
                    response = String.format("Error, Cannot initiating USSD session for: %s ",userMobileNumber);
                    System.out.println(response);
                }
            }else{
                 if(this.retrieveCurrentUserSession(con) == true){
                    System.out.println(); 
                    // continue
                    USSDService  ussdService  =  ussdServieConfig.get(ussdServiceCode);
                    if(ussdService != null){
                        if(reqText.length()== 1){
                            String newDir =  "";
                                USSDMenuItem    ussdMenuItem =  ussdService.ussdMenus.get(previousLevel).ussdMenuItems.get(reqText);
                                if(ussdMenuItem != null){
                                    System.out.println(String.format("%s: Returned menu >>> %s", userMobileNumber,ussdMenuItem.getMenu()));
                                    if(ussdMenuItem.getActionCommand().equals("Back") || ussdMenuItem.getActionCommand().equals("<<")
                                                 || ussdMenuItem.getActionCommand().equals("<<<")) {

                                    }else {
                                        response  =  ussdMenuItem.getMenu();
                                        System.out.println(String.format(" <<<<  %s ",response));                            
                                    }
                                }else{   
                                    response  = String.format("Invalid menu: %s selected\n\nSelected menu is not in list of options.", reqText);
                                    System.out.println(response);   
                               }
                        }else{   
                            /***
                             if(ussdMenuItem.getActionCommand().equals("call_url") || ussdMenuItem.isFinal()){

                                    if(ussdMenuItem.isRequireAuth()){
                                       // return  Please Enter PIN
                                       // Set is_final flag of user_ussd_session
                                     }
                                    
                                    // save data

                                     if(isFinal == true){
                                         String   url = ussdMenuItem.getActionUrl();
                                         if(!StringUtil.isEmpty(url)){
                                           // response  =     String.format("%s%s%s"), url,"?PIN=",reqText);
                                         } 
                                     }
                             }
                            ***/
                        }                          
                    }else{   
                        response = String.format("No USSD Service configured for the code: %s on this platform", reqText);                        
                        System.out.println(response);                      
                    }
                 }else{
                     //error
                     response = String.format("USSD Session not found for user: %s", userMobileNumber);
                     System.out.println(response); 
                 }
                 
            }
       return   response;
   }
      
      
      
      
      
   
 
   private   boolean    retrieveCurrentUserSession(Connection  cron){
              
           StringBuilder   sbQuery = new StringBuilder(150);
           Statement    stmntx =    null;
           ResultSet rsx = null; 
           int  recordCount   = 0;
           boolean  recordFound  = false;
           try {                  
               
               sbQuery.append("  SELECT  id, ussd_service_code, previous_directory, current_directory, previous_level, "); 
               sbQuery.append("     current_level, action_expected, action_name, previous_select_option, current_select_option, "); 
               sbQuery.append("  previous_data_entered,  current_data_entered, action_url, require_authorization, ");
               sbQuery.append("  is_final,  is_active_session, session_init_date, last_session_date, last_session_time ");
               sbQuery.append("   FROM  user_ussd_sessions  "); 
               sbQuery.append("  WHERE   mobile_number  =  '%s'  AND   is_active_session  =   true "); 
         
                stmntx =    cron.createStatement();
                rsx = stmntx.executeQuery(String.format(sbQuery.toString(), userMobileNumber));
                
                // Parameters start with 1
                while (rsx.next()) {   
                   
                    this.id = rsx.getLong("id");
                    this.ussdServiceCode  =  rsx.getString("ussd_service_code");

                    this.previousDirectory =  rsx.getString("previous_directory");
                    this.currentDirectory =  rsx.getString("current_directory");
                    this.previousLevel =  rsx.getInt("previous_level");
                    this.currentLevel =  rsx.getInt("current_level");

                    this.actionExpected = rsx.getBoolean("action_expected");                 
                    this.actionName =  rsx.getString("action_name");
                    this.previousSelectOption =  rsx.getInt("previous_select_option");
                    this.currentSelectOption =  rsx.getInt("current_select_option");

                    this.previousDataEntered =  rsx.getString("previous_data_entered");
                    this.currentDataEntered =  rsx.getString("current_data_entered");
                    this.actionUrl =  rsx.getString("action_url");
                    this.requireAuth = rsx.getBoolean("require_authorization"); 
                    this.isFinal = rsx.getBoolean("is_final"); 
                    this.isActiveSession = rsx.getBoolean("is_active_session");

                    this.sessionInitDate =  rsx.getString("session_init_date");
                    this.lastSessionDate =  rsx.getString("last_session_date");
                    this.lastSessionTime =  rsx.getString("last_session_time"); 
                    
                    recordCount  = recordCount + 1;                 
                } 
                
                if(recordCount == 1){
                    recordFound = true;
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
     return  recordFound;
  } 
   
   
   
   
   private   boolean   startNewUserUSSDSession(Connection    con) {
         
         PreparedStatement ps  =    null; 
         int  countOfRecordsInserted  =  0;
         boolean  isRecordInserted  = false;
         
         StringBuilder  UPDATE_USER_USSD_SESSION_SQL =  new StringBuilder(200);
               UPDATE_USER_USSD_SESSION_SQL.append(" UPDATE  user_ussd_sessions  SET  ussd_service_code = '%s',  ");
               UPDATE_USER_USSD_SESSION_SQL.append("    previous_directory = '', current_directory = '',  ");
              UPDATE_USER_USSD_SESSION_SQL.append("   previous_level =  -1, current_level = 0, action_expected = '', "); 
               UPDATE_USER_USSD_SESSION_SQL.append("   action_name =  '', previous_select_option = -1, current_select_option = -1, "); 
               UPDATE_USER_USSD_SESSION_SQL.append("  previous_data_entered = '',  current_data_entered = '%s', ");
                UPDATE_USER_USSD_SESSION_SQL.append("   action_url = '', require_authorization = false, is_final = false, ");
               UPDATE_USER_USSD_SESSION_SQL.append("  is_active_session = true, session_init_date = CURRENT_DATE(),   ");
               UPDATE_USER_USSD_SESSION_SQL.append(" session_init_time = CURRENT_TIME() WHERE  mobile_number =  '%s' ");
                   
            try { 
                
                     ps = con.prepareStatement(String.format(UPDATE_USER_USSD_SESSION_SQL.toString(),  reqText, 
                                               reqText, userMobileNumber));

                    countOfRecordsInserted = ps.executeUpdate();
 
                     if(countOfRecordsInserted == 0){
                          
                        StringBuilder  INSERT_USER_USSD_SESSION_SQL =  new StringBuilder(200);
                        INSERT_USER_USSD_SESSION_SQL.append("INSERT  INTO  user_ussd_sessions  (ussd_service_code,  mobile_number, ");
                        INSERT_USER_USSD_SESSION_SQL.append("  current_directory, current_level, current_data_entered)  ");
                        INSERT_USER_USSD_SESSION_SQL.append("   VALUES ('%s', '%s', '%s', 0, '%s') ");

                        ps = con.prepareStatement(String.format(INSERT_USER_USSD_SESSION_SQL.toString(),  
                                                                reqText, userMobileNumber, "0", reqText));

                        isRecordInserted  =  (ps.executeUpdate() > 0);
                     
                     }else{
                         isRecordInserted = true;
                     }
                  
            } catch (Exception e) {
                e.printStackTrace();
            }
        return  isRecordInserted;
    }
   
    
    
   /***
   public int    updateCurrentUserSession(Connection    con) {
           
         int recordsInserted = 0;
        
          StringBuilder  UPDATE_USER_SESSION_SQL =  new StringBuilder(200);
          
            UPDATE_USER_SESSION_SQL.append("  UPDATE    user_ussd_sessions   SET   previous_directory = current_directory, "); 
            UPDATE_USER_SESSION_SQL.append("    current_directory = current_directory + '%s', previous_level = current_level,   "); 
            UPDATE_USER_SESSION_SQL.append("     current_level = current_level + 1, action_expected, action_name,   "); 
            UPDATE_USER_SESSION_SQL.append("      previous_select_option = current_select_option, current_select_option = '%d', ");
            UPDATE_USER_SESSION_SQL.append("  previous_data_entered = current_data_entered,  current_data_entered = '%s',");
            UPDATE_USER_SESSION_SQL.append("   require_authorization,  is_final =    ");
            UPDATE_USER_SESSION_SQL.append("   last_session_date = CURRENT_DATE(), last_session_time  = CURRENT_TIME() "); 
            UPDATE_USER_SESSION_SQL.append("  WHERE   mobile_number  =  '%s'  AND   is_active_session  =   true "); 
               
            try {

                PreparedStatement ps  =    null;  
                 if(inCurrentColumnRef <= 7 ){
                    ps = con.prepareStatement(String.format(UPDATE_BAL_HIST_SQL.toString(),  inCurrentColumnRef, 
                                              inCurrentColumnRef, inCurrentColumnRef, transactionValueAmount,  
                                                      customerReference, customerReference));

                    recordsInserted = ps.executeUpdate();
                 }
                 
                 if(inCurrentColumnRef > 7 || recordsInserted == 0){
                     StringBuilder  INSERT_BAL_HIST_SQL =  new StringBuilder(200);
                     INSERT_BAL_HIST_SQL.append("INSERT  INTO  wallet_balance_compact_history  (current_column_ref,   ");
                     INSERT_BAL_HIST_SQL.append(" customer_reference,  balance_0_change_date, balance_0_change_time,  ");
                     INSERT_BAL_HIST_SQL.append("   balance_0) VALUES (1, '%s',CURRENT_DATE,  CURRENT_TIME,  %.2f) ");
                   
                     ps = con.prepareStatement(String.format(INSERT_BAL_HIST_SQL.toString(),  
                                                             customerReference, transactionValueAmount));
                 
                      recordsInserted = ps.executeUpdate();
                 }

            } catch (Exception e) {
                e.printStackTrace();
            }
          return  recordsInserted;
    }
   
   ***/
   
   
   
    
}
