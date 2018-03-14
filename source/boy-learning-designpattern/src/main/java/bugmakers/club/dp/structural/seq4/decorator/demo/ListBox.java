package bugmakers.club.dp.structural.seq4.decorator.demo;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/14 13:48
 */
public class ListBox extends Component {

    public ListBox(){
        System.out.println("创建列表框");
    }

    @Override
    public void display() {
        System.out.println("展示列表框！");
    }
}
