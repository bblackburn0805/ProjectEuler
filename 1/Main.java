public class Main {


    public static void main(String args[]){
        int max = 1000;
        int x = 3;
        int y = 5;
        int sum = 0;

        for(int i = 1 ; i < max ; i ++){
            if( (i % 3 == 0) || (i % 5 == 0) )
                sum += i;
        }

        System.out.println(sum);
    }
}
