/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ads
 */
public class Consumer extends Thread {
    
        Programa a;

        public Consumer(Programa x) {

               a = x;
        }

        public void run() {

               try {
                   while (true) {
                       while (a.itemCount == 0)
                           sleep(100);
                       a.sConsumidor.down();
                       int item;
                       item = (Integer) a.buffer.get(0);
                       a.buffer.remove(0);
                       a.itemCount--;
                       System.out.println("consumer: consuming item "+item);
                       a.sProdutor.up();
                   }

               }

               catch(InterruptedException e) {

                       e.printStackTrace(); 

               }

        }
    
    
}
