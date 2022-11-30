package sd;

import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.List;

public class VeiculosServer {
    private int serverPort;	
    
    private List<Registo> repositorio;
    
    public VeiculosServer(int p) {
	serverPort= p;		
	repositorio= new LinkedList<>(); // INICIALIZE com LinkedList
    }
    

    
    public static void main(String[] args){
	System.err.println("SERVER...");
	if (args.length<1) {
		System.err.println("Missing parameter: port number");	
		System.exit(1);
	}
	int p=0;
	try {
	    p= Integer.parseInt( args[0] );
	}
	catch (Exception e) {
		e.printStackTrace();
		System.exit(2);
	}
	
	
	VeiculosServer serv= new VeiculosServer(p);
        serv.servico();   // activa o servico
    }
    
    





    public void servico() {

	try {

	    // inicializa o socket para receber ligacoes
            ServerSocket ss = new ServerSocket(serverPort);
	    while (true) {
		// espera uma ligacao
		// ... accept()
		Socket dataSocket = ss.accept();
		try {
		    Object objPedido= null;
		    // le os dados do pedido, como um OBJECTO "objPedido"		
                    ObjectInputStream ois = new ObjectInputStream(dataSocket.getInputStream());
                    ObjectOutputStream oos = new ObjectOutputStream(dataSocket.getOutputStream());

                    objPedido = ois.readObject();
		    
		    // apreciar o objecto com o pedido recebido:
		    if (objPedido==null)
			System.err.println("PEDIDO NULL: esqueceu-se de alguma coisa");
		    
		    if (objPedido instanceof PedidoDeConsulta) {
			PedidoDeConsulta pc= (PedidoDeConsulta)objPedido;
			
			// procurar o registo associado a matricula pretendida
                        Object res = null;
			// pesquisar no servidor (List, mais tarde num ficheiro)
                        for(Registo r: repositorio){
                            if(r.getMatricula().equals(pc.getMatricula())){
                                res = r;
                                break;
                            }
                        }
                        if(res == null){
                            oos.writeObject("NAO ENCONTRADO");
                        }
                        else{
                            oos.writeObject(res);
                        }
			
			// enviar objecto Cliente via socket		    
			// se encontra devolve o registo, se não, devolve um novo objecto ou string a representar que nao encontrou


			
		    }
		    else if (objPedido instanceof PedidoDeRegisto) {
			PedidoDeRegisto pr= (PedidoDeRegisto)objPedido; // ...
			// ver se ja existia registo desta matricula
                        boolean existente = false;
                        
                        //for(Registo r: repositorio){
                        //    if(r.getMatricula().equals(pr.getRegisto().getMatricula())){
                        //        existente = true;
                        //        repositorio.remove(r);
                        //    }
                        //}
                        String resp = "ADICIONADO";
                        if(existente)
                            resp += " , mas ja tinha registo.";
			// adicionar ao rep local (se nao e' uma repeticao)
                        repositorio.add(pr.getRegisto());
			
			// responder ao cliente
                        oos.writeObject(resp);

		    }
		    else
			System.out.println("PROBLEMA");
		    
                }
                catch (Exception exNoAtendimento) {
                    exNoAtendimento.printStackTrace();
                }
                finally { 
                    // fechar o socket de dados dedicado a este cliente:
                    try {
                        dataSocket.close();
                    }
                    catch (Exception e002) {
                    }
                }
                
		
	    
		
	    }  // ... ciclo de atendimento
	
	}
	catch (Exception problemaBindAccept) {
	    problemaBindAccept.printStackTrace();
	}

    }


}
