package books.jvm.jvm_3_.garbagecollector;

public class C3_5_minorGC {

    private static int MB = 1024 * 1024;

    /**
     * -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:PrintGCDetails
     * @param args
     */
    public static void main(String[] args) {
        byte[] array1, array2, array3, array4;
        array1 = new byte[2 * MB];
        System.out.println("allocate array1 over");
        array2 = new byte[2 * MB];
        System.out.println("allocate array2 over");
        array3 = new byte[2 * MB];
        System.out.println("allocate array3 over");
        array4 = new byte[4 * MB];
        System.out.println("allocate array4 over");
    }
}
