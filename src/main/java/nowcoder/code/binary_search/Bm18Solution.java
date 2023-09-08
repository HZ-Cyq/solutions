package nowcoder.code.binary_search;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/8/29
 */
public class Bm18Solution {
    public static void main(String[] args) {
        int[][] array = new int[4][4];
        array[0][0] = 1;
        array[0][1] = 2;
        array[0][2] = 8;
        array[0][3] = 9;

        array[1][0] = 2;
        array[1][1] = 4;
        array[1][2] = 8;
        array[1][3] = 12;


        array[2][0] = 4;
        array[2][1] = 7;
        array[2][2] = 10;
        array[2][3] = 13;


        array[3][0] = 6;
        array[3][1] = 8;
        array[3][2] = 11;
        array[3][3] = 15;

        Bm18Solution bm18Solution = new Bm18Solution();
        System.out.println(bm18Solution.Find2(15, array));
    }

    // 对每一行进行二分查找，假设是m行n列，时间复杂度是m * log(n)
    public boolean Find (int target, int[][] array) {
        if(array == null) {
            return false;
        }
        for (int[] ints : array) {
            if (binarySearch(target, ints)) {
                return true;
            }
        }
        return false;
    }

    // 从左下角看，假设是m行n列，
    // 如果目标值大于左下角的值，那么一定不在第1列，
    // 如果目标值小于左下角的值，那么一定不在最后一行，
    // 以此类推，可以找到target.
    // 时间复杂度是O(m + n)
    public boolean Find2(int target, int[][] array) {
        if(array == null || array[0] == null) {
            return false;
        }
        // row是行数，col是列数
        int row = array.length;
        int col = array[0].length;
        // 左下角元素
        int i = row - 1;
        int j = 0;
        while (i >= 0 && j <= col - 1 && array[i][j] != target) {
            if(array[i][j] > target) {
                i -= 1;
            } else {
                j += 1;
            }
        }
        return i >= 0 && j <= col - 1;
    }

    public boolean binarySearch(int target, int[] array) {
        if(array == null || array.length == 0) {
            return false;
        }
        int begin = 0;
        int end = array.length - 1;
        int mid = (begin + end) / 2;
        // 目标index在[begin, end]之间
        while (array[mid] != target && begin < end) {
            if(array[mid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
            mid = (begin + end) / 2;
        }
        return array[mid] == target;
    }
}
