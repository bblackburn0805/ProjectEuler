/*  Brandon Blackburn
    Euler Project #7
    What is the 10 001st prime number?
 */


import java.util.Vector;

public class Main {
    public static void main (String args[]){

        //set target prime number. Current number starts at 3 and primecounter starts at 1 because 2 is added from the
        //start/
        int target = 10001;
        int primeCounter = 1;
        int currentNumber = 3;
        int prime = 0;

        //primes are stored in a vector as a shortcut to check for the prime of current number. We don't need to try
        // every single number multiple times because all numbers are compromised as a multiple of primes.
        Vector<Integer> primeNumbers = new Vector<Integer>();
        primeNumbers.add(2);


        //primecounter is what prime number we currently have. Program does not stop until the target is reached.
        while (primeCounter != target){

            // for i is used to search through the primeNumbers vector. The for loop ends if the number is divisible,
            // or if the end of the primeNumbers vector is reached. If the end of vector is reached, then the current
            // number is prime, added to the vector, and prime counter is incremented.
            for (int i = 0 ; i < primeNumbers.size() ; i++){
                prime = primeNumbers.get(i);
                if (currentNumber % prime == 0)            // currentNumber is divisible and not prime.
                    i = primeNumbers.size();
                else if (i == primeNumbers.size() - 1) {   // currentNumber is prime
                    primeNumbers.add(currentNumber);
                    primeCounter++;
                    i = primeNumbers.size();
                }

            }//end for
            currentNumber += 2;             // incremented by 2, to keep the currentNumber odd.
        }//end while

        System.out.println(primeNumbers.lastElement());     // Answer :)
        
    }//end main


}
