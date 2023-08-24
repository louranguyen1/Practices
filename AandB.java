package com.company;
import java.util.regex.*;
import java.util.Scanner;
//Description: Odd number of a’s and b’s.
//This means that both of them together have to sum up to an odd number.
//So either there’s an even number of a’s or there’s an even number of b’s.
public class AandB {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string of a's and b's: ");
        String input1 = input.nextLine();

        //even number of a's and odd number of b's
        Pattern pattern1 = Pattern.compile("(aa)*b(bb)*|b(bb)*(aa)*");
        Matcher match1 = pattern1.matcher(input1);

        //even number of b's and odd number of a's
        Pattern pattern2 = Pattern.compile("a(aa)*(bb)*|(bb)*a(aa)*");
        Matcher match2 = pattern2.matcher(input1);

        boolean ifCase1Match = match1.matches();
        boolean ifCase2Match = match2.matches();

        if (ifCase1Match | ifCase2Match) {
            System.out.println("This string has an odd number of a's and b's.");
        }
        else {
            System.out.println("This string does NOT have an odd number of a's and b's.");
        }
    }
}
