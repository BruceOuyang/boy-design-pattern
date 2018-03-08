package bugmakers.club.dp.creational.seq6.builder.demo;

/**
 * @Description: 角色建造器：抽象建造者
 * @Author: Bruce
 * @Datetime: 2018/3/8 17:05
 */
abstract class ActorBuilder {

    protected  Actor actor = new Actor();

    public  abstract void buildType();
    public  abstract void buildSex();
    public  abstract void buildFace();
    public  abstract void buildCostume();
    public  abstract void buildHairstyle();

    /**
     * 工厂方法，返回一个完整的游戏角色对象
     * @return
     */
    public Actor createActor(){
        return actor;
    }
}
