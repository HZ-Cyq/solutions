package design_pattern.behavioral.visitor;

/**
 * @author chenyuqun
 */
public class PptFile extends ResourceFile {
    public PptFile(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
