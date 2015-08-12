package mars.zhou;

import java.util.Collection;
import java.util.Map;

public class OneManBand implements Performer {
	public OneManBand() {
	}

//	private Collection<Instrument> instruments;
	private Map<String, Instrument> instruments;

	@Override
	public void perform() throws PerformanceException {
		// TODO Auto-generated method stub
//		for (Instrument instrument : instruments) {
//			instrument.play();
//		}
		
		for(String key : instruments.keySet()){
			System.out.println("key" + " : ");
			Instrument instrument = instruments.get(key);
			instrument.play();
		}
	}

	public void setInstruments(/*Collection<Instrument>*/Map<String, Instrument> instruments) {
		this.instruments = instruments;
	}

}
