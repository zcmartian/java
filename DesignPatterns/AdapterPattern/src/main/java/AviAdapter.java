/**
 * Created by Administrator on 2016/11/26.
 */
public class AviAdapter implements MediaPlayer{
    @Override
    public void play(String mediaType, String fileName) {
        System.out.println("Playing " + mediaType + "file : " + fileName);
    }
}
