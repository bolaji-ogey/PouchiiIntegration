/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  i.ogeyingbo.core.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Bolaji
 */
public class DBUtils {
    
    
    
  private    GenericDTO   getGenericDTOByFilter(String  dataObjectName, Connection    connection,  String   tableName,   String[]   selectFieldNames, String  FILTER_QUERY){
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
        
     
     
     
     
     
    private      ArrayList<GenericDTO>   getGenericDTOListByFilter(String  dataObjectName, Connection    connection,  String   tableName,  String[]   selectFieldNames,   String  FILTER_QUERY){
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
        
          
          
    
    
    
    public   boolean    batchUpdate(Connection    cron,  GenericDTO[]   genericDTO){
      boolean  isSuccessfullOperation  =  false;
         try{
              cron.setAutoCommit(false);
              
              for(int iter = 0; iter < genericDTO.length; iter++){
                   if(genericDTO[iter].getUpdateIntent().equalsIgnoreCase("new") ||  genericDTO[iter].getUpdateIntent().equalsIgnoreCase("persist")){
                       genericDTO[iter].persist(cron);
                   }else{
                       genericDTO[iter].update(cron);
                   }
              }
              isSuccessfullOperation  =  true;
         }catch(Exception  ex){
              try{
                  cron.rollback();
              }catch(Exception ed){
                  ed.printStackTrace();
               }
              isSuccessfullOperation  =  false;
             ex.printStackTrace();
         }finally{
             try{
                  cron.rollback();
              }catch(Exception ed){
                  ed.printStackTrace();
               }
         }
        return    isSuccessfullOperation;
   }
        
       
        
   
 public   boolean    batchPersist(Connection    cron,  java.util.ArrayList<GenericDTO>    genericDTOList){
      
     PreparedStatement    dtoUpdatePs =   null;
     boolean  isSuccessfullOperation    =  false;
     GenericDTO     genericDTO   =   genericDTOList.get(1);
      
             String  DTO_BATCH_INSERT_SQL   =     "  INSERT   INTO    "+genericDTO.getTableName()+"   (";  
                   for(int  iter = 0;  iter < genericDTO.getGenericDataUnits().length; iter++){
                       if(iter < (genericDTO.getGenericDataUnits().length - 1))
                          DTO_BATCH_INSERT_SQL   +=   genericDTO.getGenericDataUnits()[iter].getFieldName() + ", ";
                        else 
                          DTO_BATCH_INSERT_SQL   +=   genericDTO.getGenericDataUnits()[iter].getFieldName() + ") ";
                   }
                   DTO_BATCH_INSERT_SQL  +=  "  VALUES   ";  
                   
                   for(int   k = 0;  k < genericDTOList.size();  k++){
                       DTO_BATCH_INSERT_SQL  +=  " ("; 
                            for(int  iter = 0;  iter < genericDTO.getGenericDataUnits().length; iter++){
                                if(iter < (genericDTO.getGenericDataUnits().length - 1))
                                   DTO_BATCH_INSERT_SQL   +=   genericDTO.getGenericDataUnits()[iter].getNewValue() + ", ";
                                 else 
                                   DTO_BATCH_INSERT_SQL   +=   genericDTO.getGenericDataUnits()[iter].getNewValue() + " ";
                            }
                            
                         if(k < (genericDTOList.size() - 1))
                             DTO_BATCH_INSERT_SQL   +=  "),  ";
                         else
                            DTO_BATCH_INSERT_SQL   +=  ")  ";
                   }      
                   
                   Utils.doTrace(DTO_BATCH_INSERT_SQL);     
         
		try {
                     
                        dtoUpdatePs = cron.prepareStatement(DTO_BATCH_INSERT_SQL);
                         
                        isSuccessfullOperation  =   (dtoUpdatePs.executeUpdate() != -1);
                     
		} catch (Exception e) {
	
                    e.printStackTrace();
                    try{   cron.rollback();  }catch(Exception ex){  ex.printStackTrace();  }

		} finally {
                    try{      
                        if(dtoUpdatePs != null){ dtoUpdatePs.close(); }    
                         
                    }catch(Exception  e){  e.printStackTrace();  }
		}
        return    isSuccessfullOperation;
   }
     
   
          
    
}
