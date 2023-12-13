package org.main.logsystem.queue;

import java.util.HashMap;

public class First {
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> charCount = new HashMap<>();

        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (charCount.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leopard"));
        System.out.println(firstUniqChar("loveleopard"));
        System.out.println(firstUniqChar("aabb"));
    }
}
