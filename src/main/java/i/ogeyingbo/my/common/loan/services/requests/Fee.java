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
public class Fee {
    
    private String  feeName = "";
    private String  feeMode = "";
    private  BigDecimal  feeAmount =  new BigDecimal(0.00);
    private  BigDecimal  operationValue =  new BigDecimal(0.00);
    
    
    public  String  getFeeName(){
        return  feeName;
    }
    
    public  String  getFeeMode(){
        return  feeMode;
    }
    
    public  BigDecimal  getFeeAmount(){
        return  feeAmount;
    }
    
    
    public  BigDecimal  getOperationValue(){
        return  operationValue;
    }
    
    
}
