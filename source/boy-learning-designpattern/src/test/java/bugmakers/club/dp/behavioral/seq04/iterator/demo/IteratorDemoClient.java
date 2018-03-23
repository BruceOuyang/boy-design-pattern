package bugmakers.club.dp.behavioral.seq04.iterator.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/23 10:49
 */
public class IteratorDemoClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {

        // 数据集合
        List products = new ArrayList();
        products.add("倚天剑");
        products.add("屠龙刀");
        products.add("断肠草");
        products.add("葵花宝典");
        products.add("四十二章经");

        // 定义聚合类
        AbstractObjectList list = new ProductList(products);

        // 定义迭代器
        AbstractIterator iterator = list.createIterator();

        System.out.println("正向遍历：");
        while(!iterator.isLast()){
            System.out.print(iterator.getNextItem() + ", ");
            iterator.next();
        }

        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("逆向遍历：");
        while(!iterator.isFirst()){
            System.out.print(iterator.getPreviousItem() + ", ");
            iterator.previous();
        }
    }
}
