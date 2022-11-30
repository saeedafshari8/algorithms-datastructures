package algorithms.codeforces.div3.challenge834;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Problem2 {

    public static void main(String[] args) throws IOException {
        try (var br = new BufferedReader(new InputStreamReader(System.in))) {
            var numberOfTests = Integer.parseInt(br.readLine());
            var sb = new StringBuilder();
            while (numberOfTests > 0) {
                numberOfTests--;

                String[] split = br.readLine().split(" ");
                int n = Integer.parseInt(split[0]);
                int sum = Integer.parseInt(split[1]);

                split = br.readLine().split(" ");
                Set<Integer> found = new HashSet<>();
                Set<Integer> notFound = new HashSet<>();
                int max1 = 0;
                int max2 = 0;
                for (int i = 0; i < split.length; i++){
                    int num = Integer.parseInt(split[i]);
                    found.add(num);
                    max1 = Integer.max(max1, num);
                }
                int sum2 = 0;
                for(int i = 1; i < Integer.MAX_VALUE; i++){
                    if(!found.contains(i)){
                        sum2 += i;
                        notFound.add(i);
                        max2 = Integer.max(max2, i);
                    }
                    if(sum2 >= sum){
                        break;
                    }
                }
                int max = Integer.max(max1, max2);
                sb.append(sum2 == sum && max == (found.size() + notFound.size()) ? "YES" : "NO").append("\n");
            }

            System.out.println(sb);
        }
    }
}
