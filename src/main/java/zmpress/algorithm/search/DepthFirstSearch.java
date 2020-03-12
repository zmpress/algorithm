package zmpress.algorithm.search;

import java.util.Arrays;

/**
 * @author zc
 * @version 1.0
 * @date 2020/3/12 8:06 下午
 * @desc 深度优先搜索
 * 关键在于解决当下是怎么做,而不是下一步该怎么做
 */
public class DepthFirstSearch {


    private static int count = 0;


    public static void main(String[] args) {
        dfs(8);
        System.out.println("循环次数:" + count);
    }


    /**
     * 输出1~n的全排列
     *
     * @param num
     */
    public static void dfs(int num) {

        // 标记哪些数字已经使用,索引0即表示数字1
        int[] book = new int[num];

        // 记录排列的结果
        int[] ints = new int[num];

        recursive(ints, book, 0, num);

    }

    private static void recursive(int[] ints, int[] book, int step, int num) {
        if (step == num) {
            System.out.println(Arrays.toString(ints));
            return;
        }
        for (int i = 0; i < num; i++) {
            count++;
            // book[i] == 0 第i个数,即数字i+1,没有使用
            if (book[i] == 0) {
                ints[step] = i + 1;
                // 第i个数,即表示数字i+1已经用了
                book[i] = 1;

                // 继续下一个位置的数
                recursive(ints, book, step + 1, num);
                // 表示当前的数字i+1没有使用
                book[i] = 0;

            }
        }

    }


}
