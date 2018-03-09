package bugmakers.club.dp.structural.seq1.adapter.structural.clss;

/**
 * @Description: 类适配器
 * @Author: Bruce
 * @Datetime: 2018/3/9 13:38
 */
public class ClssAdapter extends ClssAdaptee implements ClssTarget {

    public void request() {
        super.specialRequest();
    }
}
