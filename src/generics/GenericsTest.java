package generics;

import org.junit.jupiter.api.Test;

import java.util.List;

public class GenericsTest {

    @Test
    public void testAccount() {
        Account<Integer, Double> acc1 = new Account<>(2334, 5000.0);
        int acc1Id = acc1.getId();
        System.out.println(acc1Id);
        Account<String, Long> acc2 = new Account<>("sid5523", 500L);
        String acc2Id = acc2.getId();
        System.out.println(acc2Id);
        acc1.changeInfo(1,2.0);
    }

    @Test
    public void testGenericMethod() {
        Printer printer = new Printer();
        String[] people = {"Tom", "Alice", "Sam", "Kate", "Bob", "Helen"};
        Integer[] numbers = {23, 4, 5, 2, 13, 456, 4};
        printer.print(people);
        printer.print(numbers);
    }

    @Test
    public void testGenericWildCards() {
        List<Car> cars = List.of(new Car(), new Car());
        List<Vehicle> vehicles = List.of(new Vehicle(), new Vehicle());
        printColors(cars);
        printColors(vehicles);
    }

    private void printColors(List<? super Car> items) {
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i));
        }
    }

}
