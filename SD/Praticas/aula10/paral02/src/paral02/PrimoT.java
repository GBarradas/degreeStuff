/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paral02;

/**
 *
 * @author barradas
 */
public class PrimoT extends Thread
{
    int start;
    int end;
    public PrimoT(int start, int end){
        super();
        this.start = start;
        this.end = end;
    }
    public void run(){
        Primos p = new Primos(start, end);
        p.go();
    }
}
