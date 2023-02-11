package mds.uevora.comerEvora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    Cliente c;

    @BeforeEach
    void setUp() {
        c = new Cliente("Rolando Escadabaixo", "jafoste123", "Rua Bernardo de Matos nº52", "rolandoescada12@gmail.com", "fome e sono");
    }

    @Test
    void getAlergias() {
        assertEquals("fome e sono", c.getAlergias());
    }

    @Test
    void setAlergias() {
        c.setAlergias("sede");
        assertEquals("sede", c.getAlergias());
    }

    @Test
    void setContacto() {
        c.setContacto("rolandinho32@hotmail.com");
        assertEquals("rolandinho32@hotmail.com", c.getContacto());
    }

    @Test
    void getContacto() {
        assertEquals("rolandoescada12@gmail.com", c.getContacto());
    }

    @Test
    void getMorada() {
        assertEquals("Rua Bernardo de Matos nº52", c.getMorada());
    }

    @Test
    void setMorada() {
        c.setMorada("Praça do Giraldo");
        assertEquals("Praça do Giraldo", c.getMorada());
    }
}