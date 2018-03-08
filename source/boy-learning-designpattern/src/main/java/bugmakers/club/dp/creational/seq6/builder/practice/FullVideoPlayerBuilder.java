package bugmakers.club.dp.creational.seq6.builder.practice;

public class FullVideoPlayerBuilder extends VideoPlayerBuilder {

  public FullVideoPlayerBuilder(){
    System.out.println("构建完整版播放器");
    System.out.println("---------------");
  }

  public void buildMenu() {
    System.out.println("显示菜单");
  }

  public void buildPlist() {
    System.out.println("显示播放列表");
  }

  public void buildMain() {
    System.out.println("显示主播放界面");
  }

  public void buildProgress() {
    System.out.println("显示进度条");
  }


}
