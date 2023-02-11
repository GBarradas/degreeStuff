package mds.uevora.comerEvora;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Utilizador {

    protected String morada;
    protected String contacto;
    private List<Encomenda> Encomendas;
    protected String alergias;
    private List<Classificacao> Classificacoes;

    public Cliente(String nome, String password,String morada, String contacto, String alergias) {
        super(nome, password);
        this.morada = morada;
        this.contacto = contacto;
        this.alergias = alergias;
        Encomendas = new ArrayList<Encomenda>();
        Classificacoes = new ArrayList<Classificacao>();
    }

    public String getAlergias(){
        return this.alergias;
    }
    protected void setAlergias(String alergias){
        this.alergias = alergias;
    }
    protected void setContacto(String contacto){
        this.contacto = contacto;
    }
    public String getContacto(){
        return this.contacto;
    }
    public String getMorada(){
        return this.morada;
    }
    protected void setMorada(String morada){
        this.morada = morada;
    }
    public void newEncomenda(Encomenda encomenda){
        Encomendas.add(encomenda);
    }

}
