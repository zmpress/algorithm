package zmpress.algorithm.sort;

import java.util.Random;

/**
 * @author zc
 * @version 1.0
 * @date 2020/3/10 9:14 下午
 * @desc
 */
public class SortUtil {

    public static int[] randomArray(int length){
        Random random = new Random();
        int[] ints = new int[length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(1000);
        }
        return ints;
    }
}
