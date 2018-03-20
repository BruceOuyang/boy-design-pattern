18.1 机器人控制程序  

Sunny软件公司欲为某玩具公司开发一套机器人控制程序，在该机器人控制程序中包含一些简单的英文控制指令，每一个指令对应一个表达式(expression)，该表达式可以是简单表达式也可以是复合表达式，每一个简单表达式由移动方向(direction)，移动方式(action)和移动距离(distance)三部分组成，其中移动方向包括上(up)、下(down)、左(left)、右(right)；移动方式包括移动(move)和快速移动(run)；移动距离为一个正整数。两个表达式之间可以通过与(and)连接，形成复合(composite)表达式。  

用户通过对图形化的设置界面进行操作可以创建一个机器人控制指令，机器人在收到指令后将按照指令的设置进行移动，例如输入控制指令：up move 5，则“向上移动5个单位”；输入控制指令：down run 10 and left move 20，则“向下快速移动10个单位再向左移动20个单位”。  

Sunny软件公司开发人员决定自定义一个简单的语言来解释机器人控制指令，根据上述需求描述，用形式化语言来表示该简单语言的文法规则如下：  
```
expression ::= direction action distance | composite //表达式
composite ::= expression 'and' expression //复合表达式
direction ::= 'up' | 'down' | 'left' | 'right' //移动方向
action ::= 'move' | 'run' //移动方式
distance ::= an integer //移动距离
```

上述语言一共定义了五条文法规则，对应五个语言单位，这些语言单位可以分为两类，一类为终结符（也称为终结符表达式），例如direction、action和distance，它们是语言的最小组成单位，不能再进行拆分；另一类为非终结符（也称为非终结符表达式），例如expression和composite，它们都是一个完整的句子，包含一系列终结符或非终结符。  

我们根据上述规则定义出的语言可以构成很多语句，计算机程序将根据这些语句进行某种操作。为了实现对语句的解释，可以使用解释器模式，在解释器模式中每一个文法规则都将对应一个类，扩展、改变文法以及增加新的文法规则都很方便，下面就让我们正式进入解释器模式的学习，看看使用解释器模式如何来实现对机器人控制指令的处理。

18.4 完整解决方案

为了能够解释机器人控制指令，Sunny软件公司开发人员使用解释器模式来设计和实现机器人控制程序。针对五条文法规则，分别提供五个类来实现，其中终结符表达式direction、action和distance对应DirectionNode类、ActionNode类和DistanceNode类，非终结符表达式expression和composite对应SentenceNode类和AndNode类。  

我们可以通过抽象语法树来表示具体解释过程，例如机器人控制指令“down run 10 and left move 20”对应的抽象语法树如图18-4所示：  
![图18-4 机器人控制程序抽象语法树实例](https://upload-images.jianshu.io/upload_images/5792176-986d57822742940a.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
图18-4 机器人控制程序抽象语法树实例  

机器人控制程序实例基本结构如图18-5所示：  
![图18-5 机器人控制程序结构图](https://upload-images.jianshu.io/upload_images/5792176-c09979139404e267.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
图18-5 机器人控制程序结构图  

在图18-5中，AbstractNode充当抽象表达式角色，DirectionNode、ActionNode和DistanceNode充当终结符表达式角色，AndNode和SentenceNode充当非终结符表达式角色。完整代码如下所示：  
```java
//注：本实例对机器人控制指令的输出结果进行模拟，将英文指令翻译为中文指令，实际情况是调用不同的控制程序进行机器人的控制，包括对移动方向、方式和距离的控制等  
import java.util.*;  

//抽象表达式  
abstract class AbstractNode {  
    public abstract String interpret();  
}  

//And解释：非终结符表达式  
class AndNode extends AbstractNode {  
    private AbstractNode left; //And的左表达式  
    private AbstractNode right; //And的右表达式  

    public AndNode(AbstractNode left, AbstractNode right) {  
        this.left = left;  
        this.right = right;  
    }  

    //And表达式解释操作  
    public String interpret() {  
        return left.interpret() + "再" + right.interpret();  
    }  
}  

//简单句子解释：非终结符表达式  
class SentenceNode extends AbstractNode {  
    private AbstractNode direction;  
    private AbstractNode action;  
    private AbstractNode distance;  

    public SentenceNode(AbstractNode direction,AbstractNode action,AbstractNode distance) {  
        this.direction = direction;  
        this.action = action;  
        this.distance = distance;  
    }  

    //简单句子的解释操作  
    public String interpret() {  
        return direction.interpret() + action.interpret() + distance.interpret();  
    }     
}  

//方向解释：终结符表达式  
class DirectionNode extends AbstractNode {  
    private String direction;  

    public DirectionNode(String direction) {  
        this.direction = direction;  
    }  

    //方向表达式的解释操作  
    public String interpret() {  
        if (direction.equalsIgnoreCase("up")) {  
            return "向上";  
        }  
        else if (direction.equalsIgnoreCase("down")) {  
            return "向下";  
        }  
        else if (direction.equalsIgnoreCase("left")) {  
            return "向左";  
        }  
        else if (direction.equalsIgnoreCase("right")) {  
            return "向右";  
        }  
        else {  
            return "无效指令";  
        }  
    }  
}  

//动作解释：终结符表达式  
class ActionNode extends AbstractNode {  
    private String action;  

    public ActionNode(String action) {  
        this.action = action;  
    }  

    //动作（移动方式）表达式的解释操作  
    public String interpret() {  
        if (action.equalsIgnoreCase("move")) {  
            return "移动";  
        }  
        else if (action.equalsIgnoreCase("run")) {  
            return "快速移动";  
        }  
        else {  
            return "无效指令";  
        }  
    }  
}  

//距离解释：终结符表达式  
class DistanceNode extends AbstractNode {  
    private String distance;  

    public DistanceNode(String distance) {  
        this.distance = distance;  
    }  

//距离表达式的解释操作  
    public String interpret() {  
        return this.distance;  
    }     
}  

//指令处理类：工具类  
class InstructionHandler {  
    private String instruction;  
    private AbstractNode node;  

    public void handle(String instruction) {  
        AbstractNode left = null, right = null;  
        AbstractNode direction = null, action = null, distance = null;  
        Stack stack = new Stack(); //声明一个栈对象用于存储抽象语法树  
        String[] words = instruction.split(" "); //以空格分隔指令字符串  
        for (int i = 0; i < words.length; i++) {  
//本实例采用栈的方式来处理指令，如果遇到“and”，则将其后的三个单词作为三个终结符表达式连成一个简单句子SentenceNode作为“and”的右表达式，而将从栈顶弹出的表达式作为“and”的左表达式，最后将新的“and”表达式压入栈中。                   if (words[i].equalsIgnoreCase("and")) {  
                left = (AbstractNode)stack.pop(); //弹出栈顶表达式作为左表达式  
                String word1= words[++i];  
                direction = new DirectionNode(word1);  
                String word2 = words[++i];  
                action = new ActionNode(word2);  
                String word3 = words[++i];  
                distance = new DistanceNode(word3);  
                right = new SentenceNode(direction,action,distance); //右表达式  
                stack.push(new AndNode(left,right)); //将新表达式压入栈中  
            }  
            //如果是从头开始进行解释，则将前三个单词组成一个简单句子SentenceNode并将该句子压入栈中  
            else {  
                String word1 = words[i];  
                direction = new DirectionNode(word1);  
                String word2 = words[++i];  
                action = new ActionNode(word2);  
                String word3 = words[++i];  
                distance = new DistanceNode(word3);  
                left = new SentenceNode(direction,action,distance);  
                stack.push(left); //将新表达式压入栈中  
            }  
        }  
        this.node = (AbstractNode)stack.pop(); //将全部表达式从栈中弹出  
    }  

    public String output() {  
        String result = node.interpret(); //解释表达式  
        return result;  
    }  
}
```  

工具类InstructionHandler用于对输入指令进行处理，将输入指令分割为字符串数组，将第1个、第2个和第3个单词组合成一个句子，并存入栈中；如果发现有单词“and”，则将“and”后的第1个、第2个和第3个单词组合成一个新的句子作为“and”的右表达式，并从栈中取出原先所存句子作为左表达式，然后组合成一个And节点存入栈中。依此类推，直到整个指令解析结束。  

编写如下客户端测试代码：  
```java
class Client {  
    public static void main(String args[]) {  
        String instruction = "up move 5 and down run 10 and left move 5";  
        InstructionHandler handler = new InstructionHandler();  
        handler.handle(instruction);  
        String outString;  
        outString = handler.output();  
        System.out.println(outString);  
    }  
}
```

编译并运行程序，输出结果如下：  
```
向上移动5再向下快速移动10再向左移动5
```  