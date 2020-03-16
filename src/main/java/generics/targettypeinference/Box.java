package generics.targettypeinference;

/**
 * @author playcrab_chenyuqun
 */
public class Box<U> {
    private U u;
    public void set(U u) {
        this.u = u;
    }

    public U get() {
        return u;
    }
}
