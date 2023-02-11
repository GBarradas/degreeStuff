package mds.uevora.comerEvora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReclamacaoTest {
    private Reclamacao reclamacao;
    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("cliente","password","morada","contactos","alergias");
        reclamacao = new Reclamacao(cliente,"descricao");
    }

    @Test
    void getUtilizador() {
        assertEquals(cliente,reclamacao.getUtilizador());
    }

    @Test
    void setDescricao() {
        reclamacao.setDescricao("descricao alterada");
        assertEquals("descricao alterada",reclamacao.getDescricao());
    }

    @Test
    void getDescricao() {
        assertEquals("descricao",reclamacao.getDescricao());
    }
}