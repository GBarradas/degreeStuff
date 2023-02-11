package mds.uevora.comerEvora;

import java.util.ArrayList;
import java.util.List;

public class Artigo {
    public String nome;
    public String descricao;
    public double precoAtual;
    private double precoNormal;
    public Categoria categoria;
    public Restaurante restaurante;
    public List<Classificacao> classificacoes;

    public Artigo(String nome, String descricao, double precoNormal, Categoria categoria, Restaurante restaurante){
        this.nome = nome;
        this.descricao = descricao;
        this.precoNormal = precoNormal;
        this.precoAtual = precoNormal;
        this.categoria = categoria;
        this.restaurante = restaurante;
        this.classificacoes = new ArrayList<Classificacao>();
    }
protected void aplicarDesconto(double percentagem){
        if(percentagem<0 || percentagem>100){
            return;
        }
        else{
            this.precoAtual = (this.precoNormal * (100-percentagem)) / 100;
        }
    }

    protected void removerDesconto(){
        this.precoAtual = this.precoNormal;
    }

    protected void setNome(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    protected void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    protected void setPreco(double precoNormal) {
        this.precoNormal = precoNormal;
        this.precoAtual = precoNormal;
    }

    public double getPreco() {
        return this.precoAtual;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    protected void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }
    public void addClassificacao(Classificacao clas) { this.classificacoes.add(clas); }

    public List<Classificacao> getClassificacoes() {
        return classificacoes;
    }
    public double getClassificacao(){
        double clas = 0;
        for(Classificacao c : this.classificacoes){
            clas += c.getNota();
        }
        if(this.classificacoes.size() == 0)
            return 0.0;
        return (clas/(this.classificacoes.size()))/100;
    }
}
