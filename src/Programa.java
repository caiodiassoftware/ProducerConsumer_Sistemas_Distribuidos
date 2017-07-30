/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ads
 */
import java.util.ArrayList;

public class Programa {
    
        int itemCount;
        ArrayList buffer;
        public Semaphore sConsumidor, sProdutor;
    
        Programa () {
            itemCount = 0;
            buffer = new ArrayList();
            sProdutor = new Semaphore(1);
            sConsumidor = new Semaphore();
        }
    
        int compartilhada;
    
        public static void main(String[] args) {
               Programa t = new Programa();
               t.run();
        } 
        
        public void run() {
            Consumer c = new Consumer(this);
            Producer p = new Producer(this);
            c.start();
            p.start();
            Consumer c1 = new Consumer(this);
            Producer p1 = new Producer(this);
            c1.start();
            p1.start();
        }
    
    
}
