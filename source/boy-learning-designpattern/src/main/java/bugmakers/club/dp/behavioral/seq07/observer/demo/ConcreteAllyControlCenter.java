package bugmakers.club.dp.behavioral.seq07.observer.demo;

import java.text.MessageFormat;

/**
 * @Description: 具体战队控制中心类：具体目标类
 * @Author: Bruce
 * @Datetime: 2018/3/28 14:59
 */
public class ConcreteAllyControlCenter extends AllyControlCenter {

    public ConcreteAllyControlCenter(String allyName) {
        System.out.println(MessageFormat.format("{0}战队组件成功！", allyName));
        System.out.println();
        System.out.println("控制中心发布盟友召集令");
        System.out.println("---------------------------------");
        this.allyName = allyName;
    }

    @Override
    public void notifyObserver(String name) {
        System.out.println();
        System.out.println(MessageFormat.format("{0}战队紧急通知：盟友{1}正在遭受攻击，请速速支援！", this.allyName, name));
        System.out.println();

        // 遍历观察者集合，调用每一个盟友（自己除外）的支援方法
        for(Observer player : this.players){
            if(!player.getName().equalsIgnoreCase(name)){
                player.help();
            }
        }
    }
}
