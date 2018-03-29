package bugmakers.club.dp.behavioral.seq08.state.structural;

/**
 * @Description: 抽象状态类
 * @Author: Bruce
 * @Datetime: 2018/3/29 16:13
 */
public abstract class State {

    /**
     * 声明抽象业务方法，不同的具体状态类可以不同的实现
     */
    public abstract void handle();
}
