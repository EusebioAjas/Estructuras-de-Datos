import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements IDoublyLinkedList<T>, Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public void addAtFirst(T item) {
        Node<T> newNode = new Node<T>(item);
        if (isEmpty()) head = tail = newNode;
        else {
            head.setPrev(newNode);
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }

    @Override
    public void addAtLast(T item) {
        Node<T> newNode = new Node<T>(item);
        if (isEmpty()) head = tail = newNode;
        else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
    }

    @Override
    public void removeAtFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        else {
            head = head.getNext();
            head.setPrev(null);
            size--;
        }
    }

    @Override
    public void removeAtLast() {
        if (isEmpty()) throw new NoSuchElementException();
        else {
            tail = tail.getPrev();
            tail.setNext(null);
            size--;
        }
    }

    @Override
    public void remove(T item) {
        if (isEmpty()) throw new NullPointerException();
        else if (item.equals(head.getItem())) removeAtFirst();
        else {
            Node<T> prev = head;
            Node<T> curr = head.getNext();
            while ((curr != null) && !(item.equals(curr.getItem()))) {
                prev = curr;
                curr = curr.getNext();
            }
            if (curr != null && item.equals(curr.getItem())) {
                Node<T> tmp = curr.getNext();
                prev.setNext(tmp);

                if (tmp == null) removeAtLast();
                else {
                    tmp.setPrev(curr.getPrev());
                    size--;
                }
            }
        }
    }

    @Override
    public boolean search(T item) {
        if (!isEmpty()) {
            Node<T> tmp = head;
            while ((tmp != null) && !tmp.getItem().equals(item)) {
                tmp = tmp.getNext();
            }
            return (tmp != null) && (item.equals(tmp.getItem()));
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new IterableDoublyLinkedList();
    }

    public class IterableDoublyLinkedList implements Iterator<T> {
        private Node<T> curr = head;

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public T next() {
            T item = curr.getItem();
            curr = curr.getNext();
            return item;
        }
    }
}