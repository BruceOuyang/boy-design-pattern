package bugmakers.club.dp.behavioral.seq01.chainofresponsibility.practice;

import java.text.MessageFormat;

/**
 * @Description: 经理类
 * @Author: Bruce
 * @Datetime: 2018/3/16 9:35
 */
public class Manager extends Approver {

    public Manager(String name) {
        super(name);
    }

    @Override
    public void processRequest(VocationRequest request) {
        if(3 <= request.getDays() && request.getDays() < 10) {
            System.out.println(MessageFormat.format("经理{0}审批请假单{1}-员工{2}请假{3}天", this.name, request.getVid(), request.getName(), request.getDays()));
        }else{
            this.successor.processRequest(request);
        }
    }
}
