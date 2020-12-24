import java.math.BigInteger;

/* Brandon Blackburn
   Euler Project #3

    What is the largest prime factor of the number 600851475143 ?
*/
public class Main {

    public static void main(String[] args) {

        // The number is too big to fit into an int, so it is declared as a long.
        long number = 600851475143L;

        // Makes sure that there are no prime factors of 2
        while (number % 2 == 0)
            number /= 2;

        // Starting from 3, if the number is divisible by i, the number is divided by i.
        // Mathematically, you only have to check up to half of what number is being factored.
        int current = 0;
        for (int i = 3 ; i < number / 2 ; i += 2){
            if (number % i == 0)
                number /= i;
        }

        System.out.println(number);
    }
}
