/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */

@JsonPropertyOrder({"current_page", "pages", "lastShowing", "total_record_count", "contents"})
public class BankListRespData {
    
    @JsonProperty("current_page")
    private  String  current_page = "";
    
    @JsonProperty("pages")
    private  int  pages = 0;
    
    @JsonProperty("lastShowing")
    private  int  lastShowing = 0;
    
    @JsonProperty("total_record_count")
    private  int  total_record_count = 0;
   
    @JsonProperty("contents")
    ArrayList<Bank>    contents  =  new ArrayList<>();
     
     
     public  void  setCurrent_page(String  inCurrentPage){
         current_page  =  inCurrentPage;
     }
     
   
     public  void  setPages(int  inPages){
         pages  =  inPages;
     }
     
     public  void  setLastShowing(int  inLastShowing){
         lastShowing  =  inLastShowing;
     }
     
     public  void  setTotal_record_count(int  inTotal_record_count){
         total_record_count  =  inTotal_record_count;
     }
     
     
     
     public  void  setContents(ArrayList<Bank>  inContents){
         contents  =  inContents;
     }
    
     
     
     
     
     public  String  getCurrent_page(){
       return    current_page;
     }
     
      
     public  int  getPages(){
        return   pages;
     }
      
     
     public  int  getLastShowing(){
        return   lastShowing;
     }
     
     public  int  getTotal_record_count(){
        return   total_record_count;
     }
     
     
     
     public  ArrayList<Bank>  getContents(){
        return   contents;
     }
     
     
}
