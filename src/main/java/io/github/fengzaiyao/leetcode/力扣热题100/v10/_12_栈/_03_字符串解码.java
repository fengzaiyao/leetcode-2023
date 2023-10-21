package io.github.fengzaiyao.leetcode.力扣热题100.v10._12_栈;//package io.github.fengzaiyao.leetcode.力扣热题100.v2._12_栈;
//
//// https://leetcode.cn/problems/decode-string/?envType=study-plan-v2&id=top-100-liked
//
//import java.util.Stack;
//
//public class _03_字符串解码 {
//
//    public static void main(String[] args) {
//        System.out.println(decodeString("3[a]2[bc]"));
//        System.out.println(decodeString("3[a2[c]]"));
//        System.out.println(decodeString("2[abc]3[cd]ef"));
//    }
//
//    public static String decodeString(String s) {
//        Stack<String> stackStr = new Stack<>();
//        Stack<Integer> stackNum = new Stack<>();
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < chars.length;) {
//            // 处理数字
//            if (Character.isDigit(chars[i])) {
//                int num = 0;
//                while (i < chars.length && Character.isDigit(chars[i])) {
//                    num = num * 10 + Character.getNumericValue(chars[i]);
//                    i++;
//                }
//                stackNum.push(num);
//            }
//            // 处理字母
//            else if (Character.isLetter(chars[i])) {
//                StringBuilder builder = new StringBuilder();
//                while (i < chars.length && Character.isLetter(chars[i])) {
//                    builder.append(chars[i]);
//                    i++;
//                }
//                stackStr.push(builder.toString());
//            }
//            // 处理左括号
//            else if (chars[i] == '[') {
//                stackStr.push("[");
//                i++;
//            }
//            // 处理右括号
//            else if (chars[i] == ']') {
//                // 拼接字符,直到遇上左括号
//                StringBuilder builder = new StringBuilder();
//                while (!"[".equals(stackStr.peek())) {
//                    builder.insert(0, stackStr.pop());
//                }
//                // 处理好的字符
//                String str = builder.toString();
//                // 弹出左括号
//                stackStr.pop();
//                // 找出一个数字
//                StringBuilder builder2 = new StringBuilder();
//                Integer cnt = stackNum.pop();
//                for (int k = 0; k < cnt; k++) {
//                    builder2.append(str);
//                }
//                // 将处理后的字符重新放入字符栈中
//                stackStr.push(builder2.toString());
//                i++;
//            }
//        }
//        StringBuilder builder = new StringBuilder();
//        while (!stackStr.isEmpty()) {
//            builder.insert(0, stackStr.pop());
//        }
//        return builder.toString();
//    }
//}
