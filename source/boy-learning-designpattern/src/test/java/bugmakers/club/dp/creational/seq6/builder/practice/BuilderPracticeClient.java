package bugmakers.club.dp.creational.seq6.builder.practice;

public class BuilderPracticeClient {

  /**
   * 主函数：系统入口
   */
  public static void main(String[] args) {
     VideoPlayer player = null;

     VideoPlayerBuilder builder = new FullVideoPlayerBuilder();

     VideoPlayerController controller = new VideoPlayerController();

     player = controller.construct(builder);


  }
}
