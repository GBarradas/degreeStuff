package mds.uevora.comerEvora;

public class Classificacao {
    public double nota;
    public String descricao;

    public Classificacao(double nota, String descricao){
        if(nota<0 || nota>10 ){
            return;
        }
        this.nota = nota;
        this.descricao = descricao;
    }

    protected void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getNota() {
        return this.nota;
    }
    protected void setNota(double nota){
        if(nota < 0 || nota > 10){
            return;
        }
        this.nota = nota;
    }

    public String getDescricao() {
        return this.descricao;
    }

}
