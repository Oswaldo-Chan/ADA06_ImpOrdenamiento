public class DoublyLink<T> {
    
    public T data;
    public DoublyLink<T> next; 
    public DoublyLink<T> previous;

    public DoublyLink(T d) {
        data = d;
    }

    public T getData() {
        return data;
    }
} 