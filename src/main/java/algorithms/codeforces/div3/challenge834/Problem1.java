package algorithms.codeforces.div3.challenge834;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1 {

    public static void main(String[] args) throws IOException {
        try (var br = new BufferedReader(new InputStreamReader(System.in))) {
            var numberOfTests = Integer.parseInt(br.readLine());
            var sb = new StringBuilder();
            while (numberOfTests > 0) {
                numberOfTests--;

                String s = br.readLine();
                int index = -1;
                if (s.startsWith("Y")) {
                    index = 0;
                } else if (s.startsWith("e")) {
                    index = 1;
                } else if (s.startsWith("s")) {
                    index = 2;
                }

                if (index == -1) {
                    sb.append("NO\n");
                } else {
                    sb.append("Yes".repeat((s.length() / 3 + 3)).contains(s) ? "YES" : "NO").append("\n");
                }
            }

            System.out.println(sb);
        }
    }
}
