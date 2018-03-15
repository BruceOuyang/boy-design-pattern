package bugmakers.club.dp.structural.seq7.proxy.structural;

/**
 * @Description: 代理类
 * @Author: Bruce
 * @Datetime: 2018/3/15 16:56
 */
public class Proxy extends Subject {

    /**
     * 维持一个对真实主题对象的引用
     */
    private RealSubject realSubject = new RealSubject();

    public void preRequest(){
        // biz
    }

    @Override
    public void request() {
        preRequest();

        // 调用真实主题对象的方法
        realSubject.request();

        postRequest();
    }

    public void postRequest(){
        // biz
    }
}
