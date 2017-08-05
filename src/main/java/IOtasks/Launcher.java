package IOtasks;

import IOtasks.task1.CreateAndSort;
import IOtasks.task2.PublicToPrivate;
import IOtasks.task3.StringReversed;
import IOtasks.task4.LittleToBig;

public class Launcher {
    public static void main(String[] args) {
//                      First Task
        CreateAndSort.createRandNumFile("src/main/java/IOtasks/task1/randomNumbers");
        CreateAndSort.readAllIntsAndSort("src/main/java/IOtasks/task1/randomNumbers");
//                      Second Task
        GeneralUtilities.clearIfExists("src/main/java/IOtasks/task2/test_puToPr");
        PublicToPrivate.replacer("src/main/java/IOtasks/task2/test");
//                      Third Task
        GeneralUtilities.clearIfExists("src/main/java/IOtasks/task3/someText_rev");
        StringReversed.reversed("src/main/java/IOtasks/task3/someText");
//                      Fourth Task
        GeneralUtilities.clearIfExists("src/main/java/IOtasks/task4/someText_bigLittle");
        LittleToBig.littleToBig("src/main/java/IOtasks/task4/someText");
    }
}
