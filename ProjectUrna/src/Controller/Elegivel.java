package Controller;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface Elegivel extends Election,Security {
    //ESSA INTERFACE É USADA PARA AGRUPAR OS MÉTODOS
    //DAS INTERFACES ELECTION E SECURITY
    //PARA QUE OS SEUS MÉTODOS POSSAM SUBIR PARA O SERVIDOR
}
