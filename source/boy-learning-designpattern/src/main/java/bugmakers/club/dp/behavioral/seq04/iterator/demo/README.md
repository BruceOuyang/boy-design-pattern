1 销售管理系统中数据的遍历  

Sunny软件公司为某商场开发了一套销售管理系统，在对该系统进行分析和设计时，Sunny软件公司开发人员发现经常需要对系统中的商品数据、客户数据等进行遍历，为了复用这些遍历代码，Sunny公司开发人员设计了一个抽象的数据集合类AbstractObjectList，而将存储商品和客户等数据的类作为其子类，AbstractObjectList类结构如图2所示：  
![图2 AbstractObjectList类结构图](https://upload-images.jianshu.io/upload_images/5792176-18ceaed2eaa88cec.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
图2 AbstractObjectList类结构图  

在图2中，List类型的对象objects用于存储数据，方法说明如表1所示： 表1 AbstractObjectList类方法说明  
![表1 AbstractObjectList类方法说明](https://upload-images.jianshu.io/upload_images/5792176-e72a4717956e41a3.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  

AbstractObjectList类的子类ProductList和CustomerList分别用于存储商品数据和客户数据。

Sunny软件公司开发人员通过对AbstractObjectList类结构进行分析，发现该设计方案存在如下几个问题：

(1) 在图2所示类图中，addObject()、removeObject()等方法用于管理数据，而next()、isLast()、previous()、isFirst()等方法用于遍历数据。这将导致聚合类的职责过重，它既负责存储和管理数据，又负责遍历数据，违反了“单一职责原则”，由于聚合类非常庞大，实现代码过长，还将给测试和维护增加难度。

(2) 如果将抽象聚合类声明为一个接口，则在这个接口中充斥着大量方法，不利于子类实现，违反了“接口隔离原则”。

(3) 如果将所有的遍历操作都交给子类来实现，将导致子类代码庞大，而且必须暴露AbstractObjectList的内部存储细节，向子类公开自己的私有属性，否则子类无法实施对数据的遍历，这将破坏AbstractObjectList类的封装性。

如何解决上述问题？解决方案之一就是将聚合类中负责遍历数据的方法提取出来，封装到专门的类中，实现数据存储和数据遍历分离，无须暴露聚合类的内部属性即可对其进行操作，而这正是迭代器模式的意图所在。

3 完整解决方案

为了简化AbstractObjectList类的结构，并给不同的具体数据集合类提供不同的遍历方式，Sunny软件公司开发人员使用迭代器模式来重构AbstractObjectList类的设计，重构之后的销售管理系统数据遍历结构如图4所示：  
![图4 销售管理系统数据遍历结构图](https://upload-images.jianshu.io/upload_images/5792176-923c4c7d78f5cab2.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
图4 销售管理系统数据遍历结构图  

（注：为了简化类图和代码，本结构图中只提供一个具体聚合类和具体迭代器类）

在图4中，AbstractObjectList充当抽象聚合类，ProductList充当具体聚合类，AbstractIterator充当抽象迭代器，ProductIterator充当具体迭代器。完整代码如下所示：  
```java
//在本实例中，为了详细说明自定义迭代器的实现过程，我们没有使用JDK中内置的迭代器，事实上，JDK内置迭代器已经实现了对一个List对象的正向遍历  
import java.util.*;  

//抽象聚合类  
abstract class AbstractObjectList {  
    protected List<Object> objects = new ArrayList<Object>();  

    public AbstractObjectList(List objects) {  
        this.objects = objects;  
    }  

    public void addObject(Object obj) {  
        this.objects.add(obj);  
    }  

    public void removeObject(Object obj) {  
        this.objects.remove(obj);  
    }  

    public List getObjects() {  
        return this.objects;  
    }  

    //声明创建迭代器对象的抽象工厂方法  
    public abstract AbstractIterator createIterator();  
}  

//商品数据类：具体聚合类  
class ProductList extends AbstractObjectList {  
    public ProductList(List products) {  
        super(products);  
    }  

    //实现创建迭代器对象的具体工厂方法  
    public AbstractIterator createIterator() {  
        return new ProductIterator(this);  
    }  
}   

//抽象迭代器  
interface AbstractIterator {  
    void next(); //移至下一个元素  
    boolean isLast(); //判断是否为最后一个元素  
    void previous(); //移至上一个元素  
    boolean isFirst(); //判断是否为第一个元素  
    Object getNextItem(); //获取下一个元素  
    Object getPreviousItem(); //获取上一个元素  
}  

//商品迭代器：具体迭代器  
class ProductIterator implements AbstractIterator {  
    private ProductList productList;  
    private List products;  
    private int cursor1; //定义一个游标，用于记录正向遍历的位置  
    private int cursor2; //定义一个游标，用于记录逆向遍历的位置  

    public ProductIterator(ProductList list) {  
        this.productList = list;  
        this.products = list.getObjects(); //获取集合对象  
        cursor1 = 0; //设置正向遍历游标的初始值  
        cursor2 = products.size() -1; //设置逆向遍历游标的初始值  
    }  

    public void next() {  
        if(cursor1 < products.size()) {  
            cursor1++;  
        }  
    }  

    public boolean isLast() {  
        return (cursor1 == products.size());  
    }  

    public void previous() {  
        if (cursor2 > -1) {  
            cursor2--;  
        }  
    }  

    public boolean isFirst() {  
        return (cursor2 == -1);  
    }  

    public Object getNextItem() {  
        return products.get(cursor1);  
    }   

    public Object getPreviousItem() {  
        return products.get(cursor2);  
    }     
}
```

编写如下客户端测试代码：
```java
class Client {  
    public static void main(String args[]) {  
        List products = new ArrayList();  
        products.add("倚天剑");  
        products.add("屠龙刀");  
        products.add("断肠草");  
        products.add("葵花宝典");  
        products.add("四十二章经");  

        AbstractObjectList list;  
        AbstractIterator iterator;  

        list = new ProductList(products); //创建聚合对象  
        iterator = list.createIterator();   //创建迭代器对象  

        System.out.println("正向遍历：");      
        while(!iterator.isLast()) {  
            System.out.print(iterator.getNextItem() + "，");  
            iterator.next();  
        }  
        System.out.println();  
        System.out.println("-----------------------------");  
        System.out.println("逆向遍历：");  
        while(!iterator.isFirst()) {  
            System.out.print(iterator.getPreviousItem() + "，");  
            iterator.previous();  
        }  
    }  
}
```  

编译并运行程序，输出结果如下：
```
正向遍历：
倚天剑，屠龙刀，断肠草，葵花宝典，四十二章经，
-----------------------------
逆向遍历：
四十二章经，葵花宝典，断肠草，屠龙刀，倚天剑，
```

如果需要增加一个新的具体聚合类，如客户数据集合类，并且需要为客户数据集合类提供不同于商品数据集合类的正向遍历和逆向遍历操作，只需增加一个新的聚合子类和一个新的具体迭代器类即可，原有类库代码无须修改，符合“开闭原则”；如果需要为ProductList类更换一个迭代器，只需要增加一个新的具体迭代器类作为抽象迭代器类的子类，重新实现遍历方法，原有迭代器代码无须修改，也符合“开闭原则”；但是如果要在迭代器中增加新的方法，则需要修改抽象迭代器源代码，这将违背“开闭原则”。
