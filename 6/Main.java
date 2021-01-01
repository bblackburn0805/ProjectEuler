/*  Brandon Blackburn
    Euler Project #6
    Find the difference between the sum of the squares of the first one
    hundred natural numbers and the square of the sum.
 */


public class Main {
    public static void main (String args[]){
        int max = 100;
        int squaredSum = 0;
        int sumsSquared = 0;

        for (int i = 1 ; i <= max; i ++) {
            squaredSum += i;
            sumsSquared += i * i;
        }

        squaredSum *= squaredSum;


        System.out.println(squaredSum - sumsSquared);

    }


}
