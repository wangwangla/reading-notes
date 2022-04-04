package kw.test.demo;

import kw.test.chat.config.Config;
import kw.test.chat.protocol.Serializer;

public class App {
    public static void main(String[] args) {
        Serializer.Algorithm serializerAlgorithm = Config.getSerializerAlgorithm();
        System.out.println(serializerAlgorithm);
    }
}
