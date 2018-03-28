package bugmakers.club.dp.behavioral.seq07.observer.practice;

/**
 * @Description: 股票信息
 * @Author: Bruce
 * @Datetime: 2018/3/28 16:31
 */
public class StockState {

    /**
     * 名称
     */
    private String name;

    /**
     * 代码
     */
    private String code;

    /**
     * 当前价格
     */
    private double price;

    public StockState(String name, String code, double price) {
        this.name = name;
        this.code = code;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
