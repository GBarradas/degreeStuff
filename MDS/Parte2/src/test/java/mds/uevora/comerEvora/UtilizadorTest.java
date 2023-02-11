package mds.uevora.comerEvora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilizadorTest {

    private Utilizador utilizador;

    @BeforeEach
    void setUp() {
        utilizador = new Utilizador("Joaquim","password1");
    }

    @Test
    public void testConstrutorSemAdmin(){
        assertEquals("Joaquim",utilizador.getNome());
        assertFalse(utilizador.isAdmin());
    }

    @Test
    public void testConstrutorComAdmin(){
        Utilizador admin = new Utilizador("Carlos","password", true);
        assertEquals("Carlos", admin.getNome());
        assertTrue(admin.isAdmin());
    }
    @Test
    public void TestSetNome(){
        utilizador.setNome("Alfedro");
        assertEquals("Alfedro",utilizador.getNome());
    }

    @Test
    public void testGetPassword(){
        assertEquals("password1",utilizador.getPassword());
    }

    @Test
    public void testSetPassword(){
        utilizador.setPassword("12345");
        assertEquals("12345",utilizador.getPassword());
    }

}