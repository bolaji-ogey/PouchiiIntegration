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
@JsonPropertyOrder({"data"})
public class LockFundsResponse  extends  PouchiiResponseBase  {
    
    @JsonProperty("data")
    private  LockFundRespData   data  =  new  LockFundRespData();
    
     public  LockFundRespData   getData(){
       return  data;
   }
   
   public  void  setData(LockFundRespData   inData){
       data = inData;
   }
    
    
}
