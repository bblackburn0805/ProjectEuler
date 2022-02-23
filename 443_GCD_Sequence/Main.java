/*
Let g(n) be a sequence defined as follows:
g(4) = 13,
g(n) = g(n-1) + gcd(n, g(n-1)) for n > 4.

The first few values are:

n	    4	5	6	7	8	9	10	11	12	13	14	15	16	17	18	19	20	...
g(n)	13	14	16	17	18	27	28	29	30	31	32	33	34	51	54	55	60	...
You are given that g(1 000) = 2524 and g(1 000 000) = 2624152.

Find g(10^15).
 */

package com.company;
import java.util.ArrayList;

public class Main {

    final static double limit = Math.pow(10, 15);       //Find this G(n)
    final static int beginningGn = 13;
    final static int maxPrimeIndex = 2000000;

    public static void main(String [] args){
        long N = shortcut();
        long gN = 3 * N;
        while(N != limit){
            N++;
            gN += euclidGCD(N, gN);
        }
        System.out.println();
        System.out.println("Answer is: " + gN);
    }// end main


    public static long shortcut(){
        //Start with N such that 3N = g(N)
        ArrayList<Integer> allPrimes = new ArrayList<>(fillPrimeList());

        // long N = 20;
        // Limit = 10^6 shortcut is 812076
        // Limit = 10^7 shortcut is 6496944
        // Limit = 10^8 shortcut is 51980346
        // Limit = 10^9 shortcut is 831705066
        // Limit = 10^10 shortcut is 6653700690
        // Limit = 10^11 shortcut is 53229739992
        // Limit = 10^12 shortcut is 851675916105
        // Limit = 10^13 shortcut is 6813409144116
        // Limit = 10^14 shortcut is 54507278135385
        // Limit = 10^15 shortcut is 872116458704172

        long N = 54507278135385L;
        while(N < limit){
            //1. Take 2N -1
            long test = (2*N) - 1;
            //2. Factorize this number
            int index = 0;
            int prime = allPrimes.get(0);
            long k = 0;
            while(true){
                if(test % prime == 0){
                    //3. Find k for the smallest prime such that 2k + 3 == prime.
                    if((prime - 3) % 2 == 0) {
                        k = (prime - 3) / 2;
                        break;
                    }
                    test /= prime;
                }
                else{
                    prime = allPrimes.get(index++);
                    if (prime > Math.pow(N, .5)){
                        if((test - 3) % 2 == 0)
                            k = (test - 3) / 2;
                        else
                            System.out.println("fake");
                        break;
                    }


                }//end else
            }//end while prime factoring
            //The next N such that 3N=g(N) is N + k + 1
            if(N + k + 1 > limit)
                break;
            N = N +  k + 1;
        }// end while N <= limit
        System.out.println("Shortcut finished");
        System.out.println("3N = g(N): " + N);
        return N;
    }

    public static long euclidGCD(long smallNum, long bigNum){
        long remainder = bigNum % smallNum;
        while(remainder != 0) {
            bigNum = smallNum;
            smallNum = remainder;
            remainder = bigNum % smallNum;
        }
        return smallNum;
    }

    public static ArrayList<Integer> fillPrimeList () {
        ArrayList<Integer> primesList = new ArrayList<>();
        primesList.add(2);
        int testNum = 1;
        while (primesList.size() < maxPrimeIndex) {
            testNum += 2;
            if (isPrime(testNum, primesList)) {
                primesList.add(testNum);
            }
        }
        System.out.println("Prime List filled");
        return primesList;
    }

    public static boolean isPrime(int number, ArrayList<Integer> allPrimes){
        if(number == 1)
            return false;
        double stop = Math.pow(number, .5);
        for(long prime : allPrimes){
            if(prime > stop)
                return true;
            else if(number % prime == 0)
                return false;
        }
        return true;
    }


    public static void try1(String[] args) {
        ArrayList<Integer> allPrimes = new ArrayList<>(fillPrimeList());
        long Gn = 13;                                    //Enter G(4)

        double progress = 0;
        int lastPrimeFactorCheck = allPrimes.get(maxPrimeIndex-1);


        for(long n = 5; n < limit; n++){
            int gcd = 1;
            long copyN = n;              //Don't change the actual values of N and Gn
            long copyGn = Gn;
            int primeIndex = 0;         //What prime number is being used in order.
            int primeFactor = 2;
            while (copyN >= primeFactor){
                primeFactor = allPrimes.get(primeIndex);

                long remainderGn = copyGn % primeFactor;        //Assign variables so mod only happens once.
                long remainderN = copyN % primeFactor;

                if(remainderN == 0 && remainderGn == 0){
                    gcd *= primeFactor;
                    copyN /= primeFactor;
                    copyGn /= primeFactor;
                }
                else if(remainderN % primeFactor == 0)      //if only N is divisible by primeFactor
                    copyN /= primeFactor;
                else if(remainderGn % primeFactor == 0)     //if only Gn is divisible by primeFactor
                    copyGn /= primeFactor;
                else
                    primeIndex++;                           //If both are not divisible, move to next prime number.


                if(primeFactor == lastPrimeFactorCheck){        //Makes sure the maxPrimeIndex is high enough.
                    System.out.println("Not high enough prime index");
                    System.out.println(n);
                    System.exit(-1);
                }
            }//end While loop


            Gn = Gn + gcd;          //G(n) = G(n-1) + gcd(G(n-1), n)


            if (n % (limit / 100) == 0){         //Progress check, to make sure it's counting.
                progress += 1;
                int temp = (int)(progress*100.0);
                double shortDouble = ((double)temp)/100.0;
                System.out.println(shortDouble + "% done");
            }

        }//end for function

        System.out.println("G(n) = " + Gn);
    }

    public static void try2(String[] args) {
        long Gn = beginningGn;
        double progress = 0;
        for(long n = 5; n <= limit; n++){
            Gn += euclidGCD(n, Gn);
            if (n % (limit / 100000) == 0){         //Progress check, to make sure it's counting.
                progress += .001;
                int temp = (int)(progress*100.0);
                double shortDouble = ((double)temp)/100.0;
                System.out.println(shortDouble + "% done");
            }
        }
        System.out.println(Gn);

    }
}
