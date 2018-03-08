package bugmakers.club.dp.creational.seq6.builder.practice;

public abstract class VideoPlayerBuilder {

  protected VideoPlayer videoPlayer = new VideoPlayer();

  public abstract void buildMenu();
  public abstract void buildPlist();
  public abstract void buildMain();
  public abstract void buildProgress();

  public VideoPlayer createVideoPlayer() {
    return videoPlayer;
  }
}
