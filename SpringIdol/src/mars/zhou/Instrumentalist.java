package mars.zhou;

public class Instrumentalist implements Performer {
	public Instrumentalist() {
	}

	@Override
	public void perform() throws PerformanceException {
		// TODO Auto-generated method stub
		System.out.println("Playing" + getSong() + " : ");
		instrument.play();
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public String screamSong() {
		return song;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private String song;
	private int age;
	private Instrument instrument;

}
