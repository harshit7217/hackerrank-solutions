// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/mountblue-technologies/challenges/kangaroo/problem?isFullScreen=true
// Problem     Number Line Jumps
// Difficulty  Easy
// Subdomain   Algorithms
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-07-28, 10:26 a.m.
// Technique   simulation-loop
// Time        O((x2-x1)/(v1-v2))
// Space       O(1)
// Insight     The simulation tracks the positions of both kangaroos until one overtakes the other or they meet, effectively checking if their relative distance reaches zero.
// Interview   Before: "I could solve this using a mathematical equation to find the intersection point." After: "I implemented a simulation approach with O((x2-x1)/(v1-v2)) time complexity, which is efficient given the constraints, ensuring we correctly handle cases where one kangaroo starts ahead and moves faster."
// Pitfalls    (1) Infinite loops occur if the faster kangaroo is already ahead and moving away, as the loop condition only terminates when the trailing kangaroo overtakes the leader.  (2) The logic fails to account for cases where v1 equals v2, potentially leading to an infinite loop if x1 does not equal x2 initially.  (3) Integer overflow is possible if the simulation runs for a very large number of jumps, though the problem constraints typically limit this.
// ──────────────────────────────────────────────────

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'kangaroo' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER x1
     *  2. INTEGER v1
     *  3. INTEGER x2
     *  4. INTEGER v2
     */

    public static String kangaroo(int x1, int v1, int x2, int v2) {
    // Write your code here
        if(x1 < x2){
            while(x1 < x2){
                x1 += v1;
                x2 += v2;
                if(x1 == x2) return "YES";
            }
        }else {
            while(x2 < x1){
                x1 += v1;
                x2 += v2;
                if(x1 == x2) return "YES";
            }
        }
        return "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int x1 = Integer.parseInt(firstMultipleInput[0]);

        int v1 = Integer.parseInt(firstMultipleInput[1]);

        int x2 = Integer.parseInt(firstMultipleInput[2]);

        int v2 = Integer.parseInt(firstMultipleInput[3]);

        String result = Result.kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
