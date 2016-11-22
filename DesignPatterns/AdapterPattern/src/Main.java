public class Main {

    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");

        Adaptee adaptee = new Adaptee();
        IExecutable iExecutable = new AExecute();
        Adapter adapter = new Adapter(iExecutable);
        adaptee.execute();
        adapter.execute();
    }
}
