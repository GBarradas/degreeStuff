package paral02;

public class Primos {
    private int start;
    private int end;
    
    
    public Primos(int start, int end) {
        this.start= start;
        this.end= end;
    }
    
    int count_primes(int start, int end) {
        int total = 0;
        int i = start; // check if prime    
        while (i <= end) {
            int c;
            for (c = 2; c <= i - 1; c++) {
                if (i % c == 0) {
                    break;
                }
            }
            if (c == i) {
                //printf("%d\n", i);
                total++;
            }
            i++;   // next prime candidate
        }
        return total;
    }

    public void go() {

        int found_primes = count_primes(start, end);
        System.out.println("  found "+found_primes);
    }


// MAIN ... AQUI!!!!
    public static void main(String[] args){
        PrimoT p1 = new PrimoT(1, 50000);
        PrimoT p2 = new PrimoT(50001,100000 );
        PrimoT p3 = new PrimoT(100001,150000 );
        PrimoT p4 = new PrimoT(150001,200000 );
        p1.start();
        p2.start();
        p3.start();
        p4.start();
    }

}