package org.github.leetbook.divideconquer;


/**
 * @author hewenji
 * @Date 2022/7/25 23:30
 */
public class reversePairsSolution {

    private int[] nums;
    private int[] tmp;

    public static void main(String[] args) {

        int[] array = {7, 5, 6, 4};

        reversePairsSolution reversePairsSolution = new reversePairsSolution();
        System.out.println(reversePairsSolution.reversePairs(array));

    }

    public int reversePairs(int[] nums) {
        this.nums = nums;
        this.tmp = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }

    public int mergeSort(int l, int r) {
        // 终止条件
        if (l >= r) {
            return 0;
        }

        // 递归划分
        int m = (l + r) / 2;
        int res = mergeSort(l, m) + mergeSort(m + 1, r);

        // 合并
        int i = l;
        int j = m + 1;

        for (int k = l; k <= r; k++) {
            tmp[k] = nums[k];
        }

        for (int k = l; k <= r; k++) {
            if (i == m + 1) {
                nums[k] = tmp[j++];
            } else if (j == r + 1 || tmp[i] <= tmp[j]) {
                nums[k] = tmp[i++];
            } else {
                nums[k] = tmp[j++];
                res += m - i + 1;
            }
        }

        return res;
    }

}
