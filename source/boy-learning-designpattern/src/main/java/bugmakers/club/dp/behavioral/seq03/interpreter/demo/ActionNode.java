package bugmakers.club.dp.behavioral.seq03.interpreter.demo;

/**
 * @Description: 动作解释：终结符表达式
 * @Author: Bruce
 * @Datetime: 2018/3/20 16:00
 */
public class ActionNode extends AbstractNode {

    public static final String MOVE = "move";
    public static final String RUN = "run";

    private String action;

    public ActionNode(String action) {
        this.action = action;
    }

    /**
     * 动作（移动方式）表达式的解释操作
     * @return
     */
    @Override
    public String interpret() {
        String result;
        if(MOVE.equalsIgnoreCase(this.action)){
            result = "移动";
        }else if(RUN.equalsIgnoreCase(this.action)){
            result = "快速移动";
        }else{
            result = "无效指令";
        }
        return result;
    }
}
