package Controller;

import java.util.Scanner;

public class InputHandlers {
    public static int getChoice() {
        System.out.println("•> ");
        // read user integer input in new line
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static String getInput(String instruction) {
        // print out the instruction and "read" user input in new line
        System.out.println(instruction);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
