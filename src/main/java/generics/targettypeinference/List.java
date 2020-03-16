package generics.targettypeinference;

/**
 * @author playcrab_chenyuqun
 */
public class List<E> {
    private E element;
    private E next;
    public List(E element, E next) {
        this.element = element;
        this.next = next;
    }

    static <Z> List<Z> nil() {
        List<Z> list = new List("hello","world");
        return list;
    }

    static <Z> List<Z> cons(List<Z> tail) {
        System.out.println("tail.element: " + tail.getElement());
        System.out.println("tail.next: " + tail.getNext());
        System.out.println(tail.getElement().getClass());
        return null;
    }

    E head() {
        return element;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public E getNext() {
        return next;
    }

    public void setNext(E next) {
        this.next = next;
    }
}
