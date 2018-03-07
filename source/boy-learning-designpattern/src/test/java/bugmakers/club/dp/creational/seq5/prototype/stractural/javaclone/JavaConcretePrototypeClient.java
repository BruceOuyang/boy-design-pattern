package bugmakers.club.dp.creational.seq5.prototype.stractural.javaclone;

import bugmakers.club.dp.creational.seq5.prototype.structural.common.Prototype;
import bugmakers.club.dp.creational.seq5.prototype.structural.javaclone.JavaConcretePrototype;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/7 16:16
 */
public class JavaConcretePrototypeClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {
        JavaConcretePrototype p1 = new JavaConcretePrototype();
        JavaConcretePrototype p2 = p1.clone();
        System.out.println("p1 == p2: " + (p1 == p2));
        System.out.println("p1 eq p2: " + (p1.equals(p2)));
    }
}
