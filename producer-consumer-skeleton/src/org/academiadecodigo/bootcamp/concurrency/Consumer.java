package org.academiadecodigo.bootcamp.concurrency;

import org.academiadecodigo.bootcamp.concurrency.bqueue.BQueue;

/**
 * Consumer of integers from a blocking queue
 */
public class Consumer implements Runnable {

    private final BQueue<Integer> queue;
    private int elementNum;

    /**
     * @param queue the blocking queue to consume elements from
     * @param elementNum the number of elements to consume
     */
    public Consumer(BQueue queue, int elementNum) {
        this.queue = queue;
        this.elementNum = elementNum;
    }

    @Override
    public void run() {

        //  Loop enquanto o número de elementos a serem utilizados ainda for maior que zero.
        while (elementNum > 0 ) {


             //Isso garante que apenas uma thread por vez possa acessar o bloco de código dentro desse trecho.
            synchronized (queue) {


                try {
                    //Remove o elemento da fila, usando o método poll() da classe BQueue.
                    queue.poll();

                    // O método Thread.currentThread().getName() retorna o nome da thread atual.
                    System.out.println(Thread.currentThread().getName() + ": Consuming new element. I now have "+ queue.getSize() + " elements");



                    //Verifica se a fila está vazia
                    if(queue.getSize() == 0) {

                        //Imprime uma mensagem indicando que a fila foi deixada vazia pela thread atual.
                        System.out.println(Thread.currentThread().getName() + ": LEFT THE QUEUE EMPTY");
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            }

            try {

                // pausa de um segundo para utilizar o elemento seguinte
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            elementNum--;
        }

    }
}
