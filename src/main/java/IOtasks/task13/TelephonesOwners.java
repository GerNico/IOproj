package IOtasks.task13;

import IOtasks.GeneralUtilities;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelephonesOwners {
    public static void telephonesStartingOnTwoNumbersInPattern(String fileName,int d1,int d2) {
        d1=d1%10;d2=d2%10;
        String data = GeneralUtilities.readAllLines(fileName);
        String[] lines = data.split("\n");
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("\\(\\d{3}\\) " + d1 + d2 + "\\d*");
        for (String line : lines) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                sb.append(line).append("\n");
            }
        }
        Path writeTo = Paths.get(fileName);
        GeneralUtilities.write(writeTo.getParent().toString() + "/theDudes.txt", sb.toString());
}}
