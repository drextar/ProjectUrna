package Controller;

import javax.xml.ws.Endpoint;

public class UrnaPublisher {
    public static void main(String[] args){
        Endpoint.publish("http://127.0.0.1:9999/urna",new UrnaServer());
        System.out.println("Servidor publicado com sucesso...");
    }
}
