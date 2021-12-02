package Code;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IArrayList<T> implements IList<T> {
    private T[] buffer;
    private int nextFreeLoc;
    private int currentCapacity;

    private static final int INITIAL_CAPACITY = 3;

    public IArrayList() {
        currentCapacity = INITIAL_CAPACITY;
        nextFreeLoc = 0;
        buffer = (T[]) new Object[currentCapacity];
    }

    public void add(T elem) {
        growArrayIfNeeded();
        buffer[nextFreeLoc++] = elem;
    }

    public void add(int index, T elem) {
        if (index <= nextFreeLoc) {
            growArrayIfNeeded();

            for (int i = nextFreeLoc; i > index; i--) {
                buffer[i] = buffer[i - 1];
            }
            buffer[index] = elem;
            nextFreeLoc++;
        }
    }

    @Override
    public T set(int i, T t) throws IndexOutOfBoundsException{
        if (i >= nextFreeLoc||i<0) {
            throw new IndexOutOfBoundsException();
        }
        this.buffer[i]=t;
        return t;
    }

    public T get(int index) {
        if (index >= nextFreeLoc||index<0) {
            throw new IndexOutOfBoundsException();
        }
        return buffer[index];
    }

    public boolean remove(T elem) {
        boolean matchFound = false;
        for (int index = 0; index < nextFreeLoc && !matchFound; index++) {
            if (buffer[index].equals(elem)) {
                matchFound = true;

                for (int i = index; i < nextFreeLoc; i++) {
                    buffer[i] = buffer[i + 1];
                }

                nextFreeLoc--;

            }
        }
        return matchFound;
    }

    public T remove(int index) {
        T output;
        output = null;
        if (index <= nextFreeLoc) {
            output = buffer[index];
            for (int i = index; i < nextFreeLoc; i++) {
                buffer[i] = buffer[i + 1];
            }

            nextFreeLoc--;
        }
        return output;
    }


    public boolean contains(T elem) {
        boolean matchFound = false;
        for (int index = 0; index < nextFreeLoc && !matchFound; index++) {
            if (buffer[index].equals(elem)) {
                matchFound = true;
            }
        }
        return matchFound;
    }

    public boolean isEmpty() {
        return (nextFreeLoc == 0);
    }

    public int size() {

        return nextFreeLoc;
    }

    private void growArrayIfNeeded() {
        if (nextFreeLoc == currentCapacity) {

            T[] tempArr = (T[])new Object[buffer.length * 2];
            currentCapacity *= 2;

            for (int i = 0; i < buffer.length; i++) {
                tempArr[i] = buffer[i];
            }

            buffer = tempArr;
        }
    }

    @Override
    public String toString() {
        String data = "";
        for (int i = 0; i < nextFreeLoc; i++) {
            data += " " + buffer[i] + ",";
        }

        return "Code.IArrayList[" + data + " ]";
    }
    @Override
    public Iterator<T> iterator() {
        return new IArrayListIterator();
    }

    class IArrayListIterator implements Iterator<T>{
        private int cursor = 0;
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return cursor < nextFreeLoc;
        }
        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next() {
            if(cursor == nextFreeLoc){
                throw new NoSuchElementException();
            }
            return buffer[cursor++];
        }
        @Override
        //You do not have to provide functionality for the remove() method
        //We already have (non-iterator) mechanism for removing elements
        public void remove() {
            throw new UnsupportedOperationException("not supported yet");
        }
    }

}
