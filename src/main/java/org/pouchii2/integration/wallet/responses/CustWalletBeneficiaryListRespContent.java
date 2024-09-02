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
@JsonPropertyOrder({"current_page",  "pages", "lastShowing", 
                       "total_record_count",   "currentLastRecord", "contents"})
public class CustWalletBeneficiaryListRespContent {
    
    @JsonProperty("current_page")
    private  long  id  =  -1;
    
    @JsonProperty("current_page")
    private  String  accountName;
    
    @JsonProperty("current_page")
    private  String  accountNumber;
    
    @JsonProperty("current_page")
    private  String  bankCode;
    
    @JsonProperty("current_page")
    private  String  bankName;
    
    @JsonProperty("current_page")
    private  String  accountType;
    
    
}
