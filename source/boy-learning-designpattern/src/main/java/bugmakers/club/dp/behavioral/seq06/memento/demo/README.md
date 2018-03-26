21.1 可悔棋的中国象棋

Sunny软件公司欲开发一款可以运行在Android平台的触摸式中国象棋软件，由于考虑到有些用户是“菜鸟”，经常不小心走错棋；还有些用户因为不习惯使用手指在手机屏幕上拖动棋子，常常出现操作失误，因此该中国象棋软件要提供“悔棋”功能，用户走错棋或操作失误后可恢复到前一个步骤。如图21-1所示：  
![图21-1 Android版中国象棋软件界面示意图](https://upload-images.jianshu.io/upload_images/5792176-cd2c35b1df41bd29.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
图21-1 Android版中国象棋软件界面示意图  

如何实现“悔棋”功能是Sunny软件公司开发人员需要面对的一个重要问题，“悔棋”就是让系统恢复到某个历史状态，在很多软件中通常称之为“撤销”。下面我们来简单分析一下撤销功能的实现原理：

在实现撤销时，首先必须保存软件系统的历史状态，当用户需要取消错误操作并且返回到某个历史状态时，可以取出事先保存的历史状态来覆盖当前状态。如图21-2所示：  
![图21-2撤销功能示意图](https://upload-images.jianshu.io/upload_images/5792176-f59d40153d61f62c.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
图21-2撤销功能示意图  

备忘录模式正为解决此类撤销问题而诞生，它为我们的软件提供了“后悔药”，通过使用备忘录模式可以使系统恢复到某一特定的历史状态。

21.3 完整解决方案

为了实现撤销功能，Sunny公司开发人员决定使用备忘录模式来设计中国象棋软件，其基本结构如图21-4所示：  
![图21-4中国象棋棋子撤销功能结构图](https://upload-images.jianshu.io/upload_images/5792176-5b4c6806089dabde.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  

在图21-4中，Chessman充当原发器，ChessmanMemento充当备忘录，MementoCaretaker充当负责人，在MementoCaretaker中定义了一个ChessmanMemento类型的对象，用于存储备忘录。完整代码如下所示：  
```java
//象棋棋子类：原发器  
class Chessman {  
    private String label;  
    private int x;  
    private int y;  

    public Chessman(String label,int x,int y) {  
        this.label = label;  
        this.x = x;  
        this.y = y;  
    }  

    public void setLabel(String label) {  
        this.label = label;   
    }  

    public void setX(int x) {  
        this.x = x;   
    }  

    public void setY(int y) {  
        this.y = y;   
    }  

    public String getLabel() {  
        return (this.label);   
    }  

    public int getX() {  
        return (this.x);   
    }  

    public int getY() {  
        return (this.y);   
    }  

    //保存状态  
    public ChessmanMemento save() {  
        return new ChessmanMemento(this.label,this.x,this.y);  
    }  

    //恢复状态  
    public void restore(ChessmanMemento memento) {  
        this.label = memento.getLabel();  
        this.x = memento.getX();  
        this.y = memento.getY();  
    }  
}  

//象棋棋子备忘录类：备忘录  
class ChessmanMemento {  
    private String label;  
    private int x;  
    private int y;  

    public ChessmanMemento(String label,int x,int y) {  
        this.label = label;  
        this.x = x;  
        this.y = y;  
    }  

    public void setLabel(String label) {  
        this.label = label;   
    }  

    public void setX(int x) {  
        this.x = x;   
    }  

    public void setY(int y) {  
        this.y = y;   
    }  

    public String getLabel() {  
        return (this.label);   
    }  

    public int getX() {  
        return (this.x);   
    }  

    public int getY() {  
        return (this.y);   
    }     
}  

//象棋棋子备忘录管理类：负责人  
class MementoCaretaker {  
    private ChessmanMemento memento;  

    public ChessmanMemento getMemento() {  
        return memento;  
    }  

    public void setMemento(ChessmanMemento memento) {  
        this.memento = memento;  
    }  
}  
```

编写如下客户端测试代码：  
```java
class Client {  
    public static void main(String args[]) {  
        MementoCaretaker mc = new MementoCaretaker();  
        Chessman chess = new Chessman("车",1,1);  
        display(chess);  
        mc.setMemento(chess.save()); //保存状态       
        chess.setY(4);  
        display(chess);  
        mc.setMemento(chess.save()); //保存状态  
        display(chess);  
        chess.setX(5);  
        display(chess);  
        System.out.println("******悔棋******");     
        chess.restore(mc.getMemento()); //恢复状态  
        display(chess);  
    }  

    public static void display(Chessman chess) {  
        System.out.println("棋子" + chess.getLabel() + "当前位置为：" + "第" + chess.getX() + "行" + "第" + chess.getY() + "列。");  
    }  
}
```

编译并运行程序，输出结果如下：  
```
棋子车当前位置为：第1行第1列。
棋子车当前位置为：第1行第4列。
棋子车当前位置为：第1行第4列。
棋子车当前位置为：第5行第4列。
******悔棋******
棋子车当前位置为：第1行第4列。
```