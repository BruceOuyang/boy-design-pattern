package bugmakers.club.dp.behavioral.seq01.chainofresponsibility.demo;

import java.text.MessageFormat;

/**
 * @Description: 董事会类：具体处理
 * @Author: Bruce
 * @Datetime: 2018/3/15 20:39
 */
public class Congress extends Approver {

    public Congress(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        System.out.println(MessageFormat.format("召开董事会审批采购单：{0}，金额：{1}元，采购目的：{2}。", request.getNumber(), request.getAmount(), request.getPurpose()));
    }
}
