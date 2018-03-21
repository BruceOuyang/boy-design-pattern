package bugmakers.club.dp.behavioral.seq03.interpreter.practice;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/21 17:25
 */
public class ExpressionNode extends AbstractPracticeNode {

    /**
     * 定义一个集合用于存储多条命令
     */
    private ArrayList<AbstractPracticeNode> list = new ArrayList<AbstractPracticeNode>();

    @Override
    public void interpret(PracticeContext context) {

        // 循环处理Context中的标记
        while(true){

            // 如果已经没有任何标记，则退出解释
            if(context.currentToken() == null){
                break;
            }
            // 如果为其他标记，则解释标记并将其加入命令集合
            else{
                AbstractPracticeNode commandNode = new OtherNode();
                commandNode.interpret(context);
                list.add(commandNode);
            }
        }
    }

    @Override
    public void execute() {
        Iterator<AbstractPracticeNode> iterator = list.iterator();
        while(iterator.hasNext()){
            iterator.next().execute();
        }
    }
}
