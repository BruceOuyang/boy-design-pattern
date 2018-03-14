12.1 图形界面构件库的设计  

Sunny软件公司基于面向对象技术开发了一套图形界面构件库VisualComponent，该构件库提供了大量基本构件，如窗体、文本框、列表框等，由于在使用该构件库时，用户经常要求定制一些特效显示效果，如带滚动条的窗体、带黑色边框的文本框、既带滚动条又带黑色边框的列表框等等，因此经常需要对该构件库进行扩展以增强其功能，如图12-1所示：  
![图12-1 带滚动条的窗体示意图](https://upload-images.jianshu.io/upload_images/5792176-98b8469628cb1ebd.gif?imageMogr2/auto-orient/strip)  
图12-1 带滚动条的窗体示意图  

如何提高图形界面构件库性的可扩展性并降低其维护成本是Sunny公司开发人员必须面对的一个问题。

Sunny软件公司的开发人员针对上述要求，提出了一个基于继承复用的初始设计方案，其基本结构如图12-2所示：  
![图12-2 图形界面构件库初始设计方案](https://upload-images.jianshu.io/upload_images/5792176-14603944ab702f11.gif?imageMogr2/auto-orient/strip)  
图12-2 图形界面构件库初始设计方案  

图12-2中，在抽象类Component中声明了抽象方法display()，其子类Window、TextBox等实现了display()方法，可以显示最简单的控件，再通过它们的子类来对功能进行扩展，例如，在Window的子类ScrollBarWindow、BlackBorderWindow中对Window中的display()方法进行扩展，分别实现带滚动条和带黑色边框的窗体。仔细分析该设计方案，我们不难发现存在如下几个问题：  

(1) 系统扩展麻烦，在某些编程语言中无法实现。如果用户需要一个既带滚动条又带黑色边框的窗体，在图12-2中通过增加了一个新的类ScrollBarAndBlackBorderWindow来实现，该类既作为ScrollBarWindow的子类，又作为BlackBorderWindow的子类；但现在很多面向对象编程语言，如Java、C#等都不支持多重类继承，因此在这些语言中无法通过继承来实现对来自多个父类的方法的重用。此外，如果还需要扩展一项功能，例如增加一个透明窗体类TransparentWindow，它是Window类的子类，可以将一个窗体设置为透明窗体，现在需要一个同时拥有三项功能（带滚动条、带黑色边框、透明）的窗体，必须再增加一个类作为三个窗体类的子类，这同样在Java等语言中无法实现。系统在扩展时非常麻烦，有时候甚至无法实现。  

(2)代码重复。从图12-2中我们可以看出，不只是窗体需要设置滚动条，文本框、列表框等都需要设置滚动条，因此在ScrollBarWindow、ScrollBarTextBox和ScrollBarListBox等类中都包含用于增加滚动条的方法setScrollBar()，该方法的具体实现过程基本相同，代码重复，不利于对系统进行修改和维护。  

(3) 系统庞大，类的数目非常多。如果增加新的控件或者新的扩展功能系统都需要增加大量的具体类，这将导致系统变得非常庞大。在图12-2中，3种基本控件和2种扩展方式需要定义9个具体类；如果再增加一个基本控件还需要增加3个具体类；增加一种扩展方式则需要增加更多的类，如果存在3种扩展方式，对于每一个控件而言，需要增加7个具体类，因为这3种扩展方式存在7种组合关系（大家自己分析为什么需要7个类？）。  

总之，图12-2不是一个好的设计方案，怎么办？如何让系统中的类可以进行扩展但是又不会导致类数目的急剧增加？不用着急，让我们先来分析为什么这个设计方案会存在如此多的问题。根本原因在于复用机制的不合理，图12-2采用了继承复用，例如在ScrollBarWindow中需要复用Window类中定义的display()方法，同时又增加新的方法setScrollBar()，ScrollBarTextBox和ScrollBarListBox都必须做类似的处理，在复用父类的方法后再增加新的方法来扩展功能。根据“合成复用原则”，在实现功能复用时，我们要多用关联，少用继承，因此我们可以换个角度来考虑，将setScrollBar()方法抽取出来，封装在一个独立的类中，在这个类中定义一个Component类型的对象，通过调用Component的display()方法来显示最基本的构件，同时再通过setScrollBar()方法对基本构件的功能进行增强。由于Window、ListBox和TextBox都是Component的子类，根据“里氏代换原则”，程序在运行时，我们只要向这个独立的类中注入具体的Component子类的对象即可实现功能的扩展。这个独立的类一般称为装饰器(Decorator)或装饰类，顾名思义，它的作用就是对原有对象进行装饰，通过装饰来扩展原有对象的功能。  

装饰类的引入将大大简化本系统的设计，它也是装饰模式的核心，下面让我们正式进入装饰模式的学习。  

12.3 完整解决方案  

为了让系统具有更好的灵活性和可扩展性，克服继承复用所带来的问题，Sunny公司开发人员使用装饰模式来重构图形界面构件库的设计，其中部分类的基本结构如图12-4所示：  
![图12-4 图形界面构件库结构图](https://upload-images.jianshu.io/upload_images/5792176-73c9e6bd2ded7039.gif?imageMogr2/auto-orient/strip)  
图12-4 图形界面构件库结构图  

在图12-4中，Component充当抽象构件类，其子类Window、TextBox、ListBox充当具体构件类，Component类的另一个子类ComponentDecorator充当抽象装饰类，ComponentDecorator的子类ScrollBarDecorator和BlackBorderDecorator充当具体装饰类。完整代码如下所示：  
```java
//抽象界面构件类：抽象构件类，为了突出与模式相关的核心代码，对原有控件代码进行了大量的简化
abstract class Component
{
       public  abstract void display();
}

//窗体类：具体构件类
class Window extends Component
{
       public  void display()
       {
              System.out.println("显示窗体！");
       }
}

//文本框类：具体构件类
class TextBox extends Component
{
       public  void display()
       {
              System.out.println("显示文本框！");
       }
}

//列表框类：具体构件类
class ListBox extends Component
{
       public  void display()
       {
              System.out.println("显示列表框！");
       }
}

//构件装饰类：抽象装饰类
class ComponentDecorator extends Component
{
       private Component component;  //维持对抽象构件类型对象的引用

       public ComponentDecorator(Component  component)  //注入抽象构件类型的对象
       {
              this.component = component;
       }

       public void display()
       {
              component.display();
       }
}

//滚动条装饰类：具体装饰类
class ScrollBarDecorator extends  ComponentDecorator
{
       public ScrollBarDecorator(Component  component)
       {
              super(component);
       }

       public void display()
       {
              this.setScrollBar();
              super.display();
       }

       public  void setScrollBar()
       {
              System.out.println("为构件增加滚动条！");
       }
}

//黑色边框装饰类：具体装饰类
class BlackBorderDecorator extends  ComponentDecorator
{
       public BlackBorderDecorator(Component  component)
       {
              super(component);
       }

       public void display()
       {
              this.setBlackBorder();
              super.display();
       }

       public  void setBlackBorder()
       {
              System.out.println("为构件增加黑色边框！");
       }
}
```  

编写如下客户端测试代码：  
```java
class Client
{
       public  static void main(String args[])
       {
              Component component,componentSB;  //使用抽象构件定义
              component = new Window(); //定义具体构件
              componentSB = new  ScrollBarDecorator(component); //定义装饰后的构件
              componentSB.display();
       }
}
```  

编译并运行程序，输出结果如下：  
```
为构件增加滚动条！
显示窗体！
```  

在客户端代码中，我们先定义了一个Window类型的具体构件对象component，然后将component作为构造函数的参数注入到具体装饰类ScrollBarDecorator中，得到一个装饰之后对象componentSB，再调用componentSB的display()方法后将得到一个有滚动条的窗体。如果我们希望得到一个既有滚动条又有黑色边框的窗体，不需要对原有类库进行任何修改，只需将客户端代码修改为如下所示：  
```java
class Client
{
       public  static void main(String args[])
       {
              Component  component,componentSB,componentBB; //全部使用抽象构件定义
              component = new Window();
              componentSB = new  ScrollBarDecorator(component);
              componentBB = new  BlackBorderDecorator(componentSB); //将装饰了一次之后的对象继续注入到另一个装饰类中，进行第二次装饰
              componentBB.display();
       }
}
```  

编译并运行程序，输出结果如下：  
```
为构件增加黑色边框！
为构件增加滚动条！
显示窗体！
```  

我们可以将装饰了一次之后的componentSB对象注入另一个装饰类BlackBorderDecorator中实现第二次装饰，得到一个经过两次装饰的对象componentBB，再调用componentBB的display()方法即可得到一个既有滚动条又有黑色边框的窗体。  

如果需要在原有系统中增加一个新的具体构件类或者新的具体装饰类，无须修改现有类库代码，只需将它们分别作为抽象构件类或者抽象装饰类的子类即可。与图12-2所示的继承结构相比，使用装饰模式之后将大大减少了子类的个数，让系统扩展起来更加方便，而且更容易维护，是取代继承复用的有效方式之一。