package mobinusi.config;

import com.google.common.collect.Lists;
import exception.log.LogbackDemo;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

public class Demo {
    @Test
    public void test1() {
        HashMap<Integer, Config> dict = new HashMap<>();
        HashMap<String, String> limitState = new HashMap<>();
        limitState.put("type", "IN:[1;2]");
        for (int i = 0; i < 20; i++) {
            HeroModelConfig heroModelConfig = new HeroModelConfig(i, i, String.valueOf(i));
            dict.put(i, heroModelConfig);
        }

        for (Map.Entry<String, String> entry : limitState.entrySet()) {
            String fieldName = entry.getKey();
            List<Object> objects = dict.values().stream().map(ele -> {
                Object obj = new Object();
                try {
                    Field field = ele.getClass().getDeclaredField(fieldName);
                    Class<? extends Field> aClass = field.getClass();
                    obj = field.get(ele);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                return obj;
            }).collect(Collectors.toList());
            check0(entry.getKey(), objects);
        }
    }

    private void check0(String limitState, List<Object> list) {
        String[] split = limitState.split(":");
        String str = split[1].substring(1, split[1].length() - 1);
        switch (split[0]) {
            case "ID":
                break;
            case "IIN":checkIIN(transList(list), transToIntegerSet(str));
                break;
            case "SIN":checkSIN(transList(list), transToStringSet(str));
                break;
            case "IBETWEEN":
                break;
            case "SLENGTH":
                break;
            default:
                LogbackDemo.logger.error("表格检查错误,limitState: {}", limitState);
        }
    }

    private <T> List<T> transList(List<Object> list) {
        List<T> re = Lists.newArrayList();
        for (Object o : list) {
            re.add((T) o);
        }
        return re;
    }

    /**
     * 格式
     * 1;2;3
     */
    private List<Integer> transToIntegerList(String str) {
        String[] split = str.split(";");
        return Arrays.stream(split).map(Integer::valueOf).collect(Collectors.toList());
    }

    /**
     * 格式
     * str1;str2;str3
     */
    private List<String> transToStringList(String str) {
        String[] split = str.split(";");
        return Arrays.stream(split).collect(Collectors.toList());
    }

    /**
     * 格式
     * 1;2;3
     */
    private Set<Integer> transToIntegerSet(String str) {
        String[] split = str.split(";");
        return Arrays.stream(split).map(Integer::valueOf).collect(Collectors.toSet());
    }

    /**
     * 格式
     * str1;str2;str3
     */
    private Set<String> transToStringSet(String str) {
        String[] split = str.split(";");
        return Arrays.stream(split).collect(Collectors.toSet());
    }

    private void checkIIN(List<Integer> list, Set<Integer> in) {

    }

    private void checkSIN(List<String> list, Set<String> sin) {

    }

}