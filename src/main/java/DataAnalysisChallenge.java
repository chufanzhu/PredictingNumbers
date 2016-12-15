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
        List<LinkedList> arrayListOfLinkedLists = new ArrayList<LinkedList>();
        LinkedList<Integer> linkedList;
        Map<int[], Integer> map = new HashMap<int[], Integer>();
        for (int i = 0; i < testArray.length; i++) {//10000
//            System.out.println("i: " + i);
            arrayListOfLinkedLists  = new ArrayList<LinkedList>();
            linkedList = new LinkedList<Integer>();
            for (int j = 0; j < trainArray.length; j++) {//500
                same = 0;
                positionOfMissingValue = 0;
                valueInMissingPosition = 0;
                //map = new HashMap<int[], Integer>();
                for (int k = 0; k < 14; k++) {
                    if (testArray[i][k]==0) {
                        //record k
                        positionOfMissingValue = k;
                        valueInMissingPosition = trainArray[j][positionOfMissingValue];
//                        listOfValuesInMissingPosition.add(valueInMissingPosition);
                    } else if ((testArray[i][k]!=0) && (testArray[i][k]==trainArray[j][k])) {
                        same++;
//                        map.put(trainArray[j],same);

                    }
                    //find highest same
                    //if there is a list of them
                    //compare the occurrences of 1's and 2's
                    //
//                    if (trainArray[j][positionOfMissingValue]==1) {
//
//                        //countOne++
//                    } else if (trainArray[j][k]==positionOfMissingValue) {
//
//                    }
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
//                System.out.println("k: " + k + "column: " + column);
                    highestSame = Integer.parseInt(arrayListOfLinkedLists.get(0).get(1).toString());
//                System.out.println("highestSame: " + highestSame);
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
                } else {
                    testArray[i][Integer.parseInt(arrayListOfLinkedLists.get(row).get(3).toString())] = 1;
                }
            }

//            System.out.println("countOne: " + countOne);
//            System.out.println("countTwo: " + countTwo);
        }
//        System.out.println(map.entrySet());
//        System.out.println(map.size());
//        System.out.println("arrayListOfLinkedLists.size " + arrayListOfLinkedLists.size());
        for(int i = 0; i<10000; i++)
        {
            for(int j = 0; j<14; j++)
            {
                System.out.print(testArray[i][j] + " ");
            }
            if (i!=9999)
            System.out.println();
        }
    }
}
