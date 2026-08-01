// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/mountblue-technologies/challenges/mini-max-sum/problem?isFullScreen=true
// Problem     Mini-Max Sum
// Difficulty  Easy
// Subdomain   Algorithms
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-08-01, 02:04 p.m.
// Technique   sorting-and-linear-summation
// Time        O(N log N)
// Space       O(1)
// Insight     The algorithm sorts the array to identify the four smallest and four largest elements, calculating their respective sums in linear time.
// Interview   Before: "I could iterate through all combinations to find the min and max sums." After: "Sorting allows us to compute the min and max sums in O(N log N) time, which is efficient for five elements while preventing integer overflow by using long types."
// Pitfalls    (1) Failing to use long integers for the sum, which causes overflow when the input integers are large.  (2) Incorrectly indexing the array during summation, which leads to including the wrong elements in the min or max calculation.
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
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
        Collections.sort(arr);
        
        long min = 0;
        for(int i=0; i<4; i++){
            min += arr.get(i);
        }
        
        long max = 0;
        for(int i=arr.size() - 1; i>0; i--){
            max += arr.get(i);
        }
        System.out.print(min +" "+ max);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
