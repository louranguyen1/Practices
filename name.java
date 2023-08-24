package com.company;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//Description: write a program that accept a string that has your name in it

public class name {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name (alphabetical only): ");
        String input1 = input.nextLine();

        Pattern pattern1 = Pattern.compile("^[a-zA-Z\\s]*$");
        Matcher match1 = pattern1.matcher(input1);

        boolean ifCaseMatch = match1.matches();

        if (ifCaseMatch) {
            System.out.println("Name: Accepted.");
        }
        else {
            System.out.println("Name: Declined. Alphabetical Only.");
        }
    }
}
