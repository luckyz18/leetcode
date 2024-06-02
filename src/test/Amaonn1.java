package test;

import java.util.Arrays;

/**
 * 代码有问题
 */
public class Amaonn1 {
    public static int removeProducts(int[] prices, int k, int threshold) {
        Arrays.sort(prices);
        int start = 0;
        int end = prices.length - 1;
        int sum = 0;

        while (start <= end) {
            sum += prices[start];
            if (sum <= threshold) {
                start++;
            } else {
                sum -= prices[end];
                end--;
            }
        }

        return Math.max(0, k - (end - start + 1));
    }

    public static void main(String[] args) {
        int[] prices = {3, 2, 1, 4, 6, 5};
        int k = 3;
        int threshold = 14;
        int result = removeProducts(prices, k, threshold);
        System.out.println("需要移除的商品数量为：" + result);

    }

}
