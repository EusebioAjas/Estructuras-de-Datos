
import java.util.Iterator;

public class Queue<T> implements IQueue<T>, Iterable<T> {
    private Node<T> first;
    private Node<T> last;
    private int N;

    @Override
    public void enqueue(T item) {
        Node<T> oldLast = last;
        last = new Node<T>();
        last.setItem(item);
        last.setNext(null);
        if (isEmpty()) first = last;
        else oldLast.setNext(last);
        N++;
    }

    @Override
    public T dequeue() {
        T item = first.getItem();
        first = first.getNext();
        if(isEmpty()) last = null;
        N--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T>{
        private Node<T> current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.getItem();
            current = current.getNext();
            return item;
        }
    }
}