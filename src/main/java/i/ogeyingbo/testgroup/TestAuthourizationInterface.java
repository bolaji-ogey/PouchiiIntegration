/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package i.ogeyingbo.testgroup;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class TestAuthourizationInterface {
    
    public  final  boolean    IS_LIVE  =   true;
    public  final  boolean    IS_DEMO  =   false;
    
    public   String  BEARER_TOKEN =  ""; // "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIrMjM0ODA4MzA2NDcxOCIsImF1dGgiOiJST0xFX1VTRVIiLCJleHAiOjE2Nzg0NTI1NzJ9.zV-eL6IgeN_EzaXf5cdUrwHa3S92yxARO_4hmazBvDJhlEAdxAgkpKkwyyXZVoDWDKdNKM0u7tbhX3bqFp9j-A";
      public  final String  BASE_URL =  "https://stagingapi.pouchii.net";  
     public  final String  ALTERNATIVE_BASE_URL =  "https://api.pouchii.net"; 
    public   String  PROFILE_PHONE_NUMBER =  "+2348095510360";
    public   String  SCHEME =  "53797374656d73706563732077616c6c6574";
    public   String  BENEFICIARY_ID =  "";
    public   String  PROFILE_WALLET_ID =  "1869593834";
    public   String  FROM_DATE =  "2021-01-01";
    public   String  TO_DATE = "2023-02-07";
  //  public   final  String  OJORO_BEARER_TOKEN =  
  //   "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIrMjM0ODA5NTUxMDM2MCIsImF1dGgiOiJST0xFX0FETUlOLFJPTEVfU1VQRVJfQURNSU4sUk9MRV9VU0VSIiwiZXhwIjoxNjc3MTM3MjYxfQ.koNqhFWFZvJwFcc-F3D02iWqlUmxrKsnrjSW6f_jotUro0m6_86ipGOdfuDi2XgOrwSNIO7y3umFUxHnWlmeoQ";
    
    
      protected  String   getBaseURL(boolean   IS_LIVE){
        if(IS_LIVE == true){
            return   BASE_URL;
        }else{
            return   ALTERNATIVE_BASE_URL;
        }
    }
}
