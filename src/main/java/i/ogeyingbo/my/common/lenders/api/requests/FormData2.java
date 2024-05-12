/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.my.common.lenders.api.requests;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class FormData2  implements  FormData {
    
    private String  mobileNumber = "-";
    private String  emailAddress = "-";
    private String  address = "-"; 
    
    public  String  getMobileNumber(){
        return  mobileNumber;
    }
     
    public  String  getEmailAddress(){
        return  emailAddress;
    }
    
    public  String  getAddress(){
        return  address;
    }
     
}
