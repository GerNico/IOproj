package IOtasks.task3;

import IOtasks.GeneralUtilities;

import java.io.*;

public class StringReversed {

    public static void reversed(String fileName) {
        StringBuilder sb = new StringBuilder();

        File file = new File(fileName);

        try {
            try (BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(new StringBuilder(s).reverse().toString());
                    sb.append("\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        GeneralUtilities.write(fileName+"_rev",sb.toString());
    }
}
