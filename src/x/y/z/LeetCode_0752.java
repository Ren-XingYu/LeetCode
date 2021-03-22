package x.y.z;

import java.util.*;

public class LeetCode_0752 {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        deads.addAll(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (deads.contains(curr)) {
                    continue;
                }
                if (curr.equals(target)) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(curr, j);
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(curr, j);
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public String plusOne(String s, int j) {
        char[] chs = s.toCharArray();
        if (chs[j] == '9') {
            chs[j] = '0';
        } else {
            chs[j] += 1;
        }
        return new String(chs);
    }

    public String minusOne(String s, int j) {
        char[] chs = s.toCharArray();
        if (chs[j] == '0') {
            chs[j] = '9';
        } else {
            chs[j] -= 1;
        }
        return new String(chs);
    }
}
