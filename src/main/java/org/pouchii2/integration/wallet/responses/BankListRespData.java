/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.responses;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class BankListRespData {
    
    private  String  current_page = "";
    private  int  pages = 0;
    private  int  lastShowing = 0;
    private  int  total_record_count = 0;
   
    Bank[]    contents  =  new Bank[0];
     
     
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
     
     
     
     public  void  setContents(Bank[]  inContents){
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
     
     
     
     public  Bank[]  getContents(){
        return   contents;
     }
     
     
}
