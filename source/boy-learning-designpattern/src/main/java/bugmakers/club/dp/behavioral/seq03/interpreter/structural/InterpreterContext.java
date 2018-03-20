package bugmakers.club.dp.behavioral.seq03.interpreter.structural;

import java.util.HashMap;

/**
 * @Description: 用于存储一些全局信息
 * @Author: Bruce
 * @Datetime: 2018/3/20 15:34
 */
public class InterpreterContext {

    private HashMap<String, String> map = new HashMap<String, String>();

    /**
     * 往环境类中设值
     * @param key
     * @param value
     */
    public void assign(String key, String value){
        map.put(key, value);
    }

    /**
     * 获取存储在环境类中的值
     * @param key
     * @return
     */
    public String lookup(String key){
        return map.get(key);
    }
}
