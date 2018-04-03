package bugmakers.club.dp.behavioral.seq11.visitor.demo;

import java.text.MessageFormat;

/**
 * @Description: 财务部类：具体访问者类
 * @Author: Bruce
 * @Datetime: 2018/4/3 16:45
 */
public class FADepartment extends Department {

    /**
     * 实现财务部对全职员工的访问
     * @param employee
     */
    @Override
    public void visit(FulltimeEmployee employee) {
        int workTime = employee.getWorkTime();
        double weeklyWage = employee.getWeeklyWage();

        if(workTime > NORMAL_WORK_HOURS) {
            weeklyWage = weeklyWage + (workTime - NORMAL_WORK_HOURS) * 100;
        }
        else if(workTime < NORMAL_WORK_HOURS) {
            weeklyWage = weeklyWage - (NORMAL_WORK_HOURS - workTime) * 80;
            if(weeklyWage < 0) {
                weeklyWage = 0;
            }
        }
        System.out.println(MessageFormat.format("正式员工{0}实际工资为{1}元", employee.getName(), weeklyWage));
    }

    /**
     * 实现财务部对兼职员工的访问
     * @param employee
     */
    @Override
    public void visit(ParttimeEmployee employee) {
        int workTime = employee.getWorkTime();
        double hourWage = employee.getHourWage();
        System.out.println(MessageFormat.format("临时工{0}实际工资为{1}元", employee.getName(), workTime * hourWage));
    }
}
