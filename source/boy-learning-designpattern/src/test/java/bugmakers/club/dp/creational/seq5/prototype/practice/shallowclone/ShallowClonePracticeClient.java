package bugmakers.club.dp.creational.seq5.prototype.practice.shallowclone;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/8 14:02
 */
public class ShallowClonePracticeClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {
        ShallowCustomer c1 = new ShallowCustomer();
        c1.setName("Bruce");
        ShallowAddress addr = new ShallowAddress();
        addr.setAddr("Qi Lian Shan Road");

        ShallowCustomer c2 = c1.clone();

        System.out.println("客户是否相同: " + (c1 == c2));
        System.out.println("客户地址是否相同: " + (c1.getAddr() == c2.getAddr()));
    }
}
