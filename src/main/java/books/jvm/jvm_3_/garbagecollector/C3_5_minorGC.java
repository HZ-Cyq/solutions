package books.jvm.jvm_3_.garbagecollector;

public class C3_5_minorGC {

    private static int MB = 1024 * 1024;

    /**
     * -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:PrintGCDetails
     * @param args
     */
    public static void main(String[] args) {
        byte[] array;
        for (int i = 0; i < 100; i++) {
            array = new byte[1 * MB];
            System.out.println(array.length);
        }
    }
}
