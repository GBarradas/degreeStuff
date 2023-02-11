package mds.uevora.comerEvora;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    public String nome;
    public String descricao;
    public double precoAtual;
    private double precoNormal;
    public Restaurante restaurante;
    public List<Artigo> artigos;
    public List<Classificacao> classificacacoes;

    public Menu(String nome, String descricao, double precoNormal){
        this.nome = nome;
        this.descricao = descricao;
        this.precoNormal = precoNormal;
        this.precoAtual = precoNormal;
        classificacacoes = new ArrayList<Classificacao>();
        artigos = new ArrayList<Artigo>();
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
    public List<Artigo> getArtigos(){
        return this.artigos;
    }

    public void aplicarDesconto(double percentagem){
        if(percentagem<0 || percentagem>100){
            return;
        }
        else{
            this.precoAtual = (this.precoNormal * (100-percentagem))/100;
        }
    }
    public void removerDesconto(){
        this.precoAtual = this.precoNormal;
    }
    protected void  setNome(String nome){
        this.nome=nome;
    }

    public void addClassificacao(Classificacao c){
        this.classificacacoes.add(c);
    }

    public String getNome() {
        return nome;
    }

    protected void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    protected void setPreco(double preco){
        this.precoNormal = preco;
        this.precoAtual = preco;
    }
    public double getPreco(){
        return this.precoAtual;
    }

    public Restaurante getRestaurante() {
        return this.restaurante;
    }


    public List<Classificacao> getClassificacoes() {
        return classificacacoes;
    }
    public double getClassificacao(){
        double clas = 0;
        for(Classificacao c : this.classificacacoes){
            clas += c.getNota();
        }
        return (clas/(this.classificacacoes.size()));
    }

}
