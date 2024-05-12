/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.ussd.generic.service;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class USSDMenuItem {
    
    private  long  id = -1;
     private  String  ussdServiceCode = "";
     private  String  menuTitle = "";
     private  String  menuDirectory = "";
     private  int     menuLevel   =  -1;
     private  int     menuSelect  =  -1;
     private  String  menuOptions  = "";
     private  String  menu  = "";
     private  String  actionCommand  = "";
     private  String  actionUrl  = "";
     private  boolean  requireAuth = false;
     private  boolean  isFinal = false; 
     private  String  createdDate  = "";
     private  String  createdTime  = "";
      
     
     
     public  String  getMenu(){
         return   this.menu;
     }
     
     
     public  USSDMenuItem(long  inId,  String inUssdServiceCode, String  inMenuTitle, String inMenuDirectory,
                        int  inMenuLevel,  int  inMenuSelect,  String  inMenuOptions,  String inMenu,  String inActionCommand,
                            String  inActionUrl,  boolean  inRequireAuth,  boolean inIsFinal,  
                                    String  inCreatedDate,   String  inCreatedTime){
         this.id =  inId;
         this.ussdServiceCode = inUssdServiceCode.trim();
         this.menuTitle = inMenuTitle.trim();
         this.menuDirectory = inMenuDirectory.trim();
         this.menuLevel   =  inMenuLevel;
         this.menuSelect  =  inMenuSelect;
         this.menuOptions  = inMenuOptions.trim();
         this.menu  =  inMenu.trim();
         this.actionCommand = inActionCommand.trim();
         this.actionUrl  = inActionUrl.trim();
         this.requireAuth = inRequireAuth;
         this.isFinal = inIsFinal;
         this.createdDate  = inCreatedDate;
         this.createdTime  = inCreatedTime;         
     }
     
     
     public  long  getId(){
         return  id;
     }
     
     public  String  getUSSDServiceCode(){
         return  ussdServiceCode;
     }
     
     public  String  getMenuTitle(){
         return  menuTitle;
     }
     
      public  int  getMenuLevel(){
         return   menuLevel;
     }
     
     public  int  getMenuSelected(){
         return   menuSelect;
     }
     
     public  String  getActionCommand(){
         return  actionCommand;
     }
     
    public  String  getMenuDirectory(){
         return  menuDirectory;
     }
    
    public  String  getMenuOptions(){
         return  menuOptions;
     }
    
     
     public  String  getActionUrl(){
         return  actionUrl;
     }
     
     
      public  boolean isRequireAuth(){
         return  requireAuth;
     }
      
     public  boolean  isFinal(){
         return  isFinal;
     }
       
       
     public  String  getCreatedDate(){
         return  createdDate;
     }
     
     
      public  String  getCreatedTime(){
         return  createdTime;
     }
       
     
}
