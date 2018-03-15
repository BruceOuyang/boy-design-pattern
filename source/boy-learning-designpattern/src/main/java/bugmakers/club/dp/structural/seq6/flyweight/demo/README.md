14.1 围棋棋子的设计

Sunny软件公司欲开发一个围棋软件，其界面效果如图14-1所示：  
![图14-1 围棋软件界面效果图](https://upload-images.jianshu.io/upload_images/5792176-0e42bc27124e4292.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
图14-1 围棋软件界面效果图  

Sunny软件公司开发人员通过对围棋软件进行分析，发现在围棋棋盘中包含大量的黑子和白子，它们的形状、大小都一模一样，只是出现的位置不同而已。如果将每一个棋子都作为一个独立的对象存储在内存中，将导致该围棋软件在运行时所需内存空间较大，如何降低运行代价、提高系统性能是Sunny公司开发人员需要解决的一个问题。为了解决这个问题，Sunny公司开发人员决定使用享元模式来设计该围棋软件的棋子对象，那么享元模式是如何实现节约内存进而提高系统性能的呢？

14.3 完整解决方案

为了节约存储空间，提高系统性能，Sunny公司开发人员使用享元模式来设计围棋软件中的棋子，其基本结构如图14-4所示：  
![图14-4 围棋棋子结构图](https://upload-images.jianshu.io/upload_images/5792176-8faa94d08af94ec8.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
图14-4 围棋棋子结构图  

在图14-4中，IgoChessman充当抽象享元类，BlackIgoChessman和WhiteIgoChessman充当具体享元类，IgoChessmanFactory充当享元工厂类。完整代码如下所示：  
```java
import java.util.*;  

//围棋棋子类：抽象享元类  
abstract class IgoChessman {  
    public abstract String getColor();  

    public void display() {  
        System.out.println("棋子颜色：" + this.getColor());    
    }  
}  

//黑色棋子类：具体享元类  
class BlackIgoChessman extends IgoChessman {  
    public String getColor() {  
        return "黑色";  
    }     
}  

//白色棋子类：具体享元类  
class WhiteIgoChessman extends IgoChessman {  
    public String getColor() {  
        return "白色";  
    }  
}  

//围棋棋子工厂类：享元工厂类，使用单例模式进行设计  
class IgoChessmanFactory {  
    private static IgoChessmanFactory instance = new IgoChessmanFactory();  
    private static Hashtable ht; //使用Hashtable来存储享元对象，充当享元池  

    private IgoChessmanFactory() {  
        ht = new Hashtable();  
        IgoChessman black,white;  
        black = new BlackIgoChessman();  
        ht.put("b",black);  
        white = new WhiteIgoChessman();  
        ht.put("w",white);  
    }  

    //返回享元工厂类的唯一实例  
    public static IgoChessmanFactory getInstance() {  
        return instance;  
    }  

    //通过key来获取存储在Hashtable中的享元对象  
    public static IgoChessman getIgoChessman(String color) {  
        return (IgoChessman)ht.get(color);    
    }  
}
```  

编写如下客户端测试代码：  
```java
class Client {  
    public static void main(String args[]) {  
        IgoChessman black1,black2,black3,white1,white2;  
        IgoChessmanFactory factory;  

        //获取享元工厂对象  
        factory = IgoChessmanFactory.getInstance();  

        //通过享元工厂获取三颗黑子  
        black1 = factory.getIgoChessman("b");  
        black2 = factory.getIgoChessman("b");  
        black3 = factory.getIgoChessman("b");  
        System.out.println("判断两颗黑子是否相同：" + (black1==black2));  

        //通过享元工厂获取两颗白子  
        white1 = factory.getIgoChessman("w");  
        white2 = factory.getIgoChessman("w");  
        System.out.println("判断两颗白子是否相同：" + (white1==white2));  

        //显示棋子  
        black1.display();  
        black2.display();  
        black3.display();  
        white1.display();  
        white2.display();  
    }  
}
```  

编译并运行程序，输出结果如下：
```
判断两颗黑子是否相同：true
判断两颗白子是否相同：true
棋子颜色：黑色
棋子颜色：黑色
棋子颜色：黑色
棋子颜色：白色
棋子颜色：白色
```  

从输出结果可以看出，虽然我们获取了三个黑子对象和两个白子对象，但是它们的内存地址相同，也就是说，它们实际上是同一个对象。在实现享元工厂类时我们使用了单例模式和简单工厂模式，确保了享元工厂对象的唯一性，并提供工厂方法来向客户端返回享元对象。

