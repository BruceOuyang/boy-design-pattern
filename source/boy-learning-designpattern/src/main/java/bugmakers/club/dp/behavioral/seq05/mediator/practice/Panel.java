package bugmakers.club.dp.behavioral.seq05.mediator.practice;

/**
 * @Description: 抽象面板类
 * @Author: Bruce
 * @Datetime: 2018/3/26 15:16
 */
public abstract class Panel {

    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void interactive(){
        mediator.panelOperated(this);
    }

    /**
     * 操作
     */
    public abstract void operation();
}
