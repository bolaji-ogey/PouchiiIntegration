/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.single.node.wallet.core;

import java.math.BigDecimal;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class PendingBankCredit {
    
     private long id = -1;
    private String  companyId =  "_";
    private String  partnerCode =  "_";
    private String  appCode =  "_";
    private String  processorNodeName =  "_";
    private String  processorNodeIp =  "_";
    private String  trxnRequestId =  "_";
    private String  trxnReference =  "_";
    private String  processorReference =  "_";
    private long  processorAuthKeyHash =  -1;
    private String  trxnTypeId =  "_";
    private long  logSessionId =  -1;
    
    private String  trxnEvent =  "_";
    private String  trxnType  =  "_";
    private String  trxnMode =  "_";
    private String  creditCurrencyName =  "_";
    private String  creditCurrencyCode  =  "_";
    private String  creditCurrencySymbol =  "_";
    
    private String  trxnStartTime =  "_";
    private String  trxnStartDate  =  "_";
    private String  trxnEndTime =  "_";
    private String  trxnEndDate =  "_";
    private long  currencyExchangeLogRefId  =  -1;
    private BigDecimal  currencyExchangeRate =  new BigDecimal(0.00);
	  
    private BigDecimal  creditAmount =  new BigDecimal(0.00);
    
    private String  recieverSchemeCode =  "_";
    private String  recieverProfileTypeCode  =  "_";
    private String  recieverCustomerRef =  "_";
    private String  recieverName =  "_";
    private String  recieverBankCode =  "_";
    private String  recieverAccount =  "_";
    private String  recieverBank =  "_";
	 
    private long  authUserId  =  -1;
    private long  authFactor1KeyHash  =  -1;
    private long  authFactor2KeyHash  =  -1;
    private String  serviceProvider  =  "_";
    private String  serviceBeneficiaryCustId  =  "_";
    private String  purchaseTokenEncrypt  =  "_";
    private long    purchaseTokenHash  =  -1;
    private String  productProviderCustName  =  "_";
    private String  productProviderCustAddresss  =  "_";
    
    private  boolean  isProcessed = false;
    private  boolean  isSelected = false;
    private  boolean  debitAccntInMemory = false;
    private  boolean  creditAccntInMemory = false;
    
    private String  trxnDetail  =  "_";
    private String  narration  =  "_";
    private String  trxnComment  =  "_"; 
    
    
    
    
}                                                                                                                                                                                                                                                                                        
