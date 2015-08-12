package mars.zhou;

public class Stage {
	private Stage() {
		System.out.println("Stage is ready!");
	}
	
	private static class StageSingeltonHolder{
		static Stage instance = new Stage();
	}
	
	public static Stage getInstance(){
		return StageSingeltonHolder.instance;
	}
}
