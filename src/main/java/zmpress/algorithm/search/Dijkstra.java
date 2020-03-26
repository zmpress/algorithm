package zmpress.algorithm.search;

import java.util.Arrays;

/**
 * @author zc
 * @version 1.0
 * @date 2020/3/26 8:56 下午
 * @desc 时间复杂度 O(N^2)
 * todo 可以进一步优化
 * 不能处理负权边
 */
public class Dijkstra {

    public static void main(String[] args) {
        int[][] array = new int[6][6];
        array[0] = new int[]{0, 1, 12, 999, 999, 999};
        array[1] = new int[]{999, 0, 9, 3, 999, 999};
        array[2] = new int[]{999, 999, 0, 999, 5, 999};
        array[3] = new int[]{999, 999, 4, 0, 13, 15};
        array[4] = new int[]{999, 999, 999, 999, 0, 4};
        array[5] = new int[]{999, 999, 999, 999, 999, 0};

        int[] ret = search(array, 0);
        System.out.println("结果: " + Arrays.toString(ret));
    }

    private static int[] search(int[][] array, int num) {

        int[] ret = array[num];
        // 默认999为正无穷
        int max = 999;

        int[] book = new int[ret.length];
        // 第i个数的值为-1,表示这个数到目标点num的最小距离还没有确定下来
        Arrays.fill(book, -1);
        // num到num是0,标志距离已经确定
        book[num] = 1;
        int u = num, v;
        for (int i = 0; i < ret.length; i++) {
            int min = max;
            for (int j = 0; j < ret.length; j++) {
                if (book[j] == -1 && ret[j] < min) {
                    min = ret[j];
                    u = j;
                }
            }
            if (book[u] == 1) {
                // 说明没有找到没标记的并且可达的点,结束
                break;
            }
            // 表示第u个数到num的最小距离已经确认了
            book[u] = 1;

            for (v = 0; v < ret.length; v++) {
                // 如果num到v的距离 > num到u的距离 + u到v的距离
                if (array[u][v] < max && ret[v] > ret[u] + array[u][v]) {
                    ret[v] = ret[u] + array[u][v];
                }
            }
        }

        return ret;


    }
}
