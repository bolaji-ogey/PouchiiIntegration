/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.test;

import java.util.Random;
/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class VirtualThreadTest { 

 
  public static void main( String[] args ) {
      
    boolean vThreads = args.length > 0;
   // vThreads = true;
    System.out.println( "Using vThreads: " + vThreads);

    long start = System.currentTimeMillis();

    Random random = new Random();
    Runnable runnable = () -> { double g = random.nextDouble(1000) % random.nextDouble(1000); System.out.println("g = "+g);  };  
    for (int i = 0; i < 50000; i++){
      if (vThreads){ 
        Thread.startVirtualThread(runnable);
      } else {
        Thread t = new Thread(runnable);
        t.start();
      }
    }
   
    long finish = System.currentTimeMillis();
    long timeElapsed = finish - start;
    System.out.println("Run time: " + timeElapsed);
  }
  
  
}
