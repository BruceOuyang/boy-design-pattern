package bugmakers.club.dp.structural.seq3.composite.structural;

/**
 * @Description: 抽象构建角色
 * @Author: Bruce
 * @Datetime: 2018/3/12 15:58
 */
public abstract class Component {

    /**
     * 增加成员
     * @param component
     */
    public abstract void add(Component component);

    /**
     * 删除成员
     * @param component
     */
    public abstract void remove(Component component);

    /**
     * 获取成员
     * @param i
     * @return
     */
    public abstract Component getChild(int i);

    /**
     * 业务方法
     */
    public abstract void operation();
}
