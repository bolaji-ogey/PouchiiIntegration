/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  i.ogeyingbo.core.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Bolaji
 */
public  class GenericDTO    {

 private  String      name  =  "";
 private  String      tableName  =  "";
 private  GenericDataUnit[]    genericDataUnits   =  null;

  private  String    updateIntent  =  "new";
  private  String     filterQuery  =  "";
  
  

   public  GenericDTO(String  newName,  String  newTableName,  String[]   newDbTableColumns){
        name  =  newName;   
        tableName =  newTableName;
        genericDataUnits   =  new  GenericDataUnit[newDbTableColumns.length];
          
   }



public   void    setGenericDataUnit(String  newFieldName,  int  newFieldIndex,  String   newInitValue){
    genericDataUnits[newFieldIndex]  =   new  GenericDataUnit(newFieldName,  newFieldIndex,  newInitValue);
}



public   GenericDataUnit    getGenericDataUnit(int  newFieldIndex){
   return   genericDataUnits[newFieldIndex];
}



public   GenericDataUnit    getGenericDataUnit(String  searchFieldName){
    for(int iter  = 0; iter < genericDataUnits.length;  iter++){
        if(genericDataUnits[iter].getFieldName().equalsIgnoreCase(searchFieldName))
           return   genericDataUnits[iter];
    }
  return null;
}


public  void  setUpdateIntent(String  newUpdateIntent){
    updateIntent  =   newUpdateIntent;
}



public  String  getUpdateIntent(){
    return  updateIntent;
}



public   void   setFilterQuery(String   newFilterQuery){
    filterQuery  =  newFilterQuery;
}



public  String  getTableName(){
    return   tableName;
}




public   GenericDataUnit[]    getGenericDataUnits(){
      return   genericDataUnits;
}


 public   boolean    update(Connection    cron){
      
     PreparedStatement    dtoUpdatePs =   null;
     boolean  isSuccessfullOperation    =  false;
      
      
            String  DTO_UPDATE_SQL   =     "  UPDATE    "+tableName+"   SET   ";  
                    for(int  iter = 0;  iter < genericDataUnits.length; iter++){
                       if(genericDataUnits[iter].isLocked() == false){
                            if(iter < (genericDataUnits.length - 1))
                               DTO_UPDATE_SQL   +=   genericDataUnits[iter].getFieldName() + "  =   "+genericDataUnits[iter].getNewValue()+",   ";
                             else 
                               DTO_UPDATE_SQL   +=   genericDataUnits[iter].getFieldName() + "  =   "+genericDataUnits[iter].getNewValue()+"  ";
                       }
                   }
                   DTO_UPDATE_SQL  +=  filterQuery;  
                     Utils.doTrace(DTO_UPDATE_SQL);  
         
		try {
                     
                        dtoUpdatePs = cron.prepareStatement(DTO_UPDATE_SQL);
                         
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
     



  public   boolean    update(Connection    cron,   String  FILTER_QUERY){
      
     PreparedStatement    dtoUpdatePs =   null;
     boolean  isSuccessfullOperation    =  false;
      
      
            String  DTO_UPDATE_SQL   =     "  UPDATE    "+tableName+"   SET   ";  
                   for(int  iter = 0;  iter < genericDataUnits.length; iter++){
                       if(genericDataUnits[iter].isLocked() == false){
                            if(iter < (genericDataUnits.length - 1))
                               DTO_UPDATE_SQL   +=   genericDataUnits[iter].getFieldName() + "  =   "+genericDataUnits[iter].getNewValue()+",   ";
                             else 
                               DTO_UPDATE_SQL   +=   genericDataUnits[iter].getFieldName() + "  =   "+genericDataUnits[iter].getNewValue()+"  ";
                       }
                   }
                   DTO_UPDATE_SQL  +=  FILTER_QUERY;  
                     Utils.doTrace(DTO_UPDATE_SQL);  
         
		try {
                     
                        dtoUpdatePs = cron.prepareStatement(DTO_UPDATE_SQL);
                         
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
     
  
  
  
  
  
  public   boolean    persist(Connection    cron){
      
     PreparedStatement    dtoUpdatePs =   null;
     boolean  isSuccessfullOperation    =  false;
      
      
            String  DTO_INSERT_SQL   =     "  INSERT   INTO    "+tableName+"   (";  
                   for(int  iter = 0;  iter < genericDataUnits.length; iter++){
                       if(iter < (genericDataUnits.length - 1))
                          DTO_INSERT_SQL   +=   genericDataUnits[iter].getFieldName() + ", ";
                        else 
                          DTO_INSERT_SQL   +=   genericDataUnits[iter].getFieldName() + ") ";
                   }
                   DTO_INSERT_SQL  +=  "  VALUES   (";  
                   for(int  iter = 0;  iter < genericDataUnits.length; iter++){
                       if(iter < (genericDataUnits.length - 1))
                          DTO_INSERT_SQL   +=   genericDataUnits[iter].getNewValue() + ", ";
                        else 
                          DTO_INSERT_SQL   +=   genericDataUnits[iter].getNewValue() + ") ";
                   }
                   Utils.doTrace(DTO_INSERT_SQL);  
         
		try {
                     
                        dtoUpdatePs = cron.prepareStatement(DTO_INSERT_SQL);
                         
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
