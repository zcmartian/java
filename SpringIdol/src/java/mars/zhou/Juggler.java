package mars.zhou;

public class Juggler implements Performer {
    private int beanBags = 3;
    private Poem poem;

    public Juggler() {
    }

    public Juggler(int beanBags) {
        this.beanBags = beanBags;
    }

    public Juggler(int beanBags, Poem poem) {
        this.beanBags = beanBags;
        this.poem = poem;
    }

    @Override
    public void perform() throws PerformanceException {
        // TODO Auto-generated method stub
        System.out.println("JUGGLER " + beanBags + " BEANBAGS");
        poem.recite();
    }

}
