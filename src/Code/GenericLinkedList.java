package Code;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericLinkedList<T> implements IList<T> {
    Node head,tail;
    int size;

    public GenericLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T me) {
        Node newNode = new Node(me);

        if (head==null) {
            head = newNode;
        }

        if (tail!=null) {
            tail.next = newNode;
        }

        tail = newNode;

        this.size++;
    }

    @Override
    public void add(int i, T t) throws IndexOutOfBoundsException{
        Node auxNode, auxNodePrev,newNode;
        auxNode = head;
        auxNodePrev = auxNode;

        if ((i>size)||(i<0)) {
            throw new IndexOutOfBoundsException();
        }else{
            for(int x=0;x<i;x++){
                auxNodePrev = auxNode;
                auxNode = auxNode.next;
            }
            newNode = new Node(t);
            if(i==0){
                newNode.next = auxNode;
                head = newNode;
            }else {
                auxNodePrev.next = newNode;
                newNode.next = auxNode;
            }
        }

        this.size++;

    }

    @Override
    public T set(int i, T t) throws IndexOutOfBoundsException {

        Node current = head;
        Node currentPrev = current;
        int counter = 0;
        Node newNode =  new Node(t);

        if (i >= this.size||i<0) throw new IndexOutOfBoundsException();

        while (counter != i) {
            currentPrev = current;
            current = current.next;
            counter++;
        }

        newNode.next = current.next;

        if (counter != 0) {
            currentPrev.next = newNode;
        }else{
            head = newNode;
        }

        if (i==size-1) tail = newNode;

        return t;

    }

    public T get(int i) {

        Node current = head;
        int counter = 0;

        if (i >= this.size||i<0) throw new IndexOutOfBoundsException();

        while (counter != i) {
            current = current.next;
            counter++;
        }

        return current.getData();

    }

    public int size() {

        return this.size;
    }

    @Override
    public T remove(int i) throws IndexOutOfBoundsException{
        Node current = head;
        Node currentPrev = current;
        int counter = 0;
        T output;

        if (i >= this.size||i<0) throw new IndexOutOfBoundsException();

        while (counter != i) {
            currentPrev = current;
            current = current.next;
            counter++;
        }

        output = current.getData();

        if(counter==0){
            current = current.next;
            head = current;
        }else {
            currentPrev.next = current.next;
        }

        if(counter==size-1){
            tail = currentPrev;
        }

        this.size--;

        return output;
    }

    @Override
    public boolean remove(T t) {

        Node current = head;
        int counter = 0;
        boolean foundIt = false;

        while ((counter < this.size)&&!foundIt) {

            if (t.equals(current.getData())) {
                remove(counter);
                foundIt = true;
            }

            current = current.next;

            counter++;
        }

        return foundIt;

    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
    }

    @Override
    public boolean contains(T t) {

        Node current = head;
        int counter = 0;
        boolean foundIt = false;

        while ((counter < this.size)&&!foundIt) {

            if (t.equals(current.getData())) {
                foundIt = true;
            }

            current = current.next;

            counter++;
        }

        return foundIt;

    }

    @Override
    public Iterator<T> iterator() {
        return new ILinkedListIterator();
    }

    @Override
    public void rotate(int distance) {
        Node aux, cursorPrev;
        if (size>1){
            if (distance>0) {
                for(int counter = 0;counter<distance;counter++) {
                    aux = head;
                    cursorPrev = head;
                    head = head.next;
//This loop could be replaced if a previous-node pointer were part of the structure of the Node.
                    while (cursorPrev != tail) {
                        cursorPrev = cursorPrev.next;
                    }
                    cursorPrev.next = aux;
                    aux.next = null;
                    tail = aux;
                }
            }else if(distance<0){
                distance = distance * -1;
                for(int counter=0;counter<distance;counter++) {
                    aux = tail;
                    tail.next = head;
                    cursorPrev = head;
//This loop could be replaced if a previous-node pointer were part of the structure of the Node.
                    while (cursorPrev.next != tail) {
                        cursorPrev = cursorPrev.next;
                    }
                    tail = cursorPrev;
                    cursorPrev.next = null;
                    head = aux;
                }
            }
        }


    }

    class ILinkedListIterator implements Iterator<T>{

        private int cursor = 0;
        private Node current = head;
        private boolean pause = false;

        @Override
        public boolean hasNext() {
            return cursor<size;
        }

        @Override
        public T next() {
            Node output;
            if(cursor == size){
                throw new NoSuchElementException();
            }
            output = current;
            current = current.next;
            cursor++;
            return output.getData();
        }
    }

    private class Node {
        T data;
        Node next;

        Node(T d) {
            data = d;
            next = null;
        }

        public T getData() {
            return data;
        }
    }
}
