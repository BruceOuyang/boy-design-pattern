package bugmakers.club.dp.behavioral.seq04.iterator.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/23 10:49
 */
public class IteratorPracticeClient {

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
        AbstractObjectList list = new ProductPageList(products);

        // 定义迭代器
        AbstractIterator iterator = list.createIterator();

        System.out.println("获取2个：");
        System.out.println(iterator.getNextPage(3));

    }
}
