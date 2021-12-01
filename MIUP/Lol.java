import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Lol {
    
     int trocas;
    public Lol(){
        trocas=0;
    }
    public static boolean isEqual(List<String> inicio,  List<String> fim){
        for(int i=0;i<inicio.size();i++){
            if(inicio.get(i)!=fim.get(i)) return false;
        }
        return true;
    }
    public static List<String> troca(List<String> inicio,  List<String> fim, int indice, int troca){
        if(inicio.get(indice)==fim.get(indice)) return inicio;
        String inicio_value=inicio.get(indice);
        String value_change=fim.get(indice);
        int index_change=inicio.indexOf(value_change);
        inicio.remove(indice);
        inicio.add(indice,value_change);
        inicio.remove(index_change);
        inicio.add(index_change,inicio_value);
        return inicio;
    }

    public static void main(String[] Args){
        new Lol();
        List<String> inicio=new ArrayList<String>();
        List<String> fim= new ArrayList<String>();
        String line_1;
        String line_2;
        int nplayers;
        int troca=0;
        Scanner s=new Scanner(System.in);
        line_1= s.nextLine();
        line_2=s.nextLine();
        nplayers=s.nextInt();
        s.close();
        //System.out.println(line_1+"\n"+line_2);
        String[] order_1=line_1.split(" ");
        String[] order_2=line_2.split(" ");
        for(int i=0;i<order_1.length;i++){
            inicio.add(order_1[i]);
            fim.add(order_2[i]);
        }
        inicio.remove(0);
        fim.remove(0);
        //System.out.println(inicio+"-->"+fim);
        //System.out.println(isEqual(inicio,fim));
        for(int i=0;!isEqual(inicio, fim)&& i<inicio.size();i++){
            //System.out.println(inicio);
            if(inicio.get(i)==fim.get(i)){

            }
            else{
                //System.out.println("troca");
                String inicio_value=inicio.get(i);
                String value_change=fim.get(i);
                int index_change=inicio.indexOf(value_change);
                inicio.remove(i);
                inicio.add(i,value_change);
                inicio.remove(index_change);
                inicio.add(index_change,inicio_value);
                troca++;
            }
        }
        //System.out.println("-->"+inicio+"\n -->>>>"+troca);
        int winer=troca%nplayers;
        if(winer==0) winer=nplayers;
        System.out.println(winer);
    }
}
