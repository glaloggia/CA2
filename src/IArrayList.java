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

    public T get(int index) {
        if (index >= nextFreeLoc||index<0) {
            throw new IndexOutOfBoundsException();
        }
        return buffer[index];
    }

    public void remove(T elem) {
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
    }

    public void remove(int index) {

        if (index <= nextFreeLoc) {

            for (int i = index; i < nextFreeLoc; i++) {
                buffer[i] = buffer[i + 1];
            }

            nextFreeLoc--;
        }
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

        return "CustomizedArrayList[" + data + " ]";
    }

}