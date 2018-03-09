package bugmakers.club.dp.structural.seq2.bridge.structural;

/**
 * @Description: 抽象类
 * @Author: Bruce
 * @Datetime: 2018/3/9 16:42
 */
public abstract class Abstraction {

    /**
     * 定义实现类接口对象
     */
    protected Implementor impl;

    public void setImpl(Implementor impl) {
        this.impl = impl;
    }

    /**
     * 声明抽象业务方法(维度一)
     */
    public abstract void operation();
}
