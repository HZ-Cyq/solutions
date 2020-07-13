package design_pattern.behavioral.template.callBack;

/**
 * @author playcrab_chenyuqun
 */
public class BClass {
    public void process(ICallBack iCallBack) {
        //这个是固定的骨架
        System.out.println("before call fixed");

        // 这个可以定制
        iCallBack.callBackMethod();

        //这个也是固定的骨架
        System.out.println("after call fixed");
    }
}
