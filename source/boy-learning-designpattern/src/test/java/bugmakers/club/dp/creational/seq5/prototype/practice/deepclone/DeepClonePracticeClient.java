package bugmakers.club.dp.creational.seq5.prototype.practice.deepclone;

import java.io.IOException;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/8 14:02
 */
public class DeepClonePracticeClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {
        DeepCustomer c1, c2 = null;

        c1 = new DeepCustomer();
        c1.setName("Bruce");

        DeepAddress addr = new DeepAddress();
        addr.setAddr("Qi Lian Shan Road");

        c1.setAddr(addr);

        try {
            c2 = c1.deepClone();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("克隆失败");
        }

        System.out.println("客户是否相同: " + (c1 == c2));
        System.out.println("客户地址对象是否相同: " + (c1.getAddr() == c2.getAddr()));
        System.out.println("c1住址：" + c1.getAddr().getAddr());
        System.out.println("c2住址：" + c2.getAddr().getAddr());
    }
}
