package mds.uevora.comerEvora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EntregasTest {
    private Entregas e;
    private List<Artigo> artigos;
    private Encomenda encomenda;

    @BeforeEach
    void setUp() {
        e = new Entregas(new Estafeta("Abílio do Mar Silva", "maiordomeubairro453"),
                new Encomenda("Sopa de Cação", new Cliente("Rolando Escadabaixo", "jafoste123", "Rua Bernardo de Matos nº52", "rolandoescada12@gmail.com", "fome e sono")));
        artigos = new ArrayList<>();
        encomenda = new Encomenda("Picanha com arroz e feijão", new Cliente("Rolando Escadabaixo", "jafoste123", "Rua Bernardo de Matos nº52", "rolandoescada12@gmail.com", "fome e sono"));
    }

    @Test
    void addArtigo() {
        Artigo a = new Artigo("Pizza margheritta", "Pizza com queijo e fiambre",
                15.99, new Categoria("Pizza"),
                new Restaurante("Telepizza", "pizzas6745", "Condomínio São Domingos"));
        artigos.add(a);
        assertEquals(a, artigos.get(0));
    }

    @Test
    void removerArtigo() {
        Artigo a = new Artigo("Pizza margheritta", "Pizza com queijo e fiambre",
                15.99, new Categoria("Pizza"),
                new Restaurante("Telepizza", "pizzas6745", "Condomínio São Domingos"));
        artigos.add(a);
        if(artigos.contains(a))
            artigos.remove(a);
        assertEquals(0, artigos.size());
    }
}