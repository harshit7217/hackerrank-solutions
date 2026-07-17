// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/challenges/balanced-brackets/problem?isFullScreen=true
// Problem     Balanced Brackets
// Difficulty  Medium
// Subdomain   Stacks
// Platform    HackerRank
// Language    java8
// Status      Accepted
// Submitted   2026-07-18, 12:58 a.m.
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
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
    // Write your code here
        Stack<Character> stk = new Stack<>();
        if(s == null || s.length() == 0)
            return "NO";
            
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ')'){
                if(!stk.isEmpty() && stk.peek() == '(')
                    stk.pop();
                else 
                    return "NO";
            }else if(s.charAt(i) == '}'){
                if(!stk.isEmpty() && stk.peek() == '{')
                    stk.pop();
                else 
                    return "NO";
            }else if(s.charAt(i) == ']'){
                if(!stk.isEmpty() && stk.peek() == '[')
                    stk.pop();
                else 
                    return "NO";
            }else {
                stk.push(s.charAt(i));
            }
        }
        
        return stk.isEmpty() ? "YES" : "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
