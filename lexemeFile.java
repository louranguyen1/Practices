package com.company;
import java.io.File;
import java.util.Scanner;
//Description: takes in a text file and splits it into lexemes, identify what they are, and if they have any syntax errors

/*
    numbers = [0-9]
    letters = [a-z]*[A-Za-z0-9_]*
    whitespace = \\s+
    punctuation = (?=\\p{Punct})|(?<=\\p{Punct})
    quotations = (?=([^\"]*\"[^\"]*\")*[^\"]*$)
*/
public class lexemeFile {

    public static void importFile(File file) throws Exception {
        Scanner input = new Scanner(file);      //read
        while (input.hasNextLine()) {
            String nextToken = input.nextLine();
            lexSep(String.valueOf(nextToken));  //check on lexemes
        }
    }

    public static void lexSep(String input) {
        String[] separation = input.split("(\\s+|(?=\\p{Punct})|(?<=\\p{Punct}))" +
                "(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        //splitting by whitespace, punctuation, and " "
        for (int i = 0; i < separation.length; i++) {
            if (separation[i] != "") {
                if ((i + 1 < separation.length) && separation[i].equals(separation[i + 1])) {
                    System.out.println(separation[i] + separation[i + 1] + " - Operator");      //for ++ or --
                    i++;                                                                        //add 1 so the function can skip (i + 1)
                } else if ((i + 1 < separation.length) && separation[i + 1].matches("=") && separation[i].matches("\\p{Punct}")) {
                    System.out.println(separation[i] + separation[i + 1] + " - Operator");      //for !=, ==, -=, +=, *=, /=
                    i++;                                                                        //add 1 so the function can skip (i + 1)
                }
                else {
                    lex(separation[i].trim());              //print out all tokens that arent ++, --, !=, ==, -=, +=, *=, /=
                }                                           //calls on lex function so that the lexeme can be labeled
            }
        }
    }

    //this is part e. check lexical error
    public static void lex(String input) {
        char array[] = input.toCharArray();         //put in a char array. this code is mainly for boolean bool
        boolean bool = Character.isDigit(array[0]); //check on the first digit to see if it's a number
        boolean letter = true;
        if (input.startsWith("\"") && input.endsWith("\"")) {   //check if the input is in " "
            letter = false;
        }
        if (!letter) {           //if input is in " "
            System.out.println(input + " - Content/Input");
        }
        else if (input.matches("for|while|if|else")) {     //keyword and not in " "
            System.out.println(input + " - Keyword");
        }
        else if (input.matches("\\p{Punct}")) {    //punctuations/operations (like + that combines 2 strings)
            System.out.println(input + " - Operation/Punctuation");
        }
        else if (input.matches("[A-Za-z0-9_]+$") && (!bool)) { //identifier (letters, digits, underscores)
            System.out.println(input + " - Identifier");
        }
        else if (input.matches("[0-9]*[A-Za-z_]")) {    //identifier that starts with a number
            System.out.println(input + " - Lexical Error (Identifier can't start with a number)");
        }
        else if (input.matches("[0-9]+$")) {        //numbers
            System.out.println(input + " - Number");
        }
        else {
            //any syntax error where there's only 1 " will cause an error when splitting (show up in sentence)
            String[] separation = input.split("(\\s+|(?=\\p{Punct})|(?<=\\p{Punct}))"); //split again
            for (int i = 0; i < separation.length; i++) {
                if (separation[i] != "" && !separation[i].equals("\"")) {
                    lex(separation[i]);         //go through lex again
                }
                if (separation[i].matches("\"")) {      //anything that doesn't belong in the rest of if-else if
                    System.out.println(separation[i] + " - Error");
                }
            }
        }
    }

    //this is part f. check syntax error
    public static void checkE(File file) throws Exception {
        int count_q1 = 0;
        int count_b = 0;
        int count_p = 0;
        int count_o = 0;
        Scanner input1 = new Scanner(file);     //read file
        while (input1.hasNextLine()) {
            String input = input1.nextLine();   //get the next line
            int count_q = 0;                    //put this here for quotations so it could reset to 0 after each loop
            for (int i = 0; i < input.length(); i++) {      //check the line
                if (input.charAt(i) == '"' || input.charAt(i) == '\'') {    //check to see how many " or '
                    count_q++;
                }
                if (input.charAt(i) == '[' || input.charAt(i) == ']') {     //check to see how many [ or ]
                    count_b++;
                }
                if (input.charAt(i) == '{' || input.charAt(i) == '}') {     //check to see how many { or }
                    count_p++;
                }
                if (input.charAt(i) == '(' || input.charAt(i) == ')') {     //check to see how many ( or )
                    count_o++;
                }
            }
            if (count_q % 2 != 0) {     //this is for quotations (opening and closing quotations is always on 1 line)
                count_q1++;             //if it's even, then all quotation marks are closed, if odd then it's not closed
            }
        }

        //if count_q1 is bigger than 0, then that means it has lines where quotations arent closed
        if (count_q1 > 0) {
            System.out.println("Syntax Error (quotations aren't close): " + count_q1);
        }

        //if it's odd, then that means they aren't close since it should be in pairs
        if (count_b % 2 != 0) {
            System.out.println("Syntax Error (bracket(s) aren't close)");
        }
        if (count_p % 2 != 0) {
            System.out.println("Syntax Error (brace(s) aren't close)");
        }
        if (count_o % 2 != 0) {
            System.out.println("Syntax Error (parenthese(s) aren't close)");
        }
    }

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\_name_\\Downloads\\test1.txt");     //text file; replace _name_
        importFile(file);       //check lexical error
        System.out.println();
        checkE(file);           //check syntax error
    }
}


/* test files that I used (put them in a .txt file)

  - test1.txt
    This is a text file example:
    public class Main {
	    public static void main(String[] args) {
		    String a = "a";
		    int i = 3;
	    }
    }

  - test2.txt
    public class Main {
        public static void main String[] args) {
            String a = a";
            int i = 3;
            String b = c";
            System.out.println("yes);
        }

  - test3.txt
    public class Main {
        public static void main (String[] args) {
            int 3a = 3;
            String 1a = "yes";
            String 9a = "no";
            int 1b = 5;
            int 0x = 1;
        }
    }

  - test4.txt
    public class main {
    	public static void main(String[] args) {
	    	String a = "this is a correct file with no errors";
		    String b = "moving on to the next file";
    		int sum = 0;
	    	sum++;
	    }
    }
 */
