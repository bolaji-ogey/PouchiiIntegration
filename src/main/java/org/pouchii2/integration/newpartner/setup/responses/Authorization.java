/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.newpartner.setup.responses;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class Authorization {
    
    private  String  token =  "";
    private  String  refreshToken =  "";
    private  long  createdAt =  1704805586;
    private  long  expiredAt =  1704830786;
 
    
    public  String  getToken(){
        return token;
    }
     
    public  String  getRefreshToken(){
        return refreshToken;
    }
    
     public  long  getCreatedAt(){
        return createdAt;
    }
     
    public  long  getExpiredAt(){
        return expiredAt;
    }
    
    
    
    
    public  void  setToken(String  inToken){
          token = inToken;
    }
    
    public  void  setRefreshToken(String  inRefreshToken){
          refreshToken = inRefreshToken;
    }
    
    
    public  void  setCreatedAt(long  inCreatedAt){
          createdAt = inCreatedAt;
    }
    
    public  void  setExpiredAt(long  inExpiredAt){
          expiredAt = inExpiredAt;
    }
    
}
