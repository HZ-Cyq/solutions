package books.code_out_efficiency.B06_collection_test;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        String str = "2020-05-16 19:20:34|user.login|name=Charles&location=Beijing&device=iPhone";
//        String s = parseStr(str);
//        System.out.println(s);


//        List<Integer> list = new ArrayList<>();
//        list.add(-1);
//        list.add(-1);
//        list.add(-1);
//        list.add(-1);
//        list.add(1);
//        list.add(1);
//        list.add(1);
//        list.add(1);
//        int minAbs = findMinAbs(list);
//        System.out.println(minAbs);


//        List<Integer> list = new ArrayList<>();
//        list.add(3);
//        list.add(1);
//        list.add(2);
//        System.out.println(findMidVal(list));

    }

    public static int upStar(int high) {
        if (high <= 0) {
            return 0;
        }
        if (high == 1) {
            return 1;
        }
        if (high == 3) {
            return 2;
        }
        return upStar(high - 1) + upStar(high - 3);
    }

    public static int findMidVal(List<Integer> list) {
        // 先对list进行排序
        for (int i = 0; i < list.size(); i++) {
            int minVal = list.get(i);
            int minIndex = 0;
            for (int j = i; j < list.size(); j++) {
                if (list.get(j) < minVal) {
                    minVal = list.get(j);
                    minIndex = j;
                }
            }
            int temp = list.get(i);
            list.set(i, minVal);
            list.set(minIndex, temp);
        }
        return list.get(list.size() / 2);
    }

    public static int findMinAbs(List<Integer> sortedList) {
        int left = 0;
        int right = sortedList.size() - 1;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (Math.abs(sortedList.get(mid)) <= Math.abs(sortedList.get(mid + 1))) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return Math.abs(sortedList.get(left));
    }

    public static String parseStr(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n");
        String[] split1 = str.split("\\|");
        String last = split1[split1.length - 1];
        String[] split2 = last.split("&");
        int lastIndex = split2.length - 1;
        for (int i = 0; i < split2.length; i++) {
            String[] split = split2[i].split("=");
            if (split.length != 2) {
                System.out.println("parse error: " + Arrays.asList(split));
                continue;
            }
            if (i != lastIndex) {
                stringBuilder.append(split[0]).append(":\"").append(split[1]).append("\",").append("\n");
            } else {
                stringBuilder.append(split[0]).append(":\"").append(split[1]).append("\"").append("\n");
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
