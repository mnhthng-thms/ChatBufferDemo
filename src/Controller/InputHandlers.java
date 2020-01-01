package Controller;

import java.util.Scanner;

public class InputHandlers {
    public static int getChoice() {
        System.out.println("•> ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    public static String getInput(String instruction) {
        System.out.println(instruction);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
