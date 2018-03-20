package bugmakers.club.dp.behavioral.seq03.interpreter.demo;

/**
 * @Description: 方向解释：终结符表达式
 * @Author: Bruce
 * @Datetime: 2018/3/20 15:55
 */
public class DirectionNode extends AbstractNode {

    private static final String UP = "up";
    private static final String DOWN = "down";
    private static final String LEFT = "left";
    private static final String RIGHT = "right";

    private String direction;

    public DirectionNode(String direction) {
        this.direction = direction;
    }

    @Override
    public String interpret() {
        String result;

        if(UP.equalsIgnoreCase(this.direction)){
            result = "向上";
        }else if(DOWN.equalsIgnoreCase(this.direction)){
            result = "向上";
        }else if(LEFT.equalsIgnoreCase(this.direction)){
            result = "向左";
        }else if(RIGHT.equalsIgnoreCase(this.direction)){
            result = "向右";
        }else {
            result = "无效指令";
        }
        return result;
    }
}
