import java.lang.StringBuilder;
import java.lang.String;
import java.text.Normalizer;
class Cap09Ex24 {
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
    public boolean isPalindrome(String word) {
        word=normalize(word);
        StringBuilder str=new StringBuilder(word);
        str.reverse();
        String c=str.toString();
        return c==word;
        
        
    }
}
