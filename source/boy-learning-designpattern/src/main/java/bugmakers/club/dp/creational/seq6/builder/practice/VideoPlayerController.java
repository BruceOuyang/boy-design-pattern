package bugmakers.club.dp.creational.seq6.builder.practice;

public class VideoPlayerController {

  public VideoPlayer construct(VideoPlayerBuilder builder){
    builder.buildMain();
    builder.buildMenu();
    builder.buildPlist();
    builder.buildProgress();
    return builder.createVideoPlayer();
  }
}
