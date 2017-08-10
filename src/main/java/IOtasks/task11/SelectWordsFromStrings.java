package IOtasks.task11;

import IOtasks.GeneralUtilities;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SelectWordsFromStrings {
    public static void selectWords(String fileName, int nWords, int mLines) {
        String text = GeneralUtilities.readAllLines(fileName);
        StringJoiner sj = new StringJoiner("\n");
        String[] strings = text.split("\n");

        Function<String, String> lastWords = string -> {
            StringJoiner sb = new StringJoiner(" ");
            String regex = "[\\p{L}\\p{N}-]+";
            Matcher matcher = Pattern.compile(regex).matcher(string);
            int count = 0;
            while (matcher.find()) count++;
            int i = 0;
            if (count >= nWords) {
                Matcher reMatcher = Pattern.compile(regex).matcher(string);
                while (reMatcher.find()) {
                    if (i + nWords < count) {
                        i++;
                    } else {
                        sb.add(reMatcher.group());
                    }
                }
            }
            return sb.toString();
        };

        if (strings.length > mLines) {
            for (int i = strings.length - mLines; i < strings.length; i++) {
                    sj.add(lastWords.apply(strings[i]));
            }
        } else {
            Arrays.stream(strings).map(lastWords).forEach(sj::add);
        }

        Path writeTo = Paths.get(fileName);
        GeneralUtilities.write(writeTo.getParent().toString() + "/wordsInLines.txt", sj.toString());
    }
}
