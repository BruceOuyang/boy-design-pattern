package bugmakers.club.dp.behavioral.seq05.mediator.structural;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/26 11:08
 */
public abstract class Colleague {

    /**
     * 维持一个抽象中介者的引用
     */
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * 声明自身方法，处理自己的行为
     */
    public abstract void medthod1();

    /**
     * 定义依赖方法，与中介者进行通信
     */
    public void method2(){
        this.mediator.operation();
    }
}
