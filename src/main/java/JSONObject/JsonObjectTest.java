package JSONObject;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

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
}
