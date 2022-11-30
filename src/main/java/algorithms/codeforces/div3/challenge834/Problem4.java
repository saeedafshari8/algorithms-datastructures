package algorithms.codeforces.div3.challenge834;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem4 {

    public static void main(String[] args) throws IOException {
        try (var br = new BufferedReader(new InputStreamReader(System.in))) {
            var numberOfTests = Integer.parseInt(br.readLine());
            var sb = new StringBuilder();
            while (numberOfTests > 0) {
                numberOfTests--;

                sb.append("Answer\n");
            }

            System.out.println(sb);
        }
    }
}
