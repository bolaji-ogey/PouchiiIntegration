/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vertx.eventbus.example;

import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.MessageCodec;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
class BigSerializedObjectCodec implements MessageCodec<BigSerializedObject,
        BigSerializedObject> {
    @Override
    public void encodeToWire(Buffer buffer, BigSerializedObject o) {
        System.out.println("encodeToWire");
    }

    @Override
    public BigSerializedObject decodeFromWire(int pos, Buffer buffer) {
        System.out.println("decodeFromWire");
        return new BigSerializedObject();
    }

    @Override
    public BigSerializedObject transform(BigSerializedObject o) {
        System.out.println("transform");
        return o;
    }

    @Override
    public String name() {
        return "BrokenSerializedObjectCodec";
    }

    @Override
    public byte systemCodecID() {
        return -1;
    }
}
