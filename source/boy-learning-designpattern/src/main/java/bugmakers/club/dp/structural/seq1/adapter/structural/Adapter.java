package bugmakers.club.dp.structural.seq1.adapter.structural;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/9 13:23
 */
public class Adapter extends Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        this.adaptee.specialRequest();
    }
}
