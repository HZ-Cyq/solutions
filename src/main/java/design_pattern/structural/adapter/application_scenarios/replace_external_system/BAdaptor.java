package design_pattern.structural.adapter.application_scenarios.replace_external_system;

/**
 * 将外部系统A替换成外部系统B
 * @author chenyuqun
 */
public class BAdaptor implements IA {
    private B b;

    public BAdaptor(B b) {
        this.b = b;
    }

    @Override
    public void fa() {
        b.fa();
    }
}
