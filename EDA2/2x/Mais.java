import java.io.*;

class Main {

    public static void main(String[] args) throws IOException

    {

        BufferedReader br= new BufferedReader( new InputStreamReader(System.in));

        Coins algoland = new Coins(Integer.parseInt(br.readLine()));

        String[] values=br.readLine().split(" ");

        algoland.setValues(values);;

        int numChanges = Integer.parseInt(br.readLine());

        int amount;

        int[] result;

        for(int i=0;i<numChanges;i++){

            amount=Integer.parseInt(br.readLine());

            result= algoland.change(amount);

            System.out.print(amount+": "+"["+result.length+"]");

            for(int coin : result){

                System.out.print(" "+coin);

            }

            System.out.println();

            

        }

  

    }

  }

  class Coins {

    int[] coinsValues;

    int numCoins;

    public Coins(int coins){

        this.numCoins=coins;

        coinsValues= new int[coins];

    }

    /* Inicializa os valores das moedas existentes. */

    public void setValues(String[] values){

        for(int i =0; i<coinsValues.length;i++){

            coinsValues[i]=Integer.parseInt(values[i]);

        }

    }

    /*

  Calcula e devolve o número mínimo de moedas necessário para

  obter a quantia AMOUNT.

    */

    public int[] change(int amount){

        int[] coins=new int[amount+1];

        int[] coinUse=new int[amount+1];

        coins[0]=0;   //caso base

        for(int i=1;i<=amount;i++){

            coins[i]=i/coinsValues[0];      //maximo de moedas de troco

            for( int j=0;j<numCoins;j++){

                if(coinsValues[j]<= i && coins[i-coinsValues[j]]+1<coins[i]){

                    coins[i]=1+coins[i-coinsValues[j]];

                    coinUse[i]=coinsValues[j];

                }

            }

            if(coinUse[i]==0) coinUse[i]=coinsValues[0];

            //System.out.println(i+" "+coins[i]+" "+coinUse[i]);

        }

        int i= amount;

        int j =0;

        int[] result= new int[coins[amount]];

        

        while(i>0){

            result[j]=coinUse[i];

            j++;

            i=i-coinUse[i];

        }

        return result;

    }

  }
