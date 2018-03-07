package bugmakers.club.dp.creational.seq5.prototype.stractural.common;

import bugmakers.club.dp.creational.seq5.prototype.structural.common.ConcretePrototype;
import bugmakers.club.dp.creational.seq5.prototype.structural.common.Prototype;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/7 16:11
 */
public class PrototypeStructuralCommonClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {
        Prototype p1 = new ConcretePrototype();
        Prototype p2 = p1.clone();
    }
}
