package algorithms.codeforces.div3.challenge834;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Problem5 {

    public static void main(String[] args) throws IOException {
        try (var br = new BufferedReader(new InputStreamReader(System.in))) {
            var numberOfTests = Integer.parseInt(br.readLine());
            var sb = new StringBuilder();
            while (numberOfTests > 0) {
                numberOfTests--;

                int h = Integer.parseInt(br.readLine().split(" ")[1]);
                String[] split = br.readLine().split(" ");
                int i = solution1(h, split);
                int i2 = solution2(h, split);

                sb.append(Integer.max(i, i2)).append("\n");
            }

            System.out.println(sb);
        }
    }

    private static int solution1(int h, String[] split) {
        PriorityQueue<Integer> powers = new PriorityQueue<>();
        for (int i = 0; i < split.length; i++) {
            int pwr = Integer.parseInt(split[i]);
            powers.add(pwr);
        }
        int i = 0;
        int blue = 2;
        int green = 1;
        while (!powers.isEmpty()) {
            if (powers.peek() < h) {
                i++;
                Integer power = powers.remove();
                h += power / 2;
                continue;
            }
            if (blue > 0) {
                blue--;
                h *= 2;
            } else if (green > 0) {
                green--;
                h *= 3;
            }
            if (powers.peek() >= h && blue == 0 && green == 0) {
                break;
            }
        }
        return i;
    }

    private static int solution2(int h, String[] split) {
        PriorityQueue<Integer> powers = new PriorityQueue<>();
        boolean flag = false;
        int blue = 2;
        int green = 1;
        int nums = 0;
        for (int i = 0; i < split.length; i++) {
            int pwr = Integer.parseInt(split[i]);
            if (pwr > 1 && h < pwr && h * 2 > pwr && !flag) {
                h *= 2;
                h += pwr / 2;
                blue--;
                flag = true;
                nums++;
            } else if (pwr > 1 && h < pwr && h * 3 > pwr && !flag) {
                h *= 3;
                h += pwr / 2;
                green--;
                flag = true;
                nums++;
            } else {
                powers.add(pwr);
            }
        }
        while (!powers.isEmpty()) {
            if (powers.peek() < h) {
                nums++;
                Integer power = powers.remove();
                h += power / 2;
                continue;
            }
            if (blue > 0) {
                blue--;
                h *= 2;
            } else if (green > 0) {
                green--;
                h *= 3;
            }
            if (powers.peek() >= h && blue == 0 && green == 0) {
                break;
            }
        }
        return nums;
    }
}
