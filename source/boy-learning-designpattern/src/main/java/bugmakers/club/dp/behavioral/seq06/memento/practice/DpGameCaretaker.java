package bugmakers.club.dp.behavioral.seq06.memento.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/27 16:19
 */
public class DpGameCaretaker {

    /**
     * 支持多个存档
     */
    private Map<String, DpGameMemento> map = new HashMap<String, DpGameMemento>();

    public DpGameMemento getMemento(String key){
        System.out.println("恢复游戏存档：" + key);
        return map.get(key);
    }

    public void setMemento(String key, DpGameMemento memento){
        System.out.println("设置游戏存档：" + key);
        map.put(key, memento);
    }
}
