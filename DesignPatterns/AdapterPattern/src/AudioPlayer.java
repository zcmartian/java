/**
 * Created by marszhou on 16/2/3.
 */
public class AudioPlayer implements MediaPlayer{
    MediaAdapter mediaAdapter;

    @Override public void play(String mediaType, String fileName) {
        if (mediaType.equals("mp3")) {
            System.out.println("Playing mp3 file " + fileName);
        } else if (mediaType.equals("vlc") || mediaType.equals("mp4")) {
            mediaAdapter = new MediaAdapter(mediaType);
            mediaAdapter.play(mediaType, fileName);
        } else {
            System.out.println("Invalid media type");
        }
    }
}
