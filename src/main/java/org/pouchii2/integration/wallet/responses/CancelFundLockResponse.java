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
@JsonPropertyOrder({ "data"})
public class CancelFundLockResponse  extends  PouchiiResponseBase  {
   
    @JsonProperty("data")
    private  CancelFundLockRespData  data  =  new  CancelFundLockRespData();
    
     public  CancelFundLockRespData   getData(){
       return  data;
   }
   
   public  void  setData(CancelFundLockRespData   inData){
       data = inData;
   }
    
    
}
