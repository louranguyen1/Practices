package com.company;
import java.util.Arrays;
import java.util.Scanner;
//Description: This program takes the user input and split it into lexemes that are considered as separate tokens.

public class lexemeInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an input: ");
        String input1 = input.nextLine();

        String[] separation = input1.split("(\\s+|(?=\\p{Punct})|(?<=\\p{Punct}))" +
                "(?=([^\"]*\"[^\"]*\")*[^\"]*$)(?=([^*/]*/\\*[^/*]*\\*/)*[^*/]*$)");
        System.out.println(Arrays.toString(separation));
        //splitting by whitespace, punctuation, and " "
        for (int i = 0; i < separation.length; i++) {
            if (separation[i] != "") {
                if ((i + 1 < separation.length) && separation[i].equals(separation[i + 1])) {
                    System.out.println(separation[i] + separation[i + 1]);      //for ++ or --
                    i++;                                                        //add 1 so the function can skip (i + 1)
                } else if ((i + 1 < separation.length) && separation[i + 1].matches("=") && separation[i].matches("\\p{Punct}")) {
                    System.out.println(separation[i] + separation[i + 1]);      //for !=, ==, -=, +=, *=, /=
                    i++;                                                        //add 1 so the function can skip (i + 1)
                }
                else {
                    System.out.println(separation[i].trim());       //print out all tokens that arent ++, --, !=, ==, -=, +=, *=, /=
                }
            }
        }
    }
}
