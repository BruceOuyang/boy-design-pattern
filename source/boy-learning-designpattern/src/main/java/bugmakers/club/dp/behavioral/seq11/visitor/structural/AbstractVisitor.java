package bugmakers.club.dp.behavioral.seq11.visitor.structural;

/**
 * @Description: 抽象访问者类
 * @Author: Bruce
 * @Datetime: 2018/4/3 15:43
 */
public abstract class AbstractVisitor {

    public abstract void visit(ConcreteElementA elementA);
    public abstract void visit(ConcreteElementB elementB);
    public void visit(ConcreteElementC elementC) {
        // biz
    }
}
