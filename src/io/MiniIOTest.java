package io;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.*;

public class MiniIOTest {
    public static final String TEST_INPUT = "resources/input.dat";
    public static final String TEST_OUTPUT = "resources/output.dat";
    public static final String TEST_OUTPUT_STRING = "Let me output something";

    public MiniIOTest() {
    }

    @Test
    public void readFromFile() throws IOException {
        System.out.println(readFromFile(TEST_INPUT));
        assertThat(readFromFile(TEST_INPUT)).isNotNull();
    }

    @Test
    public void writeToFile() throws IOException {
        writeToFile(TEST_OUTPUT, TEST_OUTPUT_STRING);
        assertThat(readFromFile(TEST_OUTPUT)).as("File should contain string").isEqualTo(TEST_OUTPUT_STRING);
    }

    private String readFromFile(String path) throws IOException {
        StringBuilder s = new StringBuilder();
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader(new File(path)))) {
            while ((line = br.readLine()) != null) {
                s.append(line);
            }
        }
        return s.toString();
    }

    private void writeToFile(String path, String content) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path)));) {
            bw.write(content);
            bw.newLine();
        }
    }
}
