package mds.uevora.comerEvora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArtigoTest {

    private Categoria c;
    private Restaurante r;
    private Artigo a;
    List<Classificacao> classificacoes;

    @BeforeEach
    void setUp() {
        c = new Categoria("Carne");
        r = new Restaurante("Parque dos Leitões",
                "leitaodobelo", "Horta das Figueiras");
        a = new Artigo("Leitão", "Leitão grelhado na brasa com batata assada e arroz",
                23.99, c, r);
        classificacoes = new ArrayList<>();
    }

    @Test
    void aplicarDesconto() {
        a.aplicarDesconto(15);
        assertEquals(20.39, a.getPreco(), 0.01);
    }

    @Test
    void removerDesconto() {
        a.aplicarDesconto(15);
        a.removerDesconto();
        assertEquals(23.99, a.getPreco(), 0.01);
    }

    @Test
    void setNome() {
        a.setNome("Leitão grelhado");
        assertEquals("Leitão grelhado", a.getNome());
    }

    @Test
    void getNome() {
        assertEquals("Leitão", a.getNome());
    }

    @Test
    void setDescricao() {
        a.setDescricao("Leitão assado com batata frita");
        assertEquals("Leitão assado com batata frita", a.getDescricao());
    }

    @Test
    void getDescricao() {
        assertEquals("Leitão grelhado na brasa com batata assada e arroz", a.getDescricao());
    }

    @Test
    void setPreco() {
        a.setPreco(28.99);
        assertEquals(28.99, a.getPreco(), 0.01);
    }

    @Test
    void getPreco() {
        assertEquals(23.99, a.getPreco(), 0.01);
    }

    @Test
    void getCategoria() {
        Categoria aux = new Categoria("Ovo");
        a.setCategoria(aux);
        assertEquals(aux, a.getCategoria());
    }

    @Test
    void setCategoria() {
        Categoria aux = new Categoria("Leitão");
        a.setCategoria(aux);
        assertEquals(aux, a.getCategoria());
    }


    @Test
    void getRestaurante() {
        Restaurante aux = new Restaurante("Dom Joaquim", "quimbarreiros", "Évora");
        Artigo temp = new Artigo("Robalo", "pescado no Xarrama", 31.90, new Categoria("Peixe"), aux);
        assertEquals(aux, temp.getRestaurante());
    }

    @Test
    void addClassificacao() {
        Classificacao clas = new Classificacao(86.88, "muito bom");
        classificacoes.add(clas);
        assertEquals(classificacoes.get(0), clas);
    }

    @Test
    void getClassificacoes() {
        Classificacao clas1 = new Classificacao(78.88, "gostei mas poderiam ter enviado mais molho na francesinha");
        Classificacao clas2 = new Classificacao(90.21, "adorei");
        Classificacao clas3 = new Classificacao(63.65, "poderia ser muito melhor");
        Classificacao test[] = {clas1, clas2, clas3};
        classificacoes.add(clas1);
        classificacoes.add(clas2);
        classificacoes.add(clas3);
        assertArrayEquals(test, classificacoes.toArray());
    }

    @Test
    void getClassificacao() {
        Classificacao clas = new Classificacao(78.88, "gostei mas poderiam ter enviado mais molho na francesinha");
        classificacoes.add(clas);
        assertEquals(clas, classificacoes.get(0));
    }
}