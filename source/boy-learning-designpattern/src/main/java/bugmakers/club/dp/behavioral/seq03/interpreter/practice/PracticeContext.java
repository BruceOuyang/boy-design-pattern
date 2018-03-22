package bugmakers.club.dp.behavioral.seq03.interpreter.practice;

import java.text.MessageFormat;
import java.util.StringTokenizer;

/**
 * @Description: 环境类：用于存储和操作需要解释的语句
 * @Author: Bruce
 * @Datetime: 2018/3/22 10:19
 */
public class PracticeContext {

    /**
     * 用于记录原始指令表达式
     */
    private String text;

    /**
     * 用于将字符串分解为更小的字符串标记(Token)，默认情况下以空格作为分隔符
     */
    private StringTokenizer tokenizer;

    /**
     * 当前字符串标记
     */
    private String currentToken;

    /**
     * 通过传入的指令字符串创建StringTokenizer对象
     * @param text
     */
    public PracticeContext(String text){
        this.text = text;
        tokenizer = new StringTokenizer(text);
        nextToken();
    }


    /**
     * 返回下一个标记
     * @return
     */
    public String nextToken(){
        if(tokenizer.hasMoreTokens()){
            currentToken = tokenizer.nextToken();
        }
        else{
            currentToken = null;
        }
        return currentToken;
    }

    /**
     * 返回当前的标记
     * @return
     */
    public String currentToken(){
        return currentToken;
    }

    /**
     * 跳过一个标记
     * @param token
     */
    public void skipToken(String token){
        if(!token.equals(currentToken)){
            System.err.println(MessageFormat.format("错误提示：{0}解释错误！", currentToken));
        }
        nextToken();
    }

    public String getText() {
        return text;
    }
}
