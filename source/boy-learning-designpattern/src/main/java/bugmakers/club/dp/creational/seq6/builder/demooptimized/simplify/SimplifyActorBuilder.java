package bugmakers.club.dp.creational.seq6.builder.demooptimized.simplify;

import bugmakers.club.dp.creational.seq6.builder.demo.Actor;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/8 17:26
 */
public abstract class SimplifyActorBuilder {

    protected Actor actor = new Actor();

    public  abstract void buildType();
    public  abstract void buildSex();
    public  abstract void buildFace();
    public  abstract void buildCostume();
    public  abstract void buildHairstyle();

    public Actor construct(){
        this.buildType();
        this.buildSex();
        this.buildFace();
        this.buildCostume();
        this.buildHairstyle();
        return actor;
    }
}
