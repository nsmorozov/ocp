package io;

import lombok.Data;

import java.io.Serializable;

@Data
public class Collar implements Serializable {

    private final int collarSize;

    public Collar(int collarSize) {
        this.collarSize = collarSize;
    }
}
