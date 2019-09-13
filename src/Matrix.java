import com.sun.jdi.IntegerValue;

import java.util.Random;
import java.util.Scanner;

public class Matrix {

    private int[][] matrix;
    private int size;
    private int max;

    private final int GRADER = 99;
    private final int lGrader = -GRADER - 1;

    public void generate() throws NumberFormatException {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a size of the matrix: ");
        size = Integer.parseInt(sc.next());

        final Random rand = new Random();

        System.out.println("Generated matrix:");

        matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = -GRADER + rand.nextInt(GRADER * 2 + 1);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    public int find() {

        int[][] temp = new int[size * size][2];

        for (int i = 0; i < size * size; i++) {
            temp[i][0] = lGrader;
        }

        int pos = 0;
        int test = -1;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                for (int k = 0; k <= pos; k++) {
                    if (matrix[i][j] == temp[k][0]) {
                        test = k;
                        break;
                    }
                }

                if (test >= 0) {
                    temp[test][1]++;
                    test = -1;
                } else {
                    temp[pos][0] = matrix[i][j];
                    temp[pos][1] = 1;
                    pos++;
                }

            }
        }

        max = lGrader;

        for (int i = 0; i < pos; i++) {
            if (temp[i][1] > 1 && temp[i][0] > max) {
                max = temp[i][0];
            }
        }

        return max;
    }

    public void print() {
        if (max > lGrader) {
            System.out.println(max);
        }
        else {
            System.out.println("No repeats");
        }
    }

}
