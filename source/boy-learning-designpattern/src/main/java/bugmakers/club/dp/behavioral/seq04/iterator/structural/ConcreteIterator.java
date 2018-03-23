package bugmakers.club.dp.behavioral.seq04.iterator.structural;

/**
 * @Description: 具体迭代器
 * @Author: Bruce
 * @Datetime: 2018/3/23 9:53
 */
public class ConcreteIterator implements Iterator {

    /**
     * 维持一个对具体聚合对象的引用，以便于访问存储在聚合对象中的数据
     */
    private ConcreteIterator aggregate;

    /**
     * 定义一个游标，用于记录当前访问位置
     */
    public int cursor;

    public void first() {

    }

    public void next() {

    }

    public boolean hasNext() {
        return false;
    }

    public Object currentItem() {
        return null;
    }
}
