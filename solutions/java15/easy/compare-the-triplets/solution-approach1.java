// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/mountblue-technologies/challenges/compare-the-triplets/problem?isFullScreen=true
// Problem     Compare the Triplets
// Difficulty  Easy
// Subdomain   Algorithms
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-07-28, 10:36 a.m.
// Technique   linear-scan-comparison
// Time        O(1)
// Space       O(1)
// Insight     The algorithm iterates through the fixed-size triplets once, incrementing the respective score counter only when a strict inequality is satisfied for each index.
// Interview   Before: "I would use a hash map to store the counts for Alice and Bob." After: "Since the input size is fixed at three, a simple linear scan with two integer counters provides an O(1) time and O(1) space solution that correctly handles the comparison rules."
// Pitfalls    (1) Failing to handle the equality case where neither Alice nor Bob receives a point.  (2) Incorrectly returning the scores in the wrong order, as the problem requires Alice's score first.
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
     * Complete the 'compareTriplets' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int alice = 0; int bob = 0;
        for(int i=0; i<a.size(); i++){
            if(a.get(i) > b.get(i)){
                alice++;
            }else if(a.get(i) < b.get(i)){
                bob++;
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(alice);
        res.add(bob);
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.compareTriplets(a, b);

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
