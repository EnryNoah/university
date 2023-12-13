package org.main.logsystem.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fifth {
    public static int[] movesToStamp(String stamp, String target) {
        char[] s = target.toCharArray();
        char[] t = stamp.toCharArray();
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[s.length];
        boolean replaced;

        while (!allStamped(visited)) {
            replaced = false;

            for (int i = 0; i <= s.length - t.length; i++) {
                if (!visited[i] && canReplace(s, i, t)) {
                    replaceStamp(s, i, t.length);
                    result.add(i);
                    replaced = true;

                    for (int j = 0; j < t.length; j++) {
                        if (s[i + j] != '*' && s[i + j] != t[j]) {
                            visited[i + j] = true;
                        }
                    }
                }
            }

            if (!replaced) {
                break;
            }
        }

        if (allStamped(visited)) {
            int[] resultArray = new int[result.size()];
            for (int i = 0; i < resultArray.length; i++) {
                resultArray[i] = result.get(resultArray.length - 1 - i);
            }
            return resultArray;
        } else {
            return new int[]{};
        }
    }

    private static boolean allStamped(boolean[] visited) {
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    private static boolean canReplace(char[] s, int index, char[] t) {
        for (int i = 0; i < t.length; i++) {
            if (s[index + i] != '*' && s[index + i] != t[i]) {
                return false;
            }
        }
        return true;
    }

    private static void replaceStamp(char[] s, int index, int length) {
        for (int i = 0; i < length; i++) {
            s[index + i] = '*';
        }
    }

    public static void main(String[] args) {
        int[] result1 = movesToStamp("abc", "ababc");
        System.out.println("Output 1: " + java.util.Arrays.toString(result1));  // Output: [0, 2]

        int[] result2 = movesToStamp("abca", "aabcaca");
        System.out.println("Output 2: " + java.util.Arrays.toString(result2));  // Output: [3, 0, 1]
    }
}
