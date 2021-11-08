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

        if (i >= this.size||i<0) throw new IndexOutOfBoundsException();

        while (counter != i) {
            current = current.next;
            counter++;
        }

        return current.data;

    }

    public int size() {

        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
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
