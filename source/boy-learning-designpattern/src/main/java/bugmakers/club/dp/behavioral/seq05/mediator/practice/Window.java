package bugmakers.club.dp.behavioral.seq05.mediator.practice;

/**
 * @Description: 窗口
 * @Author: Bruce
 * @Datetime: 2018/3/26 15:25
 */
public class Window extends Mediator {

    public TextPanel text;
    public ListPanel list;
    public GraphicPanel graphic;

    @Override
    public void panelOperated(Panel panel) {

        // 具体交互逻辑可自行定义
//        if(panel == text){
//            text.operation();
//        }
//        else if(panel == list){
//            list.operation();
//        }
//        else if(panel == graphic){
//            graphic.operation();
//        }

        // 此处表示不管哪个panel有动作，都触发另外两个
        text.operation();
        list.operation();
        graphic.operation();
    }
}
