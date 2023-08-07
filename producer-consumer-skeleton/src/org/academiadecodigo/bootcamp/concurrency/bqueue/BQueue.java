package org.academiadecodigo.bootcamp.concurrency.bqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Blocking Queue
 *
 * @param <T> the type of elements stored by this queue
 */
public class BQueue<T> {

    private int limit;

    //criação de uma linkList
    Queue<T> queueList;

    /**
     * Constructs a new queue with a maximum size
     *
     * @param limit the queue size
     */
    public BQueue(int limit) {

        queueList = new LinkedList<T>();
        this.limit = limit;
    }


    /**
     * Inserts the specified element into the queue
     * Blocking operation if the queue is full
     *
     * @param data the data to add to the queue
     */

    //Método offer() que insere um elemento na fila.
    //synchronized indica que o método é sincronizado, permite que apenas uma thread por vez possa executar esse método.
    public synchronized void offer(T data) throws InterruptedException {

        //Verifica se a fila atingiu o limite máximo de elementos.
        if (getSize() == getLimit()) {

            //Faz a thread atual esperar até que haja espaço disponível na fila
            //esta linha bloqueia a thread até que outra thread notifique a fila
            wait();
            System.out.println("Can't produce anymore pizzas. Waiting...");
        }

        //Adiciona o elemento data à fila usando o método add() da lista.
            queueList.add(data);
            System.out.println("inserir " + queueList.size());

            //Notifica todas as threads que estão aguardando na fila que um novo elemento foi adicionado.
            // Isso permite que as threads em espera sejam acordadas e continuem a execução.
            notifyAll();

    }


    /**
     * Retrieves and removes data from the head of the queue
     * Blocking operation if the queue is empty
     *
     * @return the data from the head of the queue
     */


    //Método poll() que remove e retorna o elemento da cabeça da fila.
    // O modificador synchronized indica que o método é sincronizado.
    public T poll() throws InterruptedException {

        //Bloco de código sincronizado usando o objeto atual (this) como monitor.
        synchronized (this) {

            //Verifica se a fila está vazia.
            if (getSize() == 0) {
                System.out.println("No pizzas for me. Waiting...");

                //Faz a thread atual esperar até que haja elementos na fila para consumir.
                // Essa linha bloqueia a thread.
                wait();

            }

            System.out.println("remove: " + queueList.size());


            notifyAll();
            return queueList.poll();


        }
    }

    /**
     * Gets the number of elements in the queue
     *
     * @return the number of elements
     */
    public synchronized int getSize() {

        //System.out.println("Limit:  " + queueList.size());
        return queueList.size();

    }

    /**
     * Gets the maximum number of elements that can be present in the queue
     *
     * @return the maximum number of elements
     */
    public int getLimit() {


        return this.limit;

    }

}
