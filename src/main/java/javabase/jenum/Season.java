package javabase.jenum;

/**
 * @author playcrab_chenyuqun
 */
public class Season {
    private SeasonEnum seasonEnum;

    Season(SeasonEnum seasonEnum) {
        this.seasonEnum = seasonEnum;
    }
    public void print() {
        System.out.println("now is " + seasonEnum.name() + " ,the type is:" + seasonEnum.getSeq());
    }

    public SeasonEnum getSeasonEnum() {
        return seasonEnum;
    }

    public void setSeasonEnum(SeasonEnum seasonEnum) {
        this.seasonEnum = seasonEnum;
    }
}
