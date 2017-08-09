package IOtasks.task9;

import IOtasks.GeneralUtilities;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveComments {
    public static void justDelete(String fileName) {
        String regex = "(/\\*)+([\\r?\\n]|([^*/]|[\\r?\\n]))*(\\*//*)+";
        Pattern pattern=Pattern.compile(regex);
        String s;
        StringBuilder mainBuilder = new StringBuilder();
        try {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        while ((s = in.readLine()) != null) {
            StringBuffer sb=new StringBuffer();
            Matcher m2 = pattern.matcher(s);
            while (m2.find()) {
                m2.appendReplacement(sb, "");
            }
            String row=sb.toString();
            mainBuilder.append(row).append("\n");
        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Path writeTo = Paths.get(fileName);
        GeneralUtilities.write(writeTo.getParent().toString() + "/replace.txt", mainBuilder.toString());
    }
}
