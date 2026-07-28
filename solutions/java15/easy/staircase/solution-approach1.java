// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/mountblue-technologies/challenges/staircase/problem?isFullScreen=true
// Problem     Staircase
// Difficulty  Easy
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-07-28, 10:31 a.m.
// Technique   nested-loop-string-construction
// Time        O(n^2)
// Space       O(1)
// Insight     The algorithm prints n lines where each line i contains n-1-i leading spaces followed by i+1 hash symbols.
// Interview   Before: "How would you print a right-aligned staircase of size n?" After: "I use nested loops to print spaces and hashes, resulting in O(n^2) time complexity, ensuring the last line has zero leading spaces as required by the problem constraints."
// Pitfalls    (1) Incorrectly calculating the number of spaces as n-i instead of n-1-i, which would cause the staircase to be misaligned.  (2) Using an incorrect loop range for the hash symbols, such as starting from 1 instead of 0, which would result in an incorrect number of characters per line.
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
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void staircase(int n) {
    // Write your code here
    
        for(int i=0; i<n; i++){
            
            for(int j=n-1-i; j>0; j--){
                System.out.print(" ");
            }
            
            for(int k=0; k<i+1; k++){
                System.out.print("#");
            }
            System.out.println();
        }
        

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.staircase(n);

        bufferedReader.close();
    }
}
