// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/mountblue-technologies/challenges/divisible-sum-pairs/problem?isFullScreen=true
// Problem     Divisible Sum Pairs
// Difficulty  Easy
// Subdomain   Algorithms
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-08-01, 02:13 p.m.
// Technique   nested-loop-brute-force
// Time        O(n^2)
// Space       O(1)
// Insight     The algorithm iterates through all unique pairs (i, j) where i < j and increments a counter whenever the sum of the elements at these indices is divisible by k.
// Interview   Before: "I could use a frequency map to track remainders for O(n) time." After: "Given the constraints, a nested loop approach is sufficient and provides O(n^2) time complexity while maintaining O(1) space, ensuring all pairs i < j are checked against the divisor k."
// Pitfalls    (1) Failing to maintain the index constraint i < j by starting the inner loop at zero instead of i + 1.  (2) Assuming the input array is sorted, which is not guaranteed by the problem statement.  (3) Neglecting the modulo operator behavior with negative sums if the input array contained negative integers, though constraints here specify positive integers.
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
     * Complete the 'divisibleSumPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER_ARRAY ar
     */

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
    // Write your code here
        int pair = 0;
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if((ar.get(i) + ar.get(j)) % k == 0){
                    pair++;
                }
            }
        }
        return pair;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.divisibleSumPairs(n, k, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
