package com.company;
import java.util.Scanner;

//Description: this is a DFA that accepts string literals
/*Explanation: q0 is the starting point
               q1 is the one with the "
               q2 is the contents inside the " ", it can be anything
    q0: if first char isn't " -> end
        if char = "     -> go to 1
        if char != "    -> go to 2
    q1, q2: if char = " -> go to 1
        if char != "    -> go to 2
    String literal = anything inside " "
 */

public class FA {
    public static void q1(String s, int i) {
        //check the end of string
        if (i == s.length()) {
            System.out.println("It's a string literal");
            return;
        }

        if (s.charAt(i) == '\"') {
            q1(s, i + 1);
        }
        else {
            q2(s, i + 1);
        }
    }

    public static void q2(String s, int i) {
        if (i == s.length()) {
            System.out.println("Not a string literal");
            return;
        }

        if (s.charAt(i) == '\"') {
            q1(s, i + 1);
        }
        else {
            q2(s, i + 1);
        }
    }

    public static void q0(String s, int i) {
        if (i == s.length()) {
            System.out.println("Not a string literal");
            return;
        }

        if (s.charAt(i) != '\"' && i == 0) {
            System.out.println("Not a string literal");
        }
        else if (s.charAt(i) == '\"') {
            q1(s, i + 1);
        }
        else {
            q2(s, i + 1);
        }
    }

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string literal: ");
        String s = input.nextLine();
        q0(s, 0);
    }
}