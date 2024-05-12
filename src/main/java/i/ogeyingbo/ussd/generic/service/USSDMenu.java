/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.ussd.generic.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class USSDMenu {
    
     private  long  id = -1;
     private  String  ussdServiceCode = ""; 
     private  String  menuDirectory = "";
     private  int     menuLevel   =  -1; 
     
    public final  USSDMenuItems   ussdMenuItems  =  new  USSDMenuItems();
     
     
     
     public  USSDMenu(long  inId,  String inUssdServiceCode,  String inMenuDirectory,
                        int  inMenuLevel){
         this.id =  inId;
         this.ussdServiceCode = inUssdServiceCode.trim(); 
         this.menuDirectory = inMenuDirectory.trim();
         this.menuLevel   =  inMenuLevel;
     }
     
     
     
     
    public  final void   initUSSDMenuItems(Connection  cron,  String  inUssdServiceCode,  int  inMenuLevel){
              
           StringBuilder   sbQuery = new StringBuilder(150);
           Statement    stmntx =    null;
           ResultSet rsx = null;  
           String  menuDirectory =  "";
           
           try {   
                 
                sbQuery.append("  SELECT  id, ussd_service_code, menu_title, menu_directory,  ");
               sbQuery.append(" menu_level, menu_select,  menu_options, menu,  action_command, action_url, "); 
               sbQuery.append("   require_authorization, is_final, created_date,  created_time ");  
               sbQuery.append("    FROM   customer_ussd_menus  WHERE  ussd_service_code  = '%s' "); 
               sbQuery.append("   AND  menu_level  =  %d   "); 
         
                stmntx =    cron.createStatement();
                rsx = stmntx.executeQuery(String.format(sbQuery.toString(), inUssdServiceCode,  inMenuLevel));
                
                 while (rsx.next()) {                     
              
                   menuDirectory =  rsx.getString("menu_directory");
                   USSDMenuItem     ussdMenuItem =
                      new USSDMenuItem(rsx.getLong("id"),  rsx.getString("ussd_service_code"), 
                         rsx.getString("menu_title"), rsx.getString("menu_directory"), 
                 rsx.getInt("menu_level"), rsx.getInt("menu_select"),  rsx.getString("menu_options"), 
             rsx.getString("menu"), rsx.getString("action_command"),  rsx.getString("action_url"),  
                        rsx.getBoolean("require_authorization"),    rsx.getBoolean("is_final"),
                     rsx.getString("created_date"),  rsx.getString("created_time"));

                    ussdMenuItems.put(menuDirectory,ussdMenuItem);
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
