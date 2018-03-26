package bugmakers.club.dp.behavioral.seq06.memento.structural;

/**
 * @Description: 备忘录类，默认可见性，包内可见
 * @Author: Bruce
 * @Datetime: 2018/3/26 16:24
 */
public class Memento {

    private String state;

    public Memento(Originator originator){
        state = originator.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
