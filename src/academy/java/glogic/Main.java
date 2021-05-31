package academy.java.glogic;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Your input text: ");
        String input = scanner.nextLine().toLowerCase();
        String filteredInput = Util.removeSpecialChars(input);

        InputParser ip = new InputParser(new char[] {'L', 'O', 'G', 'I', 'C'});
        ip.parseInput(filteredInput);
    }
}
