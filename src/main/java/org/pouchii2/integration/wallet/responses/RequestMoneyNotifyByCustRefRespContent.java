/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pouchii2.integration.wallet.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
@JsonPropertyOrder({"id",  "dateRequested", "dateApproved",  "requestedAmount",
                       "requestMessage",   "reason", "requestMoneyStatus", "requestOperator"})
public class RequestMoneyNotifyByCustRefRespContent {
    
    @JsonProperty("id")
    private  long  id  =  -1;
    
    @JsonProperty("dateRequested")
    private  String  dateRequested;
    
    @JsonProperty("dateApproved")
    private  String  dateApproved;
    
    @JsonProperty("requestedAmount")
    private  String  requestedAmount;
    
    @JsonProperty("requestMessage")
    private  String  requestMessage;
    
    @JsonProperty("reason")
    private  String  reason;
    
    @JsonProperty("requestMoneyStatus")
    private  String  requestMoneyStatus;
    
    @JsonProperty("requestOperator")
    private  String  requestOperator;
       
    
    
    public   void  setId(long  inId){
        id =  inId;
    }
    
    public  void  setDateRequested(String  inDateRequested){
        dateRequested  =  inDateRequested;
    }
    
    
    public  void  setDateApproved(String  inDateApproved){
        dateApproved  =  inDateApproved;
    }
    
    public  void  setRequestedAmount(String  inRequestedAmount){
        requestedAmount  =  inRequestedAmount;
    }
    
    
    public  void  setRequestMessage(String  inRequestMessage){
        requestMessage  =  inRequestMessage;
    }
    
    
    public  void  setReason(String  inReason){
        reason  =  inReason;
    }
 
    
    public  void  setRequestMoneyStatus(String  inRequestMoneyStatus){
        requestMoneyStatus  =  inRequestMoneyStatus;
    }
    
    
    public  void  setRequestOperator(String  inRequestOperator){
        requestOperator  =  inRequestOperator;
    }
     
    
    
    
    
    
    
    
    
    public   long  getId(){
       return   id;
    }
    
    public  String  getDateRequested(){
       return    dateRequested;
    }
    
    
    public  String  getDateApproved(){
       return    dateApproved;
    }
    
    public  String  getRequestedAmount(){
        return   requestedAmount;
    }
    
    
    public  String  getRequestMessage(){
       return    requestMessage;
    }
    
    
    public  String  getReason(){
        return   reason;
    }
 
    
    public  String  getRequestMoneyStatus(){
       return    requestMoneyStatus;
    }
    
    
    public  String  getRequestOperator(){
        return   requestOperator;
    }
    
    
    
    
}
