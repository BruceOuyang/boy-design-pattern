package bugmakers.club.dp.behavioral.seq11.visitor.structural;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/4/3 15:47
 */
public class ConcreteElementC implements Element {

    public void accept(AbstractVisitor visitor) {
        visitor.visit(this);
    }

    public void operationC() {
        // biz
    }
}
