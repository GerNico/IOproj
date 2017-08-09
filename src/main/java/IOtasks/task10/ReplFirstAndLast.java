package IOtasks.task10;

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

public class ReplFirstAndLast {
    public static void replaceFirstAndLast(String fileName) {
        String text = GeneralUtilities.readAllLines(fileName);
        StringJoiner sj = new StringJoiner("\n");
        String[] strings = text.split("\n");

        Function<String, String> replaceWords = string -> {
            List<String> words=new ArrayList<>();
            String regex = "[\\p{L}\\p{N}-]+";
            Matcher reMatcher= Pattern.compile(regex).matcher(string);
            while (reMatcher.find()) {
                words.add(reMatcher.group());
            }
            if (words.size()>1){
            string = string.replaceFirst(words.get(words.size() - 1), words.get(0));
            string = string.replaceFirst(words.get(0), words.get(words.size() - 1));}
            return string;
        };

        Arrays.stream(strings).map(replaceWords).forEach(sj::add);

        Path writeTo = Paths.get(fileName);
        GeneralUtilities.write(writeTo.getParent().toString() + "/replace.txt", sj.toString());
    }
}
