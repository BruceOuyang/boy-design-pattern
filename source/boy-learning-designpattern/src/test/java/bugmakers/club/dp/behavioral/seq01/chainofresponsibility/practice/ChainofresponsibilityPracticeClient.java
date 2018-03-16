package bugmakers.club.dp.behavioral.seq01.chainofresponsibility.practice;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/16 9:43
 */
public class ChainofresponsibilityPracticeClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {

        // 定义审批人并设置职责链
        Approver director, manager, president;
        director = new Director("Angelia");
        manager = new Manager("Cc");
        president = new President("Bruce");

        director.setSuccessor(manager);
        manager.setSuccessor(president);

        // 填写请假单
        VocationRequest request1 = new VocationRequest("V-001", "Singe", 1);
        director.processRequest(request1);

        VocationRequest request5 = new VocationRequest("V-002", "Oscar", 5);
        director.processRequest(request5);

        VocationRequest request10 = new VocationRequest("V-003", "Peter", 10);
        director.processRequest(request10);

        VocationRequest request30 = new VocationRequest("V-005", "Ww", 30);
        director.processRequest(request30);
    }
}
