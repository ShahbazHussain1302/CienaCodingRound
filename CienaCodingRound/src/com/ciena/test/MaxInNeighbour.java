package com.ciena.test;

public class MaxInNeighbour {
    public static void main(String[] args) {
        //TC1
        int[] inputArr = {1,2,3,4,2,3,1};
        int index = findMaxElementIndex(inputArr);
        System.out.println("Index: "+index);
        System.out.println("Max Element: "+inputArr[index]);

        //TC2
        inputArr = new int[]{7,11,8,10,11,9};
        index = findMaxElementIndex(inputArr);
        System.out.println("Index: "+index);
        System.out.println("Max Element: "+inputArr[index]);

        //Negative TC1
        inputArr = new int[]{4,3,2,1};
        index = findMaxElementIndex(inputArr);
        System.out.println("Index: "+index);

        //Negative TC2
        inputArr = new int[]{1,2,3,4};
        index = findMaxElementIndex(inputArr);
        System.out.println("Index: "+index);

        //Negative TC3
        inputArr = new int[]{4};
        index = findMaxElementIndex(inputArr);
        System.out.println("Index: "+index);

    }

    /*
    Method to get a number in array which is greater than both left and right numbers
    Returns index of number
    Returns -1 if either input is not correct i.e. either it is null or array length is smaller than
    3.
    Return -1 if no such number exists.
     */
    private static int findMaxElementIndex(int[] inputArr){
        int index = -1;
        if(!validateInput(inputArr)){
            return index;
        }

        //Loop from 1 to array.len -2 as we are concerned with neighbours
        for(int i = 1; i <= inputArr.length -2; i++){
            if(inputArr[i] > inputArr[i-1] && inputArr[i] > inputArr[i+1]){
                index = i;
                break;
            }
        }
        return index;
    }


    //Validate input
    private static  boolean validateInput(int[] inputArr){
        if(inputArr == null){
            return false;
        }else if(inputArr.length < 3){
            return false;
        }
        return true;
    }
}
