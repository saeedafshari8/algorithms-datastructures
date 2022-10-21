package algorithms.datastructure.primitive.string;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */
class BalanceString {

    String getBalancedString(String s) {
        Stack<Integer> aStack = new Stack<>();
        Set<Integer> indexes = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                aStack.push(i);
            } else if (s.charAt(i) == ')') {
                if (aStack.isEmpty()) {
                    indexes.add(i);
                } else {
                    aStack.pop();
                }
            }
        }
        while (!aStack.isEmpty()) {
            indexes.add(aStack.pop());
        }
        for (int i = 0; i < s.length(); i++) {
            if (!indexes.contains(i)) sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
