package Code;

import java.util.Iterator;

public class GenericStack<T> implements IStack, Iterable {

    IList<T> stackData;

    public GenericStack() {
        this.stackData = new GenericArrayList<>();
    }

    @Override
    public void push(Object element) {
        stackData.add(0,(T)element);
    }

    @Override
    public Object pop() {
        return stackData.remove(0);
    }

    @Override
    public Object peek() {
        return stackData.get(0);
    }

    @Override
    public boolean empty() {
        return stackData.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return stackData.iterator();
    }

}
