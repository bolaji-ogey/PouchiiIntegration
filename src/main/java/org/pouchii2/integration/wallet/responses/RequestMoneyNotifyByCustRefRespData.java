/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class RequestMoneyNotifyByCustRefRespData {
    
      
            
    @JsonProperty("current_page")
    private  int  current_page =  1;
    
    @JsonProperty("pages")
    private  int  pages   =  1;
    
    @JsonProperty("lastShowing")
    private  int  lastShowing =  1;
    
    @JsonProperty("total_record_count")
    private  int  total_record_count =  1;
    
    @JsonProperty("currentLastRecord")
    private  long  currentLastRecord =  2584;
    
    @JsonProperty("contents")
    private  java.util.ArrayList<RequestMoneyNotifyByCustRefRespContent>  contents  =  new java.util.ArrayList<>();
  
        
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
    
    
    public  ArrayList<RequestMoneyNotifyByCustRefRespContent>  getContents(){
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
    
    
    public  void  setContents(ArrayList<RequestMoneyNotifyByCustRefRespContent>   inTraxnHistoryItems){
           contents = inTraxnHistoryItems;
    }
    
    
    
}
