package org.main.logsystem.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class first {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            String line = reader.readLine();
            System.out.println("Inverted line: " + invertString(line));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String invertString(String input) {
        if (input == null || input.length() <= 1)
            return input;
        return invertString(input.substring(1)) + input.charAt(0);
    }
}
