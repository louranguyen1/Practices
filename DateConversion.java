package com.company;
import java.util.Scanner;
public class DateConversion {
    //convert date from improper format to proper format
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter date to be converted (month day, year): ");
        String date = input.nextLine().replaceAll(",", "");

        Scanner dateScanner = new Scanner(date);
        String m = dateScanner.next().toLowerCase();
        String month = m.substring(0, 1).toUpperCase() + m.substring(1);
        int day = dateScanner.nextInt();
        int year = dateScanner.nextInt();

        System.out.println("Converted date: " + day + " " + month + " " + year);
    }
}
