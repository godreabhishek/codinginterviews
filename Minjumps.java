package com.algoexpert;

class Minjumps {

    public static void main(String[] args) {
        //int[] array = {3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3};
        int[] array = {3,4,2,1};
        System.out.println("Min jumps are "+minNumberOfJumps(array));
      }

    private static int minNumberOfJumps(int[] array) {
        if (array.length == 1) {
            return 0;
        }
        int jumps = 0;
        int maxReach = array[0];
        int steps = array[0];
        System.out.println( " array.length is "+array.length);
        for (int i = 1; i < array.length - 1; i++) {

            System.out.println( " i is "+i);
            System.out.println( " array[i] is "+array[i]);
            System.out.println( "  starting maxReach is "+maxReach);
            System.out.println(" starting steps is "+steps);

            maxReach = Math.max(maxReach,i+array[i]);
            System.out.println( " comparing "+ maxReach + " "+ i + array[i]);
            System.out.println( " current maxReach is "+maxReach);
            System.out.println( " current  array[i] is "+array[i]);
            System.out.println(" current steps is "+steps);
            steps--;
            System.out.println( "decrement steps is "+steps);
            if(steps == 0){
                System.out.println( " steps is = 0 ");
                jumps++;
                System.out.println( " new jumps is "+jumps);
                steps = maxReach - i;
                System.out.println( " maxReach - i "+maxReach + " i is "+i);
                System.out.println( "new steps is "+steps  );

            }
            System.out.println( " End of for loop ");
        }
        return jumps + 1;
    }
}
