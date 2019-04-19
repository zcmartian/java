package mars.zhou;

public class Stage {
    private Stage() {
        System.out.println("Stage is ready!");
    }

    public static Stage getInstance() {
        return StageSingeltonHolder.instance;
    }

    private static class StageSingeltonHolder {
        static Stage instance = new Stage();
    }
}
