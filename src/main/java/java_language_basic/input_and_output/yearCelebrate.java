package java_language_basic.input_and_output;

import com.google.common.collect.Maps;
import com.taobao.api.internal.util.StringUtils;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * @author chenyuqun
 * @date 2021/2/11 10:43 下午
 */
public class yearCelebrate {
    public static void main(String[] args) {
        String fileName = "/Users/playcrab/Documents/kosworkspace/log/yearCelebrate/fajiangmingdan.ip";
        // key是ip, value是次数。
        Map<String, Integer> map = Maps.newHashMap();
        try {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {
                String s;
                while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                    int oldValue = map.getOrDefault(s, 0);
                    map.put(s, oldValue + 1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
// 测试
//        System.out.println(map.size());
//        System.out.println(map.get("120.92.126.89"));
//        System.out.println(map.get("120.92.127.30"));
//        System.out.println(map.get("120.92.126.87"));
        // 发了多次邮件奖励的
        Map<String, Integer> ip_wit_multi = Maps.newHashMap();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                continue;
            }
            ip_wit_multi.put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Integer> entry : ip_wit_multi.entrySet()) {
            System.out.println(entry.getKey() + "," + entry.getValue());
        }

        String ip_sec_file_name = "/Users/playcrab/Documents/kosworkspace/log/yearCelebrate/ip_and_sec.txt";
        Map<String, String> ipSec = Maps.newHashMap();
        try {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(ip_sec_file_name), "UTF-8"))) {
                String s;
                while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                    String[] strings = StringUtils.split(s, " ");
                    ipSec.put(strings[0], strings[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String ip_group_file_name = "/Users/playcrab/Documents/kosworkspace/log/yearCelebrate/ip_and_sec.txt";
        Map<String, String> ipGroup = Maps.newHashMap();
        try {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(ip_group_file_name), "UTF-8"))) {
                String s;
                while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                    String[] strings = StringUtils.split(s, " ");
                    ipGroup.put(strings[0], strings[2]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String fajiangmingdanFileName = "/Users/playcrab/Documents/kosworkspace/log/yearCelebrate/fajiangmingdan.txt";
        System.out.println(ipSec.size());
        System.out.println(ipGroup.size());
        int totalNum = 0;
        // key是sec,value是多发的玩家信息
        Map<String, Map<Integer, String>> count = Maps.newHashMap();

        for (Map.Entry<String, Integer> entry : ip_wit_multi.entrySet()) {
            String ip = entry.getKey();
            String sec = ipSec.get(ip);
            String group = ipGroup.get(ip);
            String rid = getRids(group, fajiangmingdanFileName);
            Map<Integer, String> rids = findRids(rid, sec);
            totalNum += rids.size();
            count.put(sec, rids);
        }

        for (Map.Entry<String, Integer> entry : ip_wit_multi.entrySet()) {
            String sec = ipSec.get(entry.getKey());
            int sendTime = entry.getValue();
            Map<Integer, String> playerInfo = count.get(sec);
            System.out.println(sec + "服多发了" + (sendTime - 1) + "封邮件，玩家是：");
            playerInfo.forEach((key, value) -> {
                System.out.print("[" + key + "," + value + "]");
            });
            System.out.println();
        }

        System.out.println("小结：");
        for (Map.Entry<String, Integer> entry : ip_wit_multi.entrySet()) {
            int sendTime = entry.getValue();
            String sec = ipSec.get(entry.getKey());
            int np = count.get(sec).size();
            System.out.printf("[%s服有%3d人多发了%3d封邮件]\n", sec, np, sendTime - 1);
        }
        System.out.println("全服有" + totalNum + "人多发了邮件");
    }

    /**
     * @param rids 类似"online#16724351_80350","online#15122552_80349","online#1002056_80349"
     * @param sec  类似80350
     * @return online#16724351_80350
     */
    public static Map<Integer, String> findRids(String rids, String sec) {
        Map<Integer, String> re = Maps.newHashMap();
        String[] ridArray = StringUtils.split(rids, ',');
        for (int i = 0; i < 300; i++) {
            String s = ridArray[i];
            String rid = s.substring(1, s.length() - 1);
            String player_code = StringUtils.split(rid, "#")[1];
            String player_sec = player_code.split("_")[1];
            if (sec.equals(player_sec)) {
                re.put(i + 1, rid);
            }
        }
        return re;
    }

    public static String getRids(String group, String fileName) {
        String re = null;
        try {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {
                String s;
                while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                    String[] strings = StringUtils.split(s, "：");
                    if (strings.length == 2 && strings[0].contains(group)) {
                        re = strings[1].substring(1, strings[1].length() - 1);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return re;
    }

    @Test
    public void test1() {
        System.out.println(Long.MAX_VALUE);
    }
}
