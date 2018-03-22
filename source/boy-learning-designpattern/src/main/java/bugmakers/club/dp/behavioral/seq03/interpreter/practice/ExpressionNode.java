package bugmakers.club.dp.behavioral.seq03.interpreter.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/22 14:38
 */
public class ExpressionNode extends AbstractPracticeNode {

    private AbstractPracticeNode node;

    private static final String COPY = "COPY";
    private static final String MOVE = "MOVE";

    private List<AbstractPracticeNode> list = new ArrayList<AbstractPracticeNode>();

    @Override
    public void interpret(PracticeContext context) {
        try {
            while(true){
                if(context.currentToken() == null){
                    break;
                }
                if(COPY.equalsIgnoreCase(context.currentToken())){
                    node = new CopyNode();
                }
                else if(MOVE.equalsIgnoreCase(context.currentToken())){
                    node = new MoveNode();
                }else{
                    throw new ErrExpressionException(context);
                }
                list.add(node);
                node.interpret(context);
            }

            // 解释完成后立即执行
            execute();

        } catch (Exception e) {
            System.err.println(e.getMessage());
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
