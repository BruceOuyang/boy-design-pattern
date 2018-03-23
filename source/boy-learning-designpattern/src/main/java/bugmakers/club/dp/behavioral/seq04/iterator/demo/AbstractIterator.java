package bugmakers.club.dp.behavioral.seq04.iterator.demo;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/23 10:24
 */
public interface AbstractIterator {

    /**
     * 移至下一个元素
     */
    void next();

    /**
     * 判断是否为最后一个元素
     * @return
     */
    boolean isLast();

    /**
     * 移至上一个元素
     */
    void previous();

    /**
     * 判断是否为第一个元素
     * @return
     */
    boolean isFirst();

    /**
     * 获取下一个元素
     * @return
     */
    Object getNextItem();

    /**
     * 获取上一个元素
     * @return
     */
    Object getPreviousItem();
}
