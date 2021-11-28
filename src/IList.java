import java.util.Iterator;

public interface IList<T> extends Iterable{
    void add(T i);
    void add(int i, T t);
    T set(int i, T t);
    T get(int i) throws IndexOutOfBoundsException;
    int size();
    T remove(int i);
    boolean remove(T t);
    boolean isEmpty();
    boolean contains(T t);
    Iterator<T> iterator();
}
