public interface IDoublyLinkedList<T> {
    void addAtFirst(T item);

    void addAtLast(T item);

    void removeAtFirst();

    void removeAtLast();

    void remove(T item);

    boolean search(T item);

    int size();

    boolean isEmpty();
}