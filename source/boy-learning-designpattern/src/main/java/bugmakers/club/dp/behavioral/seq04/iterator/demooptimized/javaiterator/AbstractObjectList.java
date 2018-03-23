package bugmakers.club.dp.behavioral.seq04.iterator.demooptimized.javaiterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/23 15:12
 */
public abstract class AbstractObjectList {

    private List<Object> objects = new ArrayList<Object>();

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
     * 抽象工厂方法
     * @return
     */
    public abstract Iterator createIterator();
}
