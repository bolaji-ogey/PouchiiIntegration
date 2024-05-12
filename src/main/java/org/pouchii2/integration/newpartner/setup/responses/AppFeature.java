/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.newpartner.setup.responses;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class AppFeature {
    
    private  int  id = 1;
    private  String  name =  "";
    private  String  appFeature =  ""; 
    private  int  index = 1;
    private  boolean  status = true;
    
    public  int  getId(){
        return id;
    }
     
    public  String  getName(){
        return name;
    }
    
    public  String  getAppFeature(){
        return appFeature;
    }
    
    public  int  getIndex(){
        return id;
    }
    
    public  boolean  getStatus(){
        return status;
    }
    
    
    
    
    public  void  setId(int  inId){
          id = inId;
    }
     
    public  void  setName(String  inName){
          name = inName;
    }
    
    public  void  setAppFeature(String  inAppFeature){
          appFeature = inAppFeature;
    }
    
    public  void  setIndex(int  inIndex){
          index = inIndex;
    }
    
    public  void  setStatus(boolean  inStatus){
        status = inStatus;
    }
    
    
}
