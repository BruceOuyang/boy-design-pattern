package bugmakers.club.dp.creational.seq6.builder.demo;

/**
 * @Description: 游戏角色创建控制器：指挥者
 * @Author: Bruce
 * @Datetime: 2018/3/8 17:12
 */
public class ActorController {

    /**
     * 逐步构建复杂产品对象
     * @param builder
     * @return
     */
    public Actor construct(ActorBuilder builder){

        builder.buildType();
        builder.buildSex();
        builder.buildFace();
        builder.buildCostume();
        builder.buildHairstyle();

        return builder.createActor();
    }
}
