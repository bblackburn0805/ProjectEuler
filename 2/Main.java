/* Brandon Blackburn
   Euler Problem #2:
       By considering the terms in the Fibonacci sequence whose values do not exceed four million,
       find the sum of the even-valued terms.

 */

public class Main {


    public static void main(String args[]){
        int num1 = 1;
        int num2 = 1;
        int answer = 0;
        System.out.println(recursive(num1, num2, answer));
    }

    static int recursive(int num1, int num2, int answer){
        int temp = num1 + num2;
        if (temp < 4000000) {
            num1 = num2;
            answer = recursive(num1, temp, answer);
        }
        if (temp % 2 == 0)
            return answer + temp;
        else
            return answer;
    }
}
