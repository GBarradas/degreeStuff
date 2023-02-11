package mds.uevora.comerEvora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestauranteTest {

    private Restaurante r;
    private Artigo artigo1;
    private Artigo artigo2;
    private Menu menu1;
    private Menu menu2;
    private Classificacao class1;
    private Classificacao class2;
    private Entregas entrega1;
    private Entregas entrega2;
    private Reclamacao reclamacao1;
    private Reclamacao reclamacao2;


    @BeforeEach
    void setUp() {
        r = new Restaurante("Restaurant", "pass","Morada Test");
        artigo1 = new Artigo("Artigo1","descricao1",10,new Categoria("categoria1"),r);
        artigo2 = new Artigo("Artigo2","descricao2",10,new Categoria("categoria2"),r);
        menu1 = new Menu("Menu1","descricao1",10);
        menu2 = new Menu("Menu2","descricao2",10);
        class1 = new Classificacao(8,"descrição1");
        class2 = new Classificacao(5.5,"descrição2");
        entrega1 = new Entregas(new Estafeta("Estafeta1","passE1"),new Encomenda("detalhes",new Cliente("Cliente1","passC1","morada 1","contacto","alergias")));
        entrega2 = new Entregas(new Estafeta("Estafeta2","passE2"),new Encomenda("detalhes",new Cliente("Cliente1","passC1","morada 1","contacto","alergias")));
    }

    @Test
    public void testSetMorada(){
        r.setMorada("Set Morada Test");
        assertEquals("Set Morada Test",r.getMorada());
    }
    @Test
    public void testAddArtigo(){
        r.addArtigo(artigo1);
        assertEquals(1,r.getArtigos().size());
    }

    @Test
    public void testRemoveArtigo(){
        r.addArtigo(artigo1);
        assertFalse(r.removeArtigo(artigo2));
        assertTrue(r.removeArtigo(artigo1));
        assertEquals(0,r.getArtigos().size());
    }

    @Test
    public void testAddMenu(){
        r.addMenu(menu1);
        assertEquals(1,r.getMenus().size());
        r.addMenu(menu2);
        assertEquals(2,r.getMenus().size());
    }

    @Test
    public void testRemoveMenu(){
        r.addMenu(menu1);
        assertFalse(r.removeMenu(menu2));
        assertTrue(r.removeMenu(menu1));
        assertEquals(0,r.getMenus().size());
    }
    @Test
    public void testClassificacoes(){
        r.addClassificacao(class1);
        r.addClassificacao(class2);
        assertEquals(2,r.getClassificacoes().size());
        assertEquals(6.75,r.getClassificacao(),0);
    }
    @Test
    public void addEntrega(){
        r.addEntrega(entrega1);
        assertEquals(1,r.getEntregas().size());
    }
    @Test
    public void addReclamacao(){
        r.addReclamacao(reclamacao1);
        assertEquals(1,r.getReclamacacoes().size());
    }

}
