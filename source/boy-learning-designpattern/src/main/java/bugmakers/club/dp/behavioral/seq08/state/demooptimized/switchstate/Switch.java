package bugmakers.club.dp.behavioral.seq08.state.demooptimized.switchstate;

/**
 * @Description: 开关类
 * @Author: Bruce
 * @Datetime: 2018/3/29 17:32
 */
public class Switch {

    /**
     * 定义三个静态的状态对象
     */
    private static SwitchState state, on, off;

    /**
     * 开关的名字
     */
    private String name;

    /**
     * 初始
     * @param name
     */
    public Switch(String name) {
        this.name = name;

        on = new OnState();
        off = new OffState();
        state = on;
    }

    public static SwitchState getState(String type) {
        return "on".equalsIgnoreCase(type)? on : off;
    }

    public void setState(SwitchState state) {
        Switch.state = state;
    }

    /**
     * 打开
     */
    public void on(){
        System.out.print("打开" + name + "\t");
        state.on(this);
    }

    /**
     * 关闭
     */
    public void off(){
        System.out.print("关闭" + name + "\t");
        state.off(this);
    }
}
