package IOtasks.task9;

import IOtasks.GeneralUtilities;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.regex.Pattern;

public class RemoveComments {
    public static void justDelete(String fileName) {
        String lineComment = "//.*|/\\*(.*)\\*/";
        String blockComment = "/\\*(.*)\\*/";
        String docComment = "(^/\\*\\*)|(.\\**?\\*+/$)|^\\s\\*.*";
        String comments = lineComment + "|" + blockComment + "|" + docComment;
        Pattern pattern=Pattern.compile(comments,Pattern.DOTALL | Pattern.MULTILINE);
        String[] text=GeneralUtilities.readAllLines(fileName).split("\n");
        StringJoiner sj=new StringJoiner("\n");
        Arrays.stream(text).map(line->line=line.replaceAll(comments,"")).forEach(sj::add);
        Path writeTo = Paths.get(fileName);
        GeneralUtilities.write(writeTo.getParent().toString() + "/replace.txt", sj.toString().trim());
    }
}
