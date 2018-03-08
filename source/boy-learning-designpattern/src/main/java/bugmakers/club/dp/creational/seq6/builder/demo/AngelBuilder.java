package bugmakers.club.dp.creational.seq6.builder.demo;

/**
 * @Description: 天使角色建造器：具体建造者
 * @Author: Bruce
 * @Datetime: 2018/3/8 17:09
 */
public class AngelBuilder extends ActorBuilder {

    @Override
    public void buildType()
    {
        actor.setType("天使");
    }

    @Override
    public void buildSex()
    {
        actor.setSex("女");
    }

    @Override
    public void buildFace()
    {
        actor.setFace("漂亮");
    }

    @Override
    public void buildCostume()
    {
        actor.setCostume("白裙");
    }

    @Override
    public void buildHairstyle()
    {
        actor.setHairstyle("披肩长发");
    }
}
