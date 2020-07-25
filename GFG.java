package com.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GFG
{
    // method for Maximum size square sub-matrix with all 1s
   // static void printMaxSubSquare(int M[][])
    static int largestArea(List<List<Integer>> samples)
    {
        int[][] sampleArray = new int[samples.size()][];
        for (int i = 0; i < sampleArray.length; i++) {
            sampleArray[i] = new int[samples.get(i).size()];
        }
        for(int i=0; i<samples.size(); i++){
            for (int j = 0; j < samples.get(i).size(); j++) {
                sampleArray[i][j] = samples.get(i).get(j);
            }
        }

        sampleArray = new int[][]{{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};

        int i,j;

        int rows = sampleArray.length;         //no of rows in sampleArray[][]
        int columns = sampleArray[0].length;     //no of columns in sampleArray[][]
        int resultArray[][] = new int[rows][columns];

        int max_of_s, max_i, max_j;

        /* Set first column of resultArray[][]*/
        for(i = 0; i < rows; i++)
            resultArray[i][0] = sampleArray[i][0];

        /* Set first row of resultArray[][]*/
        for(j = 0; j < columns; j++)
            resultArray[0][j] = sampleArray[0][j];

        /* Construct other entries of resultArray[][]*/
        for(i = 1; i < rows; i++)
        {
            for(j = 1; j < columns; j++)
            {
                if(sampleArray[i][j] == 1)
                    resultArray[i][j] = Math.min(resultArray[i][j-1],
                            Math.min(resultArray[i-1][j], resultArray[i-1][j-1])) + 1;
                else
                    resultArray[i][j] = 0;
            }
        }

        /* Find the maximum entry, and indexes of maximum entry
            in resultArray[][] */
        max_of_s = resultArray[0][0]; max_i = 0; max_j = 0;
        for(i = 0; i < rows; i++)
        {
            for(j = 0; j < columns; j++)
            {
                if(max_of_s < resultArray[i][j])
                {
                    max_of_s = resultArray[i][j];
                    max_i = i;
                    max_j = j;
                }
            }
        }
        int count = 0;
        System.out.println("Maximum size sub-matrix is: ");
        for(i = max_i; i > max_i - max_of_s; i--)
        {
            for(j = max_j; j > max_j - max_of_s; j--)
            {
                System.out.print(sampleArray[i][j] + " ");
            }
            count++;
            System.out.println();
            System.out.println("Count is "+count);
        }
        return count;
    }

    // Driver program
    public static void main(String[] args)
    {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        largestArea(list);

    }

}