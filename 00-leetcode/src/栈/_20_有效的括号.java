package 栈;

import java.util.HashMap;
import java.util.Stack;

//https://leetcode.cn/problems/valid-parentheses/description/
public class _20_有效的括号 {
    class Solution1{
        public boolean isValid(String s) {
            while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
                s = s.replace("()", "");
                s = s.replace("[]", "");
                s = s.replace("{}", "");
            }
            return s.isEmpty();
        }
    }
    class Solution2{
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            int len = s.length();
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                }
                else {
                    if (stack.isEmpty()) return false;
                    char left = stack.pop();
                    if (left == '(' && c !=')') return false;
                    if (left == '[' && c !=']') return false;
                    if (left == '{' && c !='}') return false;

                }
            }
            return stack.isEmpty();
        }

    }
    class Solution3{
        private HashMap<Character, Character> map = new HashMap<>();
        {
            map.put('(', ')');
            map.put('[', ']');
            map.put('{', '}');
        }
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            int len = s.length();
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                }
                else {
                    if (stack.isEmpty()) return false;
                    char left = stack.pop();
                    if (map.get(left)!=c) return false;
                }
            }
            return stack.isEmpty();
        }
    }
}
