10.1 跨平台图像浏览系统  

Sunny软件公司欲开发一个跨平台图像浏览系统，要求该系统能够显示BMP、JPG、GIF、PNG等多种格式的文件，并且能够在Windows、Linux、Unix等多个操作系统上运行。系统首先将各种格式的文件解析为像素矩阵(Matrix)，然后将像素矩阵显示在屏幕上，在不同的操作系统中可以调用不同的绘制函数来绘制像素矩阵。系统需具有较好的扩展性以支持新的文件格式和操作系统。  

Sunny软件公司的开发人员针对上述要求，提出了一个初始设计方案，其基本结构如图10-1所示：  
![图 10-1 跨平台图像浏览系统初始设计方案](http://upload-images.jianshu.io/upload_images/5792176-3093b3e1506595c8.gif?imageMogr2/auto-orient/strip)  

在图10-1的初始设计方案中，使用了一种多层继承结构，Image是抽象父类，而每一种类型的图像类，如BMPImage、JPGImage等作为其直接子类，不同的图像文件格式具有不同的解析方法，可以得到不同的像素矩阵；由于每一种图像又需要在不同的操作系统中显示，不同的操作系统在屏幕上显示像素矩阵有所差异，因此需要为不同的图像类再提供一组在不同操作系统显示的子类，如为BMPImage提供三个子类BMPWindowsImp、BMPLinuxImp和BMPUnixImp，分别用于在Windows、Linux和Unix三个不同的操作系统下显示图像。  

我们现在对该设计方案进行分析，发现存在如下两个主要问题：  

(1)由于采用了多层继承结构，导致系统中类的个数急剧增加，图10-1中，在各种图像的操作系统实现层提供了12个具体类，加上各级抽象层的类，系统中类的总个数达到了17个，在该设计方案中，具体层的类的个数 = 所支持的图像文件格式数×所支持的操作系统数。  

(2)系统扩展麻烦，由于每一个具体类既包含图像文件格式信息，又包含操作系统信息，因此无论是增加新的图像文件格式还是增加新的操作系统，都需要增加大量的具体类，例如在图10-1中增加一种新的图像文件格式TIF，则需要增加3个具体类来实现该格式图像在3种不同操作系统的显示；如果增加一个新的操作系统Mac OS，为了在该操作系统下能够显示各种类型的图像，需要增加4个具体类。这将导致系统变得非常庞大，增加运行和维护开销。  
  
如何解决这两个问题？我们通过分析可得知，该系统存在两个独立变化的维度：图像文件格式和操作系统，如图10-2所示：  
![图 10-2 跨平台图像浏览器中存在的两个独立变化维度示意图](http://upload-images.jianshu.io/upload_images/5792176-4002ab97df55fb77.gif?imageMogr2/auto-orient/strip)

在图10-2中，如何将各种不同类型的图像文件解析为像素矩阵与图像文件格式本身相关，而如何在屏幕上显示像素矩阵则仅与操作系统相关。正因为图10-1所示结构将这两种职责集中在一个类中，导致系统扩展麻烦，从类的设计角度分析，具体类BMPWindowsImp、BMPLinuxImp和BMPUnixImp等违反了“单一职责原则”，因为不止一个引起它们变化的原因，它们将图像文件解析和像素矩阵显示这两种完全不同的职责融合在一起，任意一个职责发生改变都需要修改它们，系统扩展困难。

如何改进？我们的方案是将图像文件格式（对应图像格式的解析）与操作系统（对应像素矩阵的显示）两个维度分离，使得它们可以独立变化，增加新的图像文件格式或者操作系统时都对另一个维度不造成任何影响。看到这里，大家可能会问，到底如何在软件中实现将两个维度分离呢？不用着急，本章我将为大家详细介绍一种用于处理多维度变化的设计模式——桥接模式。

10.3 完整解决方案  

为了减少所需生成的子类数目，实现将操作系统和图像文件格式两个维度分离，使它们可以独立改变，Sunny公司开发人员使用桥接模式来重构跨平台图像浏览系统的设计，其基本结构如图10-5所示：  
![图 10-5 跨平台图像浏览器系统结构图](http://upload-images.jianshu.io/upload_images/5792176-826c6a6f845b0ef6.gif?imageMogr2/auto-orient/strip)  

在图10-5中，Image充当抽象类，其子类JPGImage、PNGImage、BMPImage和GIFImage充当扩充抽象类；ImageImp充当实现类接口，其子类WindowsImp、LinuxImp和UnixImp充当具体实现类。完整代码如下所示：  
```java
//像素矩阵类：辅助类，各种格式的文件最终都被转化为像素矩阵，不同的操作系统提供不同的方式显示像素矩阵  
class Matrix {  
    //此处代码省略  
}  

//抽象图像类：抽象类  
abstract class Image {  
    protected ImageImp imp;  

    public void setImageImp(ImageImp imp) {  
        this.imp = imp;  
    }   

    public abstract void parseFile(String fileName);  
}  

//抽象操作系统实现类：实现类接口  
interface ImageImp {  
    public void doPaint(Matrix m);  //显示像素矩阵m  
}   

//Windows操作系统实现类：具体实现类  
class WindowsImp implements ImageImp {  
    public void doPaint(Matrix m) {  
        //调用Windows系统的绘制函数绘制像素矩阵  
        System.out.print("在Windows操作系统中显示图像：");  
    }  
}  

//Linux操作系统实现类：具体实现类  
class LinuxImp implements ImageImp {  
    public void doPaint(Matrix m) {  
        //调用Linux系统的绘制函数绘制像素矩阵  
        System.out.print("在Linux操作系统中显示图像：");  
    }  
}  

//Unix操作系统实现类：具体实现类  
class UnixImp implements ImageImp {  
    public void doPaint(Matrix m) {  
        //调用Unix系统的绘制函数绘制像素矩阵  
        System.out.print("在Unix操作系统中显示图像：");  
    }  
}  

//JPG格式图像：扩充抽象类  
class JPGImage extends Image {  
    public void parseFile(String fileName) {  
        //模拟解析JPG文件并获得一个像素矩阵对象m;  
        Matrix m = new Matrix();   
        imp.doPaint(m);  
        System.out.println(fileName + "，格式为JPG。");  
    }  
}  

//PNG格式图像：扩充抽象类  
class PNGImage extends Image {  
    public void parseFile(String fileName) {  
        //模拟解析PNG文件并获得一个像素矩阵对象m;  
        Matrix m = new Matrix();   
        imp.doPaint(m);  
        System.out.println(fileName + "，格式为PNG。");  
    }  
}  

//BMP格式图像：扩充抽象类  
class BMPImage extends Image {  
    public void parseFile(String fileName) {  
        //模拟解析BMP文件并获得一个像素矩阵对象m;  
        Matrix m = new Matrix();   
        imp.doPaint(m);  
        System.out.println(fileName + "，格式为BMP。");  
    }  
}  

//GIF格式图像：扩充抽象类  
class GIFImage extends Image {  
    public void parseFile(String fileName) {  
        //模拟解析GIF文件并获得一个像素矩阵对象m;  
        Matrix m = new Matrix();   
        imp.doPaint(m);  
        System.out.println(fileName + "，格式为GIF。");  
    }  
}
```  

为了让系统具有更好的灵活性和可扩展性，我们引入了配置文件，将具体扩充抽象类和具体实现类类名都存储在配置文件中，再通过反射生成对象，将生成的具体实现类对象注入到扩充抽象类对象中，其中，配置文件config.xml的代码如下所示：  
```xml
<?xml version="1.0"?>  
<config>  
    <!--RefinedAbstraction-->  
    <className>JPGImage</className>   
    <!--ConcreteImplementor-->  
    <className>WindowsImp</className>  
</config>
```  

用于读取配置文件config.xml并反射生成对象的XMLUtil类的代码如下所示：  
```java
import javax.xml.parsers.*;  
import org.w3c.dom.*;  
import org.xml.sax.SAXException;  
import java.io.*;  
public class XMLUtil {  
//该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象  
    public static Object getBean(String args) {  
        try {  
            //创建文档对象  
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();  
            DocumentBuilder builder = dFactory.newDocumentBuilder();  
            Document doc;                             
            doc = builder.parse(new File("config.xml"));   
            NodeList nl=null;  
            Node classNode=null;  
            String cName=null;  
            nl = doc.getElementsByTagName("className");  

            if(args.equals("image")) {  
                //获取第一个包含类名的节点，即扩充抽象类  
                classNode=nl.item(0).getFirstChild();  

            }  
            else if(args.equals("os")) {  
               //获取第二个包含类名的节点，即具体实现类  
                classNode=nl.item(1).getFirstChild();  
            }  

             cName=classNode.getNodeValue();  
             //通过类名生成实例对象并将其返回  
             Class c=Class.forName(cName);  
             Object obj=c.newInstance();  
             return obj;          
           }     
           catch(Exception e) {  
              e.printStackTrace();  
              return null;  
          }  
     }  
}
```  

编写如下客户端测试代码：  
```java
class Client {  
    public static void main(String args[]) {  
        Image image;  
        ImageImp imp;  
        image = (Image)XMLUtil.getBean("image");  
        imp = (ImageImp)XMLUtil.getBean("os");  
        image.setImageImp(imp);  
        image.parseFile("小龙女");  
    }  
}
```  

编译并运行程序，输出结果如下：
```
在Windows操作系统中显示图像：小龙女，格式为JPG。
```

如果需要更换图像文件格式或者更换操作系统，只需修改配置文件即可，在实际使用时，可以通过分析图像文件格式后缀名来确定具体的文件格式，在程序运行时获取操作系统信息来确定操作系统类型，无须使用配置文件。当增加新的图像文件格式或者操作系统时，原有系统无须做任何修改，只需增加一个对应的扩充抽象类或具体实现类即可，系统具有较好的可扩展性，完全符合“开闭原则”。  
