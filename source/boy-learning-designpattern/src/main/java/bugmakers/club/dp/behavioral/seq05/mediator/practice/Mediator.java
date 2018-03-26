package bugmakers.club.dp.behavioral.seq05.mediator.practice;

/**
 * @Description: 抽象中介者
 * @Author: Bruce
 * @Datetime: 2018/3/26 15:25
 */
public abstract class Mediator {

    /**
     * 面板有动作
     * @param panel
     */
    public abstract void panelOperated(Panel panel);
}
