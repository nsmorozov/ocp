package io;

import lombok.Data;

@Data
public class Owner {
    private String name = "unnamed";
    private int age;

    public Owner(String name) {
        this.name = name;
    }
}
