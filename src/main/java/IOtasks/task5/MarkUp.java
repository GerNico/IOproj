package IOtasks.task5;

import IOtasks.GeneralUtilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringJoiner;

public class MarkUp {
    private static String[] names = {"Urbytes","Kimberk","Peck-gray","Joshi","Squires","Pasternack",
            "Hinnant","Markatos","Geer","Camiz","Kirshner","Dozier","Papa","Bettuzzi","Byrne","Mabbett"};

    public static void createMarks(String fileName) {
        StringJoiner rows = new StringJoiner("\n");
        for (String name : names) {
            StringJoiner columns = new StringJoiner("\t");
            columns.add(name);
            int tests = 7;
            for (int i = 0; i < tests; i++) {
                columns.add(String.valueOf((int) (2+Math.random() * 9)));
            }
            rows.add(columns.toString());
        }
        GeneralUtilities.write(fileName, rows.toString());
    }

    public static void markBest(String fileName, int limit) {
        StringBuilder sb = new StringBuilder();
        File file = new File(fileName);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            String s;
            while ((s = in.readLine()) != null) {
                Scanner scanner = new Scanner(s);
                int summ = 0, count = 0;
                String name = scanner.next();
                while (scanner.hasNextInt()) {
                    summ += scanner.nextInt();
                    count++;
                }
                if (count > 0) {
                    if (summ / count >= limit) s = s.replaceAll(name, name.toUpperCase());
                    s=s+"\n";
                } else throw new RuntimeException("bad data task5");
                sb.append(s);
            }
        } catch (IOException ignored) {
        }
        GeneralUtilities.write(fileName + "_best", sb.toString());
    }
}
