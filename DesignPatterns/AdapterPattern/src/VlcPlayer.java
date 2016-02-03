/**
 * Created by marszhou on 16/2/3.
 */
public class VlcPlayer implements AdvanceMediaPlayer{
    @Override public void playVlc(String fileName) {
        System.out.println("Playing vlc file " + fileName);
    }

    @Override public void playMp4(String fileName) {

    }
}
