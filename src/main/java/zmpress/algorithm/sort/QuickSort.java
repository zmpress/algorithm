package zmpress.algorithm.sort;

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
        int[] sort = quickSort(array);
        System.out.println("排序次数:" + count);
        for (int i : sort) {
            System.out.print(i + " ");
        }
    }


    /**
     * 迭代
     * 从小到大
     *
     * @param array
     * @return
     */
    public static int[] quickSort2(int[] array) {

        for (int i = 0; i < array.length; i++) {

        }

        return array;
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

        // i = j
        array[left] = array[i];
        array[i] = base;

        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }
}
