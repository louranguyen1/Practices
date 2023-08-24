package com.company;
//practices

import java.util.*;
import java.util.Arrays;

public class practice {
    public static void main(String[] args) {
        //Q1
        //find the max number in an array
        System.out.println("Question 1:");
        int testResult1 = maxOfArray(new int[]{1, 3, 4, 5, 2});
        int testResult2 = maxOfArray(new int[]{-1, -3, -4, -5, -2});

        System.out.println(testResult1); // should output 5
        System.out.println(testResult2); // should output -1
        boolean emptyCaseCorrect = false;
        try {
            maxOfArray(new int[]{});
        } catch (IllegalArgumentException e) {
            emptyCaseCorrect = true;
        }
        if (emptyCaseCorrect) {
            System.out.println("maxOfArray appears to work for the empty array case");
        } else {
            System.out.println("maxOfArray appears to be incorrect for the empty array case");
        }

        //Q2
        //find 2 elements from the array that add up to the target sum
        System.out.println("Question 2:");
        int[] testResult3 = twoSum(new int[]{0, 2, 3, 4, 5}, 6);
        int[] testResult4 = twoSum(new int[]{1, 2, 3, 4, 5}, 10);

        System.out.println(Arrays.toString(testResult3)); // should output [1, 3]
        System.out.println(Arrays.toString(testResult4)); // should output [-1, -1]

        //Q3
        // add the 2 arrays together
        System.out.println("Question 3:");
        List<Integer> testResult5 = add(Arrays.asList(1, 2, 3), Arrays.asList(2, 4, 2));
        List<Integer> testResult6 = add(Arrays.asList(9, 9, 9), Arrays.asList(1));
        List<Integer> testResult7 = add(Arrays.asList(9, 2, 2, 3, 3, 7, 2, 0, 3, 6, 8, 5, 4, 7, 7, 5, 8, 0, 7), Arrays.asList(1, 2, 3, 4, 5));

        System.out.println(testResult5); // should output [3, 6, 5]
        System.out.println(testResult6); // should output [1, 0, 0, 0]
        System.out.println(testResult7); // should output [9, 2, 2, 3, 3, 7, 2, 0, 3, 6, 8, 5, 4, 7, 8, 8, 1, 5, 2]

        //Q4
        //find the missing number in the patterned array
        System.out.println("Question 4:");
        int testResult8 = findMissing(new int[] {0, 1, 2, 4, 5});
        System.out.println(testResult8); // should output 3

        int testResult9 = findMissing(new int[] {5, 0, 4, 3, 1});
        System.out.println(testResult9); // should output 2

        int testResult10 = findMissing(new int[] {});
        System.out.println(testResult10); // should output 0

        int testResult11 = findMissing(new int[] {9, 3, 5, 1, 4, 8, 2, 10, 0, 6});
        System.out.println(testResult11); // should output 7

        //Q5
        //print out the most repeated number
        System.out.println("Question 5:");
        System.out.println(countFives(123467890)); // should output 0
        System.out.println(countFives(555555));    // should output 6
        System.out.println(countFives(15354));     // should output 2

        //Q6
        /* add up all the selected numbers so you can get the highest number
        for every number that you choose, a number next to it has to be skip
        for every number that you choose, you can't skip more than 1 number
         */
        System.out.println("Question 6:");
        int testResult12 = pickTrees(new int[] {1, 2, 3, 4, 5});
        System.out.println(testResult12); // should output 9 (1 + 3 + 5)

        int testResult13 = pickTrees(new int[] {1, 3, 4, 3});
        System.out.println(testResult13); // should output 6 (3 + 3)

        int testResult14 = pickTrees(new int[] {5, 1, 4, 9});
        System.out.println(testResult14); // should output 14 (5 + 9)

    }

    //Q1
    public static int maxOfArray(int[] arr) {
        //approach: I need to go through every value of the array and compare them to each other
        int max = Integer.MIN_VALUE;            //this represents the minimum integer value that can be represented in 32 bits
        for (int i = 0; i < arr.length; i++) {  //going through the array
            if (arr[i] > max) {                 //if the number in the array is bigger than max
                max = arr[i];                   //then max = the number
            }
        }
        return max;     //return the maximum number of the array
    }

    //Q2
    public static int[] twoSum(int[] arr, int targetSum) {
        //approach: I need to go through the loop 2 times in order to find the sum of each number and put them in a pair if they match with the targetSum
        int array[] = new int[2];                   //making an array to return the pair at the end
        array[0] = 0;                               //set the values for the array
        array[1] = 0;
        for (int i = 0; i < arr.length; i++) {      //going through the first loop
            for (int j = 0; j < arr.length; j++) {  //the second loop
                if (arr[i] != arr[j]) {             //you can't use the same element since it won't be distinct if you do that
                    if (arr[i] + arr[j] == targetSum) {     //add the 2 elements up
                        array[0] = j;                       //assign 1 of each element to each of the value in the new array
                        array[1] = i;
                    }
                }
            }
        }
        if (array[0] == 0 & array[1] == 0) {        //if both values are still 0, then that means there were no distinct elements
            array[0] = -1;              //set the new values
            array[1] = -1;
        }
        return array;                   //return the array
    }

    //Q3
    public static List<Integer> add(List<Integer> lst1, List<Integer> lst2) {
        //approach: I need take the last elements in each lists and add them together
        List<Integer> newList = new ArrayList<Integer>();   //add new lists
        List<Integer> result = new ArrayList<Integer>();
        int num = 0;                                        //any number that will carry over if it go past 10
        int i = lst1.size() - 1;                            //get the last element in the list
        int j = lst2.size() - 1;
        int sum;
        while (i >= 0 && j >= 0) {                          //this will reverse the list
            sum = lst1.get(i) + lst2.get(j) + num;          //this will add the last element in each list together
            newList.add(sum % 10);                          //the "% 10" will get the last digit in the sum if the sum have 2 digits
            num = sum / 10;                                 //the "/ 10" will let you know if there are any number carry over (if sum has more than 1 digit) if num isn't equal to 0
            i--;                                            //making the way to the beginning of the list
            j--;
        }
        //the code above will continue to run as long as there are still elements left in i or j to be added

        while (i >= 0) {
            sum = lst1.get(i) + num;        //this will take the current digit and add it to num if there are any numbers carrying over
            newList.add(sum % 10);          //the "% 10" will get the last digit in the sum if the sum have 2 digits
            num = sum / 10;                 //the "/ 10" will let you know if there are any number carry over if num isn't equal to 0
            i--;
        }
        // the code above will continue to run as long as lst1 is larger than lst2

        while (j >= 0) {
            sum = lst2.get(j) + num;        //this will take the current digit and add it to num if there are any numbers carrying over
            newList.add(sum % 10);          //the "% 10" will get the last digit in the sum if the sum have 2 digits
            num = sum / 10;                 //the "/ 10" will let you know if there are any number carry over if num isn't equal to 0
            i--;
        }
        // the code above will continue to run as long as lst2 is larger than lst1

        if (num != 0) {             //at the end of the loop when i and j doesn't have any numbers left to add
            newList.add(num);       //if num isn't 0, then it will be added to the end of the list as a new number
        }
        for (i = newList.size() - 1; i >= 0; i--) {     //this code will flip the list backward
            result.add(newList.get(i));
        }
        return result;
    }

    //Q4
    public static int findMissing(int[] arr) {
        int missing = 0;
        Arrays.sort(arr);       //sort the array
        int i = 0;
        int j = 0;
        while (i < arr.length && j < arr.length + 1) {      //i is the one going through the original array, j is the one going through the whole array that contain the missing number
            if (j != arr[i]) {                              //if they arent equal to each other
                missing = j;                                //it means that j contain the missing number
                break;
            }
            else {          //continue down the loop if they are equal
                j++;
                i++;
            }
        }
        return missing;
    }

    //Q5
    public static int countFives(int num) {
        int count = 0;
        if (num % 10 == 5) {    //if the last digit is 5, add 1 to count
            count++;
        }
        if (num <= 0) {         //if the number is less than 0, end the loop
            return 0;
        }
        else {
            return count + countFives(num / 10);    //call on recursive method. divide by 10 to reduce the digits by 1
        }
    }

    //Q6
    public static int pickTrees(int[] arr) {
        if(arr.length == 0){    //check if length is empty
            return 0;
        }

        int woods1 = arr[0];        //if the first tree is picked
        if (arr.length > 2) {       //check if the length of the array is more than 2
            woods1 += pickTrees(Arrays.copyOfRange(arr, 2, arr.length));
            //this code here will copy the original array, but it will start from arr[2] instead of arr[0]
            //since arr[1] can't be picked if arr[0] is picked
            //everytime the code runs, it will continue to move along the array by 2
        }

        int woods2 = 0;             //if the first tree isn't picked
        if(arr.length > 1){         //check if the length of array is more than 1
            woods2 += pickTrees(Arrays.copyOfRange(arr, 1, arr.length));
        }

        int max = 0;                //find the max number out of the 2
        if (woods1 < woods2) {
            max = woods2;
        }
        else {
            max = woods1;
        }

        return max;    //return the max value
    }
}
