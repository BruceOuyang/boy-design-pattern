package bugmakers.club.dp.structural.seq6.flyweight.structural;

/**
 * @Description: 享元对象
 * @Author: Bruce
 * @Datetime: 2018/3/15 14:09
 */
public class Flyweight {

    /**
     * 内部状态intrinsicState作为成员变量，同一个享元对象其内部状态是一致的
     */
    private String instrinsicState;

    public Flyweight(String instrinsicState) {
        this.instrinsicState = instrinsicState;
    }

    /**
     * 外部状态extrinsicState在使用时由外部设置，不保存在享元对象中，即使是同一个对象，在每一次调用时也可以传入不同的外部状态
     * @param extrinsicState
     */
    public void operation(String extrinsicState){
        // biz
    }
}
