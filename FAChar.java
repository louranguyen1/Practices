package com.company;
import java.util.Scanner;
//Description: this is a DFA that accepts character literals
/*Char literal - a single sign (letter/digit/special character)
               - it's express in single quotes */
/*Explanation: q0 is the starting point
               q1 is the one with the '
               q2 is the contents inside the ' '
                - it can be anything, but only in length of 1
    q0: if length isn't 3     -> end
        if first char isn't ' -> end
        if char = '     -> go to 1
        if char != '    -> go to 2
    q1, q2: if char = ' -> go to 1
        if char != '    -> go to 2
*/
public class FAChar {
    public static void q1(String s, int i) {
        //check the end of string
        if (i == s.length()) {
            System.out.println("It's a character literal");
            return;
        }

        if (s.charAt(i) == '\'') {
            q1(s, i + 1);
        }
        else {
            q2(s, i + 1);
        }
    }

    public static void q2(String s, int i) {
        if (i == s.length()) {
            System.out.println("Not a character literal");
            return;
        }

        if (s.charAt(i) == '\'') {
            q1(s, i + 1);
        }
        else {
            q2(s, i + 1);
        }
    }

    public static void q0(String s, int i) {
        if (i == s.length()) {
            System.out.println("Not a character literal");
            return;
        }

        if (s.length() != 3) {  //length is 3 because 2 of them is single quote
            System.out.println("Not a character literal");
            return;
        }

        if (s.charAt(i) != '\'' && i == 0) {
            System.out.println("Not a character literal");
            return;
        }

        if (s.charAt(i) == '\'') {
            q1(s, i + 1);
        }
        else {
            q2(s, i + 1);
        }
    }

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a character literal: ");
        String s = input.nextLine();
        q0(s, 0);
    }
}