import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class example {
//comment
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("train.txt"));
        scanner.useDelimiter(" *\\n*");
        int ntrain = 500;
        int matrix[][] = new int[ntrain][14];
        double avgColumn[] = new double[14];
        for(int row=0; scanner.hasNext() && row<ntrain; row++) {
            for(int i=0; i<14; i++)
                matrix[row][i] = Integer.parseInt(scanner.next());
        }
        for(int row=0; row<ntrain; row++) {
            for(int i=0; i<14; i++) {
                avgColumn[i] += matrix[row][i];
            }
        }
        scanner.close();
        scanner = new Scanner(new File("test.txt"));
        scanner.useDelimiter(" *\\n*");
        for(int row=0; scanner.hasNext(); row++) {
            for(int i=0; i<14; i++) {
                int tmp = Integer.parseInt(scanner.next());
                if(tmp != 0) System.out.print(tmp);
                else {
                    System.out.print(avgColumn[i]/ntrain); //Average of column of train.txt
                }
                if(i<13) System.out.print(" ");
            }
            System.out.println("");
        }
        scanner.close();
        //commentFromMacPro
        //comment
        //comment
        //comment
        //2222223333344444446666666
    }
}
