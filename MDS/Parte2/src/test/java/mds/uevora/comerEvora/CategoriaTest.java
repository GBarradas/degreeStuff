package mds.uevora.comerEvora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoriaTest {
    private Categoria categoria;
    @BeforeEach
    void setUp() {
        categoria = new Categoria("Example");
    }

   @Test
    public void testCategoria(){
        assertEquals("Example", categoria.getCategoria());
        categoria.setCategoria("Ex1");
        assertEquals("Ex1",categoria.getCategoria());

   }
   @Test
    public void testAddandRemoveArtigo(){
        Artigo a = new Artigo("artigo","descrição",12.0,categoria,new Restaurante("rest","password","morada"));
        categoria.addArtigo(a);
        assertEquals(1,categoria.getArtigos().size());
   }
   @Test
    public void removeArtigo(){
       Artigo a = new Artigo("artigo","descrição",12.0,categoria,new Restaurante("rest","password","morada"));
       categoria.addArtigo(a);
       categoria.removeArtigo(a);
       assertEquals(0,categoria.getArtigos().size());
   }
}