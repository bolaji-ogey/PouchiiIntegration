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
import  java.util.HashMap; 


/**
 *
 * @author Bolaji
 */
public class Utils  extends   AccountType {
    
 // static boolean  logTrace  =  false;
 static boolean  logTrace  =  true;
 
  
  public  static void   doTrace(String   trace){
      if(logTrace == true){
          System.out.println(trace);
      }
  }
  
    
    
    
    
        
    
}
