package bugmakers.club.dp.behavioral.seq01.chainofresponsibility.practice;

/**
 * @Description: 抽象审批人
 * @Author: Bruce
 * @Datetime: 2018/3/16 9:32
 */
public abstract class Approver {

    /**
     * 审批人
     */
    protected String name;

    /**
     * 下一高级别审批人
     */
    protected Approver successor;

    public Approver(String name) {
        this.name = name;
    }

    public void setSuccessor(Approver successor) {
        this.successor = successor;
    }

    public abstract void processRequest(VocationRequest request);
}
