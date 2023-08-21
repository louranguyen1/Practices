//practices

public class forPattern1 {
    public static void main(String[] args) {
        //000111222333444555666777888999
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j <= 9; j++) {
                System.out.print(j);
                System.out.print(j);
                System.out.print(j);
            }
            System.out.println();
        }

        //999999999888888887777777666666555554444333221
        for (int i = 1; i <= 4; i++) {
            for (int j = 9; j >= 1; j--) {
                for (int k = -j; k <= -1; k++) {
                    System.out.print(j);
                }
            }
            System.out.println();
        }

        //0000111223
        for (int i = 1; i <= 4; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = j; k <= 3; k++) {
                    System.out.print(j);
                }
            }
            System.out.println();
        }

/*      !!!!!!!!!!!!!!!!!!!!!!
        \\!!!!!!!!!!!!!!!!!!//
        \\\\!!!!!!!!!!!!!!////
        \\\\\\!!!!!!!!!!//////
        \\\\\\\\!!!!!!////////
        \\\\\\\\\\!!//////////    */
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= (2 * i - 2); j++) {
                System.out.print("\\");
            }
            for (int j = 1; j <= (26 - 4 * i); j++) {
                System.out.print("!");
            }
            for (int j = 1; j <= (2 * i - 2); j++) {
                System.out.print("/");
            }
            System.out.println();
        }
    }
}
