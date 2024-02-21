package SQL;

import java.util.Optional;
import java.util.Scanner;

public class Checking {
    private static final Scanner scr = new Scanner(System.in);

    public static void onlyLetterForUsername(String str) {
        Optional.of(str)
                .filter(s -> s.matches("^[a-zA-Z0-9]*$"))
                .orElseThrow(() -> new RuntimeException("Invalid input: " + str));
    }

    public static void correctPassword(String password) {
        Optional.of(password)
                .filter(p -> p.matches("^[a-zA-Z0-9]*$") & p.matches(".*[A-Z].*") & p.length() >= 8)
                .orElseThrow(() -> new RuntimeException("\n> Password must contain only digits and letters\n" +
                        "> Password must have at least one uppercase letter\n" +
                        "> Password must be at least 8 characters long.\n"));
    }
}