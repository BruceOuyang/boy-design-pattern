package bugmakers.club.dp.structural.seq6.flyweight.structural;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/15 14:07
 */
public class FlyweightFactory {

    /**
     * 定义一个HashMap用于存储享元对象，实现享元池
     */
    private Map<String, Flyweight> flyweights = new HashMap<String, Flyweight>();

    /**
     * 获取享元对象
     * @param key
     * @return
     */
    public Flyweight getFlyweight(String key) {
        if(flyweights.containsKey(key)){
            return flyweights.get(key);
        }
        else{
            Flyweight newFlyweight = new Flyweight(key);
            flyweights.put(key, newFlyweight);
            return newFlyweight;
        }
    }
}
