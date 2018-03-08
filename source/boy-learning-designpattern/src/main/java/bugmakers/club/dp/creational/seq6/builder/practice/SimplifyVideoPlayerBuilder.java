package bugmakers.club.dp.creational.seq6.builder.practice;

public class SimplifyVideoPlayerBuilder extends VideoPlayerBuilder {

  public SimplifyVideoPlayerBuilder(){
    System.out.println("构建精简版播放器");
    System.out.println("---------------");
  }

  public void buildMenu() {
    System.out.println("显示菜单");
  }

  public void buildPlist() {
  }

  public void buildMain() {
    System.out.println("显示主播放界面");
  }

  public void buildProgress() {
  }
}
