package bugmakers.club.dp.creational.seq6.builder.demooptimized.hookmethod;

import bugmakers.club.dp.creational.seq6.builder.demo.Actor;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/8 17:52
 */
public class HookMethodActorController {

    public Actor construct(HookMethodActorBuilder ab) {
        Actor actor;

        ab.buildType();
        ab.buildSex();
        ab.buildFace();
        ab.buildCostume();

        //通过钩子方法来控制产品的构建
        if(!ab.isBareheaded())
        {
            ab.buildHairstyle();
        }
        actor=ab.createActor();
        return  actor;
    }
}
