/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vertx.eventbus.example;

import java.util.UUID;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
class BigSerializedObject{
    private String message;

    @Override
    public String toString() {
        return message;
    }

    public BigSerializedObject() {
       // StringBuilder sb = new StringBuilder(UUID.randomUUID().toString());
        StringBuilder sb = new StringBuilder(30);
        for (int i = 0; i < 20; i++) {
            System.out.println("i >>> "+i);
            sb.append(i);
        }
        this.message = sb.toString();
        System.out.println("this message --> "+message);
    }
}