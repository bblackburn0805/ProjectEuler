package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    final static int maxPrimeIndex = 100000;

    public static void main(String[] args) {
        ArrayList<Integer> allPrimes = new ArrayList<>(fillPrimeList());
        ArrayList<Integer> concatPrimes = new ArrayList<>(fillConcatPrimeList(allPrimes));
        int concatPrimesLen = concatPrimes.size();
        int lowestTotal = 100000000;
        for(int concatPrime1 = 0; concatPrime1 < concatPrimesLen - 4 ; concatPrime1++){

            for(int concatPrime2 = concatPrime1 + 1; concatPrime2 < concatPrimesLen - 3 ; concatPrime2++){
                if(isConcatCombo(concatPrimes.get(concatPrime1), concatPrimes.get(concatPrime2), allPrimes)) {

                    for (int concatPrime3 = concatPrime2 + 1; concatPrime3 < concatPrimesLen - 2; concatPrime3++) {
                        if(isConcatCombo(concatPrimes.get(concatPrime1), concatPrimes.get(concatPrime3), allPrimes) &&
                           isConcatCombo(concatPrimes.get(concatPrime2), concatPrimes.get(concatPrime3), allPrimes)){

                            for (int concatPrime4 = concatPrime3 + 1; concatPrime4 < concatPrimesLen - 1; concatPrime4++){
                                if(isConcatCombo(concatPrimes.get(concatPrime1), concatPrimes.get(concatPrime4), allPrimes) &&
                                   isConcatCombo(concatPrimes.get(concatPrime2), concatPrimes.get(concatPrime4), allPrimes) &&
                                   isConcatCombo(concatPrimes.get(concatPrime3), concatPrimes.get(concatPrime4), allPrimes)){

                                    for (int concatPrime5 = concatPrime4 + 1; concatPrime5 < concatPrimesLen; concatPrime5++){
                                        if(isConcatCombo(concatPrimes.get(concatPrime1), concatPrimes.get(concatPrime5), allPrimes) &&
                                           isConcatCombo(concatPrimes.get(concatPrime2), concatPrimes.get(concatPrime5), allPrimes) &&
                                           isConcatCombo(concatPrimes.get(concatPrime3), concatPrimes.get(concatPrime5), allPrimes) &&
                                           isConcatCombo(concatPrimes.get(concatPrime4), concatPrimes.get(concatPrime5), allPrimes)){

                                            int total = concatPrimes.get(concatPrime1) + concatPrimes.get(concatPrime2) +
                                                    concatPrimes.get(concatPrime3) + concatPrimes.get(concatPrime4) +
                                                    concatPrimes.get(concatPrime5);
                                            if(total < lowestTotal) {
                                                System.out.println(concatPrimes.get(concatPrime1) + " " + concatPrimes.get(concatPrime2)
                                                        + " " + concatPrimes.get(concatPrime3) + " " + concatPrimes.get(concatPrime4)
                                                        + " " + concatPrimes.get(concatPrime5) + ":        " + total);
                                                lowestTotal = total;
                                            }

                                        }//end if prime5
                                    }//end for prime5

                                }//end if prime4
                            }//end for prime4

                        }//end if prime3
                    }//end for prime3

                }//end if prime2
            }//end for prime2

        }//end for prime1
    }


    public static boolean isPrime(int number, ArrayList<Integer> allPrimes){
        if(number == 1)
            return false;
        double stop = Math.pow(number, .5);
        for(int prime : allPrimes){
            if(prime > stop)
                return true;
            else if(number % prime == 0)
                return false;
        }
        return true;
    }


    public static boolean isPrime(long number, ArrayList<Integer> allPrimes){
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


    public static ArrayList<Integer> fillPrimeList(){
        ArrayList<Integer> primesList = new ArrayList<>();
        primesList.add(2);
        int testNum = 1;
        while (primesList.size() < maxPrimeIndex){
            testNum += 2;
            if(isPrime(testNum, primesList))
                primesList.add(testNum);
            }
        return primesList;
        }

    public static int concat(int num1, int num2){
         String concat = String.valueOf(num1) + String.valueOf(num2);
         return Integer.parseInt(concat);
    }

    public static boolean isConcatCombo(int num1, int num2, ArrayList<Integer> allPrimes){
        String test = String.valueOf(num1) + String.valueOf(num2);
        if(test.length() < 10) {
            if (!isPrime(Integer.parseInt(test), allPrimes))
                return false;
            test = String.valueOf(num2) + String.valueOf(num1);
            if (!isPrime(Integer.parseInt(test), allPrimes))
                return false;
        }
        else{
            if (!isPrime(Long.parseLong(test), allPrimes))
                return false;
            test = String.valueOf(num2) + String.valueOf(num1);
            if (!isPrime(Long.parseLong(test), allPrimes))
                return false;
        }
        return true;

    }

    public static ArrayList<Integer> fillConcatPrimeList(ArrayList<Integer> allPrimes){
        ArrayList<Integer> concatPrimes = new ArrayList<>();
        for(int prime : allPrimes){
            String primeString = String.valueOf(prime);
            int primeLen = primeString.length();

            for(int splittingIndex = 1; splittingIndex < primeLen ; splittingIndex++){
                int firstSplit = Integer.parseInt(primeString.substring(0, splittingIndex));
                String secondSplitString = primeString.substring(splittingIndex);
                if(!secondSplitString.startsWith("0")){
                    int secondSplit = Integer.parseInt(secondSplitString);

                    if(isPrime(firstSplit, allPrimes) && isPrime(secondSplit, allPrimes)){
                        if(!concatPrimes.contains(firstSplit))
                            concatPrimes.add(firstSplit);
                        if(!concatPrimes.contains(secondSplit))
                        concatPrimes.add(secondSplit);
                    }
                }
            }
        }
        return concatPrimes;
    }
}
