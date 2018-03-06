package bugmakers.club.dp.creational.seq4.singleton.structural;

/**
 * @Description: 懒汉单例模式 ： 启动时创建，双检索会影响系统性能
 * @Author: Bruce
 * @Datetime: 2018/3/6 17:18
 */
public class LazySingleton {

    /**
     * 静态成员变量，系统启动时执行，不实例化
     */
    private static LazySingleton instance = null;

    /**
     * 默认构造方法的访问修饰符设为private，屏蔽外部通过new来实例化对象
     */
    private LazySingleton() { }

    /**
     * 使用双检索防止高并发下出现多个实例的情况
     * @return
     */
    public static LazySingleton getInstance() {
        //第一重判断
        if (instance == null) {
            //锁定代码块
            synchronized (LazySingleton.class) {
                //第二重判断
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
