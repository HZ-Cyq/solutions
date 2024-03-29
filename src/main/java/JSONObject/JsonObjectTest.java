package JSONObject;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author playcrab_chenyuqun
 */
public class JsonObjectTest {
    @Test
    public void testJsonObject() {
        JSONObject json = new JSONObject();

        JSONObject json1 = new JSONObject();
        JSONObject json2 = new JSONObject();
        JSONObject json3 = new JSONObject();

        json1.put("item0", 1);
        json2.put("item1", 2);
        json3.put("item2", 3);

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(json1);
        jsonArray.add(json2);
        jsonArray.add(json3);
        json.put("dItem", json1);
    }

    @Test
    public void test() {
        JSONObject json = new JSONObject();
        Integer i = json.getInteger("hello");
        System.out.println(i == null);
    }

    @Test
    public void testAddAll() {
        JSONArray array1 = new JSONArray();
        JSONObject json1 = new JSONObject();
        json1.put("type", 1);
        json1.put("code", 1);
        json1.put("amount", 1);
        JSONObject json2 = new JSONObject();
        json2.put("type", 2);
        json2.put("code", 2);
        json2.put("amount", 2);
        JSONObject json3 = new JSONObject();
        json3.put("type", 3);
        json3.put("code", 3);
        json3.put("amount", 3);
        JSONObject json4 = new JSONObject();
        json4.put("type", 4);
        json4.put("code", 4);
        json4.put("amount", 4);
        array1.add(json1);
        array1.add(json2);
        array1.add(json3);
        array1.add(json4);

        JSONArray array2 = new JSONArray();
        array2.add(json1);
        array2.add(json2);
        array2.add(json3);
        array2.add(json4);

        array1.addAll(array2);
        array1.forEach(json -> {
            System.out.println(json.toString());
        });
    }

    @Test
    public void testPut() {
        JSONObject json = new JSONObject();
        json.put("hello", "world");
        json.put("hello", "newWorld");
        System.out.println(json.getString("hello"));
    }

    @Test
    public void testJson() {
        JSONObject json = new JSONObject();
        json.put("hello", 1);
        json.put("world", 1.0);
        System.out.println(json.getDouble("hello"));
        System.out.println(json.getDouble("world"));

        json.put("hp", 1);
        long value = json.getLongValue("hp");
//        long value = (long)json.getOrDefault("hp", 0L);

        System.out.println(value);
    }

    @Test
    public void test1() {
        long l1 = 100L;
        long l2 = 33L;
        System.out.println(1.0 * l1 / l2);
    }

    @Test
    public void testNull() {
        JSONObject json = new JSONObject();
        int a = (int) json.getLongValue("2")
                * 3;
        System.out.println(a);
    }

    @Test
    public void testParse() {
        Object obj = JSONObject.parse("hello:world");
        System.out.println(obj);
    }

    /**
     * 测试parseObject方法
     * https://my.oschina.net/u/4034553/blog/3070839
     */
    @Test
    public void testParseObject() {
        String jsonString = "{name:'yxs', age: 23, sex:'man', telephone:'123456'}";
        Staff staff = JSON.parseObject(jsonString, Staff.class);
        System.out.println(staff.toString());
        String string = JSON.toJSONString(staff);
        System.out.println(string);
    }

    @Test
    public void testsParseArray() {
        String jsonStr = "{\"RGift_Cust202011_1\":[[\"AC_16340_1_1\",\"AC_16340_1_2\",\"AC_16340_1_3\"],[\"AC_16340_1_4\",\"AC_16340_1_5\",\"AC_16340_1_6\"],[\"AC_16340_1_7\"]],\n" +
                "\"RGift_Cust202011_2\":[[\"AC_16340_1_1\",\"AC_16340_1_2\",\"AC_16340_1_3\"],[\"AC_16340_1_4\",\"AC_16340_1_5\",\"AC_16340_1_6\"],[\"AC_16340_1_7\"]],\n" +
                "\"RGift_Cust202011_3\":[[\"AC_16340_1_1\",\"AC_16340_1_2\",\"AC_16340_1_3\"],[\"AC_16340_1_4\",\"AC_16340_1_5\",\"AC_16340_1_6\"],[\"AC_16340_1_7\"]]}";
        JSONObject json = JSON.parseObject(jsonStr);
        JSONArray goods = json.getJSONArray("RGift_Cust202011_1");
        for (Object good : goods) {
            JSONArray aRowGoods = (JSONArray) good;
            System.out.println(aRowGoods);
        }
        System.out.println(goods);
    }


    @Test
    public void testGetObject() {
        JSONObject json = new JSONObject();
        List<Staff> list = Lists.newLinkedList();
        Staff staff1 = new Staff("1", 1, "1", "1");
        Staff staff2 = new Staff("1", 1, "1", "1");
        Staff staff3 = new Staff("1", 1, "1", "1");
        list.add(staff1);
        list.add(staff2);
        list.add(staff3);
        json.put("staff", list);

        List<Staff> jList = json.getObject("staff", List.class);
        jList.add(staff1);

        System.out.println(JSON.toJSONString(json));
    }

    @Test
    public void testContainsAll() {
        List<String> list = Lists.newArrayList();
        list.add("1");
        list.add("2");
        list.add("3");

        JSONArray jsonArray = new JSONArray();
        jsonArray.add("1");
        jsonArray.add("2");

        System.out.println(list.containsAll(jsonArray.toJavaList(String.class)));
    }

    @Test
    public void testGetObjectNull() {
        JSONObject jsonObject = new JSONObject();
        List<String> list1 = Lists.newArrayList();
        jsonObject.put("list1", list1);
        List<String> list = jsonObject.getObject("list", List.class);
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(list);
        System.out.println(jsonArray.size());
    }

    @Test
    public void testToString() {
        Staff staff = new Staff("", 10, "fel", "11");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("staff", staff);
        String s1 = jsonObject.toJSONString();
        System.out.println(s1);
        String s = jsonObject.toJSONString();
        Staff staff1 = jsonObject.getObject("staff", Staff.class);
        System.out.println(staff1);
    }

    @Test
    public void test2() {
        String a = "";
        System.out.println(a.equals(null));
        List<String> list = Lists.newArrayList();
        list.add("afeeea");
        list.add("afeae");
        list.add("bwefa");
        list.add("cfawef");
        list.add("cfawef");
        list.add("cfawef");
        list.add("cfawef");
        list.add("cfawef");
        list.add("cfawef");
        list.add("cfawef");
        list.add("cfawef");
        list.add("bwefa");
        list.add("cfawef");
        list.add("bwefa");
        list.add("cfawef");
        list.add("bdwae");
        list.add("bwefa");
        list.add("ceafe");
        list.add("bwefa");
        list.add("cfawef");
        list.add("bwefa");
        list.add("cfawef");
        list.add("bwefa");
        list.add("cfawef");
        list.add("bwefa");
        list.add("cfawef");
        list.add("bwefa");
        list.add("bwefa");
        list.add("cfawef");
        list.add("bwefa");
        list.add("cfawef");
        list.add("bwefa");
        list.add("cfawef");
        list.add("bwefa");
        Map<String, List<String>> collect = list.stream().collect(Collectors.groupingBy(ele -> String.valueOf(ele.getBytes()[0])));
        for (Map.Entry<String, List<String>> entry : collect.entrySet()) {
            System.out.println("key: " + entry.getKey());
            for (String s : entry.getValue()) {
                System.out.println(s);
            }
        }
    }

    @Test
    public void test3() {
        HashSet<String> set = new HashSet<>();
        set.add("a");
        set.add("b");

        System.out.println(set);
    }

    @Test
    public void testCreate() {
//        Staff staff = new Staff("11",12,"man", "1232");
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("v", staff);
//        Staff v = jsonObject.getObject("v", Staff.class);
//        v.setName("feeewa");
//        System.out.println(staff);
        List<String> list = Lists.newArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        List<String> collect = list.stream().filter(ele -> "1".equals(ele)).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void testJson1() {
        Staff1 staff = new Staff1("11",12,"man");
        staff.setTelephone("123321");
        String s = JSONObject.toJSONString(staff);
        System.out.println(s);
        Staff1 staff1 = JSONObject.parseObject(s, Staff1.class);
        System.out.println(staff1);
    }

}
