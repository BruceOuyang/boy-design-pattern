16.1 采购单的分级审批

Sunny软件公司承接了某企业SCM(Supply Chain Management，供应链管理)系统的开发任务，其中包含一个采购审批子系统。该企业的采购审批是分级进行的，即根据采购金额的不同由不同层次的主管人员来审批，主任可以审批5万元以下（不包括5万元）的采购单，副董事长可以审批5万元至10万元（不包括10万元）的采购单，董事长可以审批10万元至50万元（不包括50万元）的采购单，50万元及以上的采购单就需要开董事会讨论决定。如图16-1所示：  
![图16-1 采购单分级审批示意图](https://upload-images.jianshu.io/upload_images/5792176-37ab1333ca281434.gif?imageMogr2/auto-orient/strip)  
图16-1 采购单分级审批示意图  

如何在软件中实现采购单的分级审批？Sunny软件公司开发人员提出了一个初始解决方案，在系统中提供一个采购单处理类PurchaseRequestHandler用于统一处理采购单，其框架代码如下所示：  
```java
//采购单处理类  
class PurchaseRequestHandler {  
    //递交采购单给主任  
    public void sendRequestToDirector(PurchaseRequest request) {  
        if (request.getAmount() < 50000) {  
            //主任可审批该采购单  
            this.handleByDirector(request);  
        }  
        else if (request.getAmount() < 100000) {  
            //副董事长可审批该采购单  
            this.handleByVicePresident(request);  
        }  
        else if (request.getAmount() < 500000) {  
            //董事长可审批该采购单  
            this.handleByPresident(request);  
        }  
        else {  
            //董事会可审批该采购单  
            this.handleByCongress(request);  
        }  
    }  

    //主任审批采购单  
    public void handleByDirector(PurchaseRequest request) {  
        //代码省略  
    }  

    //副董事长审批采购单  
    public void handleByVicePresident(PurchaseRequest request) {  
        //代码省略  
    }  

    //董事长审批采购单  
    public void handleByPresident(PurchaseRequest request) {  
        //代码省略  
    }  

    //董事会审批采购单  
    public void handleByCongress(PurchaseRequest request) {  
        //代码省略  
    }  
}
```  

问题貌似很简单，但仔细分析，发现上述方案存在如下几个问题：  

(1)PurchaseRequestHandler类较为庞大，各个级别的审批方法都集中在一个类中，违反了“单一职责原则”，测试和维护难度大。  

(2)如果需要增加一个新的审批级别或调整任何一级的审批金额和审批细节（例如将董事长的审批额度改为60万元）时都必须修改源代码并进行严格测试，此外，如果需要移除某一级别（例如金额为10万元及以上的采购单直接由董事长审批，不再设副董事长一职）时也必须对源代码进行修改，违反了“开闭原则”。  

(3)审批流程的设置缺乏灵活性，现在的审批流程是“主任-->副董事长-->董事长-->董事会”，如果需要改为“主任-->董事长-->董事会”，在此方案中只能通过修改源代码来实现，客户端无法定制审批流程。  

如何针对上述问题对系统进行改进？Sunny公司开发人员迫切需要一种新的设计方案，还好有职责链模式，通过使用职责链模式我们可以最大程度地解决这些问题，下面让我们正式进入职责链模式的学习。  


16.3 完整解决方案  

为了让采购单的审批流程更加灵活，并实现采购单的链式传递和处理，Sunny公司开发人员使用职责链模式来实现采购单的分级审批，其基本结构如图16-3所示：  
![图16-3 采购单分级审批结构图](https://upload-images.jianshu.io/upload_images/5792176-6b20adbdc9a2430a.gif?imageMogr2/auto-orient/strip)    

在图16-3中，抽象类Approver充当抽象处理者（抽象传递者），Director、VicePresident、President和Congress充当具体处理者（具体传递者），PurchaseRequest充当请求类。完整代码如下所示：  
```java
//采购单：请求类  
class PurchaseRequest {  
    private double amount;  //采购金额  
    private int number;  //采购单编号  
    private String purpose;  //采购目的  

    public PurchaseRequest(double amount, int number, String purpose) {  
        this.amount = amount;  
        this.number = number;  
        this.purpose = purpose;  
    }  

    public void setAmount(double amount) {  
        this.amount = amount;  
    }  

    public double getAmount() {  
        return this.amount;  
    }  

    public void setNumber(int number) {  
        this.number = number;  
    }  

    public int getNumber() {  
        return this.number;  
    }  

    public void setPurpose(String purpose) {  
        this.purpose = purpose;  
    }  

    public String getPurpose() {  
        return this.purpose;  
    }  
}  

//审批者类：抽象处理者  
abstract class Approver {  
    protected Approver successor; //定义后继对象  
    protected String name; //审批者姓名  

    public Approver(String name) {  
        this.name = name;  
    }  

    //设置后继者  
    public void setSuccessor(Approver successor) {   
        this.successor = successor;  
    }  

    //抽象请求处理方法  
    public abstract void processRequest(PurchaseRequest request);  
}  

//主任类：具体处理者  
class Director extends Approver {  
    public Director(String name) {  
        super(name);  
    }  

    //具体请求处理方法  
    public void processRequest(PurchaseRequest request) {  
        if (request.getAmount() < 50000) {  
            System.out.println("主任" + this.name + "审批采购单：" + request.getNumber() + "，金额：" + request.getAmount() + "元，采购目的：" + request.getPurpose() + "。");  //处理请求  
        }  
        else {  
            this.successor.processRequest(request);  //转发请求  
        }     
    }  
}  

//副董事长类：具体处理者  
class VicePresident extends Approver {  
    public VicePresident(String name) {  
        super(name);  
    }  

    //具体请求处理方法  
    public void processRequest(PurchaseRequest request) {  
        if (request.getAmount() < 100000) {  
            System.out.println("副董事长" + this.name + "审批采购单：" + request.getNumber() + "，金额：" + request.getAmount() + "元，采购目的：" + request.getPurpose() + "。");  //处理请求  
        }  
        else {  
            this.successor.processRequest(request);  //转发请求  
        }     
    }  
}  

//董事长类：具体处理者  
class President extends Approver {  
    public President(String name) {  
        super(name);  
    }  

    //具体请求处理方法  
    public void processRequest(PurchaseRequest request) {  
        if (request.getAmount() < 500000) {  
            System.out.println("董事长" + this.name + "审批采购单：" + request.getNumber() + "，金额：" + request.getAmount() + "元，采购目的：" + request.getPurpose() + "。");  //处理请求  
        }  
        else {  
            this.successor.processRequest(request);  //转发请求  
        }  
    }  
}  

//董事会类：具体处理者  
class Congress extends Approver {  
    public Congress(String name) {  
        super(name);  
    }  

    //具体请求处理方法  
    public void processRequest(PurchaseRequest request) {  
        System.out.println("召开董事会审批采购单：" + request.getNumber() + "，金额：" + request.getAmount() + "元，采购目的：" + request.getPurpose() + "。");        //处理请求  
    }      
}
```

编写如下客户端测试代码：
```java
class Client {  
    public static void main(String[] args) {  
        Approver wjzhang,gyang,jguo,meeting;  
        wjzhang = new Director("张无忌");  
        gyang = new VicePresident("杨过");  
        jguo = new President("郭靖");  
        meeting = new Congress("董事会");  

        //创建职责链  
        wjzhang.setSuccessor(gyang);  
        gyang.setSuccessor(jguo);  
        jguo.setSuccessor(meeting);  

        //创建采购单  
        PurchaseRequest pr1 = new PurchaseRequest(45000,10001,"购买倚天剑");  
        wjzhang.processRequest(pr1);  

        PurchaseRequest pr2 = new PurchaseRequest(60000,10002,"购买《葵花宝典》");  
        wjzhang.processRequest(pr2);  

        PurchaseRequest pr3 = new PurchaseRequest(160000,10003,"购买《金刚经》");  
        wjzhang.processRequest(pr3);  

        PurchaseRequest pr4 = new PurchaseRequest(800000,10004,"购买桃花岛");  
        wjzhang.processRequest(pr4);  
    }  
}
```

编译并运行程序，输出结果如下：  
```
主任张无忌审批采购单：10001，金额：45000.0元，采购目的：购买倚天剑。
副董事长杨过审批采购单：10002，金额：60000.0元，采购目的：购买《葵花宝典》。
董事长郭靖审批采购单：10003，金额：160000.0元，采购目的：购买《金刚经》。
召开董事会审批采购单：10004，金额：800000.0元，采购目的：购买桃花岛。
```

如果需要在系统增加一个新的具体处理者，如增加一个经理(Manager)角色可以审批5万元至8万元（不包括8万元）的采购单，需要编写一个新的具体处理者类Manager，作为抽象处理者类Approver的子类，实现在Approver类中定义的抽象处理方法，如果采购金额大于等于8万元，则将请求转发给下家，代码如下所示：  
```java
//经理类：具体处理者  
class Manager extends Approver {  
    public Manager(String name) {  
        super(name);  
    }  

    //具体请求处理方法  
    public void processRequest(PurchaseRequest request) {  
        if (request.getAmount() < 80000) {  
            System.out.println("经理" + this.name + "审批采购单：" + request.getNumber() + "，金额：" + request.getAmount() + "元，采购目的：" + request.getPurpose() + "。");  //处理请求  
        }  
        else {  
            this.successor.processRequest(request);  //转发请求  
        }     
    }  
}
```  

由于链的创建过程由客户端负责，因此增加新的具体处理者类对原有类库无任何影响，无须修改已有类的源代码，符合“开闭原则”。

在客户端代码中，如果要将新的具体请求处理者应用在系统中，需要创建新的具体处理者对象，然后将该对象加入职责链中。如在客户端测试代码中增加如下代码：  
```java
Approver rhuang;  
rhuang = new Manager("黄蓉");
```

将建链代码改为：  
```java
//创建职责链

//将“黄蓉”作为“张无忌”的下家
wjzhang.setSuccessor(rhuang);

//将“杨过”作为“黄蓉”的下家
rhuang.setSuccessor(gyang); 
gyang.setSuccessor(jguo);
jguo.setSuccessor(meeting);
```

重新编译并运行程序，输出结果如下：  
```
主任张无忌审批采购单：10001，金额：45000.0元，采购目的：购买倚天剑。 
经理黄蓉审批采购单：10002，金额：60000.0元，采购目的：购买《葵花宝典》。
董事长郭靖审批采购单：10003，金额：160000.0元，采购目的：购买《金刚经》。 
召开董事会审批采购单：10004，金额：800000.0元，采购目的：购买桃花岛。
```
