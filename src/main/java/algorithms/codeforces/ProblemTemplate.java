package algorithms.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemTemplate {

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
