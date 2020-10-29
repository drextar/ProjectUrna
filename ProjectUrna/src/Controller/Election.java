package Controller;

import Model.Candidato;
import Model.Voto;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface Election{
    //INTERFACE DE ELEIÇÃO
    
    //insere o voto do eleitor
    @WebMethod boolean inserirVoto(Voto voto) throws SQLException,ClassNotFoundException; 
    
    //retorna a qtde de votos de um candidato
    @WebMethod int retornaQtdeVotos(int numeroCandidato) throws SQLException,ClassNotFoundException; 
    
    //retorna os candidatos da eleição atual
    @WebMethod ArrayList<Candidato> candidatos() throws SQLException,ClassNotFoundException; 
    
    //atualiza o status do voto do eleitor
    @WebMethod boolean atualizarVotoEleitor(int id) throws SQLException,ClassNotFoundException;
}
