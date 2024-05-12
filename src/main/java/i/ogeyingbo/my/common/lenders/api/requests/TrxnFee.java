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
public class TrxnFee {
    
    private  String  feeName = "Payment Fee";
    private  String  feeType = "Flat";
    private  BigDecimal  feeOperator = new BigDecimal(100.00);
    private  BigDecimal  feeAmount = new BigDecimal(100.00);
   
    
    public  String  getFeeName(){
        return  feeName;
    }
    
    public  String  getFeeType(){
        return  feeType;
    }
    
    public  BigDecimal  getFeeOperator(){
        return  feeOperator;
    }
    
    public  BigDecimal  getFeeAmount(){
        return  feeAmount;
    }
    
    
}
