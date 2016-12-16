import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class DataAnalysisChallengeSecondMethod {
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

        scanner = new Scanner(new File("test.txt"));
        scanner.useDelimiter(" *\\n*");
        int oneTestArray[][] = new int[10000][14];
        for (int row = 0; scanner.hasNext() && row < 10000; row++) {
            for (int column = 0; column < 14; column++) {
                oneTestArray[row][column] = Integer.parseInt(scanner.next());
            }
        }
        scanner.close();

        scanner = new Scanner(new File("test.txt"));
        scanner.useDelimiter(" *\\n*");
        int twoTestArray[][] = new int[10000][14];
        for (int row = 0; scanner.hasNext() && row < 10000; row++) {
            for (int column = 0; column < 14; column++) {
                twoTestArray[row][column] = Integer.parseInt(scanner.next());
            }
        }
        scanner.close();

        int same;
        int positionOfMissingValue;
        int valueInMissingPosition;

        int oneCount;
        int twoCount;

        for (int i = 0; i < testArray.length; i++) {//10000
            oneCount = 0;
            twoCount = 0;
            for (int j = 0; j < trainArray.length; j++) {//500
                for (int k = 0; k < 14; k++) {
                    if (testArray[i][k]==0) {
                        //record k
//                        positionOfMissingValue = k;
                        oneTestArray[i][k] = 1;
                        twoTestArray[i][k] = 2;
                        break;
                    }
                }
                if (Arrays.equals(oneTestArray[i],trainArray[j])) {
                    oneCount++;
                }
                if (Arrays.equals(twoTestArray[i],trainArray[j])) {
                    twoCount++;
                }
            }
            if (oneCount > twoCount) {
                testArray[i] = oneTestArray[i];
            } else if (oneCount < twoCount) {
                testArray[i] = twoTestArray[i];
            } else {
                testArray[i] = oneTestArray[i];
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

//        for (int i = 0; i < testArray.length; i++) {//10000
//                for (int k = 0; k < 14; k++) {
//                    if (testArray[i][k]==0) {
//                        //record k
//                        positionOfMissingValue = k;
//                        trainArray[i][k] = 1;
//                    }
//                }
//        }

//        for (int i = 0; i < testArray.length; i++) {//10000
//            for (int j = 0; j < 500; j++) {
//
//                    if (Arrays.equals(testArray[i],trainArray[j])) {
//
//                    }
//
//            }
//        }
    }
}
