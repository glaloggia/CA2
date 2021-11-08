public interface IList<T> {
    void add(T i);

    T get(int i) throws IndexOutOfBoundsException;

    int size();

    boolean isEmpty();
}
