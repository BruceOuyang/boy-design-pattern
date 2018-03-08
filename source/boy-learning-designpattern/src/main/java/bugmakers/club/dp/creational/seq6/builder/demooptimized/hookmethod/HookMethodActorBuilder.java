package bugmakers.club.dp.creational.seq6.builder.demooptimized.hookmethod;

import bugmakers.club.dp.creational.seq6.builder.demo.Actor;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/8 17:26
 */
public abstract class HookMethodActorBuilder {

    protected Actor actor = new Actor();

    public  abstract void buildType();
    public  abstract void buildSex();
    public  abstract void buildFace();
    public  abstract void buildCostume();
    public  abstract void buildHairstyle();

    /**
     * 钩子方法
     * @return
     */
    public boolean isBareheaded(){
        return false;
    }

    public Actor createActor(){
        return actor;
    }
}
