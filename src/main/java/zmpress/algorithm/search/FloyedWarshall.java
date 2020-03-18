package zmpress.algorithm.search;

import java.util.Arrays;

/**
 * @author zc
 * @version 1.0
 * @date 2020/3/18 9:20 下午
 * @desc Floyed-Warshall算法
 * 时间复杂度O(N^3)
 * 无法解决负权回路
 */
public class FloyedWarshall {

    /**
     * 0,2,6,4
     * E,0,3,E
     * 7,E,0,1
     * 5,E,12,0
     * <p>
     * 定义一个二维数组,其含义:
     * 0号到0号的距离是0,0号到1号的距离是2,0号到2号的距离是6,0号到3号的距离是4,
     * 1号无法直接到达0号(用E表示,即两点之间是有方向的),1号到1号的距离是0,1号到2号的距离是3,以此类推
     * <p>
     * 可以通过其他的点来到达目标点
     * 求任意两点间最短距离
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] array = new int[4][4];
        array[0] = new int[]{0, 2, 6, 4};
        // 结合本题,用999可以代替无法到达或者正无穷的意思
        array[1] = new int[]{999, 0, 3, 999};
        array[2] = new int[]{7, 999, 0, 1};
        array[3] = new int[]{5, 999, 12, 0};

        // 本题只有4个点,传入4
        MinDistance(array, 4);
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static void MinDistance(int[][] array, int count) {
        // 从i号到达j号只经过前k号地点的最短路径
        // Floyed-Warshall算法的核心
        // 时间复杂度是O(N^3)
        for (int k = 0; k < count; k++) {
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < count; j++) {
                    if (array[i][j] > array[i][k] + array[k][j]) {
                        array[i][j] = array[i][k] + array[k][j];
                    }
                }
            }
        }
    }
}
