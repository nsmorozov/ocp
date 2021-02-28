package collections;

import io.Collar;
import io.Dog;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    public void convertArraysList() {
        String[] sa = {"one", "two", "three", "four"};
        List list = Arrays.asList(sa);
        assertThat(sa.length).isEqualTo(list.size());
        sa[1] = "2";
        assertThat(list.get(1)).as("List element should be also updated").isEqualTo("2");
    }

    @Test
    public void listIterator() {
        List<String> sa = new ArrayList<>();
        sa.add("one");
        sa.add("two");
        sa.add("tree");
        sa.add("four");

        Iterator<String> iterator = sa.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void useTreeSets() {
        Set s = new TreeSet();
        s.add(new Collar(2));
        s.add(new Collar(1));
        s.add(new Collar(3));
        s.add(new Collar(1));
        assertThat(s.size()).as("No duplicates allowed").isEqualTo(3);
    }

    @Test
    public void useMaps() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("c1", new Collar(5));
        map.put("c2", new Collar(2));
        map.put("d1", Dog.getRandom());
        map.put("d2", Dog.getRandom());
        map.put("cat1", new Cat());
        map.put(new Cat(), "cat2");
        map.put(new ImprovedCat(), "ImprovedCat");
        assertThat(map.get(new Cat())).as("Should be null as doesn't implement hashCode() and equals()").isEqualTo(null);
        assertThat(map.get(new ImprovedCat())).as("Shouldn't be null").isEqualTo("ImprovedCat");
    }

    @Test
    public void useNavigation() {
        TreeSet<Integer> time = new TreeSet<>();
        time.add(0);
        time.add(5);
        time.add(7);
        time.add(11);
        time.add(22);
        SortedSet<Integer> subset = time.subSet(1,11);
        subset.add(6);
        assertThat(time).as("Original collection should get the entry from a subset").contains(6);
        time.add(4);
        assertThat(subset).as("Subset should get the entry from original").contains(4);
    }
}
