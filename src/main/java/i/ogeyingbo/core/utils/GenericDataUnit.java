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
public class GenericDataUnit {
    
    private  String   fieldName  = "";
    private  int      fieldIndex   =   0;
    private  String   initValue    =  "";
    private  String   newValue     =  "";
    
    private  String   viewName  = "";
    
   private  boolean   hasValueChanged   =   false;
   private  boolean   locked         =   false;
    
    
    
   public  GenericDataUnit(String  newFieldName,   int  newFieldIndex,  String   newInitValue){
         fieldName    =   newFieldName;
         fieldIndex   =   newFieldIndex;
         initValue    =   newInitValue;
         computeViewName();
   }
   
   
   
   
   
    public  GenericDataUnit(boolean  doLock, String  newFieldName,   int  newFieldIndex,  String   newInitValue){
         locked  =   doLock;
         fieldName    =   newFieldName;
         fieldIndex   =   newFieldIndex;
         initValue    =   newInitValue;
         computeViewName();
   }
   
   
   
   public   void  setNewValue(String   newNewValue){
        newValue     =    newNewValue;
   }
   
   
   
   
    public   String   getFieldName(){
       return   fieldName;
   }
    
   public   int   getFieldIndex(){
       return  fieldIndex;
   }
   
   public   String   getInitValue(){
       return  initValue;
   }
   
    public   String   getNewValue(){
       return  newValue;
   }
    
   
    
    
     public   String   getViewName(){
       return   viewName;
   }
     
     
     
     
    public   void  computeViewName(){
        
    }
    
    
    
    
    public   boolean   hasValueChanged(){
        if(!initValue.equalsIgnoreCase(newValue))
            return  true;
        else
            return  false;
    }
    
    
    
    
  public  boolean  isLocked(){
       return  locked;
   }      
      
         
          
         
}
