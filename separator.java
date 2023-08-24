package com.company;
import java.util.Scanner;
//Description: Create a program that separates letters and numbers
public class separator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter input: ");
        String input1 = input.nextLine();

        String input2 = input1.replaceAll("(?=\\d)(?<=\\D)|(?=\\D)(?<=\\d)", " ");
        System.out.println(input2);
    }
}
