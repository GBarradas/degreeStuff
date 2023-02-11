package mds.uevora.comerEvora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassificacaoTest {

    private Classificacao classificacao;

    @BeforeEach
    void setUp() {
        classificacao = new Classificacao(7,"descrição");
    }

    @Test
    void setNota() {
        classificacao.setNota(5);
        assertEquals(5,classificacao.getNota(),0);
    }

    @Test
    void setNotaOutOfRange(){
        classificacao.setNota(15);
        assertEquals(7,classificacao.getNota(),0);
    }


}