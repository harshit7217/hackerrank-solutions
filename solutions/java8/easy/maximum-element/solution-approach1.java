// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/challenges/maximum-element/problem?isFullScreen=true
// Problem     Maximum Element
// Difficulty  Easy
// Subdomain   Stacks
// Platform    HackerRank
// Language    java8
// Status      Accepted
// Submitted   2026-07-24, 10:38 p.m.
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
     * Complete the 'getMax' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY operations as parameter.
     */

    public static List<Integer> getMax(List<String> operations) {
    // Write your code here
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();
        Stack<Integer> maxStl = new Stack<>();
        for(String str : operations){
            String[] s = str.split(" ");
            int operation = Integer.parseInt(s[0]);
            if(operation == 1){
                stk.push(Integer.parseInt(s[1]));
                if(maxStl.isEmpty()){
                    maxStl.push(Integer.parseInt(s[1]));
                }else {
                    maxStl.push(Integer.parseInt(s[1]) > maxStl.peek() ? Integer.parseInt(s[1]) : maxStl.peek());
                }
            }else if(operation == 2){
                if(!stk.isEmpty()){
                    stk.pop();
                    maxStl.pop();
                }
            }else if(operation == 3){
                if(!stk.isEmpty()){
                    result.add(maxStl.peek());
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

        List<String> ops = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> res = Result.getMax(ops);

        bufferedWriter.write(
            res.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
