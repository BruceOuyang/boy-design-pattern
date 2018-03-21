package bugmakers.club.dp.behavioral.seq03.interpreter.demooptimized;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Description: 表达式节点类：非终结符表达式
 * @Author: Bruce
 * @Datetime: 2018/3/20 17:19
 */
public class ExpressionNode extends AbstractNode {

    private static final String END = "END";

    /**
     * 定义一个集合用于存储多条命令
     */
    private ArrayList<AbstractNode> list = new ArrayList<AbstractNode>();

    /**
     * 解释指令
     * @param context
     */
    @Override
    public void interpret(Context context) {

        // 循环处理Context中的标记
        while(true){

            // 如果已经没有任何标记，则退出解释
            if(context.currentToken() == null){
                break;
            }
            // 如果标记为END，则不解释END并结束本次解释过程，可以继续之后的解释
            else if(END.equals(context.currentToken())){
                context.skipToken(END);
                break;
            }
            // 如果为其他标记，则解释标记并将其加入命令集合
            else{
                AbstractNode commandNode = new CommandNode();
                list.add(commandNode);
            }
        }
    }

    /**
     * 循环执行命令集合中的每一条命令
     */
    @Override
    public void execute() {
        Iterator<AbstractNode> iterator = list.iterator();
        while(iterator.hasNext()){
            iterator.next().execute();
        }
    }
}
