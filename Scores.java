//Enter scores and calculate max, min, and average
import java.util.Scanner;
public class Scores {
    public static void main(String[] args) {
        int number, sum = 0, total = 1, max = 0, min = 10;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a score >> ");
        number = input.nextInt();
        sum += number;
        if (number > max && number != 99) {
            max = number;
        }
        if (number < min && number != 99) {
            min = number;
        }

        while (true) {
            System.out.print("Enter another score or 99 to quit >> ");
            number = input.nextInt();
            if (number == 99) {
                break;
            }
            if (number < 0 || number > 10) {
                System.out.println("Score must be between 0 and 10.");
            }
            if (number >= 0 && number != 99) {
                max = number;
                total++;
                if (number > max && number != 99) {
                    max = number;
                }
                if (number < min && number != 99) {
                    min = number;
                }
            }
        }
        System.out.println((total) + " valid scores were entered.");
        System.out.println("Highest was " + max);
        System.out.println("Lowest was " + min);
        System.out.println("Average was " + (float) sum/total);
    }
}
