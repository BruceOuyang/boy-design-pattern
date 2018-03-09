package bugmakers.club.dp.structural.seq1.adapter.structural.twoway;

/**
 * @Description: 双向适配器
 * @Author: Bruce
 * @Datetime: 2018/3/9 13:41
 */
public class TwAdapter implements TwTarget, TwAdaptee {

    private TwTarget twTarget;
    private TwAdaptee twAdaptee;

    public TwAdapter(TwTarget twTarget) {
        this.twTarget = twTarget;
    }

    public TwAdapter(TwAdaptee twAdaptee) {
        this.twAdaptee = twAdaptee;
    }

    public void specialRequest() {
        twAdaptee.specialRequest();
    }

    public void request() {
        twTarget.request();
    }
}
