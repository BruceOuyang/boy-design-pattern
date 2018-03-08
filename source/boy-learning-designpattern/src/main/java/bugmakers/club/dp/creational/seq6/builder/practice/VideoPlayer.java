package bugmakers.club.dp.creational.seq6.builder.practice;

/**
 * @Description: 抽象产品
 * @Author: Bruce
 * @Datetime: 2018/3/8 18:03
 */
public abstract class VideoPlayer {

    private String menu;
    private String plist;
    private String main;
    private String progress;

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getPlist() {
        return plist;
    }

    public void setPlist(String plist) {
        this.plist = plist;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public abstract void mode();
}
