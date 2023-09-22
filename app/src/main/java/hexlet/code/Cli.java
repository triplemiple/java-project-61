package hexlet.code;

import java.util.Scanner;

public class Cli {

    public static String askName() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        Scanner sc = new Scanner(System.in);
        String username = sc.next();
        String greetings = String.format("Hello, %s!", username);
        System.out.println(greetings);
        return username;
    }
}
