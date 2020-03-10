package zmpress.algorithm.sort;

/**
 * @author zc
 * @version 1.0
 * @date 2020/3/10 8:30 下午
 * @desc 冒泡排序
 * 时间复杂度O(N^2)
 */
public class BubbleSort {

    private static final int NUM = 50;

    private static int count = 0;


    public static void main(String[] args) {
        int[] array = SortUtil.randomArray(NUM);
        int[] sort = bubbleSort(array);
        System.out.println("排序次数:" + count);
        for (int i : sort) {
            System.out.print(i + " ");
        }

    }

    /**
     * 递归
     * 不建议使用,栈溢出
     * 从小到大排列
     *
     * @param array
     */
    public static int[] bubbleSort2(int[] array) {

        sort2(array, 0, array.length - 2);
        return array;

    }

    private static void sort2(int[] array, int left, int right) {
        if (right < 1) {
            return;
        }
        count++;

        if (array[left] > array[left + 1]) {
            int temp = array[left + 1];
            array[left + 1] = array[left];
            array[left] = temp;
        }

        if (left >= right) {
            sort2(array, 0, right - 1);
        } else {
            sort2(array, left + 1, right);
        }
    }


    /**
     * 从小到大排列
     *
     * @param array
     */
    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                count++;
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
