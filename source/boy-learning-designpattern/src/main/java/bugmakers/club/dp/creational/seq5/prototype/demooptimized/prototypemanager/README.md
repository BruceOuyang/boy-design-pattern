## 带原型管理器的原型模式

7.5 原型管理器的引入和实现

原型管理器(Prototype Manager)是将多个原型对象存储在一个集合中供客户端使用，它是一个专门负责克隆对象的工厂，其中定义了一个集合用于存储原型对象，如果需要某个原型对象的一个克隆，可以通过复制集合中对应的原型对象来获得。在原型管理器中针对抽象原型类进行编程，以便扩展。其结构如图7-8所示：  
![图7-8 带原型管理器的原型模式](http://upload-images.jianshu.io/upload_images/5792176-887c403bbb905265.gif?imageMogr2/auto-orient/strip)  
图7-8 带原型管理器的原型模式  

下面通过模拟一个简单的公文管理器来介绍原型管理器的设计与实现：  
Sunny软件公司在日常办公中有许多公文需要创建、递交和审批，例如《可行性分析报告》、《立项建议书》、《软件需求规格说明书》、《项目进展报告》等，为了提高工作效率，在OA系统中为各类公文均创建了模板，用户可以通过这些模板快速创建新的公文，这些公文模板需要统一进行管理，系统根据用户请求的不同生成不同的新公文。  

我们使用带原型管理器的原型模式实现公文管理器的设计，其结构如图7-9所示：  
![图7-9 公文管理器结构图](http://upload-images.jianshu.io/upload_images/5792176-948ce9a6882d04a6.gif?imageMogr2/auto-orient/strip)  
图7-9 公文管理器结构图  

以下是实现该功能的一些核心代码，考虑到代码的可读性，我们对所有的类都进行了简化：  
```java
import java.util.*;

//抽象公文接口，也可定义为抽象类，提供clone()方法的实现，将业务方法声明为抽象方法
interface OfficialDocument extends  Cloneable
{
       public  OfficialDocument clone();
       public  void display();
}

//可行性分析报告(Feasibility Analysis Report)类
class FAR implements OfficialDocument
{
       public  OfficialDocument clone()
      {
              OfficialDocument  far = null;
              try
              {
                     far  = (OfficialDocument)super.clone();
              }
              catch(CloneNotSupportedException  e)
              {
                      System.out.println("不支持复制！");
              }
              return  far;
       }

       public  void display()
       {
              System.out.println("《可行性分析报告》");
       }
}

//软件需求规格说明书(Software Requirements Specification)类
class SRS implements OfficialDocument
{
       public  OfficialDocument clone()
       {
              OfficialDocument  srs = null;
              try
              {
                     srs  = (OfficialDocument)super.clone();
              }
              catch(CloneNotSupportedException  e)
              { 
                     System.out.println("不支持复制！");
              }
              return  srs;
       }

       public  void display()
       {
              System.out.println("《软件需求规格说明书》");
       }
}

//原型管理器（使用饿汉式单例实现）
class  PrototypeManager
{
       //定义一个Hashtable，用于存储原型对象
       private Hashtable ht=new Hashtable();
       private static PrototypeManager pm =  new PrototypeManager();

       //为Hashtable增加公文对象   
     private  PrototypeManager()
     {
              ht.put("far",new  FAR());
              ht.put("srs",new  SRS());               
     }

     //增加新的公文对象
       public void addOfficialDocument(String  key,OfficialDocument doc)
       {
              ht.put(key,doc);
       }

       //通过浅克隆获取新的公文对象
       public OfficialDocument  getOfficialDocument(String key)
       {
              return  ((OfficialDocument)ht.get(key)).clone();
       }

       public static PrototypeManager  getPrototypeManager()
       {
              return pm;
       }
}
```  

客户端代码如下所示：  
```java
class Client
{
       public  static void main(String args[])
       {
              //获取原型管理器对象
              PrototypeManager pm =  PrototypeManager.getPrototypeManager();  

              OfficialDocument  doc1,doc2,doc3,doc4;

              doc1  = pm.getOfficialDocument("far");
              doc1.display();
              doc2  = pm.getOfficialDocument("far");
              doc2.display();
              System.out.println(doc1  == doc2);

              doc3  = pm.getOfficialDocument("srs");
              doc3.display();
              doc4  = pm.getOfficialDocument("srs");
              doc4.display();
              System.out.println(doc3  == doc4);
       }
}
```  

编译并运行程序，输出结果如下：  
```
《可行性分析报告》
《可行性分析报告》
false
《软件需求规格说明书》
《软件需求规格说明书》
false
```  

在PrototypeManager中定义了一个Hashtable类型的集合对象，使用“键值对”来存储原型对象，客户端可以通过Key（如“far”或“srs”）来获取对应原型对象的克隆对象。PrototypeManager类提供了类似工厂方法的getOfficialDocument()方法用于返回一个克隆对象。在本实例代码中，我们将PrototypeManager设计为单例类，使用饿汉式单例实现，确保系统中有且仅有一个PrototypeManager对象，有利于节省系统资源，并可以更好地对原型管理器对象进行控制。  

**思考**  

> 如果需要增加一种新类型的公文，如《项目进展报告》(Project Progress Report, PPR)，公文管理器系统源代码如何修改，动手实践你的修改方案。  
