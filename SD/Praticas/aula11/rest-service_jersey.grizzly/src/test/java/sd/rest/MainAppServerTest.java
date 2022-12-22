package sd.rest;



import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;



public class MainAppServerTest {


    private HttpServer httpServer;
    private WebTarget target;



    @Before
    public void setUp() throws Exception {
        httpServer = MainAppServer.startServer();


        Client c = ClientBuilder.newClient();
        target = c.target(sd.rest.MainAppServer.BASE_URI);

    }

    @After
    public void tearDown() throws Exception {  // o que fazer no final
        httpServer.shutdown();
    }



    // *******************************************
    // *******************************************
    // ZONA com os testes...
    // note a anotacao @Test e o assertXxx que tem a(s) validacao(oes) a observar em cada teste.



    @Test
    public void testGetOnTurma() {
        // get the initial representation
        String st = target.path("turma").request().get(String.class);
        System.out.println("resultado teste1: "+st);
        // testar a presenca de pelo menos 2 alunos
        assertEquals("A resposta não é a esperada",
                "{\"alunos\":[{\"nome\":\"Maria\",\"numero\":200},{\"nome\":\"Manuel\",\"numero\":201}]}", st);
    }





}
