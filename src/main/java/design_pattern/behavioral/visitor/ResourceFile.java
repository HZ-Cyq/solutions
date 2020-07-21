package design_pattern.behavioral.visitor;

/**
 * @author chenyuqun
 */
public abstract class ResourceFile {
    protected String filePath;

    public ResourceFile(String filePath) {
        this.filePath = filePath;
    }

    public abstract void accept(Visitor visitor);
}
