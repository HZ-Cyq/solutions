package nowcoder.code.binary_search.rotating_array;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/9/7
 */
public class LeetCode_1003 {
    public static void main(String[] args) {
        LeetCode_1003 leetCode1003 = new LeetCode_1003();
        int[] arr = new int[]{-30, -25, -22, -22, -18, -12, -11, -11, -9, -8, -8, -1, 0, 0, 5, 6, 6, 13, 14, 16, 16, 18, 19, 19, 21, 21, 22, 23, 25, 26, 30, 30, 30, 32, 37, 38, 40, 41, 43, 43, 45, 45, 45, 46, 46, 47, 56, 59, 61, 62, 64, 65, 69, 73, 74, 80, 84, 84, 86, 86, 88, 88, 89, 89, 90, 90, 91, 92, 92, -93, -93, -87, -84, -82, -80, -80, -79, -77, -74, -73, -70, -68, -66, -64, -60, -58, -55, -52, -51, -51, -49, -46, -43, -34};
        System.out.println(leetCode1003.search(arr, 89));
    }

    public int search(int[] arr, int target) {
        int begin = 0;
        int end = arr.length - 1;
        // 保持搜索空间里至少有三个元素, target在[begin, end]之间
        while (begin < end - 1) {
            int mid = begin + (end - begin) / 2;
            if(target == arr[begin]) {
                return begin;
            }

            if(target == arr[mid]) {
                // !! 注意这里不能直接返回mid, 因为mid左边可能有值和mid相等
                if(arr[mid - 1] == arr[mid]) {
                    end = mid - 1;
                } else {
                    return mid;
                }
            }
            if(arr[begin] == arr[mid]) {
                begin += 1;
            } else if(arr[begin] < arr[mid]) {
                // mid落在断点的左边
                // target在begin和mid之间
                if(target > arr[begin] && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            } else {
                // mid落在断点的右边
                // !! 注意这里后面是小于或等于
                if(target > arr[mid] && target <= arr[end]) {
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        if(arr[begin] == target) {
            return begin;
        } else if(arr[end] == target) {
            return end;
        } else {
            return -1;
        }
    }
}
