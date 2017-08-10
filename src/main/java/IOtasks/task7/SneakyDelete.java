package IOtasks.task7;

import IOtasks.GeneralUtilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SneakyDelete {
    public static void justDelete(String fileName) {
        File file = new File(fileName);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            String s;
            StringBuilder mainBuilder = new StringBuilder();

            while ((s = in.readLine()) != null) {
                int count = 0, i = 0;
                String gW="[\\p{L}\\p{N}-]";
                String regexWord = "(?<!"+gW+")("+gW+"{3,5})(?!"+gW+")";
                Pattern pattern = Pattern.compile(regexWord);
                Matcher m = pattern.matcher(s);
                StringBuffer sb = new StringBuffer();
                while (m.find()) count++;
                count = (count / 2) * 2;
                Matcher m2 = pattern.matcher(s);
                while (m2.find()) {
                    if (i<count)m2.appendReplacement(sb, "");
                    i++;
                }
                String row=sb.toString();
                mainBuilder.append(row).append("\n");
            }
            Path writeTo = Paths.get(fileName);
            GeneralUtilities.write(writeTo.getParent().toString() + "/doDelete.txt", mainBuilder.toString());
        } catch (IOException ignored) {
            throw new RuntimeException(ignored);
        }
    }
}
