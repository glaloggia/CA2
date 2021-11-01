
class CustomizedLinkedList {
    Node head;

    public void addToStart(int val)
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
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
}

