package bugmakers.club.dp.creational.seq6.builder.demo;

/**
 * @Description: 恶魔角色建造器：具体建造者
 * @Author: Bruce
 * @Datetime: 2018/3/8 17:10
 */
public class DevilBuilder extends ActorBuilder {

    @Override
    public void buildType()
    {
        actor.setType("恶魔");
    }

    @Override
    public void buildSex()
    {
        actor.setSex("妖");
    }

    @Override
    public void buildFace()
    {
        actor.setFace("丑陋");
    }

    @Override
    public void buildCostume()
    {
        actor.setCostume("黑衣");
    }

    @Override
    public void buildHairstyle()
    {
        actor.setHairstyle("光头");
    }
}
