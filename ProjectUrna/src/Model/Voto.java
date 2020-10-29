package Model;

public class Voto {
    private int voto;
    private boolean apurado;
    private Eleitor eleitor;
    private Candidato candidato;

    public Voto() {
    }

    public Voto(int voto, boolean apurado, Eleitor eleitor, Candidato candidato) {
        this.voto = voto;
        this.apurado = apurado;
        this.eleitor = eleitor;
        this.candidato = candidato;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public boolean isApurado() {
        return apurado;
    }

    public void setApurado(boolean apurado) {
        this.apurado = apurado;
    }

    public Eleitor getEleitor() {
        return eleitor;
    }

    public void setEleitor(Eleitor eleitor) {
        this.eleitor = eleitor;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
    
    
    
}
