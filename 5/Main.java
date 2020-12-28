/*  Brandon Blackburn
    Euler Project #5
    Find the smallest multiple of integers 1 through 20

    This approach takes multiples of 20, and tests each multiple to find if it's divisible by 19 - 1.
    This is mathematically not optimal in my opinion due to prime factorization, but it is an interesting method!
 */


public class Main {
    public static void main (String args[]){
        // Specify start and end numbers
        int startingNum = 1;
        int endingNum= 20;

        // testNumber is used to divide starting from 20 and going to 1
        // currentMultiple is the current number being checked for a remainder
        // multiplier is used to increment each currentMultiple
        int testNumber = 0;
        int currentMultiple = 0;
        int multiplier = 1;

        // When the testNumber finally reaches 1, that means that currentMultiple is divisible by 1-20
        while (testNumber != startingNum){

            // restart the division starting at 20
            testNumber = endingNum;
            multiplier++;
            currentMultiple = endingNum * multiplier;

            // Tests to see if the currentMultiple is divisible by 19, going down.
            // If currentMultiple isn't, then for loop breaks, and testNumber won't break while loop
            for (testNumber = endingNum - 1 ; testNumber != startingNum ; testNumber--){
                if (currentMultiple % testNumber != 0)
                    break;
            }//end for loop

        }// end while loop

        System.out.println(currentMultiple);
    }
}
