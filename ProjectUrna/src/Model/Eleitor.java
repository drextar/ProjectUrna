package Model;

public class Eleitor {
    private int idEleitor;
    private static String nome;
    private String cpf; //A senha será o CPF do eleitor
    private String tituloEleitor; //O login será o número do titulo de eleitor
    private static boolean voto; //se for TRUE o eleitor já votou
    

    
    //CONSTRUCTORS
    public Eleitor() {
    }

    public Eleitor(int idEleitor, String nome, String cpf, String tituloEleitor, boolean voto) {
        this.idEleitor = idEleitor;
        Eleitor.nome = nome;
        this.cpf = cpf;
        this.tituloEleitor = tituloEleitor;
        Eleitor.voto = voto;
    }

    public Eleitor(String nome, String cpf, String tituloEleitor, boolean voto) {
        Eleitor.nome = nome;
        this.cpf = cpf;
        this.tituloEleitor = tituloEleitor;
        Eleitor.voto = voto;
    }
    
    
    
    //GETTERS/SETTERS

    public int getIdEleitor() {
       return idEleitor;
    }

    public void setIdEleitor(int idEleitor) {
        this.idEleitor = idEleitor;
    }

    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        Eleitor.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTituloEleitor() {
        return tituloEleitor;
    }

    public void setTituloEleitor(String tituloEleitor) {
        this.tituloEleitor = tituloEleitor;
    }

    public static boolean isVoto() {
        return voto;
    }

    public static void setVoto(boolean voto) {
        Eleitor.voto = voto;
    }        
}
