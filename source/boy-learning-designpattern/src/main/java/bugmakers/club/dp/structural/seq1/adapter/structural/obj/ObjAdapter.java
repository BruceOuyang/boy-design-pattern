package bugmakers.club.dp.structural.seq1.adapter.structural.obj;

/**
 * @Description: 对象适配器
 * @Author: Bruce
 * @Datetime: 2018/3/9 13:23
 */
public class ObjAdapter extends ObjTarget {

    /**
     * 对适配者的引用
     */
    private ObjAdaptee objAdaptee;

    public ObjAdapter(ObjAdaptee objAdaptee) {
        this.objAdaptee = objAdaptee;
    }

    @Override
    public void request() {
        this.objAdaptee.specialRequest();
    }
}
