package collections;

import io.Dog;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsTest {

    @Test
    public void testObjectSorting() {
        List<Dog> dogs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dogs.add(Dog.getRandom());
        }
        Collections.sort(dogs);
        System.out.println("end");
    }

    @Test
    public void testObjectSortingUsingComparator() {
        List<Dog> dogs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dogs.add(Dog.getRandom());
        }
        Comparator<Dog> comparator =  new DogSort();
        Collections.sort(dogs, comparator);
        System.out.printf("end");
    }
}
