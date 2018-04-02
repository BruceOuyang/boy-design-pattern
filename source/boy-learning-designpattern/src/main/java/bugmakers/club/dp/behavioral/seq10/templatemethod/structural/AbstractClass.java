package bugmakers.club.dp.behavioral.seq10.templatemethod.structural;

/**
 * @Description: 抽象类
 * @Author: Bruce
 * @Datetime: 2018/4/2 16:58
 */
public abstract class AbstractClass {

    /**
     * 模板方法
     */
    public void templateMethod(){
        primitiveMethod1();
        primitiveMethod2();
        primitiveMethod3();
    }

    /**
     * 基本方法—具体方法
     */
    public void primitiveMethod1(){
        // biz
    }

    /**
     * 基本方法—抽象方法
     */
    public abstract void primitiveMethod2();

    /**
     * 基本方法—钩子方法
     */
    public void primitiveMethod3(){

    }
}
