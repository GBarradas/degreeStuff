package Fermimni;
public class Progress {
    int guessCount=0;
    Secret secret;
    Guess guess;
    public String evalGuess(Guess guess){
        guessCount++;

        return "ABC";
    }
    public int getGuessCount(){
        return guessCount;
    }
    public boolean secreatFound(){
        return guessCount==2;
    }
}
