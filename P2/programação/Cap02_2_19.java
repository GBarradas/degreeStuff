import java.util.Scanner;

public class Cap02_2_19 {
    public static void main(String[] args){
        System.out.println("Indique o seu nome:");
        Scanner S= new Scanner(System.in);
        String nomeProprio =S.next();
        String nomeMeio=S.next();
        String apelido=S.next();
        S.close();
        System.out.println(nomeProprio+" "+nomeMeio.substring(0,1)+". "+apelido);
        
    }
}