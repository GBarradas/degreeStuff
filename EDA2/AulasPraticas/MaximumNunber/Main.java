import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
      Scanner s= new Scanner(System.in);
      int max=0,
          c= s.nextInt(),
          ns,
          stick;
      for(;c>0;c--){
        ns=s.nextInt();
        for(;ns>0;ns--){
            stick=s.nextInt();
            if(stick>max) max=stick;
        }
      }
      s.close();
      System.out.println(max);
    }
}