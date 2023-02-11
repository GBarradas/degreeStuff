package mds.uevora.comerEvora;

import java.util.ArrayList;
import java.util.List;

public class Restaurante extends Utilizador{
    public String morada;
    public List<Artigo> artigos;
    public List<Menu> menus;
    private List<Entregas> entregas;
    public List<Reclamacao> reclamacacoes;
    public List<Classificacao> classificacoes;

    public Restaurante(String nome, String password, String morada){
        super(nome,password);
        this.morada = morada;
        artigos = new ArrayList<Artigo>();
        menus = new ArrayList<Menu>();
        entregas = new ArrayList<Entregas>();
        reclamacacoes = new ArrayList<Reclamacao>();
        classificacoes = new ArrayList<Classificacao>();

    }

    protected void setMorada(String morada){
        this.morada = morada;
    }
    public String getMorada(){
        return this.morada;
    }

    public List<Artigo> getArtigos() {
        return artigos;
    }

    public List<Menu> getMenus() {
        return menus;
    }
    protected void addArtigo(Artigo a){
        this.artigos.add(a);
    }
    protected void addMenu(Menu m){
        this.menus.add(m);
    }
    public void addClassificacao(Classificacao c){
        this.classificacoes.add(c);

    }

    public List<Classificacao> getClassificacoes() {
        return classificacoes;
    }

    public double getClassificacao() {
        double clas = 0;
        for(Classificacao c : this.classificacoes){
            clas += c.getNota();
        }
        return (clas/(this.classificacoes.size()));
    }

    protected boolean removeArtigo(Artigo a){
        if(this.artigos.contains(a)){
            this.artigos.remove(a);
            return true;
        }
        else{
            return false;
        }
    }
    protected boolean removeMenu(Menu m){
        if(this.menus.contains(m)){
            this.menus.remove(m);
            return true;
        }
        else{
            return false;
        }
    }

    public List<Entregas> getEntregas() {
        return entregas;
    }

    public List<Reclamacao> getReclamacacoes() {
        return reclamacacoes;
    }
    public void addEntrega(Entregas e){
        this.entregas.add(e);
    }
    public void addReclamacao(Reclamacao r){
        this.reclamacacoes.add(r);
    }

}
