/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.single.node.swift.wallet.core;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class BaseRequest {
    
    protected  String  requestChannelId = "";
    protected  String  requestChannel = "Api";
    protected  String  requestChannelType = "Integrator";
    protected  String  requestApplicationCode = "PICH";
    protected  String  requestApplicationModule = "INTEGRATOR";
    protected  String  requestPartnerCode = ""; 
    
    
   
    public  String  getRequestChannelId(){
        return  requestChannelId;
    }
    
    public  String  getRequestChannel(){
        return  requestChannel;
    }
    
    public  String  getRequestChannelType(){
        return  requestChannelType;
    }
    
    
    public  String  getRequestApplicationCode(){
        return  requestApplicationCode;
    }
    
    
    public  String  getRequestApplicationModule(){
        return  requestApplicationModule;
    }
    
    public  String  getRequestPartnerCode(){
        return  requestPartnerCode;
    }
    
    
    
    
    public  void  setRequestChannelId(String  inRequestChannelId){
           requestChannelId = inRequestChannelId;
    }
    
    public  void  setRequestChannel(String  inRequestChannel){
           requestChannel = inRequestChannel;
    }
    
    public  void  setRequestChannelType(String  inRequestChannelType){
           requestChannelType = inRequestChannelType;
    }
    
    
    public  void  setRequestApplicationCode(String  inRequestApplicationCode){
           requestApplicationCode  =  inRequestApplicationCode;
    }
    
    
    public  void  setRequestApplicationModule(String  inRequestApplicationModule){
           requestApplicationModule = inRequestApplicationModule;
    }
    
    public  void  setRequestPartnerCode(String    inRequestPartnerCode){
           requestPartnerCode =  inRequestPartnerCode;
    }
    
    
    
    
}
