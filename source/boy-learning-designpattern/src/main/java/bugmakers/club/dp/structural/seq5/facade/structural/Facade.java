package bugmakers.club.dp.structural.seq5.facade.structural;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/14 17:22
 */
public class Facade {

    private SystemA a = new SystemA();
    private SystemB b = new SystemB();
    private SystemC c = new SystemC();

    public void biz(){
        a.biz();
        b.biz();
        c.biz();
    }
}
