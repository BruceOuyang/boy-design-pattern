package bugmakers.club.dp.structural.seq1.adapter.demo;

/**
 * @Description: 抽象成绩操作类：目标接口
 * @Author: Bruce
 * @Datetime: 2018/3/9 13:55
 */
public interface ScoreOperation {

    /**
     * 成绩排序
     * @param array
     * @return
     */
    int[] sort(int array[]);

    /**
     * 成绩查询
     * @param array
     * @param key
     * @return
     */
    int search(int array[], int key);

}
