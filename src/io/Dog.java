package io;

import lombok.Data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

@Data
public class Dog implements Serializable, Comparable<Dog> {

    private Collar collar;
    private transient Owner owner;
    private int dogSize;

    public Dog(Collar collar, int dogSize, Owner owner) {
        this.collar = collar;
        this.dogSize = dogSize;
        this.owner = owner;
    }

    public static Dog getRandom() {
        return new Dog(new Collar((new Random()).nextInt(5)), (new Random()).nextInt(5), new Owner("Oleg"));
    }

    private void writeObject(ObjectOutputStream os) {
        try {
            os.defaultWriteObject();
            os.writeChars(owner.getName());
            os.writeInt(owner.getAge());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream is) {
        try {
            is.defaultReadObject();
            owner = new Owner(is.readLine());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int compareTo(Dog o) {
        return Integer.compare(dogSize, o.getDogSize());
    }
}
