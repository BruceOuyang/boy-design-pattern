9.1 没有源码的算法库  

> Sunny软件公司在很久以前曾开发了一个算法库，里面包含了一些常用的算法，例如排序算法和查找算法，在进行各类软件开发时经常需要重用该算法库中的算法。在为某学校开发教务管理系统时，开发人员发现需要对学生成绩进行排序和查找，该系统的设计人员已经开发了一个成绩操作接口ScoreOperation，在该接口中声明了排序方法sort(int[]) 和查找方法search(int[], int)，为了提高排序和查找的效率，开发人员决定重用算法库中的快速排序算法类QuickSort和二分查找算法类BinarySearch，其中QuickSort的quickSort(int[])方法实现了快速排序，BinarySearch 的binarySearch (int[], int)方法实现了二分查找。  

由于某些原因，现在Sunny公司开发人员已经找不到该算法库的源代码，无法直接通过复制和粘贴操作来重用其中的代码；部分开发人员已经针对ScoreOperation接口编程，如果再要求对该接口进行修改或要求大家直接使用QuickSort类和BinarySearch类将导致大量代码需要修改。  

Sunny软件公司开发人员面对这个没有源码的算法库，遇到一个幸福而又烦恼的问题：如何在既不修改现有接口又不需要任何算法库代码的基础上能够实现算法库的重用？  

通过分析，我们不难得知，现在Sunny软件公司面对的问题有点类似本章最开始所提到的电压问题，成绩操作接口ScoreOperation好比只支持20V电压的笔记本，而算法库好比220V的家庭用电，这两部分都没有办法再进行修改，而且它们原本是两个完全不相关的结构，如图9-2所示：  
![图9-2 需协调的两个系统的结构示意图](http://upload-images.jianshu.io/upload_images/5792176-2534565dc8132148.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
图9-2 需协调的两个系统的结构示意图  

现在我们需要ScoreOperation接口能够和已有算法库一起工作，让它们在同一个系统中能够兼容，最好的实现方法是增加一个类似电源适配器一样的适配器角色，通过适配器来协调这两个原本不兼容的结构。如何在软件开发中设计和实现适配器是本章我们将要解决的核心问题，下面就让我们正式开始学习这种用于解决不兼容结构问题的适配器模式。  

9.3 完整解决方案  

Sunny软件公司开发人员决定使用适配器模式来重用算法库中的算法，其基本结构如图9-4所示：  
![图9-4 算法库重用结构图](http://upload-images.jianshu.io/upload_images/5792176-f6518ac275a16ae3.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)   
图9-4 算法库重用结构图  

在图9-4中，ScoreOperation接口充当抽象目标，QuickSort和BinarySearch类充当适配者，OperationAdapter充当适配器。完整代码如下所示：  
```java
//抽象成绩操作类：目标接口  
interface ScoreOperation {  
    public int[] sort(int array[]); //成绩排序  
    public int search(int array[],int key); //成绩查找  
}  

//快速排序类：适配者  
class QuickSort {  
    public int[] quickSort(int array[]) {  
        sort(array,0,array.length-1);  
        return array;  
    }  

    public void sort(int array[],int p, int r) {  
        int q=0;  
        if(p<r) {  
            q=partition(array,p,r);  
            sort(array,p,q-1);  
            sort(array,q+1,r);  
        }  
    }  

    public int partition(int[] a, int p, int r) {  
        int x=a[r];  
        int j=p-1;  
        for (int i=p;i<=r-1;i++) {  
            if (a[i]<=x) {  
                j++;  
                swap(a,j,i);  
            }  
        }  
        swap(a,j+1,r);  
        return j+1;   
    }  

    public void swap(int[] a, int i, int j) {     
        int t = a[i];     
        a[i] = a[j];     
        a[j] = t;     
    }  
}  

//二分查找类：适配者  
class BinarySearch {  
    public int binarySearch(int array[],int key) {  
        int low = 0;  
        int high = array.length -1;  
        while(low <= high) {  
            int mid = (low + high) / 2;  
            int midVal = array[mid];  
            if(midVal < key) {    
                low = mid +1;    
            }  
            else if (midVal > key) {    
                high = mid -1;    
            }  
            else {    
                return 1; //找到元素返回1    
            }  
        }  
        return -1;  //未找到元素返回-1  
    }  
}  

//操作适配器：适配器  
class OperationAdapter implements ScoreOperation {  
    private QuickSort sortObj; //定义适配者QuickSort对象  
    private BinarySearch searchObj; //定义适配者BinarySearch对象  

    public OperationAdapter() {  
        sortObj = new QuickSort();  
        searchObj = new BinarySearch();  
    }  

    public int[] sort(int array[]) {    
        return sortObj.quickSort(array); //调用适配者类QuickSort的排序方法  
    }  

    public int search(int array[],int key) {    
        return searchObj.binarySearch(array,key); //调用适配者类BinarySearch的查找方法  
    }
}
```  

为了让系统具备良好的灵活性和可扩展性，我们引入了工具类XMLUtil和配置文件，其中，XMLUtil类的代码如下所示：  
```java
import javax.xml.parsers.*;  
import org.w3c.dom.*;  
import org.xml.sax.SAXException;  
import java.io.*;  
class XMLUtil {  
//该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象  
    public static Object getBean() {  
        try {  
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
        catch(Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
}
```  

配置文件config.xml中存储了适配器类的类名，代码如下所示：  
```xml
<?xml version="1.0"?>  
<config>  
    <className>OperationAdapter</className>  
</config>
```  

编写如下客户端测试代码：  
```java
class Client {  
    public static void main(String args[]) {  
        ScoreOperation operation;  //针对抽象目标接口编程  
        operation = (ScoreOperation)XMLUtil.getBean(); //读取配置文件，反射生成对象  
        int scores[] = {84,76,50,69,90,91,88,96}; //定义成绩数组  
        int result[];  
        int score;  

        System.out.println("成绩排序结果：");  
        result = operation.sort(scores);  

        //遍历输出成绩  
        for(int i : scores) {  
            System.out.print(i + ",");  
        }  
        System.out.println();  

        System.out.println("查找成绩90：");  
        score = operation.search(result,90);  
        if (score != -1) {  
            System.out.println("找到成绩90。");  
        }  
        else {  
            System.out.println("没有找到成绩90。");  
        }  

        System.out.println("查找成绩92：");  
        score = operation.search(result,92);  
        if (score != -1) {  
            System.out.println("找到成绩92。");  
        }  
        else {  
            System.out.println("没有找到成绩92。");  
        }  
    }  
}
```  

编译并运行程序，输出结果如下：  
```
成绩排序结果：
50,69,76,84,88,90,91,96,
查找成绩90：
找到成绩90。
查找成绩92：
没有找到成绩92。
```  

在本实例中使用了对象适配器模式，同时引入了配置文件，将适配器类的类名存储在配置文件中。如果需要使用其他排序算法类和查找算法类，可以增加一个新的适配器类，使用新的适配器来适配新的算法，原有代码无须修改。通过引入配置文件和反射机制，可以在不修改客户端代码的情况下使用新的适配器，无须修改源代码，符合“开闭原则”。