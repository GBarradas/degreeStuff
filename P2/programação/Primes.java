//import java.util.Date;

public class Primes{
    public static boolean isPrime(int value){
        int count=0;
        for(int i=1;i<value;i++){
            if(value%i==0)
                count++;
        }
        return count==1;
    }
    public static int countPrimes(int value){
        int count=0;
        for(int i=2;i<=value;i++){
            if(isPrime(i))
                count++;
        }
        return count;
    }
    public static long sumPrimes(int value){
        long sum=0;
        for(int i=0;i<=value;i++){
            if(isPrime(i)){
                sum += i;
                System.out.println(sum);
            }
        }

        return sum;
    }
    public static void main(String[] Args){
        System.out.println("-->"+sumPrimes(2000000));
    }
}