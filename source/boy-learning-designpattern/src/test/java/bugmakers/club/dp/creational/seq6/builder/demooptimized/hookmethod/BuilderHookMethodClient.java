package bugmakers.club.dp.creational.seq6.builder.demooptimized.hookmethod;

import bugmakers.club.dp.creational.seq6.builder.demo.Actor;
import bugmakers.club.dp.creational.seq6.builder.demo.BuilderXMLUtil;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/8 17:39
 */
public class BuilderHookMethodClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {

        //针对抽象建造者编程
        HookMethodActorBuilder ab;

        //反射生成具体建造者对象
        ab =  (HookMethodActorBuilder) BuilderXMLUtil.getBean();

        HookMethodActorController ac = new HookMethodActorController();

        //通过指挥者创建完整的建造者对象
        Actor actor = ac.construct(ab);

        String  type = actor.getType();
        System.out.println(type  + "的外观：");
        System.out.println("性别：" + actor.getSex());
        System.out.println("面容：" + actor.getFace());
        System.out.println("服装：" + actor.getCostume());
        System.out.println("发型：" + actor.getHairstyle());
    }
}
