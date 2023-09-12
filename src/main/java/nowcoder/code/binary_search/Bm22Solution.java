package nowcoder.code.binary_search;


import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/9/12
 */
public class Bm22Solution {
    public static void main(String[] args) {
        Bm22Solution bm22Solution = new Bm22Solution();
        System.out.println(bm22Solution.compare(
                "134.105.202.15.33.83.60.151.38.150.82.113.141.168.7.24.78.1.80.1",
                "134.105.202.15.33.83.60.151.38.150.82.113.141.168.7.94.26.39.167.186.105.132"));
    }

    /**
     * 分割截取
     * @param version1
     * @param version2
     * @return
     */
    public int compare2 (String version1, String version2) {
        // write code here
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int index = 0;
        int length1 = split1.length;
        int length2 = split2.length;
        // 比较index位置的值，每迭代一次，index就会加1
        while (index < length1 || index < length2) {
            int num1 = index < length1 ? Integer.parseInt(split1[index]) : 0;
            int num2 = index < length2 ? Integer.parseInt(split2[index]) : 0;
            if(num1 == num2) {
                index ++;
                continue;
            }
            return Integer.compare(num1, num2);
        }
        return 0;
    }

    /**
     * 双指针
     * @param version1
     * @param version2
     * @return
     */
    public int compare (String version1, String version2) {
        // write code here
        int p = 0;
        int q = 0;
        while (p < version1.length() || q < version2.length()) {
            List<Integer> list1 = calVal(version1, p);
            List<Integer> list2 = calVal(version2, p);
            // !! 这里要用equals方法，不能用"=="
            if(!list1.get(0).equals(list2.get(0))) {
                return Integer.compare(list1.get(0), list2.get(0));
            }
            p = p == version1.length() ? version1.length() : list1.get(1) + 1;
            q = q == version2.length() ? version2.length() : list2.get(1) + 1;
        }
        return 0;
    }

    /**
     * 从begin位置开始计算，遇到第一个.或者结尾是结束，返回计算的值以及下一个.的位置
     * 如果beginIndex的值大于str.length,会返回0.
     * @param str
     * @param beginIndex
     * @return 位置0是值，位置1是下一个.的位置
     */
    public List<Integer> calVal(String str, int beginIndex) {
        List<Integer> re = new ArrayList<>();
        int num = 0;
        int p = beginIndex;
        // 梅迭代一次，p的值会往后挪一位
        // num是p之前所在位置的值
        while (p < str.length()) {
            char c = str.charAt(p);
            if(c == '.') {
                break;
            }
            num = (num * 10) + Integer.parseInt(String.valueOf(c));
            p++;
        }
        re.add(num);
        re.add(p);
        return re;
    }

}
