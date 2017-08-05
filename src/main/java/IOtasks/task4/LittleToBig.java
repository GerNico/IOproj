package IOtasks.task4;

import IOtasks.GeneralUtilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LittleToBig {
    public static void littleToBig(String fileName)  {
        StringBuilder sb = new StringBuilder();

        File file = new File(fileName);

        try {
            try (BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {
                String s;
                while ((s = in.readLine()) != null) {
                    for (String word:s.split(" ")){
                     if (word.length()>2)sb.append(" ").append(word.toUpperCase());
                     else sb.append(" ").append(word);
                    }
                    sb.append("\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        GeneralUtilities.write(fileName+"_bigLittle",sb.toString());
    }
}
