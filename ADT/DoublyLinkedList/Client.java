public class Client {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> numbers = new DoublyLinkedList<>();
        System.out.println("is Empty? "+numbers.isEmpty());

        numbers.addAtLast(12);
        numbers.addAtFirst(8);
        numbers.addAtFirst(2);
        numbers.addAtFirst(1);
        numbers.addAtFirst(6);
        numbers.addAtLast(5);
        numbers.addAtLast(9);

        System.out.println("Before");
        numbers.forEach(System.out::println);

        numbers.removeAtFirst();
        numbers.remove(9);
        numbers.removeAtLast();
        System.out.println("After");
        numbers.forEach(System.out::println);

        System.out.println("Exist 7? "+numbers.search(7));
        System.out.println("Exist 2? "+numbers.search(2));

        System.out.println("is Empty? "+numbers.isEmpty());
        System.out.println("size: "+numbers.size());
    }
}