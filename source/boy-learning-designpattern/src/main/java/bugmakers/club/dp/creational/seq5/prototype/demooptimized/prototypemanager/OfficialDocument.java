package bugmakers.club.dp.creational.seq5.prototype.demooptimized.prototypemanager;

/**
 * @Description: 抽象公文接口，也可定义为抽象类，提供clone()方法的实现，将业务方法声明为抽象方法
 * @Author: Bruce
 * @Datetime: 2018/3/8 10:25
 */
public interface OfficialDocument extends Cloneable {

    /**
     * 克隆
     * @return
     */
    OfficialDocument clone();

    /**
     * 展示
     */
    void display();
}
