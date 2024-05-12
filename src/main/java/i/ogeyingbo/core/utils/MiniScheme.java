/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.core.utils;

import java.math.BigDecimal;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class MiniScheme {
    
    private  String   schemeCode = "";
    private  int      promotionCount = 0;
    
        
    private  BigDecimal  minLowerLimit =  new BigDecimal(0.00);
    private  BigDecimal  minUpperLimit =  new BigDecimal(0.00);
    
    private  BigDecimal  medLowerLimit =  new BigDecimal(0.00);
    private  BigDecimal  medUpperLimit =  new BigDecimal(0.00);
    
    private  BigDecimal  maxLowerLimit =  new BigDecimal(0.00);
    private  BigDecimal  maxUpperLimit =  new BigDecimal(0.00);
    
    
    public  MiniScheme(String  inSchemeCode, int  inPromotionCount){
        schemeCode =  inSchemeCode;
        promotionCount  = inPromotionCount;
    }
    
    
    public  String  getSchemeCode(){
        return  schemeCode;
    }
    
    
    public  int   getPromotionCount(){
        return   promotionCount;
    }
    
     
    public  void  setMinLowerLimit(final BigDecimal  inMinLowerLimit){
        this.minLowerLimit =  inMinLowerLimit;
    }
    
    
    public  void  setMinUpperLimit(final BigDecimal  inMinUpperLimit){
        this.minUpperLimit =  inMinUpperLimit;
    }
    
    
    public  void  setMedLowerLimit(final BigDecimal  inMedLowerLimit){
        this.medLowerLimit =  inMedLowerLimit;
    }
    
    
    public  void  setMedUpperLimit(final BigDecimal  inMedUpperLimit){
        this.medUpperLimit =  inMedUpperLimit;
    }
    
    
    public  void  setMaxLowerLimit(final BigDecimal  inMaxLowerLimit){
        this.maxLowerLimit =  inMaxLowerLimit;
    }
    
    
    public  void  setMaxUpperLimit(final BigDecimal  inMaxUpperLimit){
        this.maxUpperLimit =  inMaxUpperLimit;
    }
    
    
    
    
    
    
           
    public  BigDecimal  getMinLowerLimit(){
        return   minLowerLimit;
    }
    
    
    public  BigDecimal  getMinUpperLimit(){
        return   minUpperLimit;
    }
    
    
    public  BigDecimal  getMedLowerLimit(){
        return   medLowerLimit;
    }
    
    
    public  BigDecimal  getMedUpperLimit(){
        return   medUpperLimit;
    }
    
    
    public  BigDecimal  getMaxLowerLimit(){
        return   maxLowerLimit;
    }
    
    
    public  BigDecimal  getMaxUpperLimit(){
        return   maxUpperLimit;
    }
    
}
