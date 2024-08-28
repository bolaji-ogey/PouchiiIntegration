/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.my.common.lenders.api.responses;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
@JsonPropertyOrder({"token", "expiredAt", "type"})
public class ResponseData {
    
    private String  token = "";
    private long expiredAt  = -1;
    private  String type = "";
    
    
    public String  getToken(){
        return  this.token;
    }
    
    public  long  getExpiredAt(){
        return  this.expiredAt;
    }
    
    public String  getType(){
        return  this.type;
    }
    
    
    
    
    
    public  void  setToken(String  inToken){
          this.token = inToken;
    }
    
    public  void  setExpiredAt(long inExpiredAt){
         this.expiredAt = inExpiredAt;
    }
    
    public void  setType(String  inType){
          this.type = inType;
    }
    
    
    
    
}
