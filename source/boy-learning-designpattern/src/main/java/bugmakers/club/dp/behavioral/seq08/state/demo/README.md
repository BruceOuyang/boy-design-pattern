1.银行系统中的账户类设计

Sunny软件公司欲为某银行开发一套信用卡业务系统，银行账户(Account)是该系统的核心类之一，通过分析，Sunny软件公司开发人员发现在该系统中，账户存在三种状态，且在不同状态下账户存在不同的行为，具体说明如下：

(1) 如果账户中余额大于等于0，则账户的状态为正常状态(Normal State)，此时用户既可以向该账户存款也可以从该账户取款；

(2) 如果账户中余额小于0，并且大于-2000，则账户的状态为透支状态(Overdraft State)，此时用户既可以向该账户存款也可以从该账户取款，但需要按天计算利息；

(3) 如果账户中余额等于-2000，那么账户的状态为受限状态(Restricted State)，此时用户只能向该账户存款，不能再从中取款，同时也将按天计算利息；

(4) 根据余额的不同，以上三种状态可发生相互转换。

Sunny软件公司开发人员对银行账户类进行分析，绘制了如图2所示UML状态图：  
![图2 银行账户状态图](https://upload-images.jianshu.io/upload_images/5792176-cc3aace42c459e53.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
图2 银行账户状态图  

在图2中，NormalState表示正常状态，OverdraftState表示透支状态，RestrictedState表示受限状态，在这三种状态下账户对象拥有不同的行为，方法deposit()用于存款，withdraw()用于取款，computeInterest()用于计算利息，stateCheck()用于在每一次执行存款和取款操作后根据余额来判断是否要进行状态转换并实现状态转换，相同的方法在不同的状态中可能会有不同的实现。为了实现不同状态下对象的各种行为以及对象状态之间的相互转换，Sunny软件公司开发人员设计了一个较为庞大的账户类Account，其中部分代码如下所示：  
```java
class Account {  
    private String state; //状态  
    private int balance; //余额  
    
    // ......  

    //存款操作    
    public void deposit() {  
        //存款  
        stateCheck();     
    }  

    //取款操作  
    public void withdraw() {  
        if (state.equalsIgnoreCase("NormalState") || state.equalsIgnoreCase("OverdraftState ")) {  
            //取款  
            stateCheck();  
        }  
        else {  
            //取款受限  
        }  
    }  

    //计算利息操作  
    public void computeInterest() {  
        if(state.equalsIgnoreCase("OverdraftState") || state.equalsIgnoreCase("RestrictedState ")) {  
            //计算利息  
        }  
    }  

    //状态检查和转换操作  
    public void stateCheck() {  
        if (balance >= 0) {  
            state = "NormalState";  
        }  
        else if (balance > -2000 && balance < 0) {  
            state = "OverdraftState";  
        }  
        else if (balance == -2000) {  
            state = "RestrictedState";  
        }  
        else if (balance < -2000) {  
            //操作受限  
        }  
    }  
    // ......  
}
```

分析上述代码，我们不难发现存在如下几个问题：

(1) 几乎每个方法中都包含状态判断语句，以判断在该状态下是否具有该方法以及在特定状态下该方法如何实现，导致代码非常冗长，可维护性较差；

(2) 拥有一个较为复杂的stateCheck()方法，包含大量的if…else if…else…语句用于进行状态转换，代码测试难度较大，且不易于维护；

(3) 系统扩展性较差，如果需要增加一种新的状态，如冻结状态（Frozen State，在该状态下既不允许存款也不允许取款），需要对原有代码进行大量修改，扩展起来非常麻烦。

为了解决这些问题，我们可以使用状态模式，在状态模式中，我们将对象在每一个状态下的行为和状态转移语句封装在一个个状态类中，通过这些状态类来分散冗长的条件转移语句，让系统具有更好的灵活性和可扩展性，状态模式可以在一定程度上解决上述问题。

3.完整解决方案

Sunny软件公司开发人员使用状态模式来解决账户状态的转换问题，客户端只需要执行简单的存款和取款操作，系统根据余额将自动转换到相应的状态，其基本结构如图4所示：  
![图4 银行账户结构图](https://upload-images.jianshu.io/upload_images/5792176-06ffda7e58039300.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
图4 银行账户结构图  

在图4中，Account充当环境类角色，AccountState充当抽象状态角色，NormalState、OverdraftState和RestrictedState充当具体状态角色。完整代码如下所示（温馨提示：代码有点长，需要有耐心！）：  
```java
//银行账户：环境类  
class Account {  
    private AccountState state; //维持一个对抽象状态对象的引用  
    private String owner; //开户名  
    private double balance = 0; //账户余额  

    public Account(String owner,double init) {  
        this.owner = owner;  
        this.balance = balance;  
        this.state = new NormalState(this); //设置初始状态  
        System.out.println(this.owner + "开户，初始金额为" + init);   
        System.out.println("---------------------------------------------");      
    }  

    public double getBalance() {  
        return this.balance;  
    }  

    public void setBalance(double balance) {  
        this.balance = balance;  
    }  

    public void setState(AccountState state) {  
        this.state = state;  
    }  

    public void deposit(double amount) {  
        System.out.println(this.owner + "存款" + amount);  
        state.deposit(amount); //调用状态对象的deposit()方法  
        System.out.println("现在余额为"+ this.balance);  
        System.out.println("现在帐户状态为"+ this.state.getClass().getName());  
        System.out.println("---------------------------------------------");              
    }  

    public void withdraw(double amount) {  
        System.out.println(this.owner + "取款" + amount);  
        state.withdraw(amount); //调用状态对象的withdraw()方法  
        System.out.println("现在余额为"+ this.balance);  
        System.out.println("现在帐户状态为"+ this. state.getClass().getName());          
        System.out.println("---------------------------------------------");  
    }  

    public void computeInterest()  
    {  
        state.computeInterest(); //调用状态对象的computeInterest()方法  
    }  
}  

//抽象状态类  
abstract class AccountState {  
    protected Account acc;  
    public abstract void deposit(double amount);  
    public abstract void withdraw(double amount);  
    public abstract void computeInterest();  
    public abstract void stateCheck();  
}  

//正常状态：具体状态类  
class NormalState extends AccountState {  
    public NormalState(Account acc) {  
        this.acc = acc;  
    }  

public NormalState(AccountState state) {  
        this.acc = state.acc;  
    }  

    public void deposit(double amount) {  
        acc.setBalance(acc.getBalance() + amount);  
        stateCheck();  
    }  

    public void withdraw(double amount) {  
        acc.setBalance(acc.getBalance() - amount);  
        stateCheck();  
    }  

    public void computeInterest()  
    {  
        System.out.println("正常状态，无须支付利息！");  
    }  

    //状态转换  
    public void stateCheck() {  
        if (acc.getBalance() > -2000 && acc.getBalance() <= 0) {  
            acc.setState(new OverdraftState(this));  
        }  
        else if (acc.getBalance() == -2000) {  
            acc.setState(new RestrictedState(this));  
        }  
        else if (acc.getBalance() < -2000) {  
            System.out.println("操作受限！");  
        }     
    }     
}    

//透支状态：具体状态类  
class OverdraftState extends AccountState  
{  
    public OverdraftState(AccountState state) {  
        this.acc = state.acc;  
    }  

    public void deposit(double amount) {  
        acc.setBalance(acc.getBalance() + amount);  
        stateCheck();  
    }  

    public void withdraw(double amount) {  
        acc.setBalance(acc.getBalance() - amount);  
        stateCheck();  
    }  

    public void computeInterest() {  
        System.out.println("计算利息！");  
    }  

    //状态转换  
    public void stateCheck() {  
        if (acc.getBalance() > 0) {  
            acc.setState(new NormalState(this));  
        }  
        else if (acc.getBalance() == -2000) {  
            acc.setState(new RestrictedState(this));  
        }  
        else if (acc.getBalance() < -2000) {  
            System.out.println("操作受限！");  
        }  
    }  
}  

//受限状态：具体状态类  
class RestrictedState extends AccountState {  
    public RestrictedState(AccountState state) {  
        this.acc = state.acc;  
    }  

    public void deposit(double amount) {  
        acc.setBalance(acc.getBalance() + amount);  
        stateCheck();  
    }  

    public void withdraw(double amount) {  
        System.out.println("帐号受限，取款失败");  
    }  

    public void computeInterest() {  
        System.out.println("计算利息！");  
    }  

    //状态转换  
    public void stateCheck() {  
        if(acc.getBalance() > 0) {  
            acc.setState(new NormalState(this));  
        }  
        else if(acc.getBalance() > -2000) {  
            acc.setState(new OverdraftState(this));  
        }  
    }  
}
```

编写如下客户端测试代码：  
```java
class Client {  
    public static void main(String args[]) {  
        Account acc = new Account("段誉",0.0);  
        acc.deposit(1000);  
        acc.withdraw(2000);  
        acc.deposit(3000);  
        acc.withdraw(4000);  
        acc.withdraw(1000);  
        acc.computeInterest();  
    }  
}
```

编译并运行程序，输出结果如下：  
```
段誉开户，初始金额为0.0
---------------------------------------------
段誉存款1000.0
现在余额为1000.0
现在帐户状态为NormalState
---------------------------------------------
段誉取款2000.0
现在余额为-1000.0
现在帐户状态为OverdraftState
---------------------------------------------
段誉存款3000.0
现在余额为2000.0
现在帐户状态为NormalState
---------------------------------------------
段誉取款4000.0
现在余额为-2000.0
现在帐户状态为RestrictedState
---------------------------------------------
段誉取款1000.0
帐号受限，取款失败
现在余额为-2000.0
现在帐户状态为RestrictedState
---------------------------------------------
计算利息！
``` 