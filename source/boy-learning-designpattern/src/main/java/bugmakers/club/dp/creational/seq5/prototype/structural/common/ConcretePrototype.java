package bugmakers.club.dp.creational.seq5.prototype.structural.common;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/7 16:05
 */
public class ConcretePrototype implements Prototype {

    /**
     * 成员属性
     */
    private String attr;

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    /**
     * 克隆方法
     * @return
     */
    @Override
    public Prototype clone() {
        //创建新对象
        ConcretePrototype  prototype = new ConcretePrototype();
        prototype.setAttr(this.attr);
        return prototype;
    }
}
