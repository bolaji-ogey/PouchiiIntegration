/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.responses;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
@JsonPropertyOrder({"responseCode", "responseMessage", "responseTime",   "current_page",  "pages",
                       "lastShowing", "total_record_count",   "currentLastRecord", "contents"})
public class MyTrxnHistoryRespData {
    
    private  int  current_page =  1;
    private  int  pages   =  1;
    private  int  lastShowing =  1;
    private  int  total_record_count =  1;
    
    private  long  currentLastRecord =  2584;
    private  java.util.ArrayList<TraxnHistoryItem>  contents  =  new java.util.ArrayList<>();
  
        
    public  int getCurrent_page(){
        return  current_page;
    }    
    
    public  int getPages(){
        return  pages;
    } 
     
    public  int getLastShowing(){
        return  lastShowing;
    } 
      
    public  int getTotal_record_count(){
        return  total_record_count;
    }
    
    
    public  long  getCurrentLastRecord(){
        return  currentLastRecord;
    }
    
    
    public  ArrayList<TraxnHistoryItem>  getContents(){
        return  contents;
    }
    
    
    
    
    
    
    public  void setCurrent_page(int inCurrent_page){
           current_page = inCurrent_page;
    }    
    
    public  void setPages(int inPages){
           pages = inPages;
    } 
     
    public  void setLastShowing(int inLastShowing){
           lastShowing = inLastShowing;
    } 
      
    public  void setTotal_record_count(int inTotal_record_count){
           total_record_count = inTotal_record_count;
    }
    
    
    public  void  setCurrentLastRecord(long  inCurrentLastRecord){
           currentLastRecord = inCurrentLastRecord;
    }
    
    
    public  void  setContents(ArrayList<TraxnHistoryItem>   inTraxnHistoryItems){
           contents = inTraxnHistoryItems;
    }
    
    
    
    
}
