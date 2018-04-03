package bugmakers.club.dp.behavioral.seq11.visitor.demo;

/**
 * @Description: 人力资源部类：具体访问者类
 * @Author: Bruce
 * @Datetime: 2018/4/3 17:06
 */
public class HRDepartment extends Department {

    @Override
    public void visit(FulltimeEmployee employee) {
        int workTime = employee.getWorkTime();
        System.out.println("正式员工" + employee.getName() + "实际工作时间为：" + workTime + "小时。");
        if(workTime > NORMAL_WORK_HOURS)
        {
            System.out.println("正式员工" + employee.getName() + "加班时间为：" + (workTime - NORMAL_WORK_HOURS) + "小时。");
        }
        else if(workTime < NORMAL_WORK_HOURS)
        {
            System.out.println("正式员工" + employee.getName() + "请假时间为：" + (NORMAL_WORK_HOURS - workTime) + "小时。");
        }
    }

    @Override
    public void visit(ParttimeEmployee employee) {
        int workTime = employee.getWorkTime();
        System.out.println("临时工" + employee.getName() + "实际工作时间为：" + workTime + "小时。");
    }
}
