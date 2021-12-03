package Code;

import java.util.Iterator;

public class GenericQueue<T> implements IQueue,Iterable{

    IList<T> queueData;

    public GenericQueue() {
        this.queueData = new IArrayList<>();
    }

    @Override
    public void enqueue(Object element) {
        queueData.add(queueData.size(), (T)element);
    }

    @Override
    public Object dequeue() {

        return queueData.remove(0);
    }

    @Override
    public Object first() {
        return queueData.get(0);
    }

    @Override
    public boolean empty() {

        return queueData.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return queueData.iterator();
    }
}
