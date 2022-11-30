package algorithms.codeforces.div3.challenge834;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem3 {

    public static void main(String[] args) throws IOException {
        try (var br = new BufferedReader(new InputStreamReader(System.in))) {
            var numberOfTests = Integer.parseInt(br.readLine());
            var sb = new StringBuilder();
            while (numberOfTests > 0) {
                numberOfTests--;

                String[] split = br.readLine().split(" ");
                int l = Integer.parseInt(split[0]);
                int r = Integer.parseInt(split[1]);
                int x = Integer.parseInt(split[2]);
                split = br.readLine().split(" ");
                int a = Integer.parseInt(split[0]);
                int b = Integer.parseInt(split[1]);
                if (b == a) {
                    sb.append("0").append("\n");
                } else if (a + x >= r && a - x <= l) {
                    sb.append("-1").append("\n");
                } else if (b - a >= x) {
                    sb.append("1").append("\n");
                } else {
                    int maxMove = r - (a + x);
                    if(maxMove > b){
                        sb.append("2").append("\n");
                    } else{
                        sb.append("3").append("\n");
                    }
                }
            }

            System.out.println(sb);
        }
    }
}
