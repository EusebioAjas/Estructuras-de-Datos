public class Main {
    public static void main(String[] args) {
        Bag<Integer> numbers = new Bag<Integer>();
        numbers.add(8);
        numbers.add(10);
        numbers.add(9);
        numbers.add(2);
        numbers.add(1);

        numbers.forEach(System.out::println);
    }
}