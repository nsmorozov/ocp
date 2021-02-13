package io;

import lombok.Data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@Data
public class Dog implements Serializable {

    private Collar collar;
    private transient Owner owner;
    private int dogSize;

    public Dog(Collar collar, int dogSize, Owner owner) {
        this.collar = collar;
        this.dogSize = dogSize;
        this.owner = owner;
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
}
