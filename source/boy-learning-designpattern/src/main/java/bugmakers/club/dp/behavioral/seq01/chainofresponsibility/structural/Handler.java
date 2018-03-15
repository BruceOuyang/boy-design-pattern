package bugmakers.club.dp.behavioral.seq01.chainofresponsibility.structural;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/15 20:12
 */
public abstract class Handler {

    /**
     * 维持对下家的引用
     */
    protected Handler successor;

    public void setSuccessor(Handler successor){
        this.successor = successor;
    }

    public abstract void handleRequest(String request);
}
