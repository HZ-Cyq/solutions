package books.code_out_efficiency.B06_collection_test.animal_cat_carfield;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * super相当于限制了get（返回值类型丢失，是Object类）
 * extends相当于限制了add (不能add任何对象)
 * 对于一个笼子，什么时候用supper，什么时候用extend呢？
 * 一直放而不取（put first）：supper
 * 一直取而不放（get first）：extends
 *
 * @author chenyuqun
 * @date 2022/3/1 10:25 上午
 */
public class AnimalCatCarfield {

    public static void main(String[] args) {
        List<Animal> animalList = new ArrayList<>();
        List<Cat> catList = new ArrayList<>();
        List<Carfield> carfieldList = new ArrayList<>();

        // 赋值操作
        List<? extends Cat> list1 = carfieldList;
        List<? super Cat> list2 = animalList;

        // 下面两行编译不过去
        // List<? extends Cat> list3 = animalList;
        // List<? super Cat> list4 = carfieldList;
        
        // get操作
        Cat cat = list1.get(0);
        Object object = list2.get(0);

        // add操作
        // list1不能add任何对象
        // list1.add(new Cat());
        // list2只能add Cat 极其子类
        list2.add(new Cat());
        list2.add(new Carfield());
        // 下面这行会报错
        // list2.add(new Animal());

    }

    @Test
    public void test2() {
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();
        System.out.println(animal1.equals(animal2));
    }

}
