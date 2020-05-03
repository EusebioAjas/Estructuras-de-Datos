import java.util.Iterator;

public class Bag<T> implements Iterable<T> {

    private Node<T> first;

    public void add(T item) {
        Node<T> oldfirst = first;
        first = new Node<T>();
        first.setItem(item);
        first.setNext(oldfirst);
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
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