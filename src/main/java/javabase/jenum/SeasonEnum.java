package javabase.jenum;

/**
 * @author playcrab_chenyuqun
 */
public enum SeasonEnum {
    SPRING(1),
    SUMMER(2),
    AUTUMN(3),
    WINTER(4);
    private int seq;

    SeasonEnum(int seq) {
        this.seq = seq;
    }

    public int getSeq() {
        return seq;
    }

    public static void main(String[] args) {
        System.out.println(AUTUMN.name());
    }
}
