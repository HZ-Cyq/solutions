package key.final_and_static;

/**
 * @author playcrab_chenyuqun
 */
public final class FinalClass {
    final int intWithNonInit;
    final int intWithInit = 2;
    final String strWithNonInit;
    final String strWithInit = "world";
    public FinalClass(int intWithNonInit, String strWithNonInit) {
        this.intWithNonInit = intWithNonInit;
        this.strWithNonInit = strWithNonInit;
    }

    public int getIntWithNonInit() {
        return intWithNonInit;
    }

    public int getIntWithInit() {
        return intWithInit;
    }

    public String getStrWithNonInit() {
        return strWithNonInit;
    }

    public String getStrWithInit() {
        return strWithInit;
    }
}
