package design_pattern.behavioral.visitor;

/**
 * @author chenyuqun
 */
public interface Visitor {
    void visit(PdfFile pdfFile);

    void visit(PptFile pptFile);

    void visit(WordFile wordFile);
}
