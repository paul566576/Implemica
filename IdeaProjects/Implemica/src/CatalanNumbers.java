import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Task number 1

public class CatalanNumbers {
    public static void main(String[] args) throws IOException {
        // make instance of an object

        CatalanNumbers cn = new CatalanNumbers();

        // make BufferedReader for read data from keyboard

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // parse string to number (integer)

        int num = Integer.parseInt(reader.readLine());

        // close reader for system security and optimal use of computer resource

        reader.close();

        //printing results to the console

        System.out.println(cn.getCatalanNumber(num));

    }

    public int getCatalanNumber(int num) {

        // make an array which more than num
        int[] n = new int[num + 1];

        // The first element of array n = 1, but anyone mathematical expression can be ine brackets;
        // for example: a + b * c == (a + b * c)
        n[0] = 1;

        // iteration received number step = 1

        for (int i = 1; i <= num; i++) {

            n[i] = 0;

            // iteration elements of first iteration, step = 1

            for (int j = 0; j < i; j++) {

                // formula for calculating Catalan numbers

                n[i] += n[j] * n[i - 1 - j];
            }
        }
        // return result

            return n[num];
    }
}
