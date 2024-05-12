/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.my.common.lenders.api.responses;

import java.math.BigDecimal;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class Fees    {
    
    private  String  feeName = "";
    private  String  feeType = "";
    private  BigDecimal  feeOperator = new BigDecimal(0.00);
    private  BigDecimal  feeAmount = new BigDecimal(0.00);
    
    
    public  String  getFeeName(){
        return   feeName;
    }
    
    public  String  getFeeType(){
        return   feeType;
    }
    
    public  BigDecimal  getFeeOperator(){
        return   feeOperator;
    }
    
    public  BigDecimal  getFeeAmount(){
        return   feeAmount;
    }
    
    
    
    
     public  void  setFeeName(String   inFeeName){
        feeName = inFeeName;
    }
    
    public  void  setFeeType(String  inFeeType){
        feeType = inFeeType;
    }
    
    public  void  setFeeOperator(BigDecimal  inFeeOperator){
         feeOperator = inFeeOperator;
    }
    
    public  void  setFeeAmount(BigDecimal  inFeeAmount){
         feeAmount = inFeeAmount;
    }
    
    
    
    
    
}
