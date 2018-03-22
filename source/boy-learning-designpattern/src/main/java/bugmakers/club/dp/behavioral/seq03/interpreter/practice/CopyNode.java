package bugmakers.club.dp.behavioral.seq03.interpreter.practice;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/22 15:21
 */
public class CopyNode extends AbstractPracticeNode {

    private static final String COPY = "COPY";
    private static final String VIEW = "VIEW";
    private static final String FROM = "FROM";
    private static final String TO = "TO";

    private String srcDb;
    private String desDb;

    @Override
    public void interpret(PracticeContext context) throws ErrExpressionException {

        // 跳过COPY字符
        if(COPY.equalsIgnoreCase(context.currentToken())){
            context.skipToken(context.currentToken());
        }else{
            throw new ErrExpressionException(context);
        }

        // 跳过VIEW字符
        if(VIEW.equalsIgnoreCase(context.currentToken())){
            context.skipToken(context.currentToken());
        }else{
            throw new ErrExpressionException(context);
        }

        // 跳过FROM
        if(FROM.equalsIgnoreCase(context.currentToken())){
            context.skipToken(context.currentToken());
        }else{
            throw new ErrExpressionException(context);
        }

        // 获取srcDb
        srcDb = context.currentToken();
        if(srcDb != null){
            context.skipToken(srcDb);
        }else{
            throw new ErrExpressionException(context, "srcDb 为空或不明确");
        }

        // 跳过TO
        if(TO.equalsIgnoreCase(context.currentToken())){
            context.skipToken(context.currentToken());
        }else{
            throw new ErrExpressionException(context);
        }

        // 获取desDb
        desDb = context.currentToken();
        if(desDb != null){
            context.skipToken(desDb);
        }else{
            throw new ErrExpressionException(context, "srcDb 为空或不明确");
        }

        // 直接忽略掉后面多余的指令

    }

    @Override
    public void execute() {
        System.out.println("跨数据库视图复制伪操作：");
        System.out.println("校验可用性：srcDB->" + srcDb + ", desDB->" + desDb);
        System.out.println("执行操作：");
        System.out.println("将" + srcDb + "数据库中所有视图复制到" + desDb + "数据库");
    }
}
