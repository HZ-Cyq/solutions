package JSONObject;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author playcrab_chenyuqun
 */
public class Staff {
    @JSONField(name = "n")
    private String name;
    @JSONField(name = "a")
    private int age;
    @JSONField(name = "s")
    private String sex;
    @JSONField(name = "t")
    private String telephone;

    private static int a = 10;

    public Staff(String name, int age, String sex, String telephone) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public static int getA() {
        return a;
    }

    public static void setA(int a) {
        Staff.a = a;
    }
}
