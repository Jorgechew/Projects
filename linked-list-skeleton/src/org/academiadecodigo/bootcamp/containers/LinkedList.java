package org.academiadecodigo.bootcamp.containers;

public class LinkedList {

    private Node head;
    private int length = 0;

    public LinkedList() {
        this.head = new Node(null);
    }

    public int size() {
        return length;
    }

    /**
     * Adds an element to the end of the list
     * @param data the element to add
     */
    public void add(Object data)  {

        Node node = new Node(data);
        Node iterator = head;
        while (iterator.getNext() != null){
            iterator = iterator.getNext();
        }
        iterator.setNext(node);
        length++;

    }

    /**
     * Obtains an element by index
     * @param index the index of the element
     * @return the element
     */
    public Object get(int index) {

        if (head.getNext() == null || index >= length){
            return null;
        }

        Node iterator = head.getNext();
        int i = 0;
        while (i < index) {
            iterator = iterator.getNext();
            i++;
        }

    return iterator.getData();

    }

    /**
     * Returns the index of the element in the list
     * @param data element to search for
     * @return the index of the element, or -1 if the list does not contain element
     */
    public int indexOf(Object data) {

        int index = 0;

        Node iterator = head.getNext();

        while (iterator != null) {
            if (iterator.getData().equals(data)) {
                return index;
            }
            index++;
            iterator = iterator.getNext();
        }

        return -1;

    }
    /**
     * Removes an element from the list
     * @param data the element to remove
     * @return true if element was removed
     */
    public boolean remove(Object data) {
        if (length == 0){return false;}
        Node iterator = head;
        Node iterator1;

        while(iterator.getNext() != null){
            iterator1 = iterator;
            iterator = iterator.getNext();
            if(iterator.getData().equals(data)){
                iterator1.setNext(iterator.getNext());
                length--;
                return true;



            }

        }
        return false;

    }

    private class Node {

        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
            next = null;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
