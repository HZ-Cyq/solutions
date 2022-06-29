package JSONObject;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author chenyuqun
 * @date 2022/3/11 10:58 上午
 */
public class Staff1 {
    @JSONField(name = "n")
    private String name;
    @JSONField(name = "a")
    private int age;
    @JSONField(name = "s")
    private String sex;
    @JSONField(name = "t")
    private String telephone;

    public Staff1(String name, int age, String sex) {
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

    @Override
    public String toString() {
        return "Staff1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
