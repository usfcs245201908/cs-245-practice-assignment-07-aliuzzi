public class Node<T> {
    public T data;
    public Node<T> next;

    public Node(Object data){
        this.data = (T) data;
    }

    public T getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = (T) data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

}
