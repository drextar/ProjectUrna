package Controller;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class UrnaClient {
    public static void main(String[] args) throws MalformedURLException{
        URL url = new URL("http://127.0.0.1:9999/urna?wsdl");
        QName qname = new QName("http://Controller/","UrnaServerService");
        Service ws = Service.create(url,qname);
        Election e = ws.getPort(Elegivel.class);
        System.out.println("Cliente executado com sucesso");
    }
}
