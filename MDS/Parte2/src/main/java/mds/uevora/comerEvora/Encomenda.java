package mds.uevora.comerEvora;

import java.util.ArrayList;
import java.util.List;

public class Encomenda {
    public double preco = 0;
    public List<Artigo> artigos;
    public String estado;
    public String detalhes;
    public Cliente cliente;
    public List<Entregas> entregas;
    public List<Menu> menus;

    public Encomenda(String detalhes, Cliente cliente){
        this.detalhes = detalhes;
        this.cliente = cliente;
        this.artigos = new ArrayList<Artigo>();
        this.entregas = new ArrayList<Entregas>();
        this.menus = new ArrayList<Menu>();
        this.estado = "Criando";
    }

    public void adicionarArtigo(Artigo a){
        this.artigos.add(a);
    }
    public void adicionarMenu(Menu m){
        this.menus.add(m);
    }
    public double caclPreco(){
        double preco = 0;
        for(Artigo a : this.artigos)
            preco += a.getPreco();
        for(Menu m : this.menus)
            preco += m.getPreco();
        return preco;
    }
    protected void setEstado(String estado){
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
    protected void setDetalhes(String detalhes){
        this.detalhes = detalhes;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void removerArtigo(Artigo a){
        if(this.artigos.contains(a)){
            this.artigos.remove(a);
        }
    }
    public void removeMenu(Menu m){
        if(this.menus.contains(m)){
            this.menus.remove(m);
        }
    }
    public boolean encomendar(){
        if(this.menus.isEmpty() && this.artigos.isEmpty())
            return false;
        this.estado = "A Preparar";
        return true;
    }
}
