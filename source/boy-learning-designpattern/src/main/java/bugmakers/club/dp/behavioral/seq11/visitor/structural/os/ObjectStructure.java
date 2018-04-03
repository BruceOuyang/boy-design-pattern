package bugmakers.club.dp.behavioral.seq11.visitor.structural.os;

import bugmakers.club.dp.behavioral.seq11.visitor.structural.AbstractVisitor;
import bugmakers.club.dp.behavioral.seq11.visitor.structural.Element;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/4/3 16:22
 */
public class ObjectStructure {

    /**
     * 定义一个集合用于存储元素对象
     */
    private ArrayList<Element> list = new ArrayList<Element>();

    public void accept(AbstractVisitor visitor) {
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            // 遍历访问集合中的每一个元素
            ((Element) iterator.next()).accept(visitor);
        }
    }

    public void addElement(Element element) {
        list.add(element);
    }

    public void removeElement(Element element) {
        list.remove(element);
    }
}
