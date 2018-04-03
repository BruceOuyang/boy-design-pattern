package bugmakers.club.dp.behavioral.seq11.visitor.demo;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/4/3 18:08
 */
public class VisitorDemoClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {

        EmployeeList list = new EmployeeList();
        Employee fte1, fte2, fte3, pte1, pte2;

        fte1 = new FulltimeEmployee("张无忌",3200.00,45);
        fte2 = new FulltimeEmployee("杨过",2000.00,40);
        fte3 = new FulltimeEmployee("段誉",2400.00,38);
        pte1 = new ParttimeEmployee("洪七公",80.00,20);
        pte2 = new ParttimeEmployee("郭靖",60.00,18);

        list.addEmployee(fte1);
        list.addEmployee(fte2);
        list.addEmployee(fte3);
        list.addEmployee(pte1);
        list.addEmployee(pte2);

        Department dpt = (Department) VisitorXMLUtil.getBean();
        list.accept(dpt);
    }
}
