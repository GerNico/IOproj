package IOtasks.task2;

import IOtasks.GeneralUtilities;

import java.io.*;

public class PublicToPrivate {

    public static void replacer(String fileName)  {
        StringBuilder sb = new StringBuilder();

        File file = new File(fileName);

        try {
            try (BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
                String fileInString = sb.toString();

                fileInString = fileInString.replaceAll("public", "private");
                GeneralUtilities.write(fileName + "_puToPr", fileInString);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
