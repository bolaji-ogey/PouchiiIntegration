/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.core.utils;

import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class EncryKeyVault {
    
    public  static  final  ConcurrentHashMap<String, String>   keyRing = new  ConcurrentHashMap<>();
    public  static  final  ConcurrentHashMap<String, String>   oldKey = new  ConcurrentHashMap<>();
    
    public  static  final  ConcurrentHashMap<String, String>   loginTracker      = new  ConcurrentHashMap<>();
    public  static  final  ConcurrentHashMap<String, String>   bearerTokenRing  = new  ConcurrentHashMap<>();
    
}
