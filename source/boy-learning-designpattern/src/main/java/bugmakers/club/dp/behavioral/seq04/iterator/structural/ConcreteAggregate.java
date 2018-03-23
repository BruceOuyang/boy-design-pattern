package bugmakers.club.dp.behavioral.seq04.iterator.structural;

/**
 * @Description: 具体聚合类
 * @Author: Bruce
 * @Datetime: 2018/3/23 9:59
 */
public class ConcreteAggregate implements Aggregate {
    public Iterator createIterator() {
        return new ConcreteIterator();
    }
}
