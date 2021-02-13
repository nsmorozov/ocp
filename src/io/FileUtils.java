package io;

import java.io.*;

public class FileUtils {

    public static String readFromFile(String path) throws IOException {
        StringBuilder s = new StringBuilder();
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader(new File(path)))) {
            while ((line = br.readLine()) != null) {
                s.append(line);
            }
        }
        return s.toString();
    }

    public static void writeToFile(String path, String content) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path)));) {
            bw.write(content);
            bw.newLine();
        }
    }

    public static void createFolders(String[] path){
        for(String f : path) {
            File dir =  new File(f);
            dir.mkdir();
        }
    }
}
