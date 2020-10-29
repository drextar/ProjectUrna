package Controller;

import Database.Database;
import Model.Administrador;
import Model.Candidato;
import Model.Eleitor;
import Model.Voto;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.jws.WebService;
import java.sql.*;


@WebService(endpointInterface = "Controller.Elegivel")
public class UrnaServer implements Elegivel{
    
    private Connection conexao;
    private PreparedStatement pst;
    private ResultSet rs;
    private Eleitor eleitor;
    private Administrador administrador;
    private Candidato candidato;
    private ArrayList<Candidato> candidatos;
    
//CLASSE QUE REPRESENTA O SERVIDOR
//ESSA CLASSE SE COMUNICA COM O BANCO E RETORNA VALORES DO MESMO
    
    @Override
    public boolean inserirVoto(Voto voto) throws SQLException, ClassNotFoundException {
        int apurado = voto.isApurado() ? 1 : 0;
        String sql = "INSERT INTO tbvoto (voto,apurado,ideleitor,numerocandidato) values (?,?,?,?)";
        Database.abreConexao();
        pst = Database.conexao.prepareStatement(sql);
        pst.setInt(1, voto.getVoto());
        pst.setInt(2, apurado);
        pst.setInt(3, voto.getEleitor().getIdEleitor());
        pst.setInt(4, voto.getCandidato().getIdCandidato());
        
        
        if (pst.executeUpdate() > 0){
            Database.fecharConexao();
            return true;
        } else {
            Database.fecharConexao();
            return false;
        }
        
    }

    @Override
    public int retornaQtdeVotos(int numeroCandidato) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Candidato> candidatos() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM tbcandidato";
        Database.abreConexao();
        pst = Database.conexao.prepareStatement(sql);
        rs = pst.executeQuery();
        candidatos = new ArrayList<>();
        
        while (rs.next()) {
            candidato = new Candidato();
            candidato.setIdCandidato(rs.getInt("idcandidato"));
            candidato.setNomeCandidato(rs.getString("nomecandidato"));
            candidatos.add(candidato);
        }
        rs.close();
        Database.fecharConexao();
        return candidatos;
    }

    @Override
    public Eleitor buscarEleitor(Eleitor eleitor) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM tbeleitor WHERE tituloeleitor = ? and cpfeleitor = ?";

        Database.abreConexao();
        pst = Database.conexao.prepareStatement(sql);
        pst.setString(1, eleitor.getTituloEleitor());
        pst.setString(2, eleitor.getCpf());
        rs = pst.executeQuery();
        this.eleitor = null;
        
        if (rs.next()) {
            int voto;
            
            this.eleitor = new Eleitor();
            this.eleitor.setIdEleitor(rs.getInt("id"));
            this.eleitor.setCpf(rs.getString("cpfeleitor"));
            Eleitor.setNome(rs.getString("nomeeleitor"));
            this.eleitor.setTituloEleitor(rs.getString("tituloeleitor"));
            voto = (rs.getInt("voto"));
            
            if(voto == 1)
                Eleitor.setVoto(true);
            else
                Eleitor.setVoto(false);
        }
        
        rs.close();
        Database.fecharConexao();
        
        return this.eleitor;
    }
    
    @Override
    public Administrador buscarAdministrador (Administrador adm) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM tbadministrador WHERE login = ? and senha = ?";
        
        Database.abreConexao();
        pst = Database.conexao.prepareStatement(sql);
        pst.setString(1, adm.getLogin());
        pst.setString(2, adm.getSenha());
        rs = pst.executeQuery();
        administrador = null;
        
        if(rs.next()){
            administrador = new Administrador();
            administrador.setNomeAdministrador(rs.getString("NOMEADMINISTRADOR"));
        }
        
        rs.close();
        Database.fecharConexao();  
        return administrador;
    }

    @Override
    public boolean atualizarVotoEleitor(int id) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE tbeleitor set voto=1 WHERE ID = ?";
        
        Database.abreConexao();
        pst = Database.conexao.prepareStatement(sql);
        pst.setInt(1, id);        
        
        if (pst.executeUpdate() > 0){
            Database.fecharConexao();
            return true;
        } else {
            Database.fecharConexao();
            return false;
        }
    }
    
    public boolean iniciaVotacao() throws SQLException, ClassNotFoundException{
        String sql = "UPDATE tbEleitor set voto = 0";
        Database.abreConexao();
        pst = Database.conexao.prepareStatement(sql);
        if(pst.executeUpdate() > 0){
            Database.fecharConexao();
            return true;
        } else {
            Database.fecharConexao();
            return false;
        }
    }
    
    public boolean encerraVotacao() throws SQLException, ClassNotFoundException{
        String sql = "UPDATE tbEleitor set voto = 1";
        Database.abreConexao();
        pst = Database.conexao.prepareStatement(sql);
        if(pst.executeUpdate() > 0){
            Database.fecharConexao();
            return true;
        } else {
            Database.fecharConexao();
            return false;
        }
    }
    
    public Integer contaVoto(int x) throws SQLException, ClassNotFoundException {
        Integer qtde = 0;
        String sql = "SELECT * FROM TBVOTO WHERE VOTO = ?";
        
        Database.abreConexao();
        pst = Database.conexao.prepareStatement(sql);
        pst.setInt(1, x);
        rs = pst.executeQuery();
        
        try {
            while(rs.next()){
                qtde++;
            }
        }
        catch(Exception ex) {
            System.out.println("------------------Tablerize.getRowCount-----------------");
            System.out.println("Cannot get resultSet row count: " + ex);
            System.out.println("--------------------------------------------------------");
        }
        
        
        
        Database.fecharConexao();
        return qtde;
        
    }
    
    public Candidato buscaCandidato(Candidato candidato) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM tbCandidato WHERE IDCANDIDATO = ?";

        Database.abreConexao();
        pst = Database.conexao.prepareStatement(sql);
        pst.setInt(1, candidato.getIdCandidato());
        rs = pst.executeQuery();
        this.candidato = null;
        
        if (rs.next()) {           
            this.candidato = new Candidato();
            this.candidato.setIdCandidato(rs.getInt("IDCANDIDATO"));
            this.candidato.setNomeCandidato(rs.getString("NOMECANDIDATO"));
        }
        
        rs.close();
        Database.fecharConexao();
        
        return this.candidato;
    }
    
    
    
}
