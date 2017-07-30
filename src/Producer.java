/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ads
 */
public class Producer extends Thread {
    
        Programa a;

        int contador;
        public Producer(Programa x) {

               a = x;
               contador =0;
        }

        public void run() {

               try {
                   while (true) {
                       while (a.itemCount == 10)
                           sleep(100);
                       a.sProdutor.down();
                       contador ++;
                       a.buffer.add(contador);
                       a.itemCount++;
                       System.out.println("produtor: producing item "+contador);
                       a.sConsumidor.up();
                   }

               }

               catch(InterruptedException e) {

                       e.printStackTrace(); 

               }

        }
    
    
}
