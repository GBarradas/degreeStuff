package Fermimni;

public class Guess {
    int a,b,c;
    public Guess(String guessText) throws Exception{
        String[] d=guessText.split(" ");
        a=Integer.parseInt(d[0]);
        b=Integer.parseInt(d[1]);
        c=Integer.parseInt(d[2]);
    }
    public int getA(){return a;}
    public int getB(){return b;}
    public int getC(){return c;}
}
