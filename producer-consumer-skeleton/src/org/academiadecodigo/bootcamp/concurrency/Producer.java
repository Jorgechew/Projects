package org.academiadecodigo.bootcamp.concurrency;

import org.academiadecodigo.bootcamp.concurrency.bqueue.BQueue;

/**
 * Produces and stores integers into a blocking queue
 */
public class Producer implements Runnable {

    private final BQueue<Integer> queue;
    private Integer count = 1;
    private int elementNum;

    /**
     * @param queue      the blocking queue to add elements to
     * @param elementNum the number of elements to produce
     */
    public Producer(BQueue queue, int elementNum) {
        this.queue = queue;
        this.elementNum = elementNum;
    }

    @Override
    public void run() {

        //Loop enquanto o número de elementos a serem produzidos ainda for maior que zero.
            while (elementNum > 0) {
                System.out.println("I prodduce: "+ elementNum);

                //  Decrementa o valor da variável elementNum em 1.
                    elementNum--;

                    //Isso garante que apenas uma thread por vez possa acessar o bloco de código dentro desse trecho.
                synchronized (queue) {

                    try {
                        queue.offer(1);
                        System.out.println(Thread.currentThread().getName() + ": Inserting new element. I now have " + queue.getSize() + " elements");


                       // Verifica se a fila atingiu o limite de tamanho, nesse caso

                        if (queue.getSize() == 10 ){
                            System.out.println(Thread.currentThread().getName() + ": FULL!!!! ");
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }


                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }



        }


    }
}


