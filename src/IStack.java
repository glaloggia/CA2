public interface IStack<T> {
    T push(T object);
    T pop();
    T peek();
    boolean empty();
}
