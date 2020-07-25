package com.algoexpert;

public class SubArraySort {
    public static int[] subarraysort(int[] array){
        int minOutOfOrder = Integer.MAX_VALUE;
        int maxOutOfOrder = Integer.MIN_VALUE;

        for (int i = 0; i < array.length ; i++) {
            int num = array[i];
            if(isOutofOrder(i,num,array)){
                minOutOfOrder = Math.min(minOutOfOrder,num);
                maxOutOfOrder = Math.max(maxOutOfOrder,num);
            }
        }
        if(minOutOfOrder == Integer.MAX_VALUE){
            return new int[]{-1,-1};
        }
        int subarrayLeftIdx = 0;
        int subarrayRightIdx = array.length-1;

        while(minOutOfOrder >= array[subarrayLeftIdx]){
            subarrayLeftIdx++;
        }

        while(maxOutOfOrder <= array[subarrayRightIdx]){
            subarrayRightIdx--;
        }
        return new int[] {subarrayLeftIdx,subarrayRightIdx};
    }

    private static boolean isOutofOrder(int i, int num, int[] array) {
        if(i == 0){
            return num > array[i+1];
        }
        if( i == array.length - 1){
            return num < array[i-1];
        }
        return  num > array[i+1] || num < array[i-1];
    }

    public static void main(String[] args) {
        int[] arrayValues = subarraysort(new int[]{1,2,4,7,10,11,7,12,6,7,16,18,19});
        for (int i = 0; i < arrayValues.length; i++) {
            System.out.println(arrayValues[i]);

        }
    }
}
