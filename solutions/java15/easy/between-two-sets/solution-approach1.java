// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/mountblue-technologies/challenges/between-two-sets/problem?isFullScreen=true
// Problem     Between Two Sets
// Difficulty  Easy
// Subdomain   Algorithms
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-08-01, 01:49 p.m.
// Technique   lcm-gcd-range-scan
// Time        O(n + m + (max(b)/lcm(a)))
// Space       O(1)
// Insight     The algorithm identifies all multiples of the least common multiple of array a that are also divisors of the greatest common divisor of array b.
// Interview   Before: "I would iterate through every number between the arrays and check divisibility." After: "I optimized this to O(n + m + range/lcm) by calculating the LCM of array a and GCD of array b, then checking only multiples of the LCM up to the GCD."
// Pitfalls    (1) Failing to handle the case where the LCM of array a exceeds the GCD of array b, resulting in an empty range.  (2) Assuming the input arrays are sorted, which is not guaranteed by the problem statement.  (3) Integer overflow when calculating the product of two numbers in the LCM function before division.
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
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
        
        int gcdB = b.get(0);
        
        for(int i=1; i<b.size(); i++){
            gcdB = GCD(gcdB, b.get(i));
        }
        
        int lcmA = a.get(0);
        
        for(int i=1; i<a.size(); i++){
            lcmA = LCM(lcmA, a.get(i));
        }
        
        int result = 0;
        
        for(int i=lcmA; i<=gcdB; i += lcmA){
            if(gcdB % i == 0){
                result++;
            }
        }
        
        return result;
    }
    
    public static int LCM(int max, int min){
        return (max * min) / GCD(max, min); 
    }
    
    public static int GCD(int max, int min){
        if(max < min){
            int temp = max;
            max = min;
            min = temp;
        }
        
        while(max % min != 0){
            int rem = max % min;
            max = min;
            min = rem;
        }
        return min;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
