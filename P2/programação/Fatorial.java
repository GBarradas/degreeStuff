public class Fatorial {
   
    public static int calcFat(int n){
        if(n<=0){
            return 1;
        }
        return n*calcFat(n-1);
    } 
    public static void main(String[] Args){
        System.out.println(

            calcFat(10)
        );
    }
    
    
}
