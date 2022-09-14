package mobinusi.config;

public class HeroModelConfig extends Config {
    int id;
    int aid;
    String type;

    public HeroModelConfig(int id, int aid, String type) {
        this.id = id;
        this.aid = aid;
        this.type = type;
    }
}
