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
@JsonPropertyOrder({"currentKycLevel"}) 
public class KycUpgradeActionInfo {
    
    @JsonProperty("currentKycLevel")
    private  String  currentKycLevel;
    
    public  void  setCurrentKycLevel(String  inCurrentKycLevel){
        currentKycLevel  =  inCurrentKycLevel;
    }
    
    
    public  String  getCurrentKycLevel(){
       return   currentKycLevel;
    }
    
}
