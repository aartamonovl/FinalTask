package Input;

import java.util.Scanner;

public class ConsoleInput {
    public static String inputStr() {
        String str = "";
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        return str;
    }

    public static int inputInt() {
        int number = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                break;
            }
        }
        return number;
    }
}
