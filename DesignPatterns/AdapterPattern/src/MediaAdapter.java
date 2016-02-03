/**
 * Created by marszhou on 16/2/3.
 */
public class MediaAdapter implements MediaPlayer{
    AdvanceMediaPlayer advanceMediaPlayer;

    public MediaAdapter(String mediaType) {
        if (mediaType.equals("vlc")) {
            advanceMediaPlayer = new VlcPlayer();
        } else if (mediaType.equals("mp4")) {
            advanceMediaPlayer = new Mp4Player();
        }
    }
    @Override public void play(String mediaType, String fileName) {
        if (mediaType.equals("vlc")) {
            advanceMediaPlayer.playVlc(fileName);
        } else if (mediaType.equals("mp4")) {
            advanceMediaPlayer.playMp4(fileName);
        }
    }
}
