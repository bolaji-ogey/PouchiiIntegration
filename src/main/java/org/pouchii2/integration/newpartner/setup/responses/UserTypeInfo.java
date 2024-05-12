/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.newpartner.setup.responses;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class UserTypeInfo {
    
    private  String  userType =  "Individual";
    private  String  description =  "Individual";
    
    
    public  String  getUserType(){
        return userType;
    }
     
    public  String  getDescription(){
        return description;
    }
    
    
    public  void  setUserType(String  inUserType){
          userType = inUserType;
    }
    
    public  void  setDescription(String  inDescription){
          description = inDescription;
    }
    
}
