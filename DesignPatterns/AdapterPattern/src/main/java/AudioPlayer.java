/**
 * Created by marszhou on 16/2/3.
 */
public class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;
    AviAdapter aviAdapter;

    @Override
    public void play(String mediaType, String fileName) {
        //AudioPlayer 的原始方法
        if (mediaType.equals("mp3")) {
            System.out.println("Playing mp3 file " + fileName);
        } else if (mediaType.equals("vlc") || mediaType.equals("mp4")) {
            //AudioPlayer 的适配方法,调用 MediaAdapter适配器的 play 方法
            mediaAdapter = new MediaAdapter(mediaType);
            mediaAdapter.play(mediaType, fileName);
        } else if (mediaType.equals("avi")) {
            //直接适配器,适配到一个实例对象,直接调用和被适配对象一样的接口.
            aviAdapter = new AviAdapter();
            aviAdapter.play(mediaType, fileName);
        } else {
            System.out.println("Invalid media type");
        }
    }
}
