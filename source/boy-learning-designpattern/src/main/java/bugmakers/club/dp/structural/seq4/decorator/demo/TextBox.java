package bugmakers.club.dp.structural.seq4.decorator.demo;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/14 13:47
 */
public class TextBox extends Component {

    public TextBox(){
        System.out.println("创建文本框");
    }

    @Override
    public void display() {
        System.out.println("展示文本框！");
    }
}
