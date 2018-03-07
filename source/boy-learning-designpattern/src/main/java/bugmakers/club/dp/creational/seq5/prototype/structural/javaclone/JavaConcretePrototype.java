package bugmakers.club.dp.creational.seq5.prototype.structural.javaclone;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/7 16:13
 */
public class JavaConcretePrototype implements Cloneable {

    @Override
    public JavaConcretePrototype clone() {
        Object object = null;
        try {
            object = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return (JavaConcretePrototype) object;
    }
}
