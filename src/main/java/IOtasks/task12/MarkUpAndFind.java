package IOtasks.task12;

import IOtasks.GeneralUtilities;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkUpAndFind {
    public static void markUp(String fileName,String targetPattern) {
        String text = GeneralUtilities.readAllLines(fileName);
        StringJoiner sj = new StringJoiner("\n");
        StringJoiner sf = new StringJoiner("\n");
        String[] strings = text.split("\n");
        String regex = "[\\p{L}\\p{N}-]+";

        for (String string : strings) {
        sj.add(string.replaceAll(regex,"-$0-"));
        }

        Pattern pattern =Pattern.compile(targetPattern);
        Matcher matcher=pattern.matcher(text);
        while (matcher.find()){sf.add(matcher.group());}

        Path writeTo = Paths.get(fileName);
        GeneralUtilities.write(writeTo.getParent().toString() + "/markUp.txt", sj.toString());
        GeneralUtilities.write(writeTo.getParent().toString() + "/found.txt", sf.toString());
    }
}

