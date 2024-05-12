/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.core.utils;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class EventLoop {
    
    private final ConcurrentLinkedDeque<Event> events = new ConcurrentLinkedDeque<>();

    private final ConcurrentHashMap<String, Consumer<Object>> handlers = new ConcurrentHashMap<>();
    
    public EventLoop on(String key, Consumer<Object> handler) {
            handlers.put(key, handler);
            return this;
    }
    
    public void dispatch(Event event) { events.add(event); }
    public void stop() { Thread.currentThread().interrupt(); }

    public void run() {   
        while (!(events.isEmpty() && Thread.interrupted())) {
                if (!events.isEmpty()) {
                   Event event = events.pop();
                if (handlers.containsKey(event.getKey())) {
                  handlers.get(event.getKey()).accept(event.getData());
                } else {
                   System.err.println("No handler for key " + event.getKey());
                }
        }
   }
}
 
    
    public static void main(String[] args) {
        EventLoop eventLoop = new EventLoop();
        new Thread(() -> {
            for (int n = 0; n < 6; n++) {
                delay(1000);
                eventLoop.dispatch(new  Event("tick", n));
            }
        eventLoop.dispatch(new  Event("stop", null));
        }).start();
        new Thread(() -> {
            delay(2500);
            eventLoop.dispatch(new Event("hello", "beautiful world"));
            delay(800);
            eventLoop.dispatch(new  Event("hello", "beautiful universe"));
            }).start();
            eventLoop.dispatch(new Event("hello", "world!"));
            eventLoop.dispatch(new Event("foo", "bar"));
            eventLoop 
            .on("hello", s -> System.out.println("hello " + s))
            .on("tick", n -> System.out.println("tick #" + n))
            .on("stop", v -> eventLoop.stop())
            .run();
            System.out.println("Bye!");
}
    
    
        private static void delay(long millis) {
            try {
               Thread.sleep(millis);
            } catch (InterruptedException e) {
            throw new RuntimeException(e);
            }
        }
    
}
