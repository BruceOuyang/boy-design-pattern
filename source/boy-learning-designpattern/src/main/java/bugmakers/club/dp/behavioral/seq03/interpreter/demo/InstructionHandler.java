package bugmakers.club.dp.behavioral.seq03.interpreter.demo;

import java.util.Stack;

/**
 * @Description: 指令处理类：工具类
 * @Author: Bruce
 * @Datetime: 2018/3/20 16:08
 */
public class InstructionHandler {

    /**
     * 指令分隔符
     */
    public static final String SPLIT_REGEX = " ";
    public static final String AND = "and";

    private String instruction;
    private AbstractNode node;

    /**
     * 处理指令
     * @param instruction
     */
    public void handle(String instruction){

        AbstractNode leftNode, rightNode, directionNode, actionNode, distanceNode = null;

        // 声明一个栈对象用于存储抽象语法树
        Stack<AbstractNode> stack = new Stack<AbstractNode>();

        // 以空格分隔指令字符串
        String [] words = instruction.split(SPLIT_REGEX);

        for (int i = 0; i < words.length; i++) {

            // 本实例采用栈的方式来处理指令
            // 如果遇到“and”，则将其后的三个单词作为三个终结符表达式连成一个简单句子
            // SentenceNode作为“and”的右表达式，而将从栈顶弹出的表达式作为“and”的左表达式，最后将新的“and”表达式压入栈中。
            if (AND.equalsIgnoreCase(words[i])) {

                //弹出栈顶表达式作为左表达式
                leftNode = stack.pop();

                String direction = words[++i];
                directionNode = new DirectionNode(direction);

                String action = words[++i];
                actionNode = new ActionNode(action);

                String distance = words[++i];
                distanceNode = new DistanceNode(distance);

                rightNode = new SentenceNode(directionNode, actionNode, distanceNode);

                // 将新表达式压入栈中
                stack.push(new AndNode(leftNode, rightNode));
            }
            // 如果是从头开始进行解释
            // 则将前三个单词组成一个简单句子SentenceNode并将该句子压入栈中
            else{
                String direction = words[i];
                directionNode = new DirectionNode(direction);

                String action = words[++i];
                actionNode = new ActionNode(action);

                String distance = words[++i];
                distanceNode = new DistanceNode(distance);

                leftNode = new SentenceNode(directionNode, actionNode, distanceNode);

                // 将新表达式压入栈中
                stack.push(leftNode);
            }
        }
        // 将全部表达式从栈中弹出
        this.node = stack.pop();
    }

    public String output(){
        return this.node.interpret();
    }
}
