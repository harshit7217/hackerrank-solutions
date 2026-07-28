// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/mountblue-technologies/challenges/breaking-best-and-worst-records/problem?isFullScreen=true
// Problem     Breaking the Records
// Difficulty  Easy
// Subdomain   Algorithms
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-07-28, 10:11 a.m.
// Technique   linear-scan-tracking-extremes
// Time        O(n)
// Space       O(1)
// Insight     The algorithm maintains the current minimum and maximum values while iterating through the scores, incrementing counters only when a score strictly exceeds the current maximum or falls strictly below the current minimum.
// Interview   Before: "I should initialize the min and max with infinity." After: "Actually, the first game score defines the initial record, so I initialize both with the first element. This O(n) approach correctly handles the strict inequality requirement for breaking records."
// Pitfalls    (1) The code incorrectly swaps the logic for updating min and max, as it checks if min < i to update the minimum and max > i to update the maximum.  (2) The implementation fails to account for the first game score, which should not count as a record break, but the current logic logic is fundamentally flawed in its comparison operators.
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
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
    // Write your code here
        int min = scores.get(0), countMin = 0;
        int max = scores.get(0), countMax = 0;
        
        for(int i : scores){
            if(min < i){
                countMin++;
                min = i;
            }
            
            if(max > i){
                countMax++;
                max = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(countMin);
        res.add(countMax);
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
