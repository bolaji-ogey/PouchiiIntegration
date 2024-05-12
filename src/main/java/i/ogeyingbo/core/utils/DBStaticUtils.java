/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  i.ogeyingbo.core.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Bolaji
 */
public class DBStaticUtils {
    
    
       
  private   static   GenericDTO   getGenericDTOByFilter(String  dataObjectName, Connection    connection,   String   tableName, String[]   selectFieldNames,  String  FILTER_QUERY){
	 int count=0;
	 Statement statement =   null;
	 ResultSet rs =  null;
         GenericDTO      genericDTO  =  null;
	 try {
	      
             String  SQL_QUERY  =  "SELECT   "+ selectFieldNames +"  FROM   "+tableName+"    "+FILTER_QUERY; 
                     
	      statement =   connection.createStatement();
	      rs =  statement.executeQuery(SQL_QUERY);  
	          
	          while (rs.next()) {
                       genericDTO  =  new  GenericDTO(dataObjectName, tableName, selectFieldNames);
                       
                        for(int  iter = 0;  iter <  selectFieldNames.length;  iter++){  
                           genericDTO.setGenericDataUnit(selectFieldNames[iter],  iter,  "");                       
                        }
                        
	         }
	 } catch (Exception e) {
	  e.printStackTrace();
	 }finally{
		 try{
			 if(statement != null){ statement.close();  statement =  null;  } 
			 if(rs != null){ rs.close(); rs =  null;  } 
		 }catch(Exception  ex){  ex.printStackTrace();  }
	  }
	 return genericDTO;
	}
        
     
     
     
     
     
    private   static   ArrayList<GenericDTO>   getGenericDTOListByFilter(String  dataObjectName, Connection    connection,   String   tableName, String[]   selectFieldNames,  String  FILTER_QUERY){
	 int count=0;
	 Statement statement =   null;
	 ResultSet rs =  null; 
         ArrayList    genericDTOList    =  new  ArrayList<GenericDTO>();
	 try {
	      
             String  SQL_QUERY  =  "SELECT   "+ selectFieldNames +"  FROM   "+tableName+"    "+FILTER_QUERY; 
                     
	      statement =   connection.createStatement();
	      rs =  statement.executeQuery(SQL_QUERY);  
	          
	          while (rs.next()) {
                      
                        GenericDTO    genericDTO  =  new  GenericDTO(dataObjectName, tableName, selectFieldNames);
                       
                        for(int  iter = 0;  iter <  selectFieldNames.length;  iter++){  
                           genericDTO.setGenericDataUnit(selectFieldNames[iter],  iter,  "");                       
                        }
                        
                        genericDTOList.add(genericDTO);                        
	         }
	 } catch (Exception e) {
	  e.printStackTrace();
	 }finally{
		 try{
			 if(statement != null){ statement.close();  statement =  null;  } 
			 if(rs != null){ rs.close(); rs =  null;  } 
		 }catch(Exception  ex){  ex.printStackTrace();  }
	  }
	 return  genericDTOList;
    }
        
          
}
