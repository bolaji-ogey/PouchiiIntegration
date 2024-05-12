/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.my.common.lenders.api.requests;

import java.math.BigDecimal;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class RePaymentInfo {
    
    private  String      repaymentCycle  = "monthly";
    private  BigDecimal  amountPerCycle  =  new BigDecimal(0.00);
    private  BigDecimal  totalRepaymentAmount  =  new BigDecimal(0.00);
    
    private  String      repaymentMode  = "Remita_Inflight";
    private  String      repaymentModeDesc  = "Remita Inflight - (RIF)";
    
    private  String      accountNumber  = "";
    private  String      accountName  = "";
    private  String      bankName  = "";
    private  String      bankCode  = "";
    
    
    public  String  getRepaymentCycle(){
        return  repaymentCycle;
    }
    
    public  BigDecimal  getAmountPerCycle(){
        return  amountPerCycle;
    }
    
    public  BigDecimal  getTotalRepaymentAmount(){
        return  totalRepaymentAmount;
    }
    
    public  String  getRepaymentMode(){
        return  repaymentMode;
    }
    
    public  String  getRepaymentModeDesc(){
        return  repaymentModeDesc;
    }
    
    public  String  getAccountNumber(){
        return  accountNumber;
    }
    
    public  String  getAccountName(){
        return  accountName;
    }
    
    public  String  getBankName(){
        return  bankName;
    }
    
    public  String  getBankCode(){
        return  bankCode;
    } 
    
    
    
    
}
