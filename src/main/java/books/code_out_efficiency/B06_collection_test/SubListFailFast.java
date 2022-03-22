package books.code_out_efficiency.B06_collection_test;

import java.util.ArrayList;
import java.util.List;

/**
 * masterList的任何关于元素个数修改的操作都会导致branchList的"增删改查"抛出ConcurrentModificationException异常。
 *
 * @author chenyuqun
 * @date 2022/3/3 3:33 下午
 */
public class SubListFailFast {
    public static void main(String[] args) {
        List<String> masterList = new ArrayList<>();
        masterList.add("one");
        masterList.add("two");
        masterList.add("three");
        masterList.add("four");
        masterList.add("five");

        List<String> branchList = masterList.subList(0, 3);

//        masterList.remove(0);
//        masterList.add("ten");
//        masterList.clear();
        masterList.set(0,"one");

        branchList.clear();
        branchList.add("six");
        branchList.add("seven");
        branchList.remove(0);

        for (String s : branchList) {
            System.out.println(s);
        }
        System.out.println(masterList);
    }

}
