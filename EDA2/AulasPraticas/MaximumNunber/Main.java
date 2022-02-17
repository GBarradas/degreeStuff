import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main{
    public static void main(String[] args){
      try{
        BufferedReader s= new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.MIN_VALUE;
        int c;
        int ns;
        String[] sticks;
        int nc = Integer.parseInt(s.readLine());
        for(int i = 0;i<nc;i++){
          sticks= s.readLine().split(" ");
           ns= Integer.parseInt(sticks[0]);
          for(int j = 1;j <= ns;j++){
            c = Integer.parseInt(sticks[j]);
            if(max<c){
              max=c;
            }
          }
        }
        s.close();
        System.out.println(max);


      }
      catch(Exception e){

      }

    }
}