import java.util.Scanner;

public class Rascunho{

    public static void main(String[] args){
        java.util.Scanner s=new Scanner(System.in);
        String text=s.nextLine();
        s.close();

        int result=text.length();

        System.out.println(result);
    }
}

