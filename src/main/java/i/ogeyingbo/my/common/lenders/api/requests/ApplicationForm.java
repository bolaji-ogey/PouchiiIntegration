/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.my.common.lenders.api.requests;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class ApplicationForm {
    
    private  final String   formName  = "Personal Information";
    private   int   formIndex = 1;  
    FormData   formData  =  null; 
    
    public  String   getFormName(){
        return   formName;
    }
    
    public  int   getFormIndex(){
        return   formIndex;
    }    
    
    public  FormData   getFormData(){
        return   formData;
    }
    
    
    
}
