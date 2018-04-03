package bugmakers.club.dp.behavioral.seq11.visitor.demo;

import java.util.ArrayList;

/**
 * @Description: 员工列表类：对象结构
 * @Author: Bruce
 * @Datetime: 2018/4/3 17:12
 */
public class EmployeeList {

    /**
     * 定义一个集合用于存储员工对象
     */
    private ArrayList<Employee> list = new ArrayList<Employee>();

    public void addEmployee(Employee employee)
    {
        list.add(employee);
    }

    /**
     * 遍历访问员工集合中的每一个员工对象
      * @param handler
     */
    public void accept(Department handler)
    {
        for(Object obj : list)
        {
            ((Employee)obj).accept(handler);
        }
    }
}
