package bugmakers.club.dp.behavioral.seq04.iterator.demooptimized.javaiterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/23 11:27
 */
public class JavaIteratorDemo {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {

        // 创建一个ArrayList类型的聚合对象
        Collection persons = new ArrayList();
        persons.add("张无忌");
        persons.add("小龙女");
        persons.add("令狐冲");
        persons.add("韦小宝");
        persons.add("袁紫衣");
        persons.add("小龙女");

        process(persons);
    }

    public static void process(Collection collection){

        // 创建迭代器对象
        Iterator iterator = collection.iterator();

        // 通过迭代器遍历聚合对象
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }
}
