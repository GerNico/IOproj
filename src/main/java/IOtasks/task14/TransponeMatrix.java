package IOtasks.task14;

import IOtasks.GeneralUtilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class TransponeMatrix {
    public static void readMatrixAndTranspose(String fileName) {

        List<List<Double>> matrix = new ArrayList<>();

        StringJoiner sj = new StringJoiner("\n");

        try {
            Scanner scanner = new Scanner(new FileReader(fileName));
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("[ ]+");
                ArrayList<Double> row = new ArrayList<>();
                for (String aLine : line) {
                    row.add(Double.valueOf(aLine));
                }
                matrix.add(row);
            }

            sj.add("Initial matrix");
            sj.add(matrix.toString());

            List<List<Double>> matrixTranspose = new ArrayList<>();
            int n=matrix.size();
            for (int i = 0; i < n; i++) {
                ArrayList<Double> row=new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add(matrix.get(j).get(i));
                }
                matrixTranspose.add(row);
            }

            sj.add("Final matrix");
            sj.add(matrixTranspose.toString());

            Path writeTo = Paths.get(fileName);
            GeneralUtilities.write(writeTo.getParent().toString() + "/matrices.txt", sj.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
