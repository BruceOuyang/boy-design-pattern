package bugmakers.club.dp.structural.seq2.bridge.structural;

/**
 * @Description: 扩充抽象类
 * @Author: Bruce
 * @Datetime: 2018/3/9 16:45
 */
public class RefindAbstraction extends Abstraction {

    @Override
    public void operation() {

        // 业务代码

        // 调用实现类的方法
        impl.operationImplementor();

        // 业务代码
    }
}
