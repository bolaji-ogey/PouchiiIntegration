/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.ussd.generic.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class USSDService {
      
    private  long id  =  -1;
    private  String  ussdServiceCode = "";
    private  long  currentUserCount = 0;
    private  String  serviceDescription = "";
    private  String  actionUrl = "";
    private  boolean  requireAuth = false;
    private  long   highestUserCount = 0;
    private  boolean  isLoadedInMemory = false;
    private  boolean  configApprovedLevel1 = false;
    private  boolean  configApprovedLevel2 = false;
    private  String  lastAcccessDate = "";
    private  String  registrationDate = "";
    private  String  registrationTime = ""; 
    
    public final USSDMenus     ussdMenus  =  new  USSDMenus();
    
    
  public  USSDService(long  inId, String  inUssdServiceCode,  long inCurrentUserCnt, String  inServiceDescr,
                   String  inActionUrl,  boolean inRequireAuth,  long  inHighestUserCnt,  boolean  inIsLoadedInMemory,
                              boolean  inConfigApprovedLevel1,  boolean  inConfigApprovedLevel2,   String inLastAccessDate,        
                               String  inRegistrationDate,  String  inRegistrationTime){
    this.id  =  inId;
    this.ussdServiceCode = inUssdServiceCode.trim();
    this.currentUserCount = inCurrentUserCnt;
    this.serviceDescription =  inServiceDescr.trim();
    this.actionUrl = inActionUrl.trim();
    this.requireAuth = inRequireAuth;
    this.highestUserCount = inHighestUserCnt;
    this.isLoadedInMemory  = inIsLoadedInMemory;
    this.configApprovedLevel1  =  inConfigApprovedLevel1;
    this.configApprovedLevel2 = inConfigApprovedLevel2;
    this.lastAcccessDate = inLastAccessDate;
    this.registrationDate = inRegistrationDate;
    this.registrationTime = inRegistrationTime;
  }
    
  
 
  public  String   getUSSDServiceCode(){
      return  this.ussdServiceCode;
  }
  
  
  
  public  final   void   initUSSDMenus(Connection  cron,  String  inUssdServiceCode){
              
           StringBuilder   sbQuery = new StringBuilder(150);
           Statement    stmntx =    null;
           ResultSet rsx = null;  
           int menuLevel = 0;
           
           try {   
                
               sbQuery.append("  SELECT   ussd_service_code,   menu_level "); 
               sbQuery.append("    FROM   customer_ussd_menus  WHERE  ussd_service_code  = '%s' "); 
               sbQuery.append("   AND  menu_level  =  %d GROUP BY  menu_level "); 
         
                stmntx =    cron.createStatement();
                rsx = stmntx.executeQuery(String.format(sbQuery.toString(), inUssdServiceCode,  menuLevel));
                
                // Parameters start with 1
                while (rsx.next()) {                     
              
                   menuLevel =  rsx.getInt("menu_level");
                   
                   USSDMenu     ussdMenu =
                      new USSDMenu(rsx.getLong("id"),  rsx.getString("ussd_service_code"), 
                                     rsx.getString("menu_directory"),   rsx.getInt("menu_level"));
                   
                       ussdMenu.initUSSDMenuItems(cron, inUssdServiceCode, menuLevel);

                   ussdMenus.put(menuLevel, ussdMenu);
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
