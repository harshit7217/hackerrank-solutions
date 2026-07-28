// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/mountblue-technologies/challenges/sock-merchant/problem?isFullScreen=true
// Problem     Sales by Match
// Difficulty  Easy
// Subdomain   Algorithms
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-07-28, 09:14 a.m.
// Technique   sorting-and-stack-matching
// Time        O(n log n)
// Space       O(n)
// Insight     The algorithm sorts the input list to group identical colors, then uses a stack to identify pairs by popping the stack whenever the current element matches the top.
// Interview   Before: "I could use a frequency map to count occurrences of each color." After: "Sorting the list allows me to pair adjacent identical elements using a stack, achieving O(n log n) time complexity and O(n) space complexity, which is efficient for the given constraints."
// Pitfalls    (1) Sorting the list is mandatory for the stack-based pairing logic to function correctly.  (2) The stack approach relies on the sorted order to ensure that identical colors are adjacent, allowing the peek-and-pop logic to identify pairs.
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
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
    // Write your code here
        Collections.sort(ar);
        Stack<Integer> stk = new Stack<>();
        int result = 0;
        for(int i : ar){
            if(stk.isEmpty()){
                stk.push(i);
            }else {
                if(stk.peek() == i){
                    stk.pop();
                    result++;
                }else {
                    stk.push(i);
                }
            }
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
