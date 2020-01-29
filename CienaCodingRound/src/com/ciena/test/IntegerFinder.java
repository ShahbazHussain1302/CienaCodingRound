package com.ciena.test;

import java.util.HashSet;
import java.util.Set;

public class IntegerFinder {
  public static void main(String args[]) {

    int[] nullInput = null;
    findMissingInteger(nullInput);

    int[] invalidInput = {};
    findMissingInteger(invalidInput);

    int[] allNegetiveInput = {-1, -1, -2, -3, -10, -15};
    findMissingInteger(allNegetiveInput);

    int[] validInputOne = {-1, 1, 2, 3, 10, 15};
    findMissingInteger(validInputOne);

    int[] validInputTwo = {-1, -4, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11};
    findMissingInteger(validInputTwo);
  }

  /**
   * Test cases runner
   */

  private static void findMissingInteger(int[] input) {
   if (isValidInput(input)) {
      int result = findSmallestMissingPositiveInteger(input);
      if (result == 0)
        System.out.println("No positive integer is missing within the array bound");
      else
        System.out.println("Missing positive integer = " + result);
    } else {
      System.out.println("Invalid Input");
    }
  }

  /**
   * Validate input
   */
  private static boolean isValidInput(int[] data) {
    return null != data && data.length > 0;
  }


  /*
  * Could have solved this using : Sort the array first and than find the number.
  * worst case complexity for that would be O(nlogn)
  *
  * Using HashSet in this approach to find the missing number in O(n)
  * */
  private static int findSmallestMissingPositiveInteger(int[] data) {
    int inputLength = data.length;
    int missing = 0;

    Set<Integer> set = new HashSet<>();

    int maxElement = 0;
    for (int i = 0; i < inputLength; i++) {
      int elem = data[i];
      if (elem > maxElement) {
        maxElement = elem;
      }
      set.add(data[i]);
    }
    //This handles the edge case when array don't have any positive integer.
    if (maxElement == 0) {
      return 1;
    }

    for (int i = 1; i < maxElement; i++) {
      if (!set.contains(i)) {
        missing = i;
        break;
      }
    }
    return missing;
  }
}

