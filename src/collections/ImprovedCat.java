package collections;

public class ImprovedCat {

    public ImprovedCat() {
    }

    private int size;

    public int hashCode() {
        return 4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImprovedCat that = (ImprovedCat) o;
        return size == that.size;
    }
}
