/*
Project Euler Problem #69: Totient Maximum.

Euler's Totient function, φ(n) [sometimes called the phi function],
is used to determine the number of numbers less than n which are relatively prime to n.
For example, as 1, 2, 4, 5, 7, and 8, are all less than nine and relatively prime to nine, φ(9)=6.

It can be seen that n=6 produces a maximum n/φ(n) for n ≤ 10.

Find the value of n ≤ 1,000,000 for which n/φ(n) is a maximum.

 */

package com.company;


import java.sql.Timestamp;

public class Main {

    final static int limit = 1000000;      //Set the limit of n here.
    public static void main(String[] args) {


        int relativelyPrimes;   // this is phi(n)
        double maximum = 0;     // maximum value of n/phi(n)
        int maxN = 0;           // the n value of maximum
        int[] primes = new int[100000];     //Create array of prime numbers
        primes[0] = 2;          // set first prime
        int primesSize = 1;     // set current amount of primes in array so far


        int prime;
        boolean[] commonMultiples;
        double stop;
        long timer = System.currentTimeMillis();


        for(int n = 2 ; n <= limit ; n++){

            // commonMultiples uses its index number as a way to keep track
            // of what numbers are NOT in phi(n).
            commonMultiples = new boolean[n];

            // relativelyPrimes is phi(n). The largest phi(n) can be is if
            // the number is a prime, which is n-1. e.g., phi(7) = 1,2,3,4,5,6.
            relativelyPrimes = n - 1;

            // When to stop trying to factor primes for n.
            stop = Math.pow(n, .5);


            // This is my way of using lists without using List<>. It's faster.
            // This for loop is equivalent to foreach prime in primes.
            for(int primeIndex = 0 ; primes[primeIndex] < stop ; primeIndex++) {
                prime = primes[primeIndex];


                if (n % prime == 0) {       // If we find a common prime factor

                    for(int k = 1 ; k * prime < n ; k++) {      // For each multiple of that prime under n


                        if(!commonMultiples[k*prime]) {         // If the multiple hasn't already been accounted for
                            relativelyPrimes--;                 // Subtract the number from phi(n)
                            commonMultiples[k*prime] = true;    // Mark as used, so we don't subtract for it again.
                        }

                    }// end for: each multiple of common prime

                }// end if: common prime is found

            } // end for: each prime in primes


            // Now check if relativelyPrimes is still n-1. If it is,
            // n is a prime number. Doing this as we go is more efficient
            // than creating a prime list and then going through them again.
            if (relativelyPrimes == n-1) {
                primes[primesSize] = n;
                primesSize++;
            }


            // if this value of n/phi(n) > the previous max, overwrite it.
            if (((double)n / (double)relativelyPrimes) > maximum) {
                maxN = n;
                maximum =  ((double)n / (double)relativelyPrimes);
            }


            //Progress check for sanity’s sake.
            if (n % 100000 == 0)
                System.out.println("n = " + n);


        }// end for: n <= limit


        // Print out answers!
        System.out.println("\n\n maximum N = " + maxN);
        System.out.println("max n/phi(n) = " + maximum);
        System.out.println("Secs to calculate = " + (System.currentTimeMillis() - timer) / 1000);
        // Interestingly, using boolean [] commonFactors takes 278 seconds.
        // Using int [] commonFactors takes

    }//end main










    /*
        This is an alternative method to get the same answer for n <= 1000000.
    The idea here is that the smaller the denominator is in a fraction the
    larger the value of it is. In this case, the denominator is the phi(n).
    Since each number can be written as a sum of prime numbers, we just
    want the largest number we can make with unique primes.
        In the case of n <= 1000000 this method works. But I think this is not an
    actual method for solving, since there is a possibility that the max n/phi(n)
    value could different from the value with the most amount of unique primes.

        This method is literally just finding prime numbers and multiplying them
     together.
     */
    public static void AlternativeMethod(String[] args){
        final int maxN = 1000000;
        int result = 1;
        int [] primeList = new int[100];
        primeList[0] = 2;
        boolean isPrime;
        int size = 1;
        int n = 3;
        double limit;

        while(true){
            isPrime = true;
            limit = Math.pow(n, .5);
            for(int primeIndex = 0; primeIndex < size ; primeIndex++){
                if(primeList[primeIndex] >= limit){
                    break;
                }
                if(n % primeList[primeIndex] == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                primeList[size] = n;
                size++;
                if(result * n <= maxN)
                    result *= n;
                else
                    break;
            }
            n++;
        }
        System.out.println(result);
    }
}
