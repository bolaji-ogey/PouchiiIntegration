/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.newpartner.setup.requests;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class STSLApplication {
    
    private  long  applicationId  = 1;
    private  String  applicationName  = "Pouchii System";
    
    public void setApplicationId(long  inApplicationId){
        applicationId = inApplicationId;
    }
    
    
    public void setApplicationName(String  inApplicationName){
        applicationName = inApplicationName;
    }
    
    
     public long getApplicationId(){
        return  applicationId;
    }
    
    
    public String getApplicationName(){
        return applicationName;
    }
    
}
