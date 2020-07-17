package design_pattern.structural.composite.composite2;

/**
 * @author chenyuqun
 */
public abstract class HumanResource {
    protected long id;
    protected double salary;

    public HumanResource(long id) {
        this.id = id;
    }

    public abstract double calculateSalary();

    public long getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }
}
