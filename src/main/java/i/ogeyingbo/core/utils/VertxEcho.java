/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.core.utils;

import io.vertx.core.Vertx;
import io.vertx.core.net.NetSocket;
/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class VertxEcho {
    
     
private static int numberOfConnections = 0;

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.createNetServer()
        .connectHandler(VertxEcho::handleNewClient)
        .listen(3000);
        vertx.setPeriodic(5000, id -> System.out.println(howMany()));
        vertx.createHttpServer()
        .requestHandler(request -> request.response().end(howMany()))
        .listen(8080);
    }
    
    
    private static void handleNewClient(NetSocket socket) {
        numberOfConnections++;
        socket.handler(buffer -> {
            socket.write(buffer);
            if (buffer.toString().endsWith("/quit\n")) {
               socket.close();
            }
        });
        socket.closeHandler(v -> numberOfConnections--);
    }
    
    
    private static String howMany() {
        return "We now have " + numberOfConnections + " connections";
    }


}
    
 
