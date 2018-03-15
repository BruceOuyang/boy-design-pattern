4.抽象外观类

在标准的外观模式结构图中，如果需要增加、删除或更换与外观类交互的子系统类，必须修改外观类或客户端的源代码，这将违背开闭原则，因此可以通过引入抽象外观类来对系统进行改进，在一定程度上可以解决该问题。在引入抽象外观类之后，客户端可以针对抽象外观类进行编程，对于新的业务需求，不需要修改原有外观类，而对应增加一个新的具体外观类，由新的具体外观类来关联新的子系统对象，同时通过修改配置文件来达到不修改任何源代码并更换外观类的目的。  

下面通过一个具体实例来学习如何使用抽象外观类：  

如果在应用实例“文件加密模块”中需要更换一个加密类，不再使用原有的基于求模运算的加密类CipherMachine，而改为基于移位运算的新加密类NewCipherMachine，其代码如下：  
```java
class NewCipherMachine  
{  
    public string Encrypt(string plainText)   
    {  
        System.out.println("数据加密，将明文转换为密文：");  
        string es = "";  
        int key = 10;//设置密钥，移位数为10  
        char[] chars = plainText.ToCharArray();  
        foreach(char ch in chars)   
        {  
            int temp = Convert.ToInt32(ch);  
            //小写字母移位  
            if (ch >= 'a' && ch <= 'z') {  
                temp += key % 26;  
                if (temp > 122) temp -= 26;  
                if (temp < 97) temp += 26;  
            }  
            //大写字母移位  
            if (ch >= 'A' && ch <= 'Z') {  
                temp += key % 26;  
                if (temp > 90) temp -= 26;  
                if (temp < 65) temp += 26;  
            }  
            es += ((char)temp).ToString();  
        }  
        System.out.println(es);  
        return es;  
    }  
} 
```  

如果不增加新的外观类，只能通过修改原有外观类EncryptFacade的源代码来实现加密类的更换，将原有的对CipherMachine类型对象的引用改为对NewCipherMachine类型对象的引用，这违背了开闭原则，因此需要通过增加新的外观类来实现对子系统对象引用的改变。  

如果增加一个新的外观类NewEncryptFacade来与FileReader类、FileWriter类以及新增加的NewCipherMachine类进行交互，虽然原有系统类库无须做任何修改，但是因为客户端代码中原来针对EncryptFacade类进行编程，现在需要改为NewEncryptFacade类，因此需要修改客户端源代码。  

如何在不修改客户端代码的前提下使用新的外观类呢？解决方法之一是：引入一个抽象外观类，客户端针对抽象外观类编程，而在运行时再确定具体外观类，引入抽象外观类之后的文件加密模块结构图如图5所示：  
![图5 引入抽象外观类之后的文件加密模块结构图](https://upload-images.jianshu.io/upload_images/5792176-70138f33ec180128.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
图5 引入抽象外观类之后的文件加密模块结构图  

在图5中，客户类Client针对抽象外观类AbstractEncryptFacade进行编程，AbstractEncryptFacade代码如下：  
```java
public abstract class AbstractEncryptFacade  
{  
    public abstract void FileEncrypt(string fileNameSrc, string fileNameDes);  
} 
```

新增具体加密外观类NewEncryptFacade代码如下：  
```java
class NewEncryptFacade extends AbstractEncryptFacade  
{  
    private FileReader reader;  
    private NewCipherMachine cipher;  
    private FileWriter writer;  

    public NewEncryptFacade()  
    {  
        reader = new FileReader();  
        cipher = new NewCipherMachine();  
        writer = new FileWriter();  
    }  

    public void FileEncrypt(string fileNameSrc, string fileNameDes)  
    {  
        string plainStr = reader.Read(fileNameSrc);  
        string encryptStr = cipher.Encrypt(plainStr);  
        writer.Write(encryptStr, fileNameDes);  
    }  
}  
```  

配置文件App.config中存储了具体外观类的类名，代码如下：  
```xml
<?xml version="1.0" encoding="utf-8" ?>  
<configuration>  
  <appSettings>  
    <add key="facade" value="FacadeSample.NewEncryptFacade"/>  
  </appSettings>  
</configuration>
```

客户端测试代码修改如下：  
```java
public class Program  
{  
    public static void Main(string[] args)  
    {  
        AbstractEncryptFacade ef; //针对抽象外观类编程  
        //读取配置文件  
        string facadeString = ConfigurationManager.AppSettings["facade"];  
        //反射生成对象  
        ef = (AbstractEncryptFacade)Assembly.Load("FacadeSample"). CreateInstance (facadeString);  
        ef.FileEncrypt("src.txt", "des.txt");  
        Console.Read();  
    }  
}  
```  

编译并运行程序，输出结果如下：  
```
读取文件，获取明文：Hello world!
数据加密，将明文转换为密文：Rovvy gybvn!
保存密文，写入文件。
```  

原有外观类EncryptFacade也需作为抽象外观类AbstractEncryptFacade类的子类，更换具体外观类时只需修改配置文件，无须修改源代码，符合开闭原则。