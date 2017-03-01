import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class DataAnalysisChallenge {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("train.txt"));
        scanner.useDelimiter(" *\\n*");
        int ntrain = 500;
        int trainArray[][] = new int[500][14];
        for(int row=0; scanner.hasNext() && row<500; row++) {
            for(int column=0; column<14; column++)
                trainArray[row][column] = Integer.parseInt(scanner.next());
        }
        scanner.close();

        scanner = new Scanner(new File("test.txt"));
        scanner.useDelimiter(" *\\n*");
        int testArray[][] = new int[10000][14];
        for (int row = 0; scanner.hasNext() && row < 10000; row++) {
            for (int column = 0; column < 14; column++) {
                testArray[row][column] = Integer.parseInt(scanner.next());
            }
        }
        scanner.close();

        int same;
        int positionOfMissingValue;
        int valueInMissingPosition;
//        List<Integer> listOfValuesInMissingPosition = new ArrayList<Integer>();
        List<LinkedList> arrayListOfLinkedLists;
        LinkedList<Integer> linkedList;
        for (int i = 0; i < testArray.length; i++) {//10000
            arrayListOfLinkedLists  = new ArrayList<LinkedList>();
            for (int j = 0; j < trainArray.length; j++) {//500
                linkedList = new LinkedList<Integer>();
                same = 0;
                positionOfMissingValue = 0;
                valueInMissingPosition = 0;
                for (int k = 0; k < 14; k++) {
                    if (testArray[i][k]==0) {
                        //record k
                        positionOfMissingValue = k;
                        valueInMissingPosition = trainArray[j][positionOfMissingValue];
//                        listOfValuesInMissingPosition.add(valueInMissingPosition);
                    } else if ((testArray[i][k]!=0) && (testArray[i][k]==trainArray[j][k])) {
                        same++;
                    }
                }
                linkedList.add(j);
                linkedList.add(same);
                linkedList.add(valueInMissingPosition);
                linkedList.add(positionOfMissingValue);
                arrayListOfLinkedLists.add(linkedList);
            }
            int countOne = 0;
            int countTwo = 0;
            int highestSame = 0;
            //find the highest among the 500
            for (int row = 0; row < arrayListOfLinkedLists.size(); row++) {
                    highestSame = Integer.parseInt(arrayListOfLinkedLists.get(0).get(1).toString());
                if (Integer.parseInt(arrayListOfLinkedLists.get(row).get(1).toString()) > highestSame) {
                    highestSame = (Integer.parseInt(arrayListOfLinkedLists.get(row).get(1).toString()));
                }
            }
            for (int row = 0; row < 500; row++) {
                if (Integer.parseInt(arrayListOfLinkedLists.get(row).get(1).toString()) == highestSame) {
                    if (Integer.parseInt(arrayListOfLinkedLists.get(row).get(2).toString()) == 1) {
                        countOne++;
                    } else if (Integer.parseInt(arrayListOfLinkedLists.get(row).get(2).toString()) == 2) {
                        countTwo++;
                    }
                }
            }
            for (int row = 0; row < 500; row++) {
                if (countOne > countTwo) {
                    testArray[i][Integer.parseInt(arrayListOfLinkedLists.get(row).get(3).toString())] = 1;
                } else if (countOne < countTwo) {
                    testArray[i][Integer.parseInt(arrayListOfLinkedLists.get(row).get(3).toString())] = 2;
                } else if (countOne == countTwo) {
                    int numberOfOnesInARow = 0;
                    int numberOfTwosInARow = 0;
                    for (int column = 0; column < 14; column++) {
                        if (testArray[i][column] == 1) {
                            numberOfOnesInARow++;
                        } else {
                            numberOfTwosInARow++;
                        }
                        if (numberOfOnesInARow > numberOfTwosInARow) {
                            testArray[i][Integer.parseInt(arrayListOfLinkedLists.get(row).get(3).toString())] = 1;
                        } else if (numberOfOnesInARow < numberOfTwosInARow) {
                            testArray[i][Integer.parseInt(arrayListOfLinkedLists.get(row).get(3).toString())] = 2;
                        } else {
                            testArray[i][Integer.parseInt(arrayListOfLinkedLists.get(row).get(3).toString())] = 1;
                        }
                    }
//                  setting one or two has not effect on the score
//                    testArray[i][Integer.parseInt(arrayListOfLinkedLists.get(row).get(3).toString())] = 2;
                }
            }
        }
        for(int i = 0; i<10000; i++)
        {
            for(int j = 0; j<14; j++)
            {
                System.out.print(testArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
