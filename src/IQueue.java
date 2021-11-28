public interface IQueue<T>{
    void enque(T object);
    T dequeue();
    T firt();
    boolean empty();
}
