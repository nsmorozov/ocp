package collections;

import io.Dog;

import java.util.Comparator;

public class DogSort implements Comparator<Dog> {

    @Override
    public int compare(Dog o1, Dog o2) {
        return Integer.compare(o1.getDogSize(), o2.getDogSize());
    }
}
