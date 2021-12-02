package Code;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ILinkedList<T> implements IList<T> {
    Node head,tail;
    int size;

    public ILinkedList() {
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
            auxNodePrev.next = newNode;
            newNode.next = auxNode;
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

        currentPrev.next = newNode;

        newNode.next = current;

        this.size++;

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

        if (i >= this.size||i<0) throw new IndexOutOfBoundsException();

        while (counter != i) {
            currentPrev = current;
            current = current.next;
            counter++;
        }

        currentPrev.next = current.next;

        this.size--;

        return current.getData();
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
