package bugmakers.club.dp.behavioral.seq02.command.demo;

import java.text.MessageFormat;
import java.util.ArrayList;

/**
 * @Description: 功能键设置窗口类
 * @Author: Bruce
 * @Datetime: 2018/3/16 17:23
 */
public class FBSettingWindow {

    /**
     * 窗口标题
     */
    private String title;

    /**
     * 定义一个ArrayList来存储所有功能键
     */
    private ArrayList<FunctionButton> functionButtons = new ArrayList<FunctionButton>();

    public FBSettingWindow(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 添加一个功能键
     * @param fb
     */
    public void addFunctionButton(FunctionButton fb){
        this.functionButtons.add(fb);
    }

    /**
     * 移除一个功能键
     * @param fb
     */
    public void removeFunctionButton(FunctionButton fb){
        this.functionButtons.remove(fb);
    }

    /**
     * 显示窗口及功能键
     */
    public void display(){
        System.out.println(MessageFormat.format("显示窗口：{0}", this.title));
        System.out.println("显示功能键：");
        for(FunctionButton fb : functionButtons){
            System.out.println(fb.getName());
        }
        System.out.println("---------------------------------");
    }

}
