/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package  i.ogeyingbo.ussd.generic.service;


 
 
   
import  java.util.HashMap;
import  java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import  java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import   java.util.Random; 

/**
 *
 * @author bogeyingbo
 * 
 * Thoroughput:   819 transactions per second
 */
public class CustomPool   extends  Thread {
    
   private    int   maxConnections  =  12;
   private    int   stackPointer  =  0;
   private    int   stackPointerLookAhead   =   5;
   private    int   inUseConnectStackPointer  =  0;
   private     boolean   initialized  =   false;
       
   private  static  CustomPool   customPoolx; 
   
   private  static  HashMap<Integer, Connection>  freeConnections   =   new   HashMap<Integer, Connection>();
   private  static  HashMap<Integer, Connection>  inUseConnections   =   new   HashMap<Integer, Connection>(); 
    
     private  static  HashMap<String, Integer>  identityKeys   =   new   HashMap<String, Integer>(); 
    
   
   private int[]   connectionStack    =   new  int[maxConnections];  
    private     boolean   errorConnect  =   false;
  
  
   final  String  postGreWalletConnString  =   "jdbc:postgresql://localhost:5432/NeoWalletDB?user=postgres&password=admin";
  
   final  String  mysqlCOnnString  =  "jdbc:postgresql://localhost:3306/fundmanagerplusdbB?user=postgres&password=admin&autoReconnect=true";         
   final  String  sqlServerConnString  =   "";
   
   final  String  postGreMiniWalletConnString  =   "jdbc:postgresql://localhost:5432/miniwalletdb?user=postgres&password=admin&autoReconnect=true";
           
           
   private  CustomPool(){
        String  status  =  "Attempting to INITIALIZE"; 
        if(initialized == false){
           status  =  init();
        }
        System.out.println(status);
   }
   
   
   
     
    public static CustomPool getInstance()
    {
        if (customPoolx == null)
        {
            synchronized (CustomPool.class)
            {
                customPoolx = new CustomPool();
            } 
        }
        return   customPoolx;
    }
   
   
     
  
   
   public static void delay(int seconds){
        try{
             Thread.sleep(seconds * 1000);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
        
   
   
   private     String    init(){
       
          
       System.out.println("Initializing connection pool....");
       
       for(int  u = 0; u < connectionStack.length;  u++){
        
           Connection   cron   =   getConnection();
        //   System.out.println("Init connection: "+cron);
           
             boolean isSafeForUse =   checkConnectionSafe(cron); 
             //  System.out.println("Init connection: "+cron);
             if(isSafeForUse == true){
                    freeConnections.put(u, cron); 
                    stackPointer   =  u; 
                   System.out.println("connection id: "+u+" initialized");
               }
       }
       initialized  =   true;
     return "Initialization of connection pool completed";  
       
   }
   
  
   
   
 
   
   
   
 
   
        
  private    Connection    getConnection(String targetDatabase) {
        Connection con = null;
         Properties properties = new Properties();
         properties.put("connectTimeout", 3600000); 
        try {
            
           switch(targetDatabase){ 
          
               case "mysql":      { 
                                      Class.forName("com.mysql.jdbc.Driver");
                                      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fundmanagerplusdb?autoReconnect=true", "root", "1newideas#");
                                  };
                                  break;
               
               case "postgresql":   {
                                     // postGreWalletConnString
                                     // postGreMiniWalletConnString
                                      Class.forName("org.postgresql.Driver");
                                      con = DriverManager.getConnection(postGreMiniWalletConnString, properties);
                                    //  con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/NeoWalletDB", "postgres", "admin");
                                       
                                  };
                                  break;
               
               default:            {
                                      Class.forName("com.mysql.jdbc.Driver");
                                      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fundmanagerplusdb?autoReconnect=true", "root", "1newideas#");
                                  };
                                  break;
           }
               

               errorConnect  =   false;
            System.out.println("Connection with local database established.");
        } catch (Exception ex) {
            errorConnect  =   true;
            ex.printStackTrace();
            //java.util.logging.Logger.getLogger(DbAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
//        }

        return con;
    }
   
  
  
  
  
     
  private    Connection    getConnection() {
        Connection con = null;  
        try {
               Properties properties = new Properties();
               properties.put("connectTimeout", 3600000);
               // postGreWalletConnString
                // postGreMiniWalletConnString
                 Class.forName("org.postgresql.Driver");
                 con = DriverManager.getConnection(postGreMiniWalletConnString, properties);
               //  con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/NeoWalletDB", "postgres", "admin");

               
               errorConnect  =   false;
            System.out.println("Connection with local database established.");
        } catch (Exception ex) {
            errorConnect  =   true;
            ex.printStackTrace();
            //java.util.logging.Logger.getLogger(DbAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
//        }

        return con;
    }
    
    
  
  
  
  
  
  
  
  
  
  
 private    Connection    refreshConnection() {
         Connection conn = null;
         Properties properties = new Properties();
         properties.put("connectTimeout", 3600000);
         
        boolean UNDONE = true;
        while (UNDONE) {
            try {
                  System.out.println("Say 123.....||| ");
                 System.out.println("Attempting to refresh connection. ");
                  
               // postGreWalletConnString
                // postGreMiniWalletConnString
                 Class.forName("org.postgresql.Driver");
                 conn = DriverManager.getConnection(postGreMiniWalletConnString, properties);
               //  con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/NeoWalletDB", "postgres", "admin");
                   System.out.println(conn); 

                   freeConnections.remove(stackPointer);
                 identityKeys.remove(stackPointer);
                 freeConnections.put(stackPointer, conn);
                 
                errorConnect  =   false;
                UNDONE = false;
                System.out.println("Connection with remote database refreshed.");
            } catch (Exception ex) {
               errorConnect = true;
               ex.printStackTrace();
                // java.util.logging.Logger.getLogger(DbAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    return   conn;
  }
  
  
  
    
    
  
 
 
 
 
 
 
 
 
 
    
 private   synchronized  void    refreshConnections(){
        
         stackPointer  =  0; 
         inUseConnectStackPointer  =  0;
     
       System.out.println("Refreshing connections in pool....");       
       for(int  u = 0; u < connectionStack.length;  u++){
          
           identityKeys   =   new   HashMap<String, Integer>();
           
           Connection   cron   =   (Connection)freeConnections.get(u); 
           cron   =  getConnection(); 
           if(cron != null){    
                    freeConnections.remove(u);  
                     freeConnections.put(u, cron);
                 }  
           Connection   crox   =   (Connection)inUseConnections.get(u);             
           if(crox != null){
                  inUseConnections.remove(u); 
                  freeConnections.put(u, cron);
               }
           System.out.println("connection id: cleaned up"); 
       }
       
       initialized  = true;
       
     System.out.println("Connection pool refreshment completed");  
       
   }
         
         
         
         
 
   
   
   
   
   
   
   
   
   public  void  closeAllConnections(){
       
       for(int  u = 0; u <  maxConnections;  u++){
           
           stackPointer  =  u;
        
           Connection  cont    =    (Connection)freeConnections.get(stackPointer);
            try{
                        if (cont != null) {
                                cont.close();
                                cont = null;
                            } 
                } catch (Exception ei) {
                System.out.println(ei.getMessage());
             }
         }
   }
   
   
   
   
   
   
   
    
   
   
   
  public   synchronized    Connection      getPoolConnection(String   IdentityKey){
       
      String   identityKey    =  IdentityKey;
       Connection  cron    =   null; 
       
      // if(initialized == false){   refreshConnections();   }
       
       cron    =  (Connection)freeConnections.get(stackPointer);
     //  System.out.println("Connection: "+cron);
        boolean isSafe  =  checkConnectionSafe(cron); 
        
       if(isSafe == true){
            identityKeys.put(identityKey,   stackPointer);
            freeConnections.remove(stackPointer);
            inUseConnections.put(stackPointer, cron); 
             stackPointer   =  stackPointer  - 1;
             if(stackPointer < 1){ 
                  stackPointer   =  maxConnections - 1; 
              }
        }else{
           cron =   refreshConnection();
           freeConnections.remove(stackPointer);
           inUseConnections.put(stackPointer, cron); 
            stackPointer   =  stackPointer  - 1;
            if(stackPointer < 1){ 
                 stackPointer   =  maxConnections - 1; 
             }
       } 
       return   cron;
   }
     
 /*  
  public   synchronized    Connection      getPoolConnection(String   IdentityKey){
       
      String   identityKey    =  IdentityKey;
       Connection  cron    =    (Connection)freeConnections.get(stackPointer);
       
       checkConnection(cron); 
       
       while(errorConnect  ==  true){
              cron    =    (Connection)freeConnections.get(stackPointer);
           }
        
         inUseConnections.put(identityKey, cron);
              identityKeys.put(identityKey, stackPointer);
               stackPointer   =  stackPointer  - 1;
               if(stackPointer < 1){ 
                    stackPointer   =  maxConnections - 1; 
                } 
          
       return   cron;
   }
  
**/  
   
  
   
   
   
  
  
  
  public     synchronized   void    closePoolConnection(String   IdKey){
      String     idKey  =   IdKey;
      int    connectKey   =   (Integer)identityKeys.get(idKey);
      Connection  cront    =    (Connection)inUseConnections.get(connectKey);      
      System.out.println("Connection Id "+connectKey+"  successfully retrieved ");
        freeConnections.put(connectKey, cront);        
  }
  
  
  
  /**
  public     synchronized   void    closePoolConnection(String   IdKey){
      String     idKey  =   IdKey;
      Connection  cront    =    (Connection)inUseConnections.get(idKey);
      int    connectKey   =   (Integer)identityKeys.get(idKey);
      System.out.println("Connection Id "+connectKey+"  successfully retrieved ");
        freeConnections.put(connectKey, cront);      
         // stackPointer   =  stackPointer  + 1;
        
  }
   **/
   
   
   
   
   
  
  

    
    
    
    
 
  
  
 public   static     String    getIdentityKey()
   {
          int     varNTrxnId  =  0;
           boolean   successfull  =  false;
           boolean   exitloop  =  false;

          // System.out.println("successfull "+successfull);

            Random        random     =  new   Random((new Random()).nextLong());

            while((successfull == false) && (exitloop == false))
            {

                    varNTrxnId  =   random.nextInt(1000000000);

                 //   System.out.println("varNTrxnId "+varNTrxnId);

                    varNTrxnId  =   varNTrxnId  + 100000000;

                     if((varNTrxnId > 100000000)  && (varNTrxnId < 1000000000))
                         {
                              exitloop =  true;
                              successfull   =  true;
                        }
                     else if((varNTrxnId <  100000000)  || (varNTrxnId >=  1000000000))
                         {

                              successfull   =  false;

                        }


         }

     return     String.valueOf(varNTrxnId);
}
 
   
   
   
   
  
 
   
   
 private  final    boolean    checkConnectionSafe(Connection  conn) { 
        PreparedStatement ps = null;
        ResultSet rs = null;  
        boolean  conectionIsSafe = false;
        
       try {
               if(conn == null || conn.isClosed()){
                  conn =   getConnection(); 
               } 
 
                 String GETMESSAGES = " SELECT  1 ";
                ps = conn.prepareStatement(GETMESSAGES);
                System.out.println(ps.toString());
                rs = ps.executeQuery();
                while (rs.next()) {
                    System.out.println("Record found"); 
                    conectionIsSafe  = true;
                }
                
                errorConnect  =  false; 
             //  return   conectionIsSafe; 
            } catch (Exception cE) {
                errorConnect  =   true; 
                cE.printStackTrace();
                System.out.println("Communication error to remote database encountered. "); 
                 conn  =   getConnection(); 
              //  System.out.println(cE.getMessage());
                
              //  delay(2);
                
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                        rs = null;
                    }
                    if (ps != null) {
                        ps.close();
                        ps = null;
                    }
                    
                } catch (Exception ex) {    
                    ex.printStackTrace();
                }
       }         
  return  conectionIsSafe;    
}
   
 
 
 
 
 
   
   
   
   
   
 private  final    Connection    checkConnectionNetw(Connection  conn) { 
        PreparedStatement ps = null;
        ResultSet rs = null; 
        boolean  upate_ok  =  false; 
        
         while (upate_ok  ==   false) {
            try {
 
                    String GETMESSAGES = " SELECT  1 ";
                    ps = conn.prepareStatement(GETMESSAGES);
                    System.out.println(ps.toString());
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        System.out.println("Record found"); 
                    }
                
                errorConnect  =  false;
                 upate_ok  =  true;
                
            } catch (Exception cE) {
                errorConnect  =   true;
                upate_ok  =  false;
                System.out.println("Communication error to remote database encountered. "); 
                   
              //   conn  =   refreshConnection(); 
                   conn  =   getConnection();
                System.out.println(cE.getMessage());
                
                delay(2);
                
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                        rs = null;
                    }
                    if (ps != null) {
                        ps.close();
                        ps = null;
                    } 
                    
                } catch (Exception ex) {   
                    ex.printStackTrace();
                }
            }
         }
     return  conn;    
    }
   
 
 
 
 
 
 
 
 public    final     List<Map<String, Object>>    queryForList(final  String  QueryString, final  ArrayList<Object>  parameterValues)
                                                          
  {
        boolean done = false; 
        PreparedStatement ps = null; 
        ResultSet   rs1   =  null; 
        String   resp  =  "fail";   
        List<Map<String, Object>>    resultList  =  new  ArrayList<Map<String, Object>>();
            
        Connection  cron   =  null;
        String     identKey    =    (String)CustomPool.getIdentityKey();
        
         boolean expectsParameter  = false;
        if(QueryString.contains("?"))    expectsParameter  = true;
     String   query  =   QueryString.replace(",    ", ",  ");
     query  =   QueryString.replace(",  ", ",");
     query  =   QueryString.replace(", ", ",");
     String[]   queryString  =  query.split(" ");
     System.out.println("queryString[1]: "+queryString[1]);
     String[]  queryTokens  = queryString[1].trim().split(",");
     
     int index = 0;
        try { 
             
                           cron   =  this.getPoolConnection(identKey); 
                          ps = cron.prepareStatement(QueryString);
                          
                           if(expectsParameter  == true) {
                              if((parameterValues != null)  && (parameterValues.size() >  0)){
                           
                                        for(int  p = 0; p < parameterValues.size(); p++){
                                            Object   paramObj   =  parameterValues.get(p);
                                            String  paramValue  = String.valueOf(paramObj);
                                             if(paramObj instanceof Integer){
                                                 ps.setInt(p + 1, Integer.parseInt(paramValue));
                                              }else if(paramObj instanceof String){
                                                 ps.setString(p + 1, paramValue);
                                              }else if(paramObj instanceof Double){
                                                 ps.setDouble(p + 1, Double.parseDouble(paramValue));
                                              }else if(paramObj instanceof java.sql.Date){
                                                // ps.setDate(p + 1, new java.sql.Date(paramValue));
                                              }else if(paramObj instanceof java.util.Date){
                                                 //ps.setDate(p + 1, new java.util.Date(paramValue));
                                              }
                                         }
                                        
                                  }else{
                                  System.out.println("No parameter set or set parameter does not match number of expected parameters.");
                              }
                          }else{
                              System.out.println("Required Parameters not set.");
                          }
                        
                        
                         rs1 = ps.executeQuery();
                          
                        while (rs1.next()) { 
                          
                           Map   rowValue =  new HashMap<String, Object>();
                           System.out.println("TOKEN LENGTH: "+queryTokens.length);
                              boolean  breakFlag  = false;
                            for(int  v = 0; v < queryTokens.length; v++){
                                String queryToken  =  queryTokens[v];
                                System.out.println("QUERY TOKEN: "+queryToken);
                                  
                                  System.out.println("QUERY TOKEN II: "+queryToken);
                            	 Object  columnValue  =  rs1.getObject(queryToken.replaceAll("\\W", "").trim());
                                 rowValue.put(queryToken.replaceAll("\\W", "").trim().toUpperCase(), columnValue);
                                       
                            }
                           
                            resultList.add(rowValue);
                         }                     
                   

          } catch (Exception e) {
              e.printStackTrace();

          } finally {
                  try{   
                      if(ps != null){  ps.close();  ps = null; }  
                       if(rs1 != null){  rs1.close();  rs1 = null; }
                       if(cron != null){  this.closePoolConnection(identKey);  }
                  }catch(Exception   e){   e.printStackTrace();  }
          } 
   return  resultList;
 }
 
 
 
 
 
 
 
 
 
 
 
 public    final     Map<String, Object>   queryForObject(final  String  QueryString, final  ArrayList<Object>  parameterValues)
                                                          
  {
        boolean done = false; 
        PreparedStatement ps = null; 
        ResultSet   rs1   =  null; 
        String   resp  =  "fail";   
        Map   rowValue =  new HashMap<String, Object>();
            
        Connection  cron   =  null;
        String     identKey    =    (String)CustomPool.getIdentityKey();
        
        boolean expectsParameter  = false;
        if(QueryString.contains("?"))    expectsParameter  = true;
     String   query  =   QueryString.replace(",    ", ",  ");
     query  =   QueryString.replace(",  ", ",");
     query  =   QueryString.replace(", ", ",");
     String[]   queryString  =  query.split(" ");
     System.out.println("queryString[1]: "+queryString[1]);
     String[]  queryTokens  = queryString[1].trim().split(",");
     
     int index = 0;
        try { 
             
                           cron   =  this.getPoolConnection(identKey); 
                          
                          ps = cron.prepareStatement(QueryString);
                           
                           if(expectsParameter  == true) {
                              if((parameterValues != null)  && (parameterValues.size() >  0)){
                                  
                              
                                            for(int  p = 0; p < parameterValues.size(); p++){
                                                Object   paramObj   =  parameterValues.get(p);
                                                String  paramValue  = String.valueOf(paramObj);
                                                 if(paramObj instanceof Integer){
                                                     ps.setInt(p + 1, Integer.parseInt(paramValue));
                                                  }else if(paramObj instanceof String){
                                                     ps.setString(p + 1, paramValue);
                                                  }else if(paramObj instanceof Double){
                                                     ps.setDouble(p + 1, Double.parseDouble(paramValue));
                                                  }else if(paramObj instanceof java.sql.Date){
                                                    // ps.setDate(p + 1, new java.sql.Date(paramValue));
                                                  }else if(paramObj instanceof java.util.Date){
                                                     //ps.setDate(p + 1, new java.util.Date(paramValue));
                                                  }
                                             }
                                            
                                }else{
                                  System.out.println("No parameter set or set parameter does not match number of expected parameters.");
                              }
                          }else{
                              System.out.println("Required Parameters not set.");
                          }
                        
                         rs1 = ps.executeQuery();
                          
                        while (rs1.next()) { 
                           
                           System.out.println("TOKEN LENGTH: "+queryTokens.length);
                              boolean  breakFlag  = false;
                            for(int  v = 0; v < queryTokens.length; v++){
                                String queryToken  =  queryTokens[v];
                                System.out.println("QUERY TOKEN: "+queryToken);
                                  
                                  System.out.println("QUERY TOKEN II: "+queryToken);
                            	 Object  columnValue  =  rs1.getObject(queryToken.replaceAll("\\W", "").trim());
                                 rowValue.put(queryToken.replaceAll("\\W", "").trim().toUpperCase(), columnValue);
                                       
                            }
                            
                         }                     
                   

          } catch (Exception e) {
              e.printStackTrace();

          } finally {
                  try{   
                      if(ps != null){  ps.close();  ps = null; }  
                       if(rs1 != null){  rs1.close();  rs1 = null; }
                       if(cron != null){  this.closePoolConnection(identKey);  }
                  }catch(Exception   e){   e.printStackTrace();  }
          } 
   return  rowValue;
 }
 
 
 
 
 
 
 
 
 public    final    int   updateRecords(final  String  QueryString, final  ArrayList<Object>  parameterValues)
                                                          
  {
        boolean done = false; 
        PreparedStatement ps = null; 
        ResultSet   rs1   =  null; 
        String   resp  =  "fail";    
        int   res =  0;
            
      Connection  cron   =  null;
      String     identKey    =    (String)CustomPool.getIdentityKey();
     String   query  =   QueryString.replace(",    ", ",  ");
     query  =   QueryString.replace(",  ", ",");
     query  =   QueryString.replace(", ", ",");
     String[]   queryString  =  query.split(" ");
     System.out.println("queryString[5]: "+queryString[5]);
     String  checkQueryPart =  ""; boolean   expectsParameter  = false;
     for(int v = 5; v < queryString.length;  v++){
         checkQueryPart  +=  queryString[v];
     }
     if(checkQueryPart.contains("?"))    expectsParameter  = true;
     String[]  queryTokens  = queryString[1].trim().split(",");
     
     int index = 0;
        try { 
             
                           cron   =  this.getPoolConnection(identKey); 
                          
                          ps = cron.prepareStatement(QueryString);
                           
                           if(expectsParameter  == true) {
                              if((parameterValues != null)  && (parameterValues.size() >  0)){
                                  
                               
                                        for(int  p = 0; p < parameterValues.size(); p++){
                                            Object   paramObj   =  parameterValues.get(p);
                                            String  paramValue  = String.valueOf(paramObj);
                                             if(paramObj instanceof Integer){
                                                 ps.setInt(p + 1, Integer.parseInt(paramValue));
                                              }else if(paramObj instanceof String){
                                                 ps.setString(p + 1, paramValue);
                                              }else if(paramObj instanceof Double){
                                                 ps.setDouble(p + 1, Double.parseDouble(paramValue));
                                              }else if(paramObj instanceof java.sql.Date){
                                                // ps.setDate(p + 1, new java.sql.Date(paramValue));
                                              }else if(paramObj instanceof java.util.Date){
                                                 //ps.setDate(p + 1, new java.util.Date(paramValue));
                                              }
                                         }
                                    }else{
                                  System.out.println("No parameter set or set parameter does not match number of expected parameters.");
                              }
                          }else{
                              System.out.println("Required Parameters not set.");
                          }
                        
                       res =   ps.executeUpdate();
                           
          } catch (Exception e) {
              e.printStackTrace();

          } finally {
                  try{   
                      if(ps != null){  ps.close();  ps = null; }  
                       if(rs1 != null){  rs1.close();  rs1 = null; }
                       if(cron != null){  this.closePoolConnection(identKey);  }
                  }catch(Exception   e){   e.printStackTrace();  }
          } 
   return   res;
 }
 
 
 
 
 
 public  class  ResultEntity {
    
   private    int  count  =  -1;
   private  double   sum   =  -1.00;
   
   public  int getCount(){
       return  this.count;
   }
   
   
   public  double   getSum(){
       return  this.sum;
   }
   
   
   public  void  setCount(int newCount){
       this.count = newCount;
   }
   
   
   public  void  setSum(double  newSum){
       this.sum  =  newSum;
   }
}
 
 
  
 
  public    final     Object  queryForSingleResult(final  String  QueryString,   final  ArrayList<Object>  parameterValues)
  {
        boolean done = false; 
        PreparedStatement ps = null; 
        ResultSet   rs1   =  null; 
        String   resp  =  "fail";   
        Map   rowValue =  new HashMap<String, Object>();
            
        Connection  cron   =  null;
        String     identKey    =    (String)CustomPool.getIdentityKey();
        
         boolean expectsParameter  = false;
        if(QueryString.contains("?"))    expectsParameter  = true;
     String   query  =   QueryString.replace(",    ", ",  ");
     query  =   QueryString.replace(",  ", ",");
     query  =   QueryString.replace(", ", ",");
     String[]   queryString  =  query.split(" ");
     System.out.println("queryString[1]: "+queryString[1]);
     String[]  queryTokens  = queryString[1].trim().split(",");
     ResultEntity   resultEntity    =  new  ResultEntity();
     
     int index = 0;
        try { 
             
                           cron   =  this.getPoolConnection(identKey); 
                          
                          ps = cron.prepareStatement(QueryString);
                       
                          if(expectsParameter  == true) {
                              if((parameterValues != null)  && (parameterValues.size() >  0)){
                                  
                                    for(int  p = 0; p < parameterValues.size(); p++){
                                        Object   paramObj   =  parameterValues.get(p);
                                        String  paramValue  = String.valueOf(paramObj);
                                         if(paramObj instanceof Integer){
                                             ps.setInt(p + 1, Integer.parseInt(paramValue));
                                          }else if(paramObj instanceof String){
                                             ps.setString(p + 1, paramValue);
                                          }else if(paramObj instanceof Double){
                                             ps.setDouble(p + 1, Double.parseDouble(paramValue));
                                          }else if(paramObj instanceof java.sql.Date){
                                            // ps.setDate(p + 1, new java.sql.Date(paramValue));
                                          }else if(paramObj instanceof java.util.Date){
                                             //ps.setDate(p + 1, new java.util.Date(paramValue));
                                          }
                                     }
                                    
                                    
                                      rs1 = ps.executeQuery();
                          
                                    while (rs1.next()) { 

                                       System.out.println("TOKEN LENGTH: "+queryTokens.length);
                                          boolean  breakFlag  = false;
                                        for(int  v = 0; v < queryTokens.length; v++){
                                            String queryToken  =  queryTokens[v];
                                            System.out.println("QUERY TOKEN: "+queryToken);

                                              System.out.println("QUERY TOKEN II: "+queryToken); 

                                                 resultEntity.setCount(rs1.getInt(1)); 
                                                 resultEntity.setSum(rs1.getDouble(2)); 

                                        }

                                     }   
                                    
                               }else{
                                  System.out.println("No reuired parameter set or set parameter does not match number of expected parameters.");
                              }
                          }else{
                              
                                 rs1 = ps.executeQuery();
                          
                                    while (rs1.next()) { 

                                       System.out.println("TOKEN LENGTH: "+queryTokens.length);
                                          boolean  breakFlag  = false;
                                        for(int  v = 0; v < queryTokens.length; v++){
                                            String queryToken  =  queryTokens[v];
                                            System.out.println("QUERY TOKEN: "+queryToken);

                                              System.out.println("QUERY TOKEN II: "+queryToken); 

                                                 resultEntity.setCount(rs1.getInt(1)); 
                                                 resultEntity.setSum(rs1.getDouble(2)); 

                                        }

                                     }     
                          }
                        
                                        
                   

          } catch (Exception e) {
              e.printStackTrace();

          } finally {
                  try{   
                      if(ps != null){  ps.close();  ps = null; }  
                       if(rs1 != null){  rs1.close();  rs1 = null; }
                       if(cron != null){  this.closePoolConnection(identKey);  }
                  }catch(Exception   e){   e.printStackTrace();  }
          } 
  
        return  resultEntity;
 }
  
  
   public  static  void  main1(String[]   args){
      // new AESUtil().doRun();
   }
  
  
 public  static  void  main(String[]   args){
     
       CustomPool    custPool  =   new   CustomPool();
       
       long   startTime  =    System.currentTimeMillis();
        List<Map<String, Object>>   resultList  =  Collections.emptyList();
        Map<String, Object>   resultObject  =  Collections.emptyMap();
       ArrayList<Object>   params  = new  ArrayList<Object>();
        params.add("wrrr");
     //   params.add(2);
      //  params.add(1);
       
       String   testQuery0    =  "select menu_item_1, menu_item_2 from  ussd_level_2_menu  where  menu_item_2  =  ?   ";
       String   testQuery    =  "select menu_item_1,    menu_item_2 from  ussd_level_2_menu  where  menu_item_2  =  ?  and  ussd_service_code  =  ? ";
       String testQueryAgg    =  "select           count(1),                   sum(ussd_service_code)          from      ussd_level_2_menu  where  menu_item_2  =  ?  ";
       
       String testUpdateQuery    =  "update  ussd_level_2_menu set  ussd_service_code  =  13   where  id   = ?    ";
       
      // for(int  v = 0;  v < 500000;   v++){ 
      for(int  v = 0;  v < 2;   v++){ 
           
           System.out.println("Test unit: "+v+" ---------------------------------------------------------------------beginning");
           
           
         //  resultList  =  custPool.queryForList(testQuery, params);
         //   System.out.println("RESULT LIST: "+resultList);
           
        // resultObject  =  custPool.queryForObject(testQuery, params);
        //    System.out.println("RESULT OBJECT: "+resultObject);
        
       //   Object  result   =  custPool.queryForSingleResult(testQueryAgg,  params);   
     //    System.out.println("ENTITY COUNT: "+((ResultEntity)result).getCount());  System.out.println("ENTITY SUM: "+((ResultEntity)result).getSum());
           
     //  System.out.println("No. of Records Updated is:   "+custPool.updateRecords(testUpdateQuery, params));
       
           String     identKey    =    (String)CustomPool.getIdentityKey();
            System.out.println("Identity key is "+identKey);
           
           Connection  cron   =  custPool.getPoolConnection(identKey);
           
               if(cron != null){
                   System.out.println("Connection: "+cron.toString()+"    acquired....");
                   custPool.closePoolConnection(identKey);
               }else{
                   
                   System.out.println("Error acquiring connection. Connection cannot be  acquired");
               }
               
               
          System.out.println(" ----------------------------------------------------------------------- done with test unit: "+v);
       }
       
       
        long   tmeTaken  =  (System.currentTimeMillis() - startTime);// / divisionTime;
	java.sql.Time    endTime  =   new java.sql.Time(tmeTaken);
        
      //  System.out.println("Time taken is: "+endTime);
        System.out.println("Time taken is in milliseconds: "+tmeTaken);
        System.out.println("Time taken is: "+new java.sql.Date(tmeTaken));

       
 }
    
   
   
 
 
 
 
 
 
 
 
   
    
}
