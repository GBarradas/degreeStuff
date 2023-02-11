package mds.uevora.comerEvora;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    public String nome;
    public List<Artigo> artigos;

    public Categoria(String nome){
        this.nome = nome;
        this.artigos = new ArrayList<>();
    }
    protected void setCategoria(String categoria){
        this.nome = categoria;
    }
    public String getCategoria(){
        return this.nome;
    }
    public void addArtigo(Artigo a){
        this.artigos.add(a);
    }
    public boolean removeArtigo(Artigo a){
        if(this.artigos.contains(a)){
            this.artigos.remove(a);
            return true;
        }
        else{
            return false;
        }
    }

    public List<Artigo> getArtigos() {
        return artigos;
    }
}
