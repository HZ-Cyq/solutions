package books.onjava8.f13_function_programming.impleInterface.method_reference.unbound_method_reference.multiple_parameters;

/**
 * @author chenyuqun
 * @date 2021/5/28 11:51 上午
 */
public class MultiUnbound {
    static class Cla {
        void zero() {
        }

        void one(int i) {
        }

        void two(int i, double d) {
        }
    }

    interface ZeroArg {
        void call0(Cla cla);
    }

    interface OneArg {
        void call1(Cla cla, int i);
    }

    interface TwoArgs {
        void call2(Cla cla, int i, double d);
    }

    public static void main(String[] args) {
        ZeroArg zeroArg = Cla::zero;
        OneArg oneArg = Cla::one;
        TwoArgs twoArgs = Cla::two;
        Cla cla = new Cla();
        zeroArg.call0(cla);
        oneArg.call1(cla,1);
        twoArgs.call2(cla,1,1.0D);
    }
}
