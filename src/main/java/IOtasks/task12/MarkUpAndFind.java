package IOtasks.task12;

import IOtasks.GeneralUtilities;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.StringJoiner;

public class MarkUpAndFind {
    public static void markUp(String fileName) {
        String text = GeneralUtilities.readAllLines(fileName);
        StringJoiner sj = new StringJoiner("\n");
        String[] strings = text.split("\n");
        String regex = "[\\p{L}\\p{N}-]+";

        for (String string : strings) {
            string = string.replaceAll(regex, "|$0|");
        }

        Arrays.stream(strings).forEach(sj::add);

        Path writeTo = Paths.get(fileName);
        GeneralUtilities.write(writeTo.getParent().toString() + "/markUp.txt", sj.toString());
    }
}

