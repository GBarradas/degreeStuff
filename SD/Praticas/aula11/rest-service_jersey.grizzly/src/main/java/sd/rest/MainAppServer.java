package sd.rest;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class MainAppServer {

    private static int getPort(int defaultPort) {
        return defaultPort;
    }

    private static URI getBaseURI() {
        return URI.create("http://localhost:8001/sd/");
    }

    public static final URI BASE_URI = getBaseURI();

    public static HttpServer startServer() throws IOException {
        // ativar um servico com os REST resources existentes neste pacote:
        ResourceConfig rc = new ResourceConfig().packages("sd.rest");

        return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Starting grizzly...");
        HttpServer httpServer = startServer();

        System.out.println("\n## Para um primeiro teste, veja isto no browser: " + BASE_URI + "turma");
        System.out.println("\n## Hit enter to stop the server...");

        System.in.read();
        // depois do enter:
        httpServer.stop();
    }

}
