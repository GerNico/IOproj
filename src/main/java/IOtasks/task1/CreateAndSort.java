package IOtasks.task1;

import IOtasks.GeneralUtilities;

import java.io.*;
import java.util.*;

public class CreateAndSort {
    public static void createRandNumFile(String name) {
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (int i = 0; i < 1000; i++) {
            stringJoiner.add(String.valueOf((int) (Math.random() * 5000)));
        }
        GeneralUtilities.write(name, stringJoiner.toString());

    }

    public static void readAllIntsAndSort(String fileName)  {
        File file = new File(fileName);

        ArrayList<Integer> ints = new ArrayList<>(5000);

        try {
            Scanner sc = new Scanner(new FileReader(file.getAbsoluteFile()));
            while (sc.hasNextInt()) {
                ints.add(sc.nextInt());
            }
            Collections.sort(ints);
            StringJoiner sj=new StringJoiner(" ");
            for (Integer i:ints) {
                sj.add(i.toString());
            }
            GeneralUtilities.write(fileName+"_new",sj.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
