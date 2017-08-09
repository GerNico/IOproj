package IOtasks.task8;

import IOtasks.GeneralUtilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RemoveTabesAndSpaces {
    public static void justDelete(String fileName) {
        File file = new File(fileName);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            String s;
            String regex = "[\\t]|(( ){2,})|(( ){2,})";
            StringBuilder mainBuilder = new StringBuilder();

            while ((s = in.readLine()) != null) {
                mainBuilder.append(s.replaceAll(regex,"")).append("\n");
            }
            Path writeTo = Paths.get(fileName);
            GeneralUtilities.write(writeTo.getParent().toString() + "/trim.txt", mainBuilder.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
