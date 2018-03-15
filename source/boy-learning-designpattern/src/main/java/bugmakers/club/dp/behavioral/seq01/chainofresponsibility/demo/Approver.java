package bugmakers.club.dp.behavioral.seq01.chainofresponsibility.demo;

/**
 * @Description: 审批者类：抽象处理者
 * @Author: Bruce
 * @Datetime: 2018/3/15 20:26
 */
public abstract class Approver {

    /**
     * 定义后继对象
     */
    protected Approver successor;

    /**
     * 审批者姓名
     */
    protected String name;

    public Approver(String name){
        this.name = name;
    }

    /**
     * 设置后继者
     * @param successor
     */
    public void setSuccessor(Approver successor) {
        this.successor = successor;
    }

    /**
     * 抽象请求处理方法
     * @param request
     */
    public abstract void processRequest(PurchaseRequest request);
}
