/**
 * Created by marszhou on 16/2/3.
 */
public class Mp4Player implements AdvanceMediaPlayer {
    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file " + fileName);
    }
}
