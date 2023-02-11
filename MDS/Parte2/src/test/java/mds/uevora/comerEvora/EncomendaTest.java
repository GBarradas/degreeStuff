package mds.uevora.comerEvora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncomendaTest {
    private Encomenda encomenda;
    private Cliente cliente;
    private Menu menu;
    private Artigo artigo;


    @BeforeEach
    void setUp() {
        cliente = new Cliente("cliente", "password", "morada", "contacto","alergias");
        encomenda = new Encomenda("detalhes", cliente );
        menu = new Menu("menu1","descricao",10);
        artigo = new Artigo("artigo1","descrição",5.5,new Categoria("categoria"),null);
    }

    @Test
    public void testAddAndRemoveArtigo(){
        encomenda.adicionarArtigo(artigo);
        assertEquals(1,encomenda.artigos.size());
        encomenda.removerArtigo(artigo);
        assertEquals(0,encomenda.artigos.size());
    }
    @Test
    public void testAddAndRemoveMenus(){
        encomenda.adicionarMenu(menu);
        assertEquals(1,encomenda.menus.size());
        encomenda.removeMenu(menu);
        assertEquals(0,encomenda.menus.size());
    }

    @Test
    public void testCalcPreco(){
        assertEquals(0,encomenda.caclPreco(),0);
        encomenda.adicionarMenu(menu);
        encomenda.adicionarArtigo(artigo);
        assertEquals(15.5, encomenda.caclPreco(), 0);
    }

    @Test
    public void testSetEstado(){
        encomenda.setEstado("A Caminho");
        assertEquals("A Caminho",encomenda.getEstado());
    }

    @Test
    public void testEncomendar(){
        encomenda.encomendar();
        assertEquals("Criando", encomenda.getEstado());
        encomenda.adicionarArtigo(artigo);
        encomenda.encomendar();
        assertEquals("A Preparar", encomenda.getEstado());
    }



}