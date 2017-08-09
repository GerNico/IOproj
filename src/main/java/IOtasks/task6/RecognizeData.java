package IOtasks.task6;

import IOtasks.GeneralUtilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecognizeData {
    public static void parseDifferentTypes(String fileName) {
        try {
            Scanner scanner=new Scanner(new FileReader(fileName));
            List<String> strings=new ArrayList<>();
            List<Double> doubles=new ArrayList<>();
            List<Long> longs=new ArrayList<>();
            while (scanner.hasNext()){
                if (scanner.hasNextLong()){longs.add(scanner.nextLong());}else
                if (scanner.hasNextDouble()){doubles.add(scanner.nextDouble());}else
                if (scanner.hasNext()){strings.add(scanner.next());}
            }
            StringBuilder sb=new StringBuilder();
            sb.append("Integer number: ");
            longs.forEach(value-> sb.append(value).append(" "));
            sb.append("\nFloating point: ");
            doubles.forEach(value-> sb.append(value).append(" "));
            sb.append("\nStrings: ");
            strings.forEach(value-> sb.append(value).append(" "));
            Path writeTo= Paths.get(fileName);
            GeneralUtilities.write(writeTo.getParent().toString()+"/ordered.txt",sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
