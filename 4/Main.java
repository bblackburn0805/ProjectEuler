/*Brandon Blackburn
  Euler Project #4
  Find the largest palindrome made from the product of two 3-digit numbers.

 */



public class Main {
    public static void main (String args[]){
        // Enter amount of digits here
        int amountOfDigits = 3;

        // Sets the initial integer to be checked at 100, and the max int at 1000. Must use exclusive < or >.
        int num1 = (int) Math.pow(10, amountOfDigits - 1);
        int maxInteger = num1 * 10;

        // I believe it is in good practice to initially declare variables so that space doesn't need to be allocated
        //      repeatedly for a variable in a while loop.
        int num2 = 0;
        int temp = 0;
        int forwards = 0;
        int backwards = 0;
        int answer1 = 0;
        int answer2 = 0;


        // Try every combination, starting with first number 100.
        // num2 = num1 because we already checked all previous multiplications E.g. 100 * 101 == 101 * 100
        while (num1 < maxInteger){
            num2 = num1;


            // Iterating the second number
            while (num2 < maxInteger){


                forwards = num1 * num2;
                temp = forwards;
                backwards = 0;

                // Temp is used to set the integer backwards
                while (temp > 0){
                    backwards = (backwards * 10) + (temp % 10);
                    temp /= 10;
                }

                // Checks for palindrome, and then if that multiple is higher, it sets it to the current answer.
                if (forwards == backwards && (num1 *  num2) > (answer1 * answer2)){
                    answer1 = num1;
                    answer2 = num2;
                }


                num2 += 1;
            } // End num2 iteration while loop


            num1 += 1;
        } // End num1 iteration whlie loop


        // Print results
        System.out.println("Number 1: " + answer1);
        System.out.println("Number 2: "+ answer2);
    }
}
