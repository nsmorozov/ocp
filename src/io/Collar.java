package io;

import lombok.Data;

import java.io.Serializable;

@Data
public class Collar implements Serializable, Comparable<Collar> {

    private final int collarSize;

    public Collar(int collarSize) {
        this.collarSize = collarSize;
    }

    @Override
    public int compareTo(Collar o) {
        return Integer.compare(collarSize, o.collarSize);
    }
}
