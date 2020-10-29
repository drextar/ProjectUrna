package Controller;

import Model.Administrador;
import Model.Candidato;
import Model.Eleitor;
import Model.Voto;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Client {
    
    public URL url;
    public QName qname;
    public Service ws;
    public Elegivel elegivel;
    private UrnaServer us = new UrnaServer();
    public static Eleitor eleitor;
    public static Candidato candidato;
    private Administrador administrador;
    

    public Client() {
        try { 
            url = new URL("http://127.0.0.1:9999/urna?wsdl");
        } catch (MalformedURLException ex) {
            System.out.println("Erro URL: " + ex.getMessage());
        }
        
        qname = new QName("http://Controller/","UrnaServerService");
        ws = Service.create(url,qname);
        elegivel = ws.getPort(Elegivel.class);
    }
    
    public boolean verificaELeitor(Eleitor eleitor) throws ClassNotFoundException, SQLException{
        Client.eleitor = us.buscarEleitor(eleitor);
        if (Client.eleitor == null) {
            return false;
        } else if (Eleitor.isVoto()){
                return false;
        } else {
            return true;
            }
        }
    
    public boolean verificaCandidato(Candidato candidato) throws ClassNotFoundException, SQLException{
        Client.candidato = us.buscaCandidato(candidato);
        if(Client.candidato == null){
            return false;
        }
        return true;
    }
    
    public boolean verificaAdministrador(Administrador adm) throws SQLException, ClassNotFoundException{
        administrador = us.buscarAdministrador(adm);
        if(administrador == null)
            return false;
        else
            return true;
    }
    
    public ArrayList<Candidato> retornarCandidatos() throws SQLException, ClassNotFoundException{
        return us.candidatos();
    }
    
    public boolean votoInserido(Voto voto) throws SQLException, ClassNotFoundException{
        if (us.inserirVoto(voto)) {
            return true;
        } else {
            return false;
        }    
    }
    
    public boolean atualizarVoto(int id) throws SQLException, ClassNotFoundException{
        if (us.atualizarVotoEleitor(id))
            return true;
        else
            return false;
    }
    
    
}

