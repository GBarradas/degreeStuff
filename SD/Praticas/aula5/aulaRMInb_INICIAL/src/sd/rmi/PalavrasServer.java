package sd.rmi;


/**
 * Classe que ativa o serviço via RMI.
 * 
 * @author jsaias
 */
public class PalavrasServer {

    public static void main(String args[]) {

	int regPort= 1099; // default RMIRegistry port

	if (args.length !=1) { // obrigar à presenca de um argumento
	    System.out.println("Usage: java sd.rmi.PalavrasServer registryPort");
	    System.exit(1);
	}
	

	try {
	    // ATENÇÃO: este porto é relativo ao binder e não ao servidor RMI
	    regPort=Integer.parseInt(args[0]);


	    // criar um Objeto Remoto
	    Palavras obj= new PalavrasImpl() ;


	    // Serviço de Nomes
            /**
             * Se quiser substituir o processo rmiregisty...
             * pode ativar o servidor de nomes neste mesmo processo (antes do bind)
             */
            //java.rmi.registry.LocateRegistry.createRegistry(regPort);            
            
            
	    // usar o Registry local (mesma máquina) e porto regPort
	    java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.getRegistry(regPort);

            
	    // Bind. Args: nome do serviço e objeto remoto
	    registry.rebind("palavras", obj);

	    /*
	      OUTRO MODO, indicando o servidor remoto para o serviço de nomes
	    java.rmi.Naming.rebind("rmi://"+regHost+":"+regPort+"/palavras", stub);	    
	    */
            
	     
	} 
	catch (Exception ex) {
	    ex.printStackTrace();
	}
    }
    
}
