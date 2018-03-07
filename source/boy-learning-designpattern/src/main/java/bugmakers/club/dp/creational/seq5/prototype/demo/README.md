7.1 大同小异的工作周报

 Sunny软件公司一直使用自行开发的一套OA (Office Automatic，办公自动化)系统进行日常工作办理，但在使用过程中，越来越多的人对工作周报的创建和编写模块产生了抱怨。追其原因，Sunny软件公司的OA管理员发现，由于某些岗位每周工作存在重复性，工作周报内容都大同小异，如图7-1工作周报示意图。这些周报只有一些小地方存在差异，但是现行系统每周默认创建的周报都是空白报表，用户只能通过重新输入或不断复制粘贴来填写重复的周报内容，极大降低了工作效率，浪费宝贵的时间。如何快速创建相同或者相似的工作周报，成为Sunny公司OA开发人员面临的一个新问题。  
 ![图7-1 工作周报示意图](http://upload-images.jianshu.io/upload_images/5792176-7d030540aa18c9f6.gif?imageMogr2/auto-orient/strip)  
 图7-1 工作周报示意图
 
Sunny公司的开发人员通过对问题进行仔细分析，决定按照如下思路对工作周报模块进行重新设计和实现：  

(1)除了允许用户创建新周报外，还允许用户将创建好的周报保存为模板；  

(2)用户在再次创建周报时，可以创建全新的周报，还可以选择合适的模板复制生成一份相同的周报，然后对新生成的周报根据实际情况进行修改，产生新的周报。  

只要按照如上两个步骤进行处理，工作周报的创建效率将得以大大提高。这个过程让我们想到平时经常进行的两个电脑基本操作：复制和粘贴，快捷键通常为Ctrl + C和Ctrl + V，通过对已有对象的复制和粘贴，我们可以创建大量的相同对象。  

如何在一个面向对象系统中实现对象的复制和粘贴呢？

7.3 完整解决方案

Sunny公司开发人员决定使用原型模式来实现工作周报的快速创建，快速创建工作周报结构图如图7-3所示：  
![图7-3 快速创建工作周报结构图](http://upload-images.jianshu.io/upload_images/5792176-3c41798ec35c0ff5.gif?imageMogr2/auto-orient/strip)  
图7-3 快速创建工作周报结构图

在图7-3中，WeeklyLog充当具体原型类，Object类充当抽象原型类，clone()方法为原型方法。WeeklyLog类的代码如下所示：  
```java
//工作周报WeeklyLog：具体原型类，考虑到代码的可读性和易理解性，只列出部分与模式相关的核心代码
class WeeklyLog implements Cloneable
{
       private  String name;
       private  String date;
       private  String content;
       public  void setName(String name) {
              this.name  = name;
       }
       public  void setDate(String date) {
              this.date  = date;
       }
       public  void setContent(String content) {
              this.content  = content;
       }
       public  String getName() {
              return  (this.name);
       }
       public  String getDate() {
              return  (this.date);
       }
       public  String getContent() {
              return  (this.content);
       }
     //克隆方法clone()，此处使用Java语言提供的克隆机制
       public WeeklyLog clone()
       {
              Object obj = null;
              try
              {
                     obj = super.clone();
                     return (WeeklyLog)obj;     
              }
              catch(CloneNotSupportedException e)
              {
                     System.out.println("不支持复制！");
                     return null;
              }
       }
}
```  

编写如下客户端测试代码：  
```java
class Client
{
   public  static void main(String args[])
   {
       WeeklyLog log_previous = new WeeklyLog();  //创建原型对象
       log_previous.setName("张无忌");
       log_previous.setDate("第12周");
       log_previous.setContent("这周工作很忙，每天加班！");

       System.out.println("****周报****");
       System.out.println("周次：" +  log_previous.getDate());
       System.out.println("姓名：" +  log_previous.getName());
       System.out.println("内容：" +  log_previous.getContent());
       System.out.println("--------------------------------");

       WeeklyLog  log_new;
       log_new  = log_previous.clone(); //调用克隆方法创建克隆对象
       log_new.setDate("第13周");
       System.out.println("****周报****");
       System.out.println("周次：" + log_new.getDate());
       System.out.println("姓名：" + log_new.getName());
       System.out.println("内容：" + log_new.getContent());
   }
}
```  

编译并运行程序，输出结果如下：  
```
****周报****
周次：第12周
姓名：张无忌
内容：这周工作很忙，每天加班！
--------------------------------
****周报****
周次：第13周
姓名：张无忌
内容：这周工作很忙，每天加班！
```  

通过已创建的工作周报可以快速创建新的周报，然后再根据需要修改周报，无须再从头开始创建。原型模式为工作流系统中任务单的快速生成提供了一种解决方案。  

**思考**  

如果在Client类的main()函数中增加如下几条语句：  
```java
System.out.println(log_previous == log_new);
System.out.println(log_previous.getDate() == log_new.getDate());
System.out.println(log_previous.getName() == log_new.getName());
System.out.println(log_previous.getContent() == log_new.getContent());
``` 

预测这些语句的输出结果。  

## 对象的克隆——原型模式（三）  

7.4 带附件的周报  

通过引入原型模式，Sunny软件公司OA系统支持工作周报的快速克隆，极大提高了工作周报的编写效率，受到员工的一致好评。但有员工又发现一个问题，有些工作周报带有附件，例如经理助理“小龙女”的周报通常附有本周项目进展报告汇总表、本周客户反馈信息汇总表等，如果使用上述原型模式来复制周报，周报虽然可以复制，但是周报的附件并不能复制，这是由于什么原因导致的呢？如何才能实现周报和附件的同时复制呢？我们在本节将讨论如何解决这些问题。  

在回答这些问题之前，先介绍一下两种不同的克隆方法，浅克隆(ShallowClone)和深克隆(DeepClone)。在Java语言中，数据类型分为值类型（基本数据类型）和引用类型，值类型包括int、double、byte、boolean、char等简单数据类型，引用类型包括类、接口、数组等复杂类型。浅克隆和深克隆的主要区别在于是否支持引用类型的成员变量的复制，下面将对两者进行详细介绍。  

1.浅克隆  

在浅克隆中，如果原型对象的成员变量是值类型，将复制一份给克隆对象；如果原型对象的成员变量是引用类型，则将引用对象的地址复制一份给克隆对象，也就是说原型对象和克隆对象的成员变量指向相同的内存地址。简单来说，在浅克隆中，当对象被复制时只复制它本身和其中包含的值类型的成员变量，而引用类型的成员对象并没有复制，如图7-4所示：  
![图7-4 浅克隆示意图](http://upload-images.jianshu.io/upload_images/5792176-e3e703be80ac7c12.gif?imageMogr2/auto-orient/strip)  
图7-4 浅克隆示意图  

在Java语言中，通过覆盖Object类的clone()方法可以实现浅克隆。为了让大家更好地理解浅克隆和深克隆的区别，我们首先使用浅克隆来实现工作周报和附件类的复制，其结构如图7-5所示：  
![图7-5 带附件的周报结构图（浅克隆）](http://upload-images.jianshu.io/upload_images/5792176-73a64136410e94ec.gif?imageMogr2/auto-orient/strip)  
图7-5 带附件的周报结构图（浅克隆）  

附件类Attachment代码如下：  
```java
//附件类
class Attachment
{
       private  String name; //附件名
       public  void setName(String name)
       {
              this.name  = name;
       }
       public  String getName()
       {
              return  this.name;
       }
     public void download()
     {
            System.out.println("下载附件，文件名为" + name);
     }
}
```

修改工作周报类WeeklyLog，修改后的代码如下：  
```java
//工作周报WeeklyLog
class WeeklyLog implements Cloneable
{
     //为了简化设计和实现，假设一份工作周报中只有一个附件对象，实际情况中可以包含多个附件，可以通过List等集合对象来实现
     private Attachment attachment;
     private String name;
     private String date;
     private String content;
     public void setAttachment(Attachment  attachment) {
         this.attachment = attachment;
     }
     public void setName(String name) {
         this.name  = name;
     }
     public void setDate(String date) { 
         this.date  = date;
     }
     public void setContent(String content) {
         this.content  = content;
     }
     public Attachment  getAttachment(){
         return (this.attachment);
     }
     public String getName() {
         return  (this.name);
     }
     public String getDate() {
         return  (this.date);
     }
     public String getContent() {
         return  (this.content);
     }
     //使用clone()方法实现浅克隆
     public WeeklyLog clone()
     {
         Object obj = null;
         try
           {
               obj = super.clone();
               return (WeeklyLog)obj; 
           }
           catch(CloneNotSupportedException  e)
           {
               System.out.println("不支持复制！");
               return null; 
           }
     }
}
```

客户端代码如下所示：  
```java
class Client
{
    public  static void main(String args[])
    {
        WeeklyLog  log_previous, log_new;
        log_previous  = new WeeklyLog(); //创建原型对象
        Attachment  attachment = new Attachment(); //创建附件对象
        log_previous.setAttachment(attachment);  //将附件添加到周报中
        log_new  = log_previous.clone(); //调用克隆方法创建克隆对象
        //比较周报
        System.out.println("周报是否相同？ " + (log_previous ==  log_new));
        //比较附件
        System.out.println("附件是否相同？ " +  (log_previous.getAttachment() == log_new.getAttachment())); 
    }
}
```

编译并运行程序，输出结果如下：  
```
周报是否相同？  false
附件是否相同？ true
```

由于使用的是浅克隆技术，因此工作周报对象复制成功，通过“==”比较原型对象和克隆对象的内存地址时输出false；但是比较附件对象的内存地址时输出true，说明它们在内存中是同一个对象。  

2.深克隆  

在深克隆中，无论原型对象的成员变量是值类型还是引用类型，都将复制一份给克隆对象，深克隆将原型对象的所有引用对象也复制一份给克隆对象。简单来说，在深克隆中，除了对象本身被复制外，对象所包含的所有成员变量也将复制，如图7-6所示：  
![图7-6 深克隆示意图](http://upload-images.jianshu.io/upload_images/5792176-6bdadf1f3f4c1bfd.gif?imageMogr2/auto-orient/strip)  
图7-6 深克隆示意图  

在Java语言中，如果需要实现深克隆，可以通过序列化(Serialization)等方式来实现。序列化就是将对象写到流的过程，写到流中的对象是原有对象的一个拷贝，而原对象仍然存在于内存中。通过序列化实现的拷贝不仅可以复制对象本身，而且可以复制其引用的成员对象，因此通过序列化将对象写到一个流中，再从流里将其读出来，可以实现深克隆。需要注意的是能够实现序列化的对象其类必须实现Serializable接口，否则无法实现序列化操作。下面我们使用深克隆技术来实现工作周报和附件对象的复制，由于要将附件对象和工作周报对象都写入流中，因此两个类均需要实现Serializable接口，其结构如图7-7所示：  
![图7-7 带附件的周报结构图（深克隆）](http://upload-images.jianshu.io/upload_images/5792176-2f0b8e3f1be57a4d.gif?imageMogr2/auto-orient/strip)
图7-7 带附件的周报结构图（深克隆）

修改后的附件类Attachment代码如下：  
```java
import  java.io.*;
//附件类
class  Attachment implements Serializable
{
       private  String name; //附件名
       public  void setName(String name)
       {
              this.name  = name;
       }
       public  String getName()
       {
              return  this.name;
       }
     public void download()
     {
            System.out.println("下载附件，文件名为" + name);
     }
}
```  

工作周报类WeeklyLog不再使用Java自带的克隆机制，而是通过序列化来从头实现对象的深克隆，我们需要重新编写clone()方法，修改后的代码如下：  
```java
import  java.io.*;
//工作周报类
class  WeeklyLog implements Serializable
{
       private  Attachment attachment;
       private  String name;
       private  String date;
       private  String content;
       public  void setAttachment(Attachment attachment) {
              this.attachment  = attachment;
       }
       public  void setName(String name) {
              this.name  = name;
       }
       public  void setDate(String date) {
              this.date  = date;
       }
       public  void setContent(String content) {
              this.content  = content;
       }
       public  Attachment getAttachment(){
              return  (this.attachment);
       }
       public  String getName() {
              return  (this.name);
       }
       public  String getDate() {
              return  (this.date);
       }
       public  String getContent() {
              return  (this.content);
       }
   //使用序列化技术实现深克隆
       public WeeklyLog deepClone() throws  IOException, ClassNotFoundException, OptionalDataException
       {
              //将对象写入流中
              ByteArrayOutputStream bao=new  ByteArrayOutputStream();
              ObjectOutputStream oos=new  ObjectOutputStream(bao);
              oos.writeObject(this);

              //将对象从流中取出
              ByteArrayInputStream bis=new  ByteArrayInputStream(bao.toByteArray());
              ObjectInputStream ois=new  ObjectInputStream(bis);
              return  (WeeklyLog)ois.readObject();
       }
}
```  

客户端代码如下所示：  
```java
class Client
{
       public  static void main(String args[])
       {
              WeeklyLog  log_previous, log_new = null;
              log_previous  = new WeeklyLog(); //创建原型对象
              Attachment  attachment = new Attachment(); //创建附件对象
              log_previous.setAttachment(attachment);  //将附件添加到周报中
              try
              {
                     log_new =  log_previous.deepClone(); //调用深克隆方法创建克隆对象                  
              }
              catch(Exception e)
              {
                     System.err.println("克隆失败！");
              }
              //比较周报
              System.out.println("周报是否相同？ " + (log_previous ==  log_new));
              //比较附件
              System.out.println("附件是否相同？ " +  (log_previous.getAttachment() == log_new.getAttachment()));
       }
}
```  

编译并运行程序，输出结果如下：  
```
周报是否相同？  false
附件是否相同？  false
```

从输出结果可以看出，由于使用了深克隆技术，附件对象也得以复制，因此用“==”比较原型对象的附件和克隆对象的附件时输出结果均为false。深克隆技术实现了原型对象和克隆对象的完全独立，对任意克隆对象的修改都不会给其他对象产生影响，是一种更为理想的克隆实现方式。  

**扩展**  

> Java语言提供的Cloneable接口和Serializable接口的代码非常简单，它们都是空接口，这种空接口也称为标识接口，标识接口中没有任何方法的定义，其作用是告诉JRE这些接口的实现类是否具有某个功能，如是否支持克隆、是否支持序列化等。
