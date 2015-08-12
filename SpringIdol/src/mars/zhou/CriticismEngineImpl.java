package mars.zhou;

public class CriticismEngineImpl implements CriticismEngine {

	@Override
	public String getCriticism() {
		// TODO Auto-generated method stub
		int i = (int) (Math.random() * getCriticismPool().length);
		return criticismPool[i];
	}

	public String[] getCriticismPool() {
		return criticismPool;
	}

	public void setCriticismPool(String[] criticismPool) {
		this.criticismPool = criticismPool;
	}

	private String[] criticismPool;
}
