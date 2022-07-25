package org.github.leetbook.simulation;

import java.util.Stack;

/**
 * @author hewenji
 * @Date 2022/7/23 10:38
 */
public class validStackSequencesSolution {
    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};

        validStackSequencesSolution solution = new validStackSequencesSolution();
        System.out.println(solution.validateStackSequences(pushed, popped));

        popped = new int[]{4, 3, 5, 1, 2};
        System.out.println(solution.validateStackSequences(pushed, popped));

    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num); // num 入栈
            while (!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }


}
