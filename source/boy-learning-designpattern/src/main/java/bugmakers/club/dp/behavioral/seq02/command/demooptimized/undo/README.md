5 撤销操作的实现

在命令模式中，我们可以通过调用一个命令对象的execute()方法来实现对请求的处理，如果需要撤销(Undo)请求，可通过在命令类中增加一个逆向操作来实现。

**扩展**  
> 除了通过一个逆向操作来实现撤销(Undo)外，还可以通过保存对象的历史状态来实现撤销，后者可使用备忘录模式(Memento Pattern)来实现。

下面通过一个简单的实例来学习如何使用命令模式实现撤销操作：

Sunny软件公司欲开发一个简易计算器，该计算器可以实现简单的数学运算，还可以对运算实施撤销操作。

Sunny软件公司开发人员使用命令模式设计了如图5所示结构图，其中计算器界面类CalculatorForm充当请求发送者，实现了数据求和功能的加法类Adder充当请求接收者，界面类可间接调用加法类中的add()方法实现加法运算，并且提供了可撤销加法运算的undo()方法。  
![图5 简易计算器结构图](https://upload-images.jianshu.io/upload_images/5792176-1537ac29b196a946.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
图5 简易计算器结构图  

本实例完整代码如下所示：  
```java
//加法类：请求接收者  
class Adder {  
    private int num=0; //定义初始值为0  

    //加法操作，每次将传入的值与num作加法运算，再将结果返回  
    public int add(int value) {  
        num += value;  
        return num;  
    }  
}  

//抽象命令类  
abstract class AbstractCommand {  
    public abstract int execute(int value); //声明命令执行方法execute()  
    public abstract int undo(); //声明撤销方法undo()  
}  

//具体命令类  
class ConcreteCommand extends AbstractCommand {  
    private Adder adder = new Adder();  
    private int value;  

    //实现抽象命令类中声明的execute()方法，调用加法类的加法操作  
public int execute(int value) {  
        this.value=value;  
        return adder.add(value);  
    }  

    //实现抽象命令类中声明的undo()方法，通过加一个相反数来实现加法的逆向操作  
    public int undo() {  
        return adder.add(-value);  
    }  
}  

//计算器界面类：请求发送者  
class CalculatorForm {  
    private AbstractCommand command;  

    public void setCommand(AbstractCommand command) {  
        this.command = command;  
    }  

    //调用命令对象的execute()方法执行运算  
    public void compute(int value) {  
        int i = command.execute(value);  
        System.out.println("执行运算，运算结果为：" + i);  
    }  

    //调用命令对象的undo()方法执行撤销  
    public void undo() {  
        int i = command.undo();  
        System.out.println("执行撤销，运算结果为：" + i);  
    }  
}
```

编写如下客户端测试代码：  
```java
class Client {  
    public static void main(String args[]) {  
        CalculatorForm form = new CalculatorForm();  
        AbstractCommand command;  
        command = new ConcreteCommand();  
        form.setCommand(command); //向发送者注入命令对象  

        form.compute(10);  
        form.compute(5);  
        form.compute(10);  
        form.undo();  
    }  
}
```

编译并运行程序，输出结果如下：  
```
执行运算，运算结果为：10
执行运算，运算结果为：15
执行运算，运算结果为：25
执行撤销，运算结果为：15
```