package Model;

public class Administrador{
    private String nomeAdministrador;
    private String login; //login de ADM
    private String senha; //senha de ADM

    //CONSTRUCTORS    
    public Administrador(){
    }

    public Administrador(String nomeAdministrador, String login, String senha) {
        this.nomeAdministrador = nomeAdministrador;
        this.login = login;
        this.senha = senha;
    }
    
    
    
    
    //GETTERS/SETTERS
    public String getNomeAdministrador() {
        return nomeAdministrador;
    }

    public void setNomeAdministrador(String nomeAdministrador) {
        this.nomeAdministrador = nomeAdministrador;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
