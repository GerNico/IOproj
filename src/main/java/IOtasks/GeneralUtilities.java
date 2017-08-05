package IOtasks;

import java.io.*;

public abstract class GeneralUtilities {
    public static void write(String fileName, String text) {
        File file = new File(fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            try (PrintWriter out = new PrintWriter(file.getAbsoluteFile())) {
                out.print(text);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void clearIfExists(String s){
        File file = new File(s);
        if (file.exists()) {file.delete();}
    }

    public static String readAllLines(String fileName) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        File file = new File( fileName);

        try {
            try (BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
