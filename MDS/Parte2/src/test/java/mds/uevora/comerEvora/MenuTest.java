package mds.uevora.comerEvora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    private Restaurante restaurante;
    private Artigo artigo1;
    private Artigo artigo2;
    private Menu menu;
    @BeforeEach
    void setUp() {
        restaurante = new Restaurante("restaurante","pass","morada");
        artigo1 = new Artigo("artigo1","descrição1",2,new Categoria("categoria"),restaurante);
        artigo2 = new Artigo("artigo2","descrição2",2,new Categoria("categoria"),restaurante);
        menu = new Menu("menu","descrição",10);
    }

    @Test
    public void testAddAndRemoveArtigo(){
        menu.addArtigo(artigo1);
        menu.addArtigo(artigo2);
        assertEquals(2,menu.getArtigos().size());
        assertTrue(menu.removeArtigo(artigo2));
        assertFalse(menu.removeArtigo(artigo2));
        assertEquals(1,menu.getArtigos().size());

    }
    @Test
    public void testAplicarAndRemoveDesconto(){
        menu.aplicarDesconto(150);
        assertEquals(10,menu.getPreco(),0);
        menu.aplicarDesconto(30);
        assertEquals(7,menu.getPreco(),0);
        menu.removerDesconto();
        assertEquals(10,menu.getPreco());
    }

    @Test
    public void testClassificacoes(){
        Classificacao clas = new Classificacao(2,"descrição");
        menu.addClassificacao(clas);
        assertEquals( 1, menu.getClassificacoes().size() );
        menu.addClassificacao(new Classificacao(8,"descr"));
        assertEquals(5,menu.getClassificacao(),0);
    }



}