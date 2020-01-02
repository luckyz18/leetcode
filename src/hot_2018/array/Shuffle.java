package hot_2018.array;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 打乱数组
 */
public class Shuffle {
    private int[] array;
    private int[] original;
    private Random random = new Random();

    public Shuffle(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        array = original.clone();
        return array;
    }

    public List<Integer> getList(int[] arr) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        List<Integer> list = getList(array);
        for (int i = 0; i < array.length; i++) {
            int randomIndex = random.nextInt(list.size());
            array[i] = list.get(randomIndex);
            list.remove(randomIndex);
        }
        return array;
    }

    //2. 洗牌算法
    public int[] reset2() {
        array = original;
        original = original.clone();
        return original;
    }

    public int randRange(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    public void swapAt(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public int[] shuffle2() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }

    //---
    public int[] shuffle3() {
        int[] a = array.clone();
        for (int j = 1; j < a.length; j++) {
            int i = random.nextInt(j + 1);
            swap(a, i, j);
        }
        return a;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    //--- 好绕
    public int[] shuffle4() {
        int[] rand = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int r = (int) (Math.random() * (i + 1));
            rand[i] = rand[r];
            rand[r] = array[i];
        }
        return rand;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Shuffle obj = new Shuffle(nums);
        obj.shuffle4();
        System.out.println();
    }
}
