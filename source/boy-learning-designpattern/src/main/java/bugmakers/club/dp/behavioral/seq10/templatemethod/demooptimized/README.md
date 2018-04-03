4 钩子方法的使用

模板方法模式中，在父类中提供了一个定义算法框架的模板方法，还提供了一系列抽象方法、具体方法和钩子方法，其中钩子方法的引入使得子类可以控制父类的行为。最简单的钩子方法就是空方法，代码如下：  
```
public virtual void Display() {   }
```

当然也可以在钩子方法中定义一个默认的实现，如果子类不覆盖钩子方法，则执行父类的默认实现代码。

另一种钩子方法可以实现对其他方法进行约束，这种钩子方法通常返回一个bool类型，即返回true或false，用来判断是否执行某一个基本方法，下面通过一个实例来说明这种钩子方法的使用。

某软件公司欲为销售管理系统提供一个数据图表显示功能，该功能的实现包括如下几个步骤：

(1) 从数据源获取数据；

(2) 将数据转换为XML格式；

(3) 以某种图表方式显示XML格式的数据。

该功能支持多种数据源和多种图表显示方式，但所有的图表显示操作都基于XML格式的数据，因此可能需要对数据进行转换，如果从数据源获取的数据已经是XML数据则无须转换。

由于该数据图表显示功能的三个步骤次序是固定的，且存在公共代码（例如数据格式转换代码），满足模板方法模式的适用条件，可以使用模板方法模式对其进行设计。因为数据格式的不同，XML数据可以直接显示，而其他格式的数据需要进行转换，因此第(2)步“将数据转换为XML格式”的执行存在不确定性，为了解决这个问题，可以定义一个钩子方法IsNotXMLData()来对数据转换方法进行控制。通过分析，该图表显示功能的基本结构如图4所示：  
![图4 数据图表显示功能结构图](https://upload-images.jianshu.io/upload_images/5792176-8bc40a51f5c96c91.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
图4 数据图表显示功能结构图  

可以将公共方法和框架代码放在抽象父类中，代码如下：  
```java
abstract class DataViewer  
{  
    //抽象方法：获取数据  
    public abstract void GetData();  

    //具体方法：转换数据  
    public void ConvertData()   
    {  
        Console.WriteLine("将数据转换为XML格式。");  
    }  

    //抽象方法：显示数据  
    public abstract void DisplayData();  

    //钩子方法：判断是否为XML格式的数据  
    public virtual bool IsNotXMLData()  
    {  
        return true;  
    }  

    //模板方法  
    public void Process()  
    {  
        GetData();  
        //如果不是XML格式的数据则进行数据转换  
        if (IsNotXMLData())  
        {  
            ConvertData();  
        }  
        DisplayData();  
    }  
}  
```

在上面的代码中，引入了一个钩子方法IsNotXMLData()，其返回类型为bool类型，在模板方法中通过它来对数据转换方法ConvertData()进行约束，该钩子方法的默认返回值为true，在子类中可以根据实际情况覆盖该方法，其中用于显示XML格式数据的具体子类XMLDataViewer代码如下： 
```java
class XMLDataViewer extends DataViewer  
{  
    //实现父类方法：获取数据  
    public override void GetData()   
    {  
        Console.WriteLine("从XML文件中获取数据。");  
    }  

    //实现父类方法：显示数据，默认以柱状图方式显示，可结合桥接模式来改进  
    public override void DisplayData()   
    {  
        Console.WriteLine("以柱状图显示数据。");  
    }  

    //覆盖父类的钩子方法  
    public override bool IsNotXMLData()  
    {  
        return false;  
    }  
} 
```

在具体子类XMLDataViewer中覆盖了钩子方法IsNotXMLData()，返回false，表示该数据已为XML格式，无须执行数据转换方法ConvertData()，客户端代码如下：  
```java
class Program  
{  
    static void Main(string[] args)  
    {  
        DataViewer dv;  
        dv = new XMLDataViewer();  
        dv.Process();  
        Console.Read();  
    }  
}  
```

该程序运行结果如下：  
```
从XML文件中获取数据。
以柱状图显示数据。
```