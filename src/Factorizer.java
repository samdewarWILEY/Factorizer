import java.util.Scanner;
import java.util.ArrayList;

public class Factorizer {
    public static void main(String[] args) {
        int num = getInput();
        int[] factors = getFactors(num);

        System.out.println(String.format("The factors of %d are: ", num));

        //print array using foreach loop
        for (int factor : factors)
            System.out.print(String.format("%d ", factor));

        //print number of factors
        System.out.println(String.format("\n%d has %d factors.", num, factors.length));

        //Call isPerf() to determine if num is perfect
        if (!isPerf(num, factors)) System.out.println(String.format("%d is not a perfect", num));
        else System.out.println(String.format("%d is a perfect", num));

        //if there are only 2 factors we can assume they are 1 & num, which implies prime
        if (factors.length > 2) System.out.println(String.format("%d is not a prime", num));
        else System.out.println(String.format("%d is a prime", num));


    } //end main()

    /**
     * Determint if num is perfect
     *
     * @return sum(factors)==num
     */
    public static boolean isPerf(int num, int[] factors) {
        int sum = 0;
        //Loop to sum all elements excluding the last( == num)
        for (int i = 0; i < factors.length - 1; i++) {
            sum += factors[i];
        } // end loop
        if (num == sum) return true;
        else return false;
    }// end isPerf()

    /**
     * Prompt user for input
     * Create scanner and get user input
     *
     * @return console input (int)
     */
    public static int getInput() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("What Number Would you like to Factor? ");
        return myScanner.nextInt();
    }//end get input()

    /**
     * Method loops through all integers 0..num to find instances where remainder(%) is 0
     * Probably very inefficient
     *
     * @return factors of num in an array
     */
    public static int[] getFactors(int num) {
        ArrayList<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) factors.add(i);
        }//end loop

        //put arraylist into regular array
        int[] arr = new int[factors.size()];
        //have to use a loop :(
        for (int i = 0; i < factors.size(); i++) {
            arr[i] = factors.get(i);
        }//end loop
        return arr;
    }//end getFactors() method
}//end Factorizer class

