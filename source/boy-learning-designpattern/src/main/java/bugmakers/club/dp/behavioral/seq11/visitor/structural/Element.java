package bugmakers.club.dp.behavioral.seq11.visitor.structural;

/**
 * @Description: 元素类
 * @Author: Bruce
 * @Datetime: 2018/4/3 15:44
 */
public interface Element {

    void accept(AbstractVisitor visitor);
}
