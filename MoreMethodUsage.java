//ask user to enter inches, then convert to feet and yards
import java.util.Scanner;
public class MoreMethodUsage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int inches;
        System.out.print("Enter inches >> ");
        inches = input.nextInt();

        convertToFeet(inches);
        convertToYards(inches);
    }
    public static void convertToFeet(int inches) {
        float result = (float) inches / 12;
        System.out.println(inches + " inches is " + result + " feet.");
    }
    public static void convertToYards(int inches) {
        float result1 = (float) inches / 36;
        System.out.println(inches + " inches is " + result1 + " yards.");
    }
}
