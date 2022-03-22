package books.code_out_efficiency.B06_collection_test.hashcode_equals;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author chenyuqun
 * @date 2022/3/2 6:47 下午
 */
public class EqualObject {
    private int id;

    private String name;

    public EqualObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EqualObject that = (EqualObject) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        HashMap<EqualObject, Integer> map = new HashMap<>();
        EqualObject equalObject1 = new EqualObject(1, "hello");
        EqualObject equalObject2 = new EqualObject(1, "hello");
        map.put(equalObject1, 1);
        map.put(equalObject2, 2);
        System.out.println(map.size());
    }
}
