package bugmakers.club.dp.behavioral.seq11.visitor.demo;

/**
 * @Description: 部门类：抽象访问者类
 * @Author: Bruce
 * @Datetime: 2018/4/3 16:35
 */
public abstract class Department {

    public static final int NORMAL_WORK_HOURS = 40;

    /**
     * 声明一组重载的访问方法，用于访问不同类型的具体元素
     * @param employee
     */
    public abstract void visit(FulltimeEmployee employee);

    public abstract void visit(ParttimeEmployee employee);
}
