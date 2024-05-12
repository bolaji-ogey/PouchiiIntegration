/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.java.client.example;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class Test {
   
    /**
    static {
        System.loadLibrary("nativeLib");
    }
    **/
    
    public  static  void  main(String[]  args){
        
        var string = "foo bar ";
        var yu = 6;
        
         

      var result = string.repeat(2);
      
        System.out.println(result);
         
        
        for(int v = 0; v < 4; v++){
            System.out.println(v);
            if(v > 2){ 
                break; 
            }else{ 
                System.out.println("Check our v = "+v);
                continue; 
                
            }
            
        }
        
         System.out.println("Ending");
    }
    
}
