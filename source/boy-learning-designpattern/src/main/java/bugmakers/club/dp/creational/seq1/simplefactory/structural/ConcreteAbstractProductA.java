package bugmakers.club.dp.creational.seq1.simplefactory.structural;

/**
 * @Description: 具体产品类
 * @Author: Bruce
 * @Datetime: 2018/3/1 15:22
 */
public class ConcreteAbstractProductA extends AbstractProduct {

    /**
     * 实现业务方法
     */
    @Override
    public void methodDiff() {
        // 具体业务实现
        System.out.println("具体产品A");
    }
}
