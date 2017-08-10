package IOtasks.task16;

import IOtasks.GeneralUtilities;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFinder {
    public static void findAndSaveToFile(String fileName,String targetString) {
        String text = GeneralUtilities.readAllLines(fileName);
        StringJoiner sf = new StringJoiner("\n");
        String[] strings = text.split("\n");
        Pattern pattern =Pattern.compile(targetString);

        for (int i=0;i<strings.length;i++) {
        Matcher matcher=pattern.matcher(strings[i]);
        while (matcher.find()){sf.add("string №"+(i+1)+" contains it");}
        }

        Path writeTo = Paths.get(fileName);
        GeneralUtilities.write(writeTo.getParent().toString() + "/found.txt", sf.toString());
    }
}
