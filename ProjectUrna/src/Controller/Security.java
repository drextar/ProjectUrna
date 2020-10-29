package Controller;

import Model.Administrador;
import Model.Eleitor;
import java.sql.SQLException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface Security {
    //INTERFACE DE SEGURANÇA
    
    //verifica se o eleitor está cadastrado
    @WebMethod Eleitor buscarEleitor(Eleitor eleitor) throws SQLException, ClassNotFoundException;
    
    //verifica se o Administrador está cadastrado
    @WebMethod Administrador buscarAdministrador (Administrador adm) throws SQLException, ClassNotFoundException;
}
