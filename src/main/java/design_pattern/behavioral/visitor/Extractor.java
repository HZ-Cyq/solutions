package design_pattern.behavioral.visitor;

/**
 * @author chenyuqun
 */
public class Extractor implements Visitor{
    @Override
    public void visit(PdfFile pdfFile) {
        System.out.println("extract pdf");
    }

    @Override
    public void visit(PptFile pptFile) {
        System.out.println("extract ppt");
    }

    @Override
    public void visit(WordFile wordFile) {
        System.out.println("extract word");
    }
}
