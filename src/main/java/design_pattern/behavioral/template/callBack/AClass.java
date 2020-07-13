package design_pattern.behavioral.template.callBack;

/**
 * @author playcrab_chenyuqun
 */
public class AClass {

    public static void method() {
        BClass b = new BClass();
        b.process(new ICallBack() {
            @Override
            public void callBackMethod() {
                System.out.println("callBackMethod implement in AClass");
            }
        });
    }
}
