package Fermimni;
import java.util.Random;
public class Secret {
        private int p1=0;
        private int p2=0;
        private int p3=0;
        public Secret(){
            Random generator=new Random();
            this.p1=generator.nextInt(10);
            this.p2=generator.nextInt(10);
            this.p3=generator.nextInt(10);
        }
        public int getP1(){
            return p1;
        }
        public int getP2(){
            return p2;
        }
        public int getP3(){
            return p3;
        }
    
}
