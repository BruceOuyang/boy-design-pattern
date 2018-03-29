package bugmakers.club.dp.behavioral.seq08.state.structural;

/**
 * @Description: 环境类
 * @Author: Bruce
 * @Datetime: 2018/3/29 16:15
 */
public class Context {

    /**
     * 维持一个对抽象状态对象的引用
     */
    private State state;

    /**
     * 其他属性值，该属性值的变化可能会导致对象状态发生变化
     */
    private int value;

    /**
     * 设置状态对象
     * @param state
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * 请求
     */
    public void request(){

        // biz...

        // 调用状态对象的业务方法
        state.handle();

        // biz...
    }

//    /**
//     * 改变状态
//     */
//    public  void changeState(){
//        if(value == 0){
//            this.state = new ConcreteStateA();
//        }else if(value == 1){
//            this.state = new ConcreteStateB();
//        }else{
//            this.state = new ConcreteState();
//        }
//    }
}
