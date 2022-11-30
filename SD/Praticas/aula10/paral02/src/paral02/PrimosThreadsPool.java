/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paral02;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
/**
 *
 * @author barradas
 */
public class PrimosThreadsPool 
{
    public static void main(String[] args){
        PrimoT r1 = new PrimoT(1, 50000);
        PrimoT r2 = new PrimoT(50001,100000 );
        PrimoT r3 = new PrimoT(100001,150000 );
        PrimoT r4 = new PrimoT(150001,200000 );
        LinkedBlockingDeque<Runnable> queue = new LinkedBlockingDeque<>();
        queue.add(r1);
        queue.add(r2);
        queue.add(r3);
        queue.add(r4);
        ThreadPoolExecutor p = new 
        ThreadPoolExecutor(4,4,5,
                java.util.concurrent.TimeUnit.MINUTES,queue);
        p.prestartAllCoreThreads();
        
        p.shutdown();
        System.out.println("end");
    }
    
}
