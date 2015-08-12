import java.util.ArrayList;
import java.util.List;

public class MainTest {

	static class OOMObject{
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<OOMObject> list = new ArrayList<OOMObject>();
		while (true){
			list.add(new OOMObject());
		}
	}

}
