package mds.uevora.comerEvora;

import java.nio.file.attribute.UserPrincipal;

public class Utilizador {
    public String nome;
    private String password;
    private boolean isAdmin;


    public Utilizador(String nome, String password){
        this.nome = nome;
        this.password = password;
    }
    public Utilizador(String nome, String password, boolean isAdmin){
        this.nome = nome;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    protected void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    protected void setPassword(String password){
        this.password = password;
    }
    public boolean isAdmin(){
        return this.isAdmin;
    }
    protected  String getPassword(){
        return this.password;
    }

}
