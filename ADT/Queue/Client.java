public class Client {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(8);
        queue.enqueue(3);
        queue.enqueue(7);
        queue.enqueue(6);
        queue.enqueue(9);
        System.out.println("After");
        queue.forEach(System.out::println);
        System.out.println("Remove the least recently added item: " + queue.dequeue());
        System.out.println("Remove the least recently added item: " + queue.dequeue());
        System.out.println("Before");
        queue.forEach(System.out::println);

    }
}