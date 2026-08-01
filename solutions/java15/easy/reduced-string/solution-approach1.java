// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/mountblue-technologies/challenges/reduced-string/problem?isFullScreen=true
// Problem     Super Reduced String
// Difficulty  Easy
// Subdomain   Algorithms
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-08-01, 02:27 p.m.
// Technique   stack-based-character-reduction
// Time        O(n)
// Space       O(n)
// Insight     The algorithm maintains a stack where each incoming character is compared to the top element, resulting in a pop if they match or a push if they differ.
// Interview   Before: "I would use a recursive approach to repeatedly find and remove adjacent duplicates." After: "Using a stack allows for a single-pass O(n) time and O(n) space solution that efficiently handles the reduction of adjacent characters until no more pairs remain."
// Pitfalls    (1) Failing to handle the empty stack case after all reductions, which must return the string 'Empty String' as specified.  (2) Using string concatenation inside a loop, which can lead to O(n^2) performance in some Java environments due to repeated object creation.
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
     * Complete the 'superReducedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String superReducedString(String s) {
    // Write your code here
        Stack<Character> stk = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(stk.isEmpty()){
                stk.push(c);
            }else if(stk.peek() == c){
                stk.pop();
            }else {
                stk.push(c);
            }
        }
        if(stk.isEmpty()) return "Empty String";
        Stack<Character> newStk = new Stack<>();
        while(!stk.isEmpty()){
            newStk.push(stk.pop());
        }
        String res = "";
        while(!newStk.isEmpty()){
            res += newStk.pop();
        }
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
