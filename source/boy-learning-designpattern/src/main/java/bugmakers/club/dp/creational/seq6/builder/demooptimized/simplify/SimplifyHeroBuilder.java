package bugmakers.club.dp.creational.seq6.builder.demooptimized.simplify;

/**
 * @Description: 英雄角色建造器：具体建造者
 * @Author: Bruce
 * @Datetime: 2018/3/8 17:07
 */
public class SimplifyHeroBuilder extends SimplifyActorBuilder {

    @Override
    public void buildType() {
        actor.setType("英雄");
    }

    @Override
    public void buildSex() {
        actor.setSex("男");
    }

    @Override
    public void buildFace() {
        actor.setFace("英俊");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("盔甲");
    }

    @Override
    public void buildHairstyle() {
        actor.setHairstyle("飘逸");
    }
}
