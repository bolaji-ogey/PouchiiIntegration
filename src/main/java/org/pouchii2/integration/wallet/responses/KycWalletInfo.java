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
@JsonPropertyOrder({"hasPendingKycUpgradeApproval", "pendingKycUpgradeRequest",   
                                    "requiredKycUpgradeAction",    "kycUpgradeActionInfo"})
public class KycWalletInfo {
    
    @JsonProperty("hasPendingKycUpgradeApproval")
    private  boolean  hasPendingKycUpgradeApproval  = false;
    
    @JsonProperty("pendingKycUpgradeRequest")
    private  PendingKycUpgradeRequest   pendingKycUpgradeRequest;
    
    @JsonProperty("requiredKycUpgradeAction")
    private  boolean   requiredKycUpgradeAction  =  false;
    
    
    @JsonProperty("kycUpgradeActionInfo")
    private  KycUpgradeActionInfo   kycUpgradeActionInfo;
    
    
    public  void  setHasPendingKycUpgradeApproval(boolean  inHasPendingKycUpgradeApproval){
        hasPendingKycUpgradeApproval  =   inHasPendingKycUpgradeApproval;
    }
    
    
    public   void   setPendingKycUpgradeRequest(PendingKycUpgradeRequest   inPendingKycUpgradeRequest){
           pendingKycUpgradeRequest  =  inPendingKycUpgradeRequest;
    }
    
    
    public  void   setRequiredKycUpgradeAction(boolean  inRequiredKycUpgradeAction){
        requiredKycUpgradeAction  =   inRequiredKycUpgradeAction;
    }
    
    
    public   void   setKycUpgradeActionInfo(KycUpgradeActionInfo   inKycUpgradeActionInfo){
          kycUpgradeActionInfo  =    inKycUpgradeActionInfo;
    }
    
    
  
    
    public  boolean  getHasPendingKycUpgradeApproval(){
        return   hasPendingKycUpgradeApproval;
    }
    
    
    public   PendingKycUpgradeRequest   getPendingKycUpgradeRequest(){
           return   pendingKycUpgradeRequest;
    }
    
    
    public  boolean   getRequiredKycUpgradeAction(){
        return   requiredKycUpgradeAction;
    }
    
    
    public   KycUpgradeActionInfo   getKycUpgradeActionInfo(){
         return   kycUpgradeActionInfo;
    }
    
    
    
    
}
