/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.my.common.loan.services.requests;

import java.math.BigDecimal;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class RepaymentPlan {
    
    private  String   repaymentPlanReference  =  "";
    private  String   dueDate  =  "";
    private  BigDecimal   interestPayableAmount  =  new BigDecimal(0.00);
    
    private  BigDecimal   principalPaymentAmount  =   new BigDecimal(0.00);
    private  BigDecimal   loanBalanceAmount  =   new BigDecimal(0.00);
    private  BigDecimal   totalPayableAmount  =  new BigDecimal(0.00); 
    
      
    
    public  String   getrepaymentPlanReference(){
        return  repaymentPlanReference;
    }
    
    public  String   getDueDate(){
        return  dueDate;
    }
    
    public  BigDecimal   getInterestPayableAmount(){
        return  interestPayableAmount;
    }
    
    public  BigDecimal   getPrincipalPaymentAmount(){
        return  principalPaymentAmount;
    }
    
    public  BigDecimal   getLoanBalanceAmount(){
        return  loanBalanceAmount;
    }
    
    public  BigDecimal   getTotalPayableAmount(){
        return  totalPayableAmount;
    }
    
    
    
    
}
