package bugmakers.club.dp.structural.seq6.flyweight.demooptimized;

import java.util.Hashtable;

/**
 * @Description: 围棋棋子工厂类：享元工厂类，使用单例模式进行设计
 * @Author: Bruce
 * @Datetime: 2018/3/15 14:25
 */
public class IgoChessmanFactory {

    /**
     * 一般一个系统里边只有一个享元工厂，因此设计为单例
     */
    private static IgoChessmanFactory factory = new IgoChessmanFactory();

    /**
     * 使用Hashtable来存储享元对象，充当享元池
     */
    private static Hashtable<String, AbstractIgoChessman> ht;

    private IgoChessmanFactory(){
        ht = new Hashtable<String, AbstractIgoChessman>();
        ht.put("white", new WhiteIgoChessman());
        ht.put("black", new BlackIgoChessman());
    }

    public static IgoChessmanFactory instance(){
        return factory;
    }

    public AbstractIgoChessman getIgoChessman(String color){
        return ht.get(color);
    }
}
