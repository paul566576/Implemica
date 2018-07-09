import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

// Task number 3

public class SumOfFactorialDigits {
    public static void main(String[] args) throws IOException {

        // make instance of an object

        SumOfFactorialDigits sfd = new SumOfFactorialDigits();

        // make BufferedReader for read data from keyboard

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // parse string to number (integer)

        int num = Integer.parseInt(reader.readLine());

        // close reader for system security and optimal use of computer resource

        reader.close();

        //printing results to the console

        System.out.println(sfd.getDigitSumOfNumber(sfd.getFactorial(num)));
    }
        // make method, which get int type parameter and return BigInteger
        // (primitive types are too small to store 100!)

    public BigInteger getFactorial(int num) {
        // Factorial must be >= 0
       if (num == 0) return BigInteger.ONE;

       // recursive call with conversion type int to BigInteger

       return getFactorial(num -1).multiply(BigInteger.valueOf(num));
    }
        // make method which find sum of the digits of number

    public int getDigitSumOfNumber(BigInteger bigInteger) {
        int sum = 0;

        // parse BigInteger to string, break up string to separate symbols and add this symbols to array
        String[] str = bigInteger.toString().split("");

        // for each iteration str array
        for (String s : str) {

            // sum parses array elements
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}
