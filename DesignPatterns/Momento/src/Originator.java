/**
 * Created by marszhou on 16/2/21.
 */
public class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveStateToMomento() {
        return new Memento(state);
    }

    public void getStateFromMomento(Memento memento) {
        state = memento.getState();
    }
}
