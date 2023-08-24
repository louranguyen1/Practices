package com.company;

/*
    Description: check if the array is min heap and insert another
    min heap - each element in tree is >= its parent
    min heap - smallest: root -> left branch -> right branch (top to bottom)
 */
public class MinHeap {
    public static boolean isMinHeap(int[] array) {
        /* left = i * 2 + 1
        right = i * 2 + 2
        parent = (i - 1) / 2
        */
        for (int i = 0; i < (array.length - 1) / 2; i++) {
            if (array[i] > array[2 * i + 1]) {              //check the left side
                return false;
            }
            if (array[i] > array[2 * i + 2]) {              //check the right side
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array = {0,3,2,8,10,9,7};
        System.out.println(isMinHeap(array));

        /* samples:
            [1, 3, 2, 8, 10, 9]
            [1, 3, 2, 8, 2, 10] (false)
            [0, 3, 2, 8, 10, 9, 7]
         */
    }
}
