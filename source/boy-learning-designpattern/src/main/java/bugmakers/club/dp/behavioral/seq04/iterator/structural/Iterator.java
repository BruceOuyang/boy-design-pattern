package bugmakers.club.dp.behavioral.seq04.iterator.structural;

/**
 * @Description: 抽象迭代器
 * @Author: Bruce
 * @Datetime: 2018/3/23 9:47
 */
public interface Iterator {

    /**
     * 将游标指向第一个元素
     */
    void first();

    /**
     * 将游标指向下一个元素
     */
    void next();

    /**
     * 判断是否还有下一个元素
     * @return
     */
    boolean hasNext();

    /**
     * 获取游标指向的当前元素
     * @return
     */
    Object currentItem();
}
