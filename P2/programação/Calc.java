import java.lang.Math;

public class Calc{
    public static int calc01(int value){
        int result=0;
        for(int i=0;i<=value;i++){
            result+=i;
        }
        return result;
    }
    
    public static int calc02(int value){
        int result=0;
        for(int i=5;i<=value;i+=5){
            result+=i;
        }
        return result;
    }
    public static long calc03(int value){
        long result=0;
        for(int i=1;i<=value;i++){
            if(i%2!=0){
                result+=i;
            }
        }
        return result +(long)(Math.pow(2,value)-1);
    }
    public static double calc04(int value){
        double result=0;
        for(int i=1;i<=value;i++){
            result=result+(1.0/i);
        }
        return result;
    }
    public static long calc05(int value){
        long result=1;
        for(int i=1;i<=value;i++){
            result=result*i;
        }
        return result;
    }
    public static void main(String[] Args){
        System.out.println(calc01(110));
        System.out.println(calc02(55));
        System.out.println(calc03(23));
        System.out.println(calc04(18));
        System.out.println(calc05(17));
    }
}
