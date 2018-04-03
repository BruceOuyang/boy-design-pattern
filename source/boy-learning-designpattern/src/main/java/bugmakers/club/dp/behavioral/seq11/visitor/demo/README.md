26.1 OA系统中员工数据汇总

Sunny软件公司欲为某银行开发一套OA系统，在该OA系统中包含一个员工信息管理子系统，该银行员工包括正式员工和临时工，每周人力资源部和财务部等部门需要对员工数据进行汇总，汇总数据包括员工工作时间、员工工资等。该公司基本制度如下：  

(1) 正式员工(Full time Employee)每周工作时间为40小时，不同级别、不同部门的员工每周基本工资不同；如果超过40小时，超出部分按照100元/小时作为加班费；如果少于40小时，所缺时间按照请假处理，请假所扣工资以80元/小时计算，直到基本工资扣除到零为止。除了记录实际工作时间外，人力资源部需记录加班时长或请假时长，作为员工平时表现的一项依据。

(2) 临时工(Part time Employee)每周工作时间不固定，基本工资按小时计算，不同岗位的临时工小时工资不同。人力资源部只需记录实际工作时间。

人力资源部和财务部工作人员可以根据各自的需要对员工数据进行汇总处理，人力资源部负责汇总每周员工工作时间，而财务部负责计算每周员工工资。

Sunny软件公司开发人员针对上述需求，提出了一个初始解决方案，其核心代码如下所示：  
```java
import java.util.*;  

class EmployeeList  
{  
    private ArrayList<Employee> list = new ArrayList<Employee>(); //员工集合  

    //增加员工  
    public void addEmployee(Employee employee)   
    {  
        list.add(employee);  
    }  

    //处理员工数据  
    public void handle(String departmentName)  
    {  
        if(departmentName.equalsIgnoreCase("财务部")) //财务部处理员工数据  
        {  
            for(Object obj : list)  
            {  
                if(obj.getClass().getName().equalsIgnoreCase("FulltimeEmployee"))  
                {  
                    System.out.println("财务部处理全职员工数据！");           
                }  
                else   
                {  
                    System.out.println("财务部处理兼职员工数据！");  
                }  
            }  
        }  
        else if(departmentName.equalsIgnoreCase("人力资源部")) //人力资源部处理员工数据  
        {  
            for(Object obj : list)  
            {  
                if(obj.getClass().getName().equalsIgnoreCase("FulltimeEmployee"))  
                {  
                    System.out.println("人力资源部处理全职员工数据！");                     
                }  
                else   
                {  
                    System.out.println("人力资源部处理兼职员工数据！");  
                }  
            }             
        }  
    }  
}
```

在EmployeeList类的handle()方法中，通过对部门名称和员工类型进行判断，不同部门对不同类型的员工进行了不同的处理，满足了员工数据汇总的要求。但是该解决方案存在如下几个问题：

(1) EmployeeList类非常庞大，它将各个部门处理各类员工数据的代码集中在一个类中，在具体实现时，代码将相当冗长，EmployeeList类承担了过多的职责，既不方便代码的复用，也不利于系统的扩展，违背了“单一职责原则”。

(2)在代码中包含大量的“if…else…”条件判断语句，既需要对不同部门进行判断，又需要对不同类型的员工进行判断，还将出现嵌套的条件判断语句，导致测试和维护难度增大。

(3)如果要增加一个新的部门来操作员工集合，不得不修改EmployeeList类的源代码，在handle()方法中增加一个新的条件判断语句和一些业务处理代码来实现新部门的访问操作。这违背了“开闭原则”，系统的灵活性和可扩展性有待提高。

(4)如果要增加一种新类型的员工，同样需要修改EmployeeList类的源代码，在不同部门的处理代码中增加对新类型员工的处理逻辑，这也违背了“开闭原则”。 如何解决上述问题？如何为同一集合对象中的元素提供多种不同的操作方式？访问者模式就是一个值得考虑的解决方案，它可以在一定程度上解决上述问题（解决大部分问题）。访问者模式可以为为不同类型的元素提供多种访问操作方式，而且可以在不修改原有系统的情况下增加新的操作方式。

26.3 完整解决方案

Sunny软件公司开发人员使用访问者模式对OA系统中员工数据汇总模块进行重构，使得系统可以很方便地增加新类型的访问者，更加符合“单一职责原则”和“开闭原则”，重构后的基本结构如图26-3所示：  
![图26-3 员工数据汇总模块结构图](https://upload-images.jianshu.io/upload_images/5792176-f7db0a61d69e4a14.gif?imageMogr2/auto-orient/strip)  

在图26-3中，FADepartment表示财务部，HRDepartment表示人力资源部，它们充当具体访问者角色，其抽象父类Department充当抽象访问者角色；EmployeeList充当对象结构，用于存储员工列表；FulltimeEmployee表示正式员工，ParttimeEmployee表示临时工，它们充当具体元素角色，其父接口Employee充当抽象元素角色。完整代码如下所示：  
```java
import java.util.*;  

//员工类：抽象元素类  
interface Employee  
{  
    public void accept(Department handler); //接受一个抽象访问者访问  
}  

//全职员工类：具体元素类  
class FulltimeEmployee implements Employee  
{  
    private String name;  
    private double weeklyWage;  
    private int workTime;  

    public FulltimeEmployee(String name,double weeklyWage,int workTime)  
    {  
        this.name = name;  
        this.weeklyWage = weeklyWage;  
        this.workTime = workTime;  
    }     

    public void setName(String name)   
    {  
        this.name = name;   
    }  

    public void setWeeklyWage(double weeklyWage)   
    {  
        this.weeklyWage = weeklyWage;   
    }  

    public void setWorkTime(int workTime)   
    {  
        this.workTime = workTime;   
    }  

    public String getName()   
    {  
        return (this.name);   
    }  

    public double getWeeklyWage()   
    {  
        return (this.weeklyWage);   
    }  

    public int getWorkTime()   
    {  
        return (this.workTime);   
    }  

    public void accept(Department handler)  
    {  
        handler.visit(this); //调用访问者的访问方法  
    }  
}  

//兼职员工类：具体元素类  
class ParttimeEmployee implements Employee  
{  
    private String name;  
    private double hourWage;  
    private int workTime;  

    public ParttimeEmployee(String name,double hourWage,int workTime)  
    {  
        this.name = name;  
        this.hourWage = hourWage;  
        this.workTime = workTime;  
    }     

    public void setName(String name)   
    {  
        this.name = name;   
    }  

    public void setHourWage(double hourWage)   
    {  
        this.hourWage = hourWage;   
    }  

    public void setWorkTime(int workTime)   
    {  
        this.workTime = workTime;   
    }  

    public String getName()   
    {  
        return (this.name);   
    }  

    public double getHourWage()   
    {  
        return (this.hourWage);   
    }  

    public int getWorkTime()   
    {  
        return (this.workTime);   
    }  

    public void accept(Department handler)  
    {  
        handler.visit(this); //调用访问者的访问方法  
    }  
}  

//部门类：抽象访问者类  
abstract class Department  
{  
    //声明一组重载的访问方法，用于访问不同类型的具体元素  
    public abstract void visit(FulltimeEmployee employee);  
    public abstract void visit(ParttimeEmployee employee);    
}  

//财务部类：具体访问者类  
class FADepartment extends Department  
{  
    //实现财务部对全职员工的访问  
    public void visit(FulltimeEmployee employee)  
    {  
        int workTime = employee.getWorkTime();  
        double weekWage = employee.getWeeklyWage();  
        if(workTime > 40)  
        {  
            weekWage = weekWage + (workTime - 40) * 100;  
        }  
        else if(workTime < 40)  
        {  
            weekWage = weekWage - (40 - workTime) * 80;  
            if(weekWage < 0)  
            {  
                weekWage = 0;  
            }  
        }  
        System.out.println("正式员工" + employee.getName() + "实际工资为：" + weekWage + "元。");             
    }  

    //实现财务部对兼职员工的访问  
    public void visit(ParttimeEmployee employee)  
    {  
        int workTime = employee.getWorkTime();  
        double hourWage = employee.getHourWage();  
        System.out.println("临时工" + employee.getName() + "实际工资为：" + workTime * hourWage + "元。");       
    }         
}  

//人力资源部类：具体访问者类  
class HRDepartment extends Department  
{  
    //实现人力资源部对全职员工的访问  
    public void visit(FulltimeEmployee employee)  
    {  
        int workTime = employee.getWorkTime();  
        System.out.println("正式员工" + employee.getName() + "实际工作时间为：" + workTime + "小时。");  
        if(workTime > 40)  
        {  
            System.out.println("正式员工" + employee.getName() + "加班时间为：" + (workTime - 40) + "小时。");  
        }  
        else if(workTime < 40)  
        {  
            System.out.println("正式员工" + employee.getName() + "请假时间为：" + (40 - workTime) + "小时。");  
        }                         
    }  

    //实现人力资源部对兼职员工的访问  
    public void visit(ParttimeEmployee employee)  
    {  
        int workTime = employee.getWorkTime();  
        System.out.println("临时工" + employee.getName() + "实际工作时间为：" + workTime + "小时。");  
    }         
}  

//员工列表类：对象结构  
class EmployeeList  
{  
    //定义一个集合用于存储员工对象  
    private ArrayList<Employee> list = new ArrayList<Employee>();  

    public void addEmployee(Employee employee)  
    {  
        list.add(employee);  
    }  

    //遍历访问员工集合中的每一个员工对象  
    public void accept(Department handler)  
    {  
        for(Object obj : list)  
        {  
            ((Employee)obj).accept(handler);  
        }  
    }  
}
```

为了提高系统的灵活性和可扩展性，我们将具体访问者类的类名存储在配置文件中，并通过工具类XMLUtil来读取配置文件并反射生成对象，XMLUtil类的代码如下所示：  
```java
import javax.xml.parsers.*;  
import org.w3c.dom.*;  
import org.xml.sax.SAXException;  
import java.io.*;  
class XMLUtil  
{  
    //该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象  
    public static Object getBean()  
    {  
        try  
        {  
            //创建文档对象  
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();  
            DocumentBuilder builder = dFactory.newDocumentBuilder();  
            Document doc;                             
            doc = builder.parse(new File("config.xml"));   

            //获取包含类名的文本节点  
            NodeList nl = doc.getElementsByTagName("className");  
            Node classNode=nl.item(0).getFirstChild();  
            String cName=classNode.getNodeValue();  

            //通过类名生成实例对象并将其返回  
            Class c=Class.forName(cName);  
            Object obj=c.newInstance();  
            return obj;  
        }     
        catch(Exception e)  
        {  
            e.printStackTrace();  
            return null;  
        }  
    }  
}
```  

配置文件config.xml中存储了具体访问者类的类名，代码如下所示：  
```xml
<?xml version="1.0"?>  
<config>  
    <className>FADepartment</className>  
</config>
```

编写如下客户端测试代码：  
```java
class Client  
{  
    public static void main(String args[])  
    {  
        EmployeeList list = new EmployeeList();  
        Employee fte1,fte2,fte3,pte1,pte2;  

        fte1 = new FulltimeEmployee("张无忌",3200.00,45);  
        fte2 = new FulltimeEmployee("杨过",2000.00,40);  
        fte3 = new FulltimeEmployee("段誉",2400.00,38);  
        pte1 = new ParttimeEmployee("洪七公",80.00,20);  
        pte2 = new ParttimeEmployee("郭靖",60.00,18);  

        list.addEmployee(fte1);  
        list.addEmployee(fte2);  
        list.addEmployee(fte3);  
        list.addEmployee(pte1);  
        list.addEmployee(pte2);  

        Department dep;  
        dep = (Department)XMLUtil.getBean();  
        list.accept(dep);  
    }  
}
```  

编译并运行程序，输出结果如下：  
```
正式员工张无忌实际工资为：3700.0元。
正式员工杨过实际工资为：2000.0元。
正式员工段誉实际工资为：2240.0元。
临时工洪七公实际工资为：1600.0元。
临时工郭靖实际工资为：1080.0元。
```  

如果需要更换具体访问者类，无须修改源代码，只需修改配置文件，例如将访问者类由财务部改为人力资源部，只需将存储在配置文件中的具体访问者类FADepartment改为HRDepartment，如下代码所示：  
```xml
<?xml version="1.0"?>  
<config>  
    <className>HRDepartment</className>  
</config>
```

重新运行客户端程序，输出结果如下：  
```
正式员工张无忌实际工作时间为：45小时。
正式员工张无忌加班时间为：5小时。
正式员工杨过实际工作时间为：40小时。
正式员工段誉实际工作时间为：38小时。
正式员工段誉请假时间为：2小时。
临时工洪七公实际工作时间为：20小时。
临时工郭靖实际工作时间为：18小时。
```

如果要在系统中增加一种新的访问者，无须修改源代码，只要增加一个新的具体访问者类即可，在该具体访问者中封装了新的操作元素对象的方法。从增加新的访问者的角度来看，访问者模式符合“开闭原则”。

如果要在系统中增加一种新的具体元素，例如增加一种新的员工类型为“退休人员”，由于原有系统并未提供相应的访问接口（在抽象访问者中没有声明任何访问“退休人员”的方法），因此必须对原有系统进行修改，在原有的抽象访问者类和具体访问者类中增加相应的访问方法。从增加新的元素的角度来看，访问者模式违背了“开闭原则”。

综上所述，访问者模式与抽象工厂模式类似，对“开闭原则”的支持具有倾斜性，可以很方便地添加新的访问者，但是添加新的元素较为麻烦。
