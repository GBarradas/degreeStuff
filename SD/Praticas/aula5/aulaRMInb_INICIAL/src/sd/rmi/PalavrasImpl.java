package sd.rmi;

/**
 * CLASSE DO OBJETO REMOTO Tem a parte funcional... a implementação das
 * operações do serviço.
 */
import java.rmi.server.UnicastRemoteObject;

public class PalavrasImpl extends UnicastRemoteObject implements Palavras, java.io.Serializable {

    // deve existir um construtor
    public PalavrasImpl() throws java.rmi.RemoteException {
        super();
    }

    // ... e a implementação de
    // cada método declarado na interface remota
    
    
    /**
     * devolve a primeira palavra da frase recebida
     *
     * @param s
     * @return
     * @throws java.rmi.RemoteException
     */
    public String primeiraPalavra(String s) throws java.rmi.RemoteException {
        System.err.println("invocação primeiraPalavra() com: " + s);
        String s2 = s.trim();  // remove espacos no inicio ou fim
        int k = s2.indexOf(" ");  // indice de " "
        if (k < 0) // nao tem espacos
        {
            return s2;
        } else {
            return s2.substring(0, k);  // apenas a 1a palavra
        }
    }

    /**
     * devolve um vector com cada palavra da expressão recebida
     *
     * @param s
     * @return
     * @throws java.rmi.RemoteException
     */
    public java.util.List<String> divide(String s) throws java.rmi.RemoteException {
        System.err.println("invocação divide() com: " + s);
        java.util.LinkedList<String> v = new java.util.LinkedList<>();
        String s2 = s.trim();

        String[] s2pals = s2.split(" ");

        for (int i = 0; i < s2pals.length; i++) {
            v.add(s2pals[i]);       // adiciona a palavra i
        }
        return v;
    }

}
