public class Div20 {
    public static boolean isdiv(long value){
        boolean m1=value%1==0;
        boolean m2=value%2==0;
        boolean m3=value%3==0;
        boolean m4=value%4==0;
        boolean m5=value%5==0;
        boolean m6=value%6==0;
        boolean m7=value%7==0;
        boolean m8=value%8==0;
        boolean m9=value%9==0;
        boolean m10=value%10==0;
        boolean m11=value%11==0;
        boolean m12=value%12==0;
        boolean m13=value%13==0;
        boolean m14=value%14==0;
        boolean m15=value%15==0;
        boolean m16=value%16==0;
        boolean m17=value%17==0;
        boolean m18=value%18==0;
        boolean m19=value%19==0;
        boolean m20=value%20==0;
        return m1&&m2&&m3&&m4&&m5&&m6&&m7&&m8&&m9&&m10&&m11&&m12&&m13&&m14&&m15&&m16&&m17&&m18&&m19&&m20;
    }
    public static void main(String[] Args){
        long i= 99195680;
        do{
            System.out.println(i+":->"+isdiv(i));
            i=i+5;
        }while(!isdiv(i));
        System.out.println("Resultado:" + i);
    }
    
}
//result:232792560