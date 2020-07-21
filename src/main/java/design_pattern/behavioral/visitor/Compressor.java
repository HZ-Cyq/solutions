package design_pattern.behavioral.visitor;

/**
 * @author chenyuqun
 */
public class Compressor implements Visitor {
    @Override
    public void visit(PdfFile pdfFile) {
        System.out.println("compress pdf");
    }

    @Override
    public void visit(PptFile pptFile) {
        System.out.println("compress ppt");
    }

    @Override
    public void visit(WordFile wordFile) {
        System.out.println("compress word");
    }
}
