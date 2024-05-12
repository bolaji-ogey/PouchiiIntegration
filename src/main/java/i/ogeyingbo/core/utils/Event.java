/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.core.utils;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class Event {
     
    private final String key;
    private final Object data;

        public Event(String key, Object data) {
            this.key = key;
            this.data = data;
        } 
        
    public String  getKey(){
        return this.key;
    }
    
    public Object  getData(){
        return this.data;
    }
    
}
