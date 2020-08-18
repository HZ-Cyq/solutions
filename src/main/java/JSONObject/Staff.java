package JSONObject;

import java.util.Date;

/**
 * @author playcrab_chenyuqun
 */
public class Staff {
    private String name;
    private int age;
    private String sex;
    private String telephone;

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
}
