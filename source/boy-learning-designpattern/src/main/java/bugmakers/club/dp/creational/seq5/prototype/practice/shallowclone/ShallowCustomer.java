package bugmakers.club.dp.creational.seq5.prototype.practice.shallowclone;

/**
 * @Description: 客户类
 * @Author: Bruce
 * @Datetime: 2018/3/8 11:36
 */
public class ShallowCustomer implements Cloneable {

    private String name;
    private ShallowAddress addr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShallowAddress getAddr() {
        return addr;
    }

    public void setAddr(ShallowAddress addr) {
        this.addr = addr;
    }

    @Override
    protected ShallowCustomer clone() {
        try {
            return (ShallowCustomer) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("不支持复制");
        }
        return null;
    }
}
