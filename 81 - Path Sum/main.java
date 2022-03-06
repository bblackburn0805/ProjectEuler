/*
Project Euler #81 - Path Sum

Find the minimal path sum from the top left to the bottom right by only moving right and down in matrix.txt

 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {


    public static void main(String args[]) throws FileNotFoundException {
        // Create input. Delimiter is a return or comma
        File matrixFile = new File("src/p081_matrix.txt");
        Scanner input = new Scanner(matrixFile);
        input.useDelimiter("(\\n)|,");


        // This is the matrix where the path will be stored
        // The path is determined as the numbers are read in.
        int[][] sumsMatrix = new int[80][80];


        // x is the row number, y is the column number
        for(int x = 0 ; x < 80 ; x++) {
            for (int y = 0; y < 80; y++) {

                int number = Integer.parseInt(input.next());


                // If not the first row or first column, then
                // see if the number above or to the left is
                // higher. Add the lowest value to the number
                // read in.
                if(x != 0 && y != 0){
                    if(sumsMatrix[x-1][y] <= sumsMatrix[x][y-1])
                        sumsMatrix[x][y] = sumsMatrix[x-1][y] + number;
                    else
                        sumsMatrix[x][y] = sumsMatrix[x][y-1] + number;
                }



                // If the number is the first column
                else if(y == 0){
                    // ... and is the first row
                    if(x == 0)
                        sumsMatrix[0][0] = number;

                    // ... but is not the first row
                    else
                        sumsMatrix[x][0] = sumsMatrix[x-1][0] + number;
                }


                // If the number is the first row but not first column
                else
                    sumsMatrix[0][y] = sumsMatrix[0][y-1] + number;




            }//end y for
        }//end x for


        // Print answer.
        System.out.println(sumsMatrix[79][79]);
    }



}
