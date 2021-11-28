import java.util.Scanner;

public class Ex_05_13{
    public static  void match(int potencia){
        switch(potencia){
            case 6:
                System.out.println("Milion");
                break;
            case 9:
                System.out.println("Bilion");
                break;
            case 12:
                System.out.println("Trilion");
                break;
            case 18:
                System.out.println("Quintillion");
                break;
            case 21:
                System.out.println("Sextillion");
                break;
            case 30:
                System.out.println("Nonillion");
                break;
            case 100:
                System.out.println("Googol");
                break;
            default:
                System.out.println("no match");
                break;
        }
    }
    public static void main(String[] Args){
        Scanner s=new Scanner(System.in);
        int potencia=s.nextInt();
        
        s.close();
        match(potencia);
    }
}