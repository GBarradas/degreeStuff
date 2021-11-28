package Trabalho;
import java.util.ArrayList;
import java.util.List;
//import java.lang.Character;
import  java.util.Random;
import java.text.Normalizer;
import java.lang.String;
import java.lang.StringBuilder;

public class Cipherb {
    public static String normalize(String naturalText){
        String normalizado=new String();
        //Remover acentos e cedilhas 
        normalizado=Normalizer.normalize(naturalText,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]","");
        //Remover pontuação
        normalizado=normalizado.replaceAll("\\p{Punct}", "");
        //Remover espaços
        normalizado=normalizado.replaceAll(" ", "");
        //por letras minusculas
        normalizado=normalizado.toLowerCase();
        return normalizado;
    }

    public static String encode(String plainText, int cols){
        plainText = normalize(plainText);
        String s= plainText;
        int linhas = plainText.length()/cols;
        StringBuilder cifra = new StringBuilder();
        //int numberchar = 0;

        if(plainText.length()%cols!=0){
            linhas+=1;
            int numberchar = cols - plainText.length() % cols;
            System.out.println(numberchar);
            Random r = new Random();
            for(int i=1; i<=numberchar; i++){
                s=s+plainText.charAt(r.nextInt(plainText.length()-1));
            }
            System.out.println(s);
            plainText = s;
        }

        for(int i=0; i<linhas; i++){
            int lines = i;
            for(int j=0; j<cols; j++){
                cifra.append(plainText.charAt(lines));
                lines+=linhas;
            }
        }
        s = cifra.toString();
        return s;

    }     

    public static List<Integer> findDividers(int x){
        List<Integer> divisor=new ArrayList<Integer>();
        divisor.add(1);
        for(int i=2;i<x;i++){
            if(x%i==0){
                divisor.add(i);
            }
        }
        divisor.add(x); 
        return divisor;
    }
    public static String print(String result,int cipherLength,int cols){
       int linhas=cipherLength/cols;
       StringBuilder cipher=new StringBuilder();
       System.out.println(linhas+"c"+cols+"\n");

       for (int i=0;i<linhas;i++){
            int pos=i;
           for(int j=0;j<cols;j++){
               cipher.append(result.charAt(pos));
               System.out.print(result.charAt(pos)+" ");
                pos=pos+linhas;
           }
           System.out.println();
       }
       //System.out.println(cipher);
       return cipher.toString();
    }
    public static void main(String[] Args){
        System.out.println(encode("bom dia alegria",4));
    }
    
    
}
 
