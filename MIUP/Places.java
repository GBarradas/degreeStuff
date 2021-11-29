import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Places{

    public static int indexOfMax(List<Integer>  vote,List<Integer> calcs){
        int value=calcs.get(0);
        int index=0;
        for(int i = 1;i<calcs.size();i++){
            if(calcs.get(i)>value){
                value=calcs.get(i);
                index=1;
            }
            else {
                if(value==calcs.get(i)){
                    if(vote.get(index)>vote.get(i)){
                        value=calcs.get(i);
                        index=i;
                    }
                }
            }
        }
        return index;
    }
    public static void main(String[] Args){
        Scanner s=new Scanner(System.in);
        int places=s.nextInt();
        int nparties=s.nextInt();
        List<Integer> votes=new ArrayList<Integer>();
        List<Integer> placesTaken=new ArrayList<Integer>();
        int position=0;
        int value;
        for(int i=0;i!=nparties;i++){
            votes.add(s.nextInt());
            placesTaken.add(0);
        }
        s.close();
        //System .out.println(votes);
        for(int i=0;i<places;i++){
            List<Integer> calcs=new ArrayList<Integer>();
            //System.out.println("vai centrar no for");
            for(int j=0;j<nparties;j++){
                int adicionar=votes.get(j)/(placesTaken.get(j)+1);
                //System.out.println(votes.get(j)+"/"+(placesTaken.get(j)+1)+"="+adicionar);
                calcs.add(j,adicionar);
                
            }
            //System.out.println("saio do for");
            position=indexOfMax(votes, calcs);
            value=placesTaken.get(position);
            placesTaken.remove(position);
            value++;
            placesTaken.add(position, value);
            //System.out.println(calcs);
        }
        //System.out.println("-->" +placesTaken);
        for(int i=0;i<nparties;i++){
            System.out.println(placesTaken.get(i));
        }
    }
    
    
}