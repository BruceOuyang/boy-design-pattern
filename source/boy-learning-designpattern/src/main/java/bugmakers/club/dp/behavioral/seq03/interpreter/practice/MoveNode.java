package bugmakers.club.dp.behavioral.seq03.interpreter.practice;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/22 15:21
 */
public class MoveNode extends AbstractPracticeNode {

    private static final String MOVE = "MOVE";
    private static final String TABLE = "TABLE";
    private static final String FROM = "FROM";
    private static final String TO = "TO";

    private String table;
    private String srcDb;
    private String desDb;

    @Override
    public void interpret(PracticeContext context) throws ErrExpressionException {

        // 跳过MOVE字符
        if(MOVE.equalsIgnoreCase(context.currentToken())){
            context.skipToken(context.currentToken());
        }else{
            throw new ErrExpressionException(context);
        }

        // 跳过TABLE字符
        if(TABLE.equalsIgnoreCase(context.currentToken())){
            context.skipToken(context.currentToken());
        }else{
            throw new ErrExpressionException(context);
        }

        // 获取table
        table = context.currentToken();
        if(table != null){
            context.skipToken(table);
        }else{
            throw new ErrExpressionException(context, "TABLE 为空或不明确");
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
        System.out.println("跨数据库表格移动伪操作：");
        System.out.println("校验可用性：table->" + table + ", srcDB->" + srcDb + ", desDB->" + desDb);
        System.out.println("执行操作：");
        System.out.println("将" + srcDb + "数据库中" + table + "表移动至" + desDb + "数据库");
    }
}
