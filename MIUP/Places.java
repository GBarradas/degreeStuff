import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Places{

    public static void main(String[] Args){
        Scanner s=new Scanner(System.in);
        int places=s.nextInt();
        int nparties=s.nextInt();
        List<Integer> votes=new ArrayList<Integer>();
        for(int i=0;i!=nparties;i++){
            votes.add(s.nextInt());
        }
        s.close();
        System .out.println(votes);
    }
}