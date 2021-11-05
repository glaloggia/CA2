public class GenericLinkedList<T> implements GenericList<T> {
    Node head,tail;
    int size;

    public GenericLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T me) {
        Node newNode = new Node(me);
        newNode.next = null;

        if (head==null) {
            head = newNode;
        }

        if (tail!=null) {
            tail.next = newNode;
        }

        tail = newNode;

        this.size++;
    }

    public T get(int i) {

        Node current = head;
        int counter = 0;

        if (i > this.size) return null;

        while (counter != i) {
            current = current.next;
            counter++;
        }

        return current.data;

    }

    public int size() {

        return this.size;
    }


    public void addToStart(T val)
    {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    public void printList()
    {
        Node current = head;
        while(current != null){
            System.out.print(current.data + ", ");
            current = current.next;
        }
    }

    private class Node {
        T data;
        Node next;

        Node(T d) {
            data = d;
            next = null;
        }
    }
}
