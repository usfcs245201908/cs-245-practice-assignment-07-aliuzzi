public class LinkedList<T> implements List<T> {
    Node<T> head;
    int size;

    public LinkedList(){
        head = null;
        size = 0;
    }
    public void add(int pos, Object item) throws IndexOutOfBoundsException{
        if(pos > size || pos < 0){
            throw new IndexOutOfBoundsException();
        }
        if(pos == 0){
            Node<T> current = new Node<T>(item);
            current.setNext(head);
            head = current;
            ++size;
        }
        else {
            Node<T> current = new Node<T>(item);
            Node<T> prev =head;
            for(int i=0; i<pos-1; i++){
                prev = prev.getNext();
            }
            current.setNext(prev.getNext());
            prev.setNext(current);
            ++size;
        }
    }

    public void add(Object item){
        if(head == null){
            head = new Node<T>(item);
            ++size;
        }
        else {
            Node<T> prev = head;
            while(prev.next != null){
                prev = prev.getNext();
            }
            Node<T> curr = new Node<T>(item);
            prev.setNext(curr);
            ++size;
        }
    }
    public T get(int pos) throws IndexOutOfBoundsException{
        if(pos >= size || pos < 0){
            throw new IndexOutOfBoundsException();
        }
        Node<T> prev = head;
        for(int i=0; i<pos; i++){
            prev = prev.getNext();
        }
        return prev.getData();
    }

    public T remove(int pos) throws IndexOutOfBoundsException {
        if(pos > size - 1 || pos < 0){
            throw new IndexOutOfBoundsException();
        }
        if(pos == 0){
            T item = head.getData();
            head = head.getNext();
            size--;
            return item;
        }
        else {
            Node<T> prev = head;
            for(int i=0; i<pos-1; i++){
                prev = prev.getNext();
            }
            Node<T> current = prev.getNext();
            T item = current.getData();
            size--;
            return item;
        }
    }
    public int size(){
        return size;
    }

}
