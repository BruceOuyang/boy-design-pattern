package bugmakers.club.dp.behavioral.seq01.chainofresponsibility.practice;

import java.text.MessageFormat;

/**
 * @Description: 主任类
 * @Author: Bruce
 * @Datetime: 2018/3/16 9:35
 */
public class Director extends Approver {

    public Director(String name) {
        super(name);
    }

    @Override
    public void processRequest(VocationRequest request) {
        if(request.getDays() < 3) {
            System.out.println(MessageFormat.format("主任{0}审批请假单{1}-员工{2}请假{3}天", this.name, request.getVid(), request.getName(), request.getDays()));
        }else{
            this.successor.processRequest(request);
        }
    }
}
