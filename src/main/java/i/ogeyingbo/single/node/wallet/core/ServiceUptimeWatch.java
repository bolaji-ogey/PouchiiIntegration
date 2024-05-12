/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.single.node.wallet.core;

import i.ogeyingbo.ussd.generic.service.TimeSeriesCounter; 
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
public class ServiceUptimeWatch extends  ConcurrentHashMap<String, NodeInSession> { 
    
     private  static    ServiceUptimeWatch   serviceUptimeWatch =  null;
    private  static  final  String  postGreMiniWalletConnString  
         =   "jdbc:postgresql://localhost:5432/miniwalletdb?user=postgres&password=admin&autoReconnect=true";
    
     public static   TimeSeriesCounter   timeSeriesCounter  =  null;
     
     private  static  Connection  con = null;
 
    public  long  getSessionId(){
           return   this.timeSeriesCounter.getCurrentSessionId();
       }
    
    public  long  getTimeSeriesCount(){
        return  this.timeSeriesCounter.getTimeSeriesCount();
    }
    
  private  ServiceUptimeWatch(){ 
  }
    
  
  public static ServiceUptimeWatch getInstance()
    {
        if (serviceUptimeWatch == null)
        {
            synchronized (CustomPool.class)
            {
                serviceUptimeWatch = new ServiceUptimeWatch();
            } 
        }
         timeSeriesCounter  =  new TimeSeriesCounter(getConnection(), serviceUptimeWatch);
         timeSeriesCounter.run();
        return   serviceUptimeWatch;
    }
  
  
  
  public final int   createNewUptimeRecord(int  inNodeIndex, String  inNodeName, long  inCurrentSessionId){
        PreparedStatement ps  =    null; 
         int  countOfRecordsInserted  =  0; 
         con  =  getConnection();  
         StringBuilder  INSERT_NODE_IN_SESSION_SQL =  new StringBuilder(200);
         INSERT_NODE_IN_SESSION_SQL.append(" INSERT  INTO  node_in_sessions (node_index, node_name, ");
         INSERT_NODE_IN_SESSION_SQL.append("    start_in_session_id,    ");
         INSERT_NODE_IN_SESSION_SQL.append("   start_in_session_date,  start_in_session_time)  ");
         INSERT_NODE_IN_SESSION_SQL.append("  VALUES (?,?, %d,  CURRENT_DATE(), CURRENT_TIME())  "); 
         
          StringBuilder  INSERT_NODE_OUT_SESSION_SQL =  new StringBuilder(200);
         INSERT_NODE_OUT_SESSION_SQL.append(" INSERT  INTO  node_out_sessions (node_index, node_name, ");
         INSERT_NODE_OUT_SESSION_SQL.append("    start_out_session_id,     ");
         INSERT_NODE_OUT_SESSION_SQL.append("  start_out_session_date,     start_out_session_time)  ");
         INSERT_NODE_OUT_SESSION_SQL.append("  VALUES (?,?, %d , CURRENT_DATE(), CURRENT_TIME())  "); 
                   
            try { 
                
                  ps = con.prepareStatement(String.format(INSERT_NODE_IN_SESSION_SQL.toString(),  inCurrentSessionId));
                   ps.setInt(1, inNodeIndex);
                   ps.setString(2, inNodeName); 
                  countOfRecordsInserted = ps.executeUpdate();
                  
                  ps = con.prepareStatement(String.format(INSERT_NODE_OUT_SESSION_SQL.toString(),  inCurrentSessionId));
                    ps.setInt(1, inNodeIndex);
                    ps.setString(2, inNodeName); 
                  countOfRecordsInserted = ps.executeUpdate();
   
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                INSERT_NODE_IN_SESSION_SQL = null;
                INSERT_NODE_OUT_SESSION_SQL = null;
                try{
                    ps.close();
                    ps = null;
                }catch(Exception erx){
                    erx.printStackTrace();
                }
            }
        return  countOfRecordsInserted;
  }
  
   
  
   public  final int   updateExistingUptimeRecord(long  inCurrentSessionId) {
         
         PreparedStatement ps  =    null; 
         int  countOfRecordsUpdated  =  0; 
         
         StringBuilder  UPDATE_NODE_IN_SESSION_SQL =  new StringBuilder(200);
         UPDATE_NODE_IN_SESSION_SQL.append(" UPDATE  node_in_sessions  SET  end_in_session_id = %d,  ");
         UPDATE_NODE_IN_SESSION_SQL.append(" end_in_session_date = CURRENT_DATE(), end_in_session_time  = CURRENT_TIME() ");
         UPDATE_NODE_IN_SESSION_SQL.append("  WHERE   id = (SELECT  MAX(id)  FROM  node_in_sessions)  ");
         
         StringBuilder  UPDATE_NODE_OUT_SESSION_SQL =  new StringBuilder(200);
         UPDATE_NODE_OUT_SESSION_SQL.append(" UPDATE  node_out_sessions  SET  start_out_session_id = %d,  ");
         UPDATE_NODE_OUT_SESSION_SQL.append(" start_out_session_date = CURRENT_DATE(), start_out_session_time  = CURRENT_TIME() ");
         UPDATE_NODE_OUT_SESSION_SQL.append("  WHERE   id = (SELECT  MAX(id)  FROM  node_out_sessions)  ");
                   
            try { 
                
                  ps = con.prepareStatement(String.format(UPDATE_NODE_IN_SESSION_SQL.toString(),  inCurrentSessionId));
                  countOfRecordsUpdated = ps.executeUpdate();
                  
                  ps = con.prepareStatement(String.format(UPDATE_NODE_OUT_SESSION_SQL.toString(),  inCurrentSessionId));
                  ps.executeUpdate();
   
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                UPDATE_NODE_IN_SESSION_SQL = null;
                UPDATE_NODE_OUT_SESSION_SQL = null;
                try{
                    ps.close();
                    ps = null;
                }catch(Exception erx){
                    erx.printStackTrace();
                }
            }
        return  countOfRecordsUpdated;
    }
   
   
   
   public  final   void    loadJustCreatedSession(){
              
           StringBuilder   sbQuery = new StringBuilder(150);
           Statement    stmntx =    null;
           ResultSet rsx = null;   
         //  System.out.println(String.format("%d Node In Session has been loeaded into memory .. ", loadRecordsResetted));
           NodeInSession     nodeInSession   =  null;
           try {                  
               
               sbQuery.append("  SELECT  id, node_index, node_name, start_in_session_id,  "); 
               sbQuery.append("  end_in_session_id, start_in_session_date, start_in_session_time,  "); 
               sbQuery.append("  end_in_session_date, end_in_session_time    "); 
               sbQuery.append("    FROM  node_in_sessions  "); 
               sbQuery.append("  WHERE  id = (SELECT  MAX(id)  FROM   node_in_sessions)  "); 
         
                stmntx =    con.createStatement();
                rsx = stmntx.executeQuery(sbQuery.toString());
                
                // Parameters start with 1
                while (rsx.next()) {   
                   
                 nodeInSession =   new NodeInSession(rsx.getLong("id"), rsx.getInt("node_index"),  
                            rsx.getString("node_name"), rsx.getLong("start_in_session_id"),
                            rsx.getLong("end_in_session_id"),  rsx.getString("start_in_session_date"),
                            rsx.getString("start_in_session_time"), rsx.getString("end_in_session_date"),
                          rsx.getString("end_in_session_time"));
                
                  this.put(nodeInSession.getNodeName(),  nodeInSession);
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
     
     
     
      
    
     
}
