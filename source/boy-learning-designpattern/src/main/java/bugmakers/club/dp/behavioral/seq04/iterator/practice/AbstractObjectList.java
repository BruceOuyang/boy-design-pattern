package bugmakers.club.dp.behavioral.seq04.iterator.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 抽象聚合类
 * @Author: Bruce
 * @Datetime: 2018/3/23 10:19
 */
public abstract class AbstractObjectList {

    protected List<Object> objects = new ArrayList<Object>();

    public AbstractObjectList(List<Object> objects) {
        this.objects = objects;
    }

    public void addObject(Object object){
        this.objects.add(object);
    }

    public void removeObject(Object object){
        this.objects.remove(object);
    }

    public List getObjects(){
        return this.objects;
    }

    /**
     * 声明创建迭代器对象的抽象工厂方法
     * @return
     */
    public abstract AbstractIterator createIterator();
}
