package sd.rmi;

import java.util.List;

public interface Palavras extends java.rmi.Remote {

    public String primeiraPalavra(String s) throws java.rmi.RemoteException;

    public List<String> divide(String s) throws java.rmi.RemoteException;

}
