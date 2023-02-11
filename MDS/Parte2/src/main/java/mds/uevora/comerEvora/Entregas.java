package mds.uevora.comerEvora;

import java.util.List;

public class Entregas{
    public Estafeta estafeta;
    public List<Artigo> artigos;
    public Encomenda encomenda;

    public Entregas(Estafeta estafeta, Encomenda encomenda){
        this.estafeta = estafeta;
        this.encomenda = encomenda;
    }

    protected void setEstafeta(Estafeta estafeta) {
        this.estafeta = estafeta;
    }

    public Estafeta getEstafeta() {
        return this.estafeta;
    }
    protected void addArtigo(Artigo a){
        this.artigos.add(a);
    }
    protected void addMenu(Menu m){
        for(Artigo a : m.getArtigos()){
            this.artigos.add(a);
        }
    }
    protected void removerArtigo(Artigo a){
        if(this.artigos.contains(a)){
            this.artigos.remove(a);
        }
    }

    protected void setEncomenda(Encomenda encomenda){
        this.encomenda = encomenda;
    }

    public Encomenda getEncomenda() {
        return this.encomenda;
    }
}
