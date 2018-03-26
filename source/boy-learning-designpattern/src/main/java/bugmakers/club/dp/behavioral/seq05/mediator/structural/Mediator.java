package bugmakers.club.dp.behavioral.seq05.mediator.structural;

import java.util.ArrayList;

/**
 * @Description: 抽象中介者类
 * @Author: Bruce
 * @Datetime: 2018/3/26 11:07
 */
public abstract class Mediator {

    /**
     * 用于存储同事对象
     */
    protected ArrayList<Colleague> colleagues;

    /**
     * 注册方法，用于增加同事对象
     * @param colleague
     */
    public void register(Colleague colleague){
        this.colleagues.add(colleague);
    }

    /**
     * 声明抽象的业务方法
     */
    public abstract void operation();
}
