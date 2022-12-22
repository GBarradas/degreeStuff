package aula17;

import java.io.*;

public class ProcessaFicheiros {

    private String inFile;
    private String outFile;

    public static void main(String[] args) {
        if (args.length<3) {
            System.err.println("erro: argumentos insuficientes\n"+
                             "java ProcessaFicheiros OPCAO inFilename outFilename");
            System.exit(1);
        }

        System.out.println("vou passar dados de (" + args[0]
                + ") para (" + args[1] + ")\n");

       ProcessaFicheiros pf= new ProcessaFicheiros(args[1], args[2]); 
        if (args[0].equals("-copiar"))
            pf.passaDados();
        else if (args[0].equals("-cifrar"))
            pf.cifrar();
        else if (args[0].equals("-decifrar"))
            pf.decifrar();
        else 
            System.err.println("OPCAO INVALIDA: " + args[0]);
    }

    public ProcessaFicheiros(String inFile, String outFile) {
        this.inFile = inFile;
        this.outFile = outFile;
    }

    // faz uma copia simples
    public void passaDados() {
        byte[] b = new byte[1024];
        int lidos;

        try {
            FileInputStream fis = new FileInputStream(inFile);
            FileOutputStream fos = new FileOutputStream(outFile);

            lidos = fis.read(b);
            while (lidos > 0) {
                // escrever os bytes no outro ficheiro
                fos.write(b, 0, lidos);

                // e continuar
                lidos = fis.read(b);
            }
            fis.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("PROBLEMA: " + e.getMessage());
            return;
        }
        System.out.println("----------- ok");
    }

}
