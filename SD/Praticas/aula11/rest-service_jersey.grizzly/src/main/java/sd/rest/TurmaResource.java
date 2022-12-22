package sd.rest;



import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.QueryParam;



@Path(value = "/turma")
public class TurmaResource {

    private static Turma turma;

    /**
     * This class is annotated with @Singleton meaning that only
     * one instance of this class will be instantated per web
     * application. 
     */
    public TurmaResource() {
        if (turma==null) {
            turma = new Turma();   // alguns dados para testes
            turma.add(new Aluno(200,"Maria"));
            turma.add(new Aluno(201,"Manuel"));
        }
    }

    @GET
    @Produces({"application/json", "application/xml"})
    public synchronized Turma getTurma() {
        
        System.out.println("\ngetTurma()\n");
        
        return turma;
    }

    /* Sem a anotacao @Path, a escolha entre este metodo e o anterior faz-se pelo HTTP Method (GET/PUT)
    */
    @PUT
    @Consumes({"application/json", "application/xml"})
    public synchronized void putTurma(Turma turma) {
        this.turma = turma;
    }

    /*
	Este método é invocado se o AppServer receber um Http POST com o sufixo /add, apos o URI base deste resource.
    */
    @Path("/add")
    @GET
    @Consumes({"application/json", "application/xml"})
    @Produces({"application/json", "application/xml"})
    public synchronized Turma addAluno(@QueryParam("numero") int numero,
				       @QueryParam("nome") String nome
					) {
        turma.add(new Aluno(numero,nome));
	return turma;
    }


}

