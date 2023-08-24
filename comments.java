package com.company;
import java.util.ArrayList;
import java.util.Scanner;
/*
    single line comment is anything with // in the front
    multiline comment is anything that is enclosed in /* and */
//*/


public class comments {
    public static void main(String[] args) {
        //check to see if the user input is an appropriate single line comment
        Scanner input1 = new Scanner(System.in);
        System.out.print("Enter a single line comment: ");
        String input2 = input1.nextLine();

        String first1 = input2.substring(0, 2);     //get the first two characters in the string

        if (first1.equals("//")) {                  //compare to see if they are equal
            System.out.println("This is an appropriate single line comment in Java.");
        }
        else {
            System.out.println("This is NOT an appropriate single line comment in Java.");
        }


        //check to see if the user input is an appropriate multiline comment
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a multiline comment (enter 0 to stop): ");
        ArrayList<String> lines = new ArrayList<String>();
        boolean insertInput = true;
        while (insertInput) {                           //while true
            String value = input.nextLine();            //continue taking inputs
            lines.add(value);                           //add value to array
            if (value.equals("0")) {
                insertInput = false;                    //false
                lines.remove(lines.size() - 1);   //delete the last array (which is 0)
            }
        }

        int length = lines.size();
        String first = lines.get(0);                //get the first element
        String last = lines.get(length - 1);        //get the last element
        String firstTwo = first.substring(0, 2);            //get the first 2 letters of the first element
        String lastTwo = last.substring(last.length() - 2); //get the last 2 letters of the last element

        if (firstTwo.equals("/*") && lastTwo.equals("*/")) {        //compare to see if they are equal
            System.out.println("This is an appropriate multiline comment in Java.");
        }
        else {
            System.out.println("This is NOT an appropriate multiline comment in Java.");
        }
    }
}
