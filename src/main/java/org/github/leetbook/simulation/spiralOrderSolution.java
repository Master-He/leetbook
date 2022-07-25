package org.github.leetbook.simulation;

import java.util.Arrays;

/**
 * @author hewenji
 * @Date 2022/7/21 22:59
 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/5vfh9g/
 */
public class spiralOrderSolution {
    public static void main(String[] args) {
        int[][] int3multi3 = new int[3][3];
        int3multi3[0] = new int[]{1, 2, 3};
        int3multi3[1] = new int[]{4, 5, 6};
        int3multi3[2] = new int[]{7, 8, 9};

        spiralOrderSolution spiralOrderSolution = new spiralOrderSolution();
        int[] ints = spiralOrderSolution.spiralOrder(int3multi3);
        System.out.println(Arrays.toString(ints));


        int[][] int3multi4 = new int[3][4];
        int3multi4[0] = new int[]{1, 2, 3, 4};
        int3multi4[1] = new int[]{5, 6, 7, 8};
        int3multi4[2] = new int[]{9, 10, 11, 12};
        int[] ints1 = spiralOrderSolution.spiralOrder(int3multi4);
        System.out.println(Arrays.toString(ints1));
    }


    public int[] spiralOrder(int[][] matrix) {

        if (matrix.length == 0) {
            return new int[0];
        }

        int l = 0;
        int r = matrix[0].length - 1;
        int t = 0;
        int b = matrix.length - 1;

        int x = 0;
        int[] res = new int[(r + 1) * (b + 1)];

        while (true) {
            // left to right
            for (int i = l; i <= r; i++) {
                res[x++] = matrix[t][i];
            }
            if (++t > b) {
                break;
            }

            // top to bottom
            for (int i = t; i <= b; i++) {
                res[x++] = matrix[i][r];
            }
            if (l > --r) {
                break;
            }

            // right to left
            for (int i = r; i >= l; i--) {
                res[x++] = matrix[b][i];
            }
            if (t > --b) {
                break;
            }

            // bottom to top
            for (int i = b; i >= t; i--) {
                res[x++] = matrix[i][l];
            }
            if (++l > r) {
                break;
            }
        }

        return res;

    }

}
