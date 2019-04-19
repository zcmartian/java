package mars.zhou;

import java.util.Map;

public class OneManBand implements Performer {
    //	private Collection<Instrument> instruments;
    private Map<String, Instrument> instruments;

    public OneManBand() {
    }

    public void initialize() {
        System.out.println("bean initialize.");
    }

    public void close() {
        System.out.println("bean destroy.");
    }

    @Override
    public void perform() throws PerformanceException {
        // TODO Auto-generated method stub
//		for (Instrument instrument : instruments) {
//			instrument.play();
//		}

        for (String key : instruments.keySet()) {
            System.out.println("key" + " : ");
            Instrument instrument = instruments.get(key);
            instrument.play();
        }
    }

    public void setInstruments(/*Collection<Instrument>*/Map<String, Instrument> instruments) {
        this.instruments = instruments;
    }

}
