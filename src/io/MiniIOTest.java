package io;

import org.junit.jupiter.api.Test;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MiniIOTest {

    public static final String TEST_INPUT = "resources/input.dat";
    public static final String TEST_OUTPUT = "resources/output.dat";
    public static final String TEST_OUTPUT_STRING = "Let me output something";
    final private String saveFile = "dog.sav";
    int dogSize = 5;
    int collarSize = 1;

    public MiniIOTest() {
    }

    @Test
    public void readFromFile() throws IOException {
        System.out.println(FileUtils.readFromFile(TEST_INPUT));
        assertThat(FileUtils.readFromFile(TEST_INPUT)).isNotNull();
    }

    @Test
    public void writeToFile() throws IOException {
        FileUtils.writeToFile(TEST_OUTPUT, TEST_OUTPUT_STRING);
        assertThat(FileUtils.readFromFile(TEST_OUTPUT)).as("File should contain string").isEqualTo(TEST_OUTPUT_STRING);
    }

    @Test
    public void serializeData() {
        Dog d = new Dog(new Collar(collarSize), dogSize, new Owner("Max"));
        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(saveFile));
            o.writeObject(d);
            o.close();
        }
        catch (IOException io) {
            io.getStackTrace();
        }
    }

    @Test
    public void deserializeData() throws IOException, ClassNotFoundException {
        ObjectInputStream i = new ObjectInputStream(new FileInputStream(saveFile));
        Dog d2 = (Dog) i.readObject();
        System.out.printf("Dog size %d collar size %d owner name %s", d2.getDogSize(), d2.getCollar().getCollarSize(), d2.getOwner().getName());
        assertThat(d2.getDogSize()).as("Compare deserialized value of dog").isEqualTo(dogSize);
        assertThat(d2.getCollar().getCollarSize()).as("Compare deserialized value of collar").isEqualTo(collarSize);
    }

    @Test
    public void testPath() {
//        C:\Users\NMorozov\IdeaProjects\ocp\dog.sav
        Path p = Paths.get(saveFile);
        assertThat(Files.exists(p)).isTrue();
    }

    @Test
    public void testBackupFiles() throws IOException {
        Path fileToSave  = Paths.get(saveFile);
        Path destinationFile = Paths.get("backup", LocalDate.now().toString(), format("%s.bak", LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH-mm-ss"))));
        Files.createDirectories(destinationFile.getParent());
        Files.createFile(destinationFile);
        Files.copy(fileToSave, destinationFile, StandardCopyOption.REPLACE_EXISTING);
        System.out.printf("File size is: " + Files.size(destinationFile));
        assertThat(Files.size(destinationFile)).isGreaterThan(0);
    }

    @Test
    public void pathResovle() {
        Path p1 =  Paths.get("/home/java/");
        Path p2 = Paths.get("java/models/Model.pdf");
        Path path = p1.resolve(p2);
        System.out.printf(String.valueOf(path));
    }
}
