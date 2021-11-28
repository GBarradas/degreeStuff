//package Trabalho;
import java.util.ArrayList;
import java.util.List;
//import java.lang.Character;
import  java.util.Random;
import java.text.Normalizer;
import java.lang.String;
import java.lang.StringBuilder;

public class Cipher {
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

    public static String encode(String plaintText,int cols){
    //calcular o tamanho necessario para a cifra
    int cipherLength=0;
    String result=new String();
    for(int i=1;cipherLength<plaintText.length();i++){
        cipherLength=i*cols;
    }
    System.out.println(cipherLength);
    //verificamos se é necessario acrescentar letras
    if(cipherLength==plaintText.length()){
        return print(plaintText,cipherLength,cols);
        
    }else{//acrescenta letras
        Random r=new Random();
        result=plaintText;
        while(result.length()!=cipherLength){
            result=result+plaintText.charAt(r.nextInt(plaintText.length()));
        }
        //print fudido
        //int count=1;
        return print(result,cipherLength,cols);
    }      

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
        System.out.println(encode("hojevamosaocinemaoupassearnojardimaecaoeav",4));
    }
    
    
}
 
