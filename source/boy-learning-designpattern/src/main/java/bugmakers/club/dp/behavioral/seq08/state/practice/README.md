**练习**  
> Sunny软件公司欲开发一款纸牌游戏软件，在该游戏软件中用户角色具有入门级(Primary)、熟练级(Secondary)、高手级(Professional)和骨灰级(Final)四种等级，角色的等级与其积分相对应，游戏胜利将增加积分，失败则扣除积分。入门级具有最基本的游戏功能play() ，熟练级增加了游戏胜利积分加倍功能doubleScore()，高手级在熟练级基础上再增加换牌功能changeCards()，骨灰级在高手级基础上再增加偷看他人的牌功能peekCards()。

试使用状态模式来设计该系统。

7.练习

(1) 分析如下代码：  
```java
class TestXYZ {  
    int behaviour;  
    //Getter and Setter  
    //......  
    public void handleAll() {  
        if (behaviour == 0) { //do something }  
        else if (behaviour == 1) { //do something }  
        else if (behaviour == 2) { //do something }  
        else if (behaviour == 3) { //do something }  
        //... some more else if ...  
    }  
}
```

为了提高代码的扩展性和健壮性，可以使用( )设计模式来进行重构。 A. Visitor（访问者） B. Facade（外观） C. Memento（备忘录） D. State（状态）

(2) 传输门是传输系统中的重要装置。传输门具有Open（打开）、Closed（关闭）、Opening（正在打开）、StayOpen（保持打开）、Closing（正在关闭）五种状态。触发状态的转换事件有click、complete和timeout三种。事件与其相应的状态转换如图7所示。  
![图7 传输门响应事件与其状态转换图](https://upload-images.jianshu.io/upload_images/5792176-ef09b5c8da855f14.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
图7 传输门响应事件与其状态转换图

试使用状态模式对传输门进行状态模拟，要求绘制相应的类图并编程模拟实现。