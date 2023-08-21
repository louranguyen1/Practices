import java.util.Scanner;
public class StringLength {
    
    /*
    1) ask user to enter in their name
    2) find the first initial and length of string
    3) ask yes to continue or no to stop
     */
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        char response;
        char response1;
        do {
            System.out.print("Please enter your first and last name, separated by space: ");
            String[] name = input.nextLine().split(" ");

            String firstName = name[0];
            String lastName = name[1];
            char firstInitial = firstName.charAt(0);
            char lastInitial = lastName.charAt(0);

            int count = 0;
            for (int i = 0; i < firstName.length(); i++) {
                count++;
            }
            int count1 = 0;
            for (int j = 0; j < lastName.length(); j++) {
                count1++;
            }

            System.out.println("Hello there " + firstName + ", I have your first name as " + firstName + ", which has " + count + " characters.");
            System.out.println("Hello again " + lastName + ", I have your last name as " + lastName + ", which has " + count1 + " characters.");
            System.out.println("Did you know that your initials are " + firstInitial + lastInitial);
            System.out.print("Do you wish to continue (Y) Yes or (N) No? ");
            response = input.nextLine().charAt(0);
            response1 = Character.toUpperCase(response);
        }
        while (response1 != 'n' && response1 != 'N');
        input.close();
    }
}
