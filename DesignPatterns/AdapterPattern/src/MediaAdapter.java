/**
 * Created by marszhou on 16/2/3.
 */
public class MediaAdapter implements MediaPlayer {
    AdvanceMediaPlayer advanceMediaPlayer;

    public MediaAdapter(String mediaType) {
        //通过构造器注入具体的适配器使用的组合对象
        if (mediaType.equals("vlc")) {
            advanceMediaPlayer = new VlcPlayer();
        } else if (mediaType.equals("mp4")) {
            advanceMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String mediaType, String fileName) {
        //调用具体组合对象的方法,可以和 MediaPlayer 接口定义的方法不一样
        if (mediaType.equals("vlc")) {
            advanceMediaPlayer.playVlc(fileName);
        } else if (mediaType.equals("mp4")) {
            advanceMediaPlayer.playMp4(fileName);
        }
    }
}
