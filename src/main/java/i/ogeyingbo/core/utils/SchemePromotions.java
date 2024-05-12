/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.core.utils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class SchemePromotions extends   ConcurrentHashMap<String, BigDecimal> {
    
    
    
    
    public SchemePromotions(Connection  con){
        getSchemePromotions(con);
    }
     
            
     private     void   getSchemePromotions(Connection  con){
             
           int index =  0; 
           StringBuilder   sbQuery = new StringBuilder(150);
           Statement    stmnt =    null;
           ResultSet rs = null;
            
           try {
            
                sbQuery.append("SELECT  sp.scheme_code,  sp.every_trxn_count, sp.reward_amount FROM  scheme_promotions  sp");
                sbQuery.append("LEFT OUTER JOIN   schemes  s  on  (sp.scheme_code =  s.scheme_code)"); 
                sbQuery.append(" WHERE   sp.is_active = true ");
               
                stmnt =    con.createStatement();
                rs = stmnt.executeQuery(sbQuery.toString());
                  
                // Parameters start with 1
                while (rs.next()) {
                        
                    this.put(String.format("%s%s%d", rs.getString("scheme_code"),"_", 
                             rs.getInt("every_trxn_count")), rs.getBigDecimal("reward_amount"));
                    index = index + 1;
                }
               System.out.println(String.format("%d %s", index, " Promotional items updated."));
            } catch (Exception e) {
                e.printStackTrace();
            }  finally{ 
                stmnt = null;   rs = null;
            } 
 }
     
     
     
    
}
