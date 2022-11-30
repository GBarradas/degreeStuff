package Fermimni;
import java.util.Scanner;
public class GameUI {

    static boolean continuePlaying(String response){
        char r0= response.charAt(0);
        return r0=='s'||r0=='S';
    }

    static String prompt(String message){
        System.out.print(message);
        Scanner s=new Scanner(System.in);
        String response=s.nextLine();
        s.close();
        return response;
    }

    void play(){
        
        System.out.println("START");
        do{
            Progress progress=new Progress();
            boolean guessOk=false;
            do{
                guessOk=false;
                String guessText=null;
                Guess guess=null;

                do{

                    guessText=prompt("Palpite: ");
                    try{
                        guess=new Guess(guessText);
                        guessOk=true;
                    } catch(Exception e){
                        System.out.println("Entrada incorreta;");
                    }
                    
                    String result =progress.evalGuess(guess);
                    System.out.printf("%2d %s |> %s%n",progress.getGuessCount(),guessText,result);
                }while(progress.secreatFound());
            }while(!guessOk);
            System.out.format("Parabens, resolveu em %d palpite%n",progress.getGuessCount());
        }while(continuePlaying(prompt("Novo Jogo? ")));
        System.out.println("END");
    }
    public static void main(String[] Args){
        GameUI game= new GameUI();
        game.play();
    }

}


