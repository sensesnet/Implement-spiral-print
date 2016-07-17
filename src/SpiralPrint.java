import java.util.*;

/**
 * Created by KIRILL on 16.07.2016.
 */
public class SpiralPrint {

    public void PrintSpiral(int M, int N, ArrayList<ArrayList<Integer>> array) {

        int p = N / 2, stl = 0, str = 0; // stl - i; str - j; p - number of turns a[i,j];
        int k = 0, maxj = M,
                maxi = N;    //used maxi; maxj - because it is the third and fourth cycle needs a constant of maximum
        int numOfElem = N*M, stop=0;

        // used k - so as not to drop into on old element .
        do {

            for (int j = str; j < M; j++) {
                if(stop == numOfElem) break;
                int i = stl;
                System.out.print("a[" + i + "," + j + "] = " + array.get(j).get(i) + "; ");
                stop++;

            }

            for (int i = stl + 1; i < N; i++) {
                if(stop == numOfElem) break;
                int j = M - 1;
                System.out.print("a[" + i + "," + j + "] = " + array.get(j).get(i) + "; ");
                stop++;

            }

            for (int j = maxj - 2 - stl; j >= k; j--) {
                if(stop == numOfElem) break;
                int i = N - 1;
                System.out.print("a[" + i + "," + j + "] = " + array.get(j).get(i) + "; ");
                stop++;

            }

            for (int i = maxi - 2 - str; i > k; i--) {
                if(stop == numOfElem) break;
                int j = str;
                System.out.print("a[" + i + "," + j + "] = " + array.get(j).get(i) + "; ");
                stop++;

            }

            N--;
            M--;
            str++;
            stl++;
            k++;
        } while (N > p);
    }


    public static void main(String[] arg) {

        Scanner input = new Scanner(System.in);

        System.out.print("Set number of column" + '\n'
                + " M  =  ");
        int M = input.nextInt();                                // read numbers rows and columns

        System.out.print("Set number of row" + '\n'
                + " N  =  ");
        int N = input.nextInt();

        ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();

        //________________________________________________________________________________________
        System.out.print("Set values into the matrix ( 1 - Random; 2 - Manually) " + '\n'
                + " Choose 1 or 2  =  ");
        int S = input.nextInt();

        if (S == 1) {

            for (int i = 0; i < M; i++) {
                ArrayList row = new ArrayList<>();
                for (int j = 0; j < N; j++) {
                    Random random = new Random();
                    // generate a number from 10 to 100
                    row.add(random.nextInt(90) + 10);
                }
                array.add(row);
            }
        }                                                       //Initialize array

        if (S == 2) {

            for (int i = 0; i < M; i++) {
                ArrayList row = new ArrayList<>();
                for (int j = 0; j < N; j++) {
                    System.out.println("Set value [" + i + "]" + "[" + j + "] =");
                    int val = input.nextInt();
                    row.add(val);
                }
                array.add(row);
            }
        }
        //___________________________________________________________________________________________

        // output
        System.out.println("_ matrix _");

        for (int j = 0; j < N; j++)
            for (int i = 0; i < M; i++) {
                System.out.print(array.get(i).get(j) + " | ");
                if (i == M - 1) {
                    System.out.println("  ");
                }

            }

        // prints out the numbers in the matrix in a spiral fashion
        SpiralPrint p = new SpiralPrint();
        p.PrintSpiral(M, N, array);

    }
}
