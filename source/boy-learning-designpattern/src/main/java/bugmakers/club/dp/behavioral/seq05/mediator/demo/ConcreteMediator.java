package bugmakers.club.dp.behavioral.seq05.mediator.demo;

/**
 * @Description: 具体中介者
 * @Author: Bruce
 * @Datetime: 2018/3/26 14:27
 */
public class ConcreteMediator extends Mediator {

    /**
     * 维持对各个同事对象的引用
     */
    public Button button;
    public List list;
    public ComboBox comboBox;
    public TextBox textBox;

    /**
     * 封装同事对象之间的交互
     * @param component
     */
    @Override
    public void componentChanged(Component component) {

        // 单击按钮
        if(component == button){
            buttonChanged();
        }
        // 从列表框选择客户
        else if(component == list){
            listChanged();
        }
        // 从组合框选择客户
        else if(component == comboBox){
            comboBoxChanged();
        }
    }

    protected void buttonChanged(){
        System.out.println("--单击添加按钮--");
        list.update();
        comboBox.update();
        textBox.update();
    }

    protected void listChanged(){
        System.out.println("--从列表框选择客户--");
        list.select();
        textBox.setText();
    }

    protected void comboBoxChanged(){
        System.out.println("--从组合框选择客户--");
        comboBox.select();
        textBox.setText();
    }
}
