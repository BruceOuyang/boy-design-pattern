11.1 设计杀毒软件的框架结构  

Sunny软件公司欲开发一个杀毒(AntiVirus)软件，该软件既可以对某个文件夹(Folder)杀毒，也可以对某个指定的文件(File)进行杀毒。该杀毒软件还可以根据各类文件的特点，为不同类型的文件提供不同的杀毒方式，例如图像文件(ImageFile)和文本文件(TextFile)的杀毒方式就有所差异。现需要提供该杀毒软件的整体框架设计方案。

在介绍Sunny公司开发人员提出的初始解决方案之前，我们先来分析一下操作系统中的文件目录结构，例如在Windows操作系统中，存在如图11-1所示目录结构：  
![图11-1 Windows目录结构](https://upload-images.jianshu.io/upload_images/5792176-15c2a6dda7eaa9cc.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
图11-1 Windows目录结构  

图11-1可以简化为如图11-2所示树形目录结构：  
![图11-2 树形目录结构示意图](https://upload-images.jianshu.io/upload_images/5792176-862f08a95b35d262.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
图11-2 树形目录结构示意图  

我们可以看出，在图11-2中包含文件（灰色节点）和文件夹（白色节点）两类不同的元素，其中在文件夹中可以包含文件，还可以继续包含子文件夹，但是在文件中不能再包含子文件或者子文件夹。在此，我们可以称文件夹为容器(Container)，而不同类型的各种文件是其成员，也称为叶子(Leaf)，一个文件夹也可以作为另一个更大的文件夹的成员。如果我们现在要对某一个文件夹进行操作，如查找文件，那么需要对指定的文件夹进行遍历，如果存在子文件夹则打开其子文件夹继续遍历，如果是文件则判断之后返回查找结果。

Sunny软件公司的开发人员通过分析，决定使用面向对象的方式来实现对文件和文件夹的操作，定义了如下图像文件类ImageFile、文本文件类TextFile和文件夹类Folder：  
```java
//为了突出核心框架代码，我们对杀毒过程的实现进行了大量简化 
import java.util.*; 

//图像文件类 
class ImageFile { 
private String name; 

public ImageFile(String name) { 
this.name = name; 
} 

public void killVirus() { 
//简化代码，模拟杀毒 
System.out.println("----对图像文件'" + name + "'进行杀毒"); 
} 
} 

//文本文件类 
class TextFile { 
private String name; 

public TextFile(String name) { 
this.name = name; 
} 

public void killVirus() { 
//简化代码，模拟杀毒 
System.out.println("----对文本文件'" + name + "'进行杀毒"); 
} 
} 

//文件夹类 
class Folder { 
private String name; 
//定义集合folderList，用于存储Folder类型的成员 
private ArrayList<Folder> folderList = new ArrayList<Folder>(); 
//定义集合imageList，用于存储ImageFile类型的成员 
private ArrayList<ImageFile> imageList = new ArrayList<ImageFile>(); 
//定义集合textList，用于存储TextFile类型的成员 
private ArrayList<TextFile> textList = new ArrayList<TextFile>(); 

public Folder(String name) { 
this.name = name; 
} 

//增加新的Folder类型的成员 
public void addFolder(Folder f) { 
folderList.add(f); 
} 

//增加新的ImageFile类型的成员 
public void addImageFile(ImageFile image) { 
imageList.add(image); 
} 

//增加新的TextFile类型的成员 
public void addTextFile(TextFile text) { 
textList.add(text); 
} 

//需提供三个不同的方法removeFolder()、removeImageFile()和removeTextFile()来删除成员，代码省略 

//需提供三个不同的方法getChildFolder(int i)、getChildImageFile(int i)和getChildTextFile(int i)来获取成员，代码省略 

public void killVirus() { 
System.out.println("****对文件夹'" + name + "'进行杀毒"); //模拟杀毒 

//如果是Folder类型的成员，递归调用Folder的killVirus()方法 
for(Object obj : folderList) { 
((Folder)obj).killVirus(); 
} 

//如果是ImageFile类型的成员，调用ImageFile的killVirus()方法 
for(Object obj : imageList) { 
((ImageFile)obj).killVirus(); 
} 

//如果是TextFile类型的成员，调用TextFile的killVirus()方法 
for(Object obj : textList) { 
((TextFile)obj).killVirus(); 
} 
} 
}
```
  
编写如下客户端测试代码进行测试：  
```java
class Client { 
public static void main(String args[]) { 
Folder folder1,folder2,folder3; 
folder1 = new Folder("Sunny的资料"); 
folder2 = new Folder("图像文件"); 
folder3 = new Folder("文本文件"); 

ImageFile image1,image2; 
image1 = new ImageFile("小龙女.jpg"); 
image2 = new ImageFile("张无忌.gif"); 

TextFile text1,text2; 
text1 = new TextFile("九阴真经.txt"); 
text2 = new TextFile("葵花宝典.doc"); 

folder2.addImageFile(image1); 
folder2.addImageFile(image2); 
folder3.addTextFile(text1); 
folder3.addTextFile(text2); 
folder1.addFolder(folder2); 
folder1.addFolder(folder3); 

folder1.killVirus(); 
} 
}
```  

编译并运行程序，输出结果如下：  
```
****对文件夹'Sunny的资料'进行杀毒
****对文件夹'图像文件'进行杀毒
----对图像文件'小龙女.jpg'进行杀毒
----对图像文件'张无忌.gif'进行杀毒
****对文件夹'文本文件'进行杀毒
----对文本文件'九阴真经.txt'进行杀毒
----对文本文件'葵花宝典.doc'进行杀毒
```  

Sunny公司开发人员“成功”实现了杀毒软件的框架设计，但通过仔细分析，发现该设计方案存在如下问题：  

(1) 文件夹类Folder的设计和实现都非常复杂，需要定义多个集合存储不同类型的成员，而且需要针对不同的成员提供增加、删除和获取等管理和访问成员的方法，存在大量的冗余代码，系统维护较为困难；  

(2) 由于系统没有提供抽象层，客户端代码必须有区别地对待充当容器的文件夹Folder和充当叶子的ImageFile和TextFile，无法统一对它们进行处理；  

(3) 系统的灵活性和可扩展性差，如果需要增加新的类型的叶子和容器都需要对原有代码进行修改，例如如果需要在系统中增加一种新类型的视频文件VideoFile，则必须修改Folder类的源代码，否则无法在文件夹中添加视频文件。  

11.3 完整解决方案  

为了让系统具有更好的灵活性和可扩展性，客户端可以一致地对待文件和文件夹，Sunny公司开发人员使用组合模式来进行杀毒软件的框架设计，其基本结构如图11-5所示：  
![图11-5 杀毒软件框架设计结构图](https://upload-images.jianshu.io/upload_images/5792176-ac9fa6f884b2856b.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
图11-5 杀毒软件框架设计结构图  

在图11-5中， AbstractFile充当抽象构件类，Folder充当容器构件类，ImageFile、TextFile和VideoFile充当叶子构件类。完整代码如下所示：  
```java
import java.util.*;  

//抽象文件类：抽象构件  
abstract class AbstractFile {  
    public abstract void add(AbstractFile file);  
    public abstract void remove(AbstractFile file);  
    public abstract AbstractFile getChild(int i);  
    public abstract void killVirus();  
}  

//图像文件类：叶子构件  
class ImageFile extends AbstractFile {  
    private String name;  

    public ImageFile(String name) {  
        this.name = name;  
    }  

    public void add(AbstractFile file) {  
       System.out.println("对不起，不支持该方法！");  
    }  

    public void remove(AbstractFile file) {  
        System.out.println("对不起，不支持该方法！");  
    }  

    public AbstractFile getChild(int i) {  
        System.out.println("对不起，不支持该方法！");  
        return null;  
    }  

    public void killVirus() {  
        //模拟杀毒  
        System.out.println("----对图像文件'" + name + "'进行杀毒");  
    }  
}  

//文本文件类：叶子构件  
class TextFile extends AbstractFile {  
    private String name;  

    public TextFile(String name) {  
        this.name = name;  
    }  

    public void add(AbstractFile file) {  
       System.out.println("对不起，不支持该方法！");  
    }  

    public void remove(AbstractFile file) {  
        System.out.println("对不起，不支持该方法！");  
    }  

    public AbstractFile getChild(int i) {  
        System.out.println("对不起，不支持该方法！");  
        return null;  
    }  

    public void killVirus() {  
        //模拟杀毒  
        System.out.println("----对文本文件'" + name + "'进行杀毒");  
    }  
}  

//视频文件类：叶子构件  
class VideoFile extends AbstractFile {  
    private String name;  

    public VideoFile(String name) {  
        this.name = name;  
    }  

    public void add(AbstractFile file) {  
       System.out.println("对不起，不支持该方法！");  
    }  

    public void remove(AbstractFile file) {  
        System.out.println("对不起，不支持该方法！");  
    }  

    public AbstractFile getChild(int i) {  
        System.out.println("对不起，不支持该方法！");  
        return null;  
    }  

    public void killVirus() {  
        //模拟杀毒  
        System.out.println("----对视频文件'" + name + "'进行杀毒");  
    }  
}  

//文件夹类：容器构件  
class Folder extends AbstractFile {  
    //定义集合fileList，用于存储AbstractFile类型的成员  
    private ArrayList<AbstractFile> fileList=new ArrayList<AbstractFile>();  
    private String name;  

    public Folder(String name) {  
        this.name = name;  
    }  

    public void add(AbstractFile file) {  
       fileList.add(file);    
    }  

    public void remove(AbstractFile file) {  
        fileList.remove(file);  
    }  

    public AbstractFile getChild(int i) {  
        return (AbstractFile)fileList.get(i);  
    }  

    public void killVirus() {  
        System.out.println("****对文件夹'" + name + "'进行杀毒");  //模拟杀毒  

        //递归调用成员构件的killVirus()方法  
        for(Object obj : fileList) {  
            ((AbstractFile)obj).killVirus();  
        }  
    }  
}
```  

编写如下客户端测试代码：  
```java
class Client {  
    public static void main(String args[]) {  
        //针对抽象构件编程  
        AbstractFile file1,file2,file3,file4,file5,folder1,folder2,folder3,folder4;  

        folder1 = new Folder("Sunny的资料");  
        folder2 = new Folder("图像文件");  
        folder3 = new Folder("文本文件");  
        folder4 = new Folder("视频文件");  

        file1 = new ImageFile("小龙女.jpg");  
        file2 = new ImageFile("张无忌.gif");  
        file3 = new TextFile("九阴真经.txt");  
        file4 = new TextFile("葵花宝典.doc");  
        file5 = new VideoFile("笑傲江湖.rmvb");  

        folder2.add(file1);  
        folder2.add(file2);  
        folder3.add(file3);  
        folder3.add(file4);  
        folder4.add(file5);  
        folder1.add(folder2);  
        folder1.add(folder3);  
        folder1.add(folder4);  

        //从“Sunny的资料”节点开始进行杀毒操作  
        folder1.killVirus();  
    }  
}
```  

编译并运行程序，输出结果如下：  
```
****对文件夹'Sunny的资料'进行杀毒
****对文件夹'图像文件'进行杀毒
----对图像文件'小龙女.jpg'进行杀毒
----对图像文件'张无忌.gif'进行杀毒
****对文件夹'文本文件'进行杀毒
----对文本文件'九阴真经.txt'进行杀毒
----对文本文件'葵花宝典.doc'进行杀毒
****对文件夹'视频文件'进行杀毒
----对视频文件'笑傲江湖.rmvb'进行杀毒
```  

由于在本实例中使用了组合模式，在抽象构件类中声明了所有方法，包括用于管理和访问子构件的方法，如add()方法和remove()方法等，因此在ImageFile等叶子构件类中实现这些方法时必须进行相应的异常处理或错误提示。在容器构件类Folder的killVirus()方法中将递归调用其成员对象的killVirus()方法，从而实现对整个树形结构的遍历。  

如果需要更换操作节点，例如只需对文件夹“文本文件”进行杀毒，客户端代码只需修改一行即可，将代码：  
```java
folder1.killVirus();
```  

改为：  
```java
folder3.killVirus();
```  

输出结果如下：  
```
****对文件夹'文本文件'进行杀毒
----对文本文件'九阴真经.txt'进行杀毒
----对文本文件'葵花宝典.doc'进行杀毒
```  

在具体实现时，我们可以创建图形化界面让用户选择所需操作的根节点，无须修改源代码，符合“开闭原则”，客户端无须关心节点的层次结构，可以对所选节点进行统一处理，提高系统的灵活性。