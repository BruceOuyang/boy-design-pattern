package bugmakers.club.dp.behavioral.seq01.chainofresponsibility.practice;

import java.text.MessageFormat;

/**
 * @Description: 经理类
 * @Author: Bruce
 * @Datetime: 2018/3/16 9:35
 */
public class President extends Approver {

    public President(String name) {
        super(name);
    }

    @Override
    public void processRequest(VocationRequest request) {
        if(10 <= request.getDays() && request.getDays() < 30) {
            System.out.println(MessageFormat.format("总经理{0}审批请假单{1}-员工{2}请假{3}天", this.name, request.getVid(), request.getName(), request.getDays()));
        }else{
            System.out.println(MessageFormat.format("请假时间过长，不能通过审批。请假单信息：请假单号{1}-员工{2}请假{3}天", this.name, request.getVid(), request.getName(), request.getDays()));
        }
    }
}
