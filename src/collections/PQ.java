package collections;

import java.util.Comparator;

public class PQ {

    static class PQsort implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
}
