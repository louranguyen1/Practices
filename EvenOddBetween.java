//enter 2 integers to find all the even numbers between them

import java.util.Scanner;
public class EvenOddBetween {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x, y;
        System.out.print("Enter an integer >> ");
        x = input.nextInt();
        System.out.print("Enter another integer >> ");
        y = input.nextInt();

        int max = Math.max(x, y);
        int min = Math.min(x, y);

        boolean ifYes = true;
        for (int i = min; i <= max; i += 2) {
            if (i % 2 != 0) {
                ifYes = false;
                System.out.print("There are no EVEN integers between " + min + " and " + max);
                break;
            }
        }

        if (ifYes) {
            System.out.print("The numbers between " + min + " and " + max + " include: ");
        }
        for (int j = min; j <= max; j += 2) {
            if (j % 2 == 0) {
                System.out.print(j + " ");
            }
        }
    }
}
