package zmpress.algorithm.sort;

import java.util.Queue;
import java.util.Stack;

/**
 * @author zc
 * @version 1.0
 * @date 2020/3/10 9:14 下午
 * @desc 快速排序
 * 平均时间复杂度O(NlogN)
 * 最差时间复杂度O(N^2)
 */
public class QuickSort {

    private static final int NUM = 20;

    private static int count = 0;

    public static void main(String[] args) {
        int[] array = SortUtil.randomArray(NUM);
        int[] sort = quickSort2(array);
        System.out.println("排序次数:" + count);
        for (int i : sort) {
            System.out.print(i + " ");
        }
    }


    /**
     * 非递归
     * 从小到大
     * 用栈模拟递归调用的过程
     *
     * @param array
     * @return
     */
    public static int[] quickSort2(int[] array) {

        Stack<Integer> stack = new Stack<Integer>();
        int left = 0;
        int right = array.length - 1;
        stack.push(left);
        stack.push(right);

        while (!stack.empty()) {
            right = stack.pop();
            left = stack.pop();

            // 进行一次快速排序的交换
            int index = partSort(array, left, right);
            if (index - 1 > left) {
                stack.push(left);
                stack.push(index - 1);
            }

            if (index + 1 < right) {
                stack.push(index + 1);
                stack.push(right);
            }
        }
        return array;
    }


    private static int partSort(int[] array, int left, int right) {
        if (left > right) {
            return -1;
        }
        count++;
        // 基准数
        int base = array[left];
        int i = left;
        int j = right;
        int temp;
        while (i != j) {
            while (array[j] >= base && i < j) {
                count++;
                j--;
            }
            while (array[i] <= base && i < j) {
                count++;
                i++;
            }
            temp = array[j];
            array[j] = array[i];
            array[i] = temp;

        }
        // i == j
        array[left] = array[i];
        array[i] = base;

        return i;
    }

    /**
     * 递归
     * 从小到大
     *
     * @param array
     * @return
     */
    public static int[] quickSort(int[] array) {
        sort(array, 0, array.length - 1);
        return array;
    }

    private static void sort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }

        count++;

        // 基准数
        int base = array[left];

        int i = left;
        int j = right;
        int temp;

        while (i != j) {
            while (array[j] >= base && i < j) {
                count++;
                j--;
            }

            while (array[i] <= base && i < j) {
                count++;
                i++;
            }

            temp = array[j];
            array[j] = array[i];
            array[i] = temp;

        }

        // i == j
        array[left] = array[i];
        array[i] = base;

        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }
}
