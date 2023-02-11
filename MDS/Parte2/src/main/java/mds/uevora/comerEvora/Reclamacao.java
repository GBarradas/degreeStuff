package mds.uevora.comerEvora;

public class Reclamacao {
    public Utilizador utilizador;
    public String descricao;
    public Reclamacao(Utilizador user, String descricao){
        this.utilizador = user;
        this.descricao = descricao;
    }


    public Utilizador getUtilizador() {
        return this.utilizador;
    }

    protected void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
