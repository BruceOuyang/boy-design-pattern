package bugmakers.club.dp.behavioral.seq11.visitor.demo;

/**
 * @Description: 员工类：抽象元素类
 * @Author: Bruce
 * @Datetime: 2018/4/3 16:34
 */
public interface Employee {

    /**
     * 接受一个抽象访问者访问
     * @param handle
     */
    void accept(Department handle);
}
