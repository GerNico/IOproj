package IOtasks;

import IOtasks.task1.CreateAndSort;
import IOtasks.task10.ReplFirstAndLast;
import IOtasks.task11.SelectWordsFromStrings;
import IOtasks.task12.MarkUpAndFind;
import IOtasks.task13.TelephonesOwners;
import IOtasks.task14.TransponeMatrix;
import IOtasks.task15.RotateMatrix;
import IOtasks.task16.StringFinder;
import IOtasks.task2.PublicToPrivate;
import IOtasks.task3.StringReversed;
import IOtasks.task4.LittleToBig;
import IOtasks.task5.MarkUp;
import IOtasks.task6.RecognizeData;
import IOtasks.task7.SneakyDelete;
import IOtasks.task8.RemoveTabesAndSpaces;
import IOtasks.task9.RemoveComments;

public class Launcher {
    public static void main(String[] args) {
//                      First Task
        String baseDir = "src/main/java/IOtasks/";
        CreateAndSort.createRandNumFile(baseDir +"task1/randomNumbers");
        CreateAndSort.readAllIntsAndSort(baseDir +"task1/randomNumbers");
//                      Second Task
        GeneralUtilities.clearIfExists(baseDir +"task2/test_puToPr");
        PublicToPrivate.replacer(baseDir +"task2/test");
//                      Third Task
        GeneralUtilities.clearIfExists(baseDir +"task3/someText_rev");
        StringReversed.reversed(baseDir +"task3/someText");
//                      Fourth Task
        GeneralUtilities.clearIfExists(baseDir +"task4/someText_bigLittle");
        LittleToBig.littleToBig(baseDir +"task4/someText");
//                      Task Fifth
        GeneralUtilities.clearIfExists(baseDir +"task5/marks");
        MarkUp.createMarks(baseDir +"task5/marks");
        MarkUp.markBest(baseDir +"task5/marks",7);
//                      Task Six
        GeneralUtilities.clearIfExists(baseDir +"task6/ordered.txt");
        RecognizeData.parseDifferentTypes(baseDir +"task6/initial.txt");
//                      Task Seven
        GeneralUtilities.clearIfExists(baseDir +"task7/doDelete.txt");
        SneakyDelete.justDelete(baseDir +"task7/some.txt");
//                      Task Eight
        GeneralUtilities.clearIfExists(baseDir +"task8/doDelete.txt");
        RemoveTabesAndSpaces.justDelete(baseDir +"task8/someText");
//                      Task Nine
        GeneralUtilities.clearIfExists(baseDir +"task9/replace.txt");
        RemoveComments.justDelete(baseDir +"task9/psevdoCode.txt");
//                      Task Ten
        GeneralUtilities.clearIfExists(baseDir +"task10/replace.txt");
        ReplFirstAndLast.replaceFirstAndLast(baseDir +"task10/some.txt");
//                              Task Eleven
        GeneralUtilities.clearIfExists(baseDir +"task11/wordsInLines.txt");
        SelectWordsFromStrings.selectWords(baseDir +"task11/news.txt",8,5);
//                              Task Twelve
        GeneralUtilities.clearIfExists(baseDir +"task12/markUp.txt");
        MarkUpAndFind.markUp(baseDir +"task12/some.txt",".ight.");
//                              Task Thirteen
        GeneralUtilities.clearIfExists(baseDir +"task13/theDudes.txt");
        TelephonesOwners.telephonesStartingOnTwoNumbersInPattern(baseDir +"task13/dudes.txt",7,0);
//                              Task Fourteen
        GeneralUtilities.clearIfExists(baseDir +"task14/matrices.txt");
        TransponeMatrix.readMatrixAndTranspose(baseDir +"task14/matrix.txt");
//                              Task Fifteen
        GeneralUtilities.clearIfExists(baseDir +"task15/matrices.txt");
        RotateMatrix.readMatrixAndRotate(baseDir +"task15/matrix.txt");
//                                      Task Sixteen
        GeneralUtilities.clearIfExists(baseDir +"task16/found.txt");
        StringFinder.findAndSaveToFile(baseDir +"task16/song.txt","Aux armes, citoyens");
    }
}
