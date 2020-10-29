package Model;

public class Candidato {
    private int idCandidato; //funciona como o numero do candidato
    private String nomeCandidato;

    //CONSTRUCTORS
    public Candidato() {
    }

    public Candidato(int idCandidato, String nomeCandidato) {
        this.idCandidato = idCandidato;
        this.nomeCandidato = nomeCandidato;
    }
    
    //GETTERS

    public int getIdCandidato() {
        return idCandidato;
    }

    public String getNomeCandidato() {
        return nomeCandidato;
    }
    
    //SETTERS

    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }

    public void setNomeCandidato(String nomeCandidato) {
        this.nomeCandidato = nomeCandidato;
    }
    
    
 
}
