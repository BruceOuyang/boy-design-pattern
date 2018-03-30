package bugmakers.club.dp.behavioral.seq08.state.demooptimized.zoomstate;

/**
 * @Description: 屏幕类
 * @Author: Bruce
 * @Datetime: 2018/3/30 10:51
 */
public class Screen {

    /**
     * 枚举所有的状态，currentState表示当前状态
     */
    private State current, normal, larger, largest;

    public Screen() {
        this.normal = new NormalState();
        this.larger = new LargerState();
        this.largest = new LargestState();

        this.current = normal;
        this.display();
    }

    private void setState(State current) {
        this.current = current;
    }

    private void display(){
        this.current.display();
    }

    /**
     * 单击事件处理方法，封转了对状态类中业务方法的调用和状态的转换
     */
    public void onClick(){
        if(current == normal){
            this.setState(larger);
        }else if(current == larger){
            this.setState(largest);
        }else if(current == largest){
            this.setState(normal);
        }
        this.display();
    }
}
